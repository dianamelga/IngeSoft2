package vacunas.app.com.appvacunas;

import android.app.Activity;
import android.content.Entity;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vacunas.app.com.appvacunas.clases.Hijo;
import vacunas.app.com.appvacunas.clases.ListAdapter;
import vacunas.app.com.appvacunas.clases.Vacuna;
import vacunas.app.com.appvacunas.clases.VacunaHijo;
import vacunas.app.com.appvacunas.data.BDHelper;

/**
 * Created by adriana on 9/4/2017.
 */

public class VacunasFragment extends Fragment {
  public static final String TAG = "VacunasFragment";
    public static final String URL_SERVICE = "http://192.168.43.192:8080/VacunasRest/webresources/";
  private static final String ARG_HIJO_ID = "hijoId";
  private int mHijoId;

  private BDHelper mDQbdHelper;

  private ExpandableListView mVacunasList;
  private ListAdapter mVacunasAdapter;

  List<String> listDataHeader;
  HashMap<String, List<VacunaHijo>> listDataChild;


  public VacunasFragment() {
    // Required empty public constructor
  }

  public static VacunasFragment newInstance(int hijoId) {
    Log.d(TAG, "hijoId: "+String.valueOf(hijoId));
    VacunasFragment fragment = new VacunasFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_HIJO_ID, hijoId);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
      Log.d(TAG, "1. onCreateView");

          View root = inflater.inflate(R.layout.fragment_vacunas, container, false);
          mVacunasList = (ExpandableListView) root.findViewById(R.id.lvExp);
      preparar();
      /*
          mDQbdHelper = new BDHelper(getActivity());
          prepareListData();
          mVacunasAdapter = new ListAdapter(getActivity(), listDataHeader, listDataChild);
          mVacunasList.setAdapter(mVacunasAdapter);*/

          return root;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

      Log.d("HijosActivity", "onCreate de Vacunas Fragment");
    if (getArguments() != null) {
      mHijoId = getArguments().getInt(ARG_HIJO_ID);
        Log.d("HijosActivity", "mHijoId: "+String.valueOf(mHijoId));
    }

    setHasOptionsMenu(true);

  }

  public boolean onOptionsItemSelected(MenuItem item) {
    Log.d("HijosActivity", "onOptionsItemSelected de VacunasFragment");
    Log.d("HijosActivity", "item.getItenId(): "+String.valueOf(item.getItemId()));
    switch (item.getItemId()) {
      case R.id.action_info:
        showHijosScreen(mHijoId);
        break;
    }
    return super.onOptionsItemSelected(item);
  }

  private void showHijosScreen(int currentHijoId) {
    Intent intent = new Intent(getActivity(), DetalleHijosActivity.class);
    intent.putExtra(HijosActivity.EXTRA_HIJO_ID, currentHijoId);
    startActivityForResult(intent, 1);
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == 1) {
      if (resultCode == Activity.RESULT_OK) {
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
      }
    }
  }

  private void preparar(){
      new CargarVacunasTask().execute();
  }

  private class CargarVacunasTask extends AsyncTask<Object, Object, Boolean>{

      @Override
      protected Boolean doInBackground(Object... params) {
          HttpClient httpClient = new DefaultHttpClient();
          HttpResponse resp;
          String respStr;

          listDataHeader = new ArrayList<String>();
          listDataChild = new HashMap<String, List<VacunaHijo>>();

          listDataHeader.add("Al nacer");

          listDataHeader.add("Dos meses");
          listDataHeader.add("Cuatro meses");
          listDataHeader.add("Seis meses");
          listDataHeader.add("Doce meses");
          listDataHeader.add("Quince meses");
          listDataHeader.add("Dieciocho meses");
          listDataHeader.add("Cuarenta y ocho meses");

          try {
              HttpGet del =
                      new HttpGet(URL_SERVICE + "com.vacunashijos/vacunas/"+mHijoId);
              resp = httpClient.execute(del);
              respStr = EntityUtils.toString(resp.getEntity());

              listDataChild.put(listDataHeader.get(0), recorrer(respStr, 0));

              listDataChild.put(listDataHeader.get(1), recorrer(respStr, 2));

              listDataChild.put(listDataHeader.get(2), recorrer(respStr, 4));

              listDataChild.put(listDataHeader.get(3), recorrer(respStr, 6));

              listDataChild.put(listDataHeader.get(4), recorrer(respStr, 12));

              listDataChild.put(listDataHeader.get(5), recorrer(respStr, 15));

              listDataChild.put(listDataHeader.get(6), recorrer(respStr, 18));

              listDataChild.put(listDataHeader.get(7), recorrer(respStr, 48));
          }catch(Exception e){
              Log.d(TAG, "Error: "+e.getMessage());
          }
          return true;
      }

      protected void onPostExecute(Boolean t){
          mVacunasAdapter = new ListAdapter(getActivity(), listDataHeader, listDataChild);
          mVacunasList.setAdapter(mVacunasAdapter);
      }
  }

  public ArrayList<VacunaHijo> recorrer(String json, int month){
      JSONObject jObject;
      JSONArray jArray = null;
      ArrayList<VacunaHijo> mArrayList = new ArrayList<VacunaHijo>();
      int idHijo, id, nro_dosis, mes, aplicado, dias_atraso;
      String nombre, edad, fecha_apl, lote, responsable, fecha;
      try {
          jArray = new JSONArray(json);
          if (jArray != null){
              for (int i=0; i < jArray.length(); i++){
                  jObject = jArray.getJSONObject(i);
                  mes = jObject.getInt("mesAplicacion");

                  if (mes == month){
                      idHijo = jObject.getJSONObject("vacunasHijosPK").getInt("idHijo");
                      id = jObject.getJSONObject("vacunasHijosPK").getInt("idVacuna");
                      nro_dosis = jObject.getJSONObject("vacunasHijosPK").getInt("nro_dosis");
                      nombre = jObject.getJSONObject("vacunas").getString("nombreVacuna");
                      dias_atraso = jObject.getJSONObject("vacunasHijos").getInt("diasAtrasoApl");

                      if (jObject.isNull("edad")) {
                          edad = "";
                      }else {
                          edad = jObject.getString("edad");
                      }
                      nro_dosis = jObject.getInt("nroDosis");

                      if (jObject.isNull("fecha")) {
                          fecha = " ";
                      } else {
                          fecha = jObject.getString("fecha");
                      }

                      if (jObject.isNull("lote")) {
                          lote = " ";
                      } else {
                          lote = jObject.getString("lote");
                      }

                      if (jObject.isNull("responsable")) {
                          responsable = " ";
                      } else {
                          responsable = jObject.getString("responsable");
                      }

                      aplicado = jObject.getInt("aplicado");
                      fecha_apl = jObject.getString("fechaApl");

                      VacunaHijo v = new VacunaHijo(id, nro_dosis, idHijo, nombre,
                              fecha, lote, responsable, aplicado,
                              fecha_apl, dias_atraso, mes, Integer.parseInt(edad));

                      mArrayList.add(v);
                  }
              }
          }
      }catch (Exception e){
          Log.d(TAG, e.getMessage());
      }
      return mArrayList;
  }


/*
  private class DatosLoadTask extends AsyncTask<String, Void, ArrayList> {

    @Override
    protected ArrayList<VacunaHijo> doInBackground(String... par) {
      Cursor cursor = mDQbdHelper.getVacunasByMes(par[0], par[1]);
      Cursor cHIjo = mDQbdHelper.getHijoById(String.valueOf(mHijoId));
      cHIjo.moveToFirst();
      Hijo hijo = new Hijo(cHIjo);
      String fecha;
      ArrayList<VacunaHijo> mArrayList = new ArrayList<VacunaHijo>();
        //Log.d("HijosActivity", String.valueOf(!cursor.isAfterLast()));
      for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
        // The Cursor is now set to the right position
        VacunaHijo v = new VacunaHijo(cursor);
        Calculador ut = new Calculador();
        fecha = ut.calcularFecha(hijo.getFecha_nac(), v.getMes_aplicacion());
        v.setFecha_aplicacion(fecha);
        mArrayList.add(v);
      }
      cHIjo.close();
        //Log.d("HijosActivity", "mArrayList.size(): "+String.valueOf(mArrayList.size()));
      return  mArrayList;
    }
  }



  private void prepareListData() {
    listDataHeader = new ArrayList<String>();
    listDataChild = new HashMap<String, List<VacunaHijo>>();

    // Adding child data
    listDataHeader.add("Al nacer");
    listDataHeader.add("Dos meses");
    listDataHeader.add("Cuatro meses");
    listDataHeader.add("Seis meses");
    listDataHeader.add("Doce meses");
    listDataHeader.add("Quince meses");
    listDataHeader.add("Dieciocho meses");
    listDataHeader.add("Cuarenta y ocho meses");

    // Adding child data
    List<VacunaHijo> lista = new DatosLoadTask().doInBackground("0", String.valueOf(mHijoId));

    listDataChild.put(listDataHeader.get(0), lista); // Header, Child data

    //--------
    lista = new DatosLoadTask().doInBackground("2", String.valueOf(mHijoId));

    listDataChild.put(listDataHeader.get(1), lista); // Header, Child data

    //--------
    lista = new DatosLoadTask().doInBackground("4", String.valueOf(mHijoId));

    listDataChild.put(listDataHeader.get(2), lista); // Header, Child data

    //--------
    lista = new DatosLoadTask().doInBackground("6", String.valueOf(mHijoId));

    listDataChild.put(listDataHeader.get(3), lista); // Header, Child data

    //--------
    lista = new DatosLoadTask().doInBackground("12", String.valueOf(mHijoId));

    listDataChild.put(listDataHeader.get(4), lista); // Header, Child data

    //--------
    lista = new DatosLoadTask().doInBackground("15", String.valueOf(mHijoId));

    listDataChild.put(listDataHeader.get(5), lista); // Header, Child data

    //--------
    lista = new DatosLoadTask().doInBackground("18", String.valueOf(mHijoId));

    listDataChild.put(listDataHeader.get(6), lista); // Header, Child data

    //--------
    lista = new DatosLoadTask().doInBackground("48", String.valueOf(mHijoId));

    listDataChild.put(listDataHeader.get(7), lista); // Header, Child data
  }
  */
}
