package vacunas.app.com.appvacunas;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import vacunas.app.com.appvacunas.R;
import vacunas.app.com.appvacunas.Calculador;
import vacunas.app.com.appvacunas.clases.Hijo;
import vacunas.app.com.appvacunas.clases.C_Adapter;
import vacunas.app.com.appvacunas.clases.Notificacion;
import vacunas.app.com.appvacunas.data.HijoContract.HijosEntry;
import vacunas.app.com.appvacunas.data.BDHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class HijosFragment extends Fragment {


    private final String TAG = "HijosFragment";
    private final String URL_SERVICE = "http://192.168.0.9:8080/VacunasRest/webresources/";
  private BDHelper BDHelper;

  private ListView mHijosList;
  private C_Adapter mHijosAdapter;
    private int mUsuarioId;
    private ArrayList<Hijo> hijos;


  public HijosFragment() {
    // Required empty public constructor
  }

  public static HijosFragment newInstance(int usuarioId) {
      Log.d("HijosFragment", "newInstance");
    HijosFragment fragment = new HijosFragment();
    Bundle args = new Bundle();
    args.putInt(MainActivity.EXTRA_USUARIO_ID, usuarioId);
    fragment.setArguments(args);
    return fragment;
  }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");
        if (getArguments() != null) {
            mUsuarioId = getArguments().getInt(MainActivity.EXTRA_USUARIO_ID);
        }

    }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {


      Log.d(TAG,"onCreateView");
    View root = inflater.inflate(R.layout.fragment_hijos, container, false);

    mHijosList = (ListView) root.findViewById(R.id.hijos_list);
    mHijosAdapter = new C_Adapter(getActivity(), null);
    mHijosList.setAdapter(mHijosAdapter);


      Log.d(TAG, "setOnItemClickListener");
    mHijosList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


          Log.d(TAG, "nro de item: "+String.valueOf(i));
        Cursor currentItem = (Cursor) mHijosAdapter.getItem(i);
          Log.d(TAG,"despues de get item");
          Log.d(TAG,"currentItem.getInt "+String.valueOf(currentItem.getColumnIndex(HijosEntry.ID)) );
        int currentHijoId = currentItem.getInt(
          currentItem.getColumnIndex(HijosEntry.ID));

        showVacunasScreen(currentHijoId);
      }
    });


/*
      Log.d("HijosActivity", "deleteDatabase");
    getActivity().deleteDatabase(BDHelper.DATABASE_NAME);

    BDHelper = new BDHelper(getActivity());
*/


    Log.d(TAG,"loadHijos");
    loadHijos();

    //Crea las notificaciones solo la primera vez que corre la aplicacion
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
      Log.d(TAG, "prefs.getBoolean: "+String.valueOf(!prefs.getBoolean("firstTime", false)));
    if (!prefs.getBoolean("firstTime", false)) {
      // <---- run your one time code here
      loadNotificaciones();

      // mark first time has runned.
      SharedPreferences.Editor editor = prefs.edit();
      editor.putBoolean("firstTime", true);
      editor.commit();
    }

    return root;
  }



  private ArrayList<Integer> getMesesNoAplicados(String idHijo) {
    Cursor cursor = BDHelper.getNoAplicadas(idHijo);
    ArrayList<Integer> lista = new ArrayList<>();
    if (cursor.moveToFirst()) {
      do {
        lista.add(cursor.getInt(8));
      } while (cursor.moveToNext());
    }
    HashSet<Integer> hs = new HashSet<Integer>(lista);
    lista.clear();
    lista.addAll(hs);

    Collections.sort(lista);
    return lista;
  }


  private void showVacunasScreen(int currentHijoId) {

      Log.d(TAG, "showVacunasScreen, currentHijoId:" + String.valueOf(currentHijoId));
      Intent intent = new Intent(getActivity(), VacunasActivity.class);
    intent.putExtra(HijosActivity.EXTRA_HIJO_ID, currentHijoId);
    startActivity(intent);
  }

    private void loadNotificaciones() {
        new MesesNoAplicados().execute();
/*
    Calculador util = new Calculador();
    Cursor cursor = BDHelper.getHijoById("1");
    ArrayList<Integer> meses = getMesesNoAplicados("1");
    cursor.moveToFirst();
    Hijo hijo = new Hijo(cursor);
    for (int i = 0; i < meses.size(); i++) {
      String fecha = util.calcularFecha(hijo.getFecha_nac(), meses.get(i));
      new Notificacion(getActivity(),
        util.calcularNotificacion(fecha),
        hijo.getId(),
        hijo.getNombre() + " " + hijo.getApellido(),
        meses.get(i));
    }
    cursor.close();

    cursor = BDHelper.getHijoById("2");
    meses = getMesesNoAplicados("2");
    cursor.moveToFirst();
    hijo = new Hijo(cursor);
    for (int i = 0; i < meses.size(); i++) {
      String fecha = util.calcularFecha(hijo.getFecha_nac(), meses.get(i));
      new Notificacion(getActivity(),
        util.calcularNotificacion(fecha),
        hijo.getId(),
        hijo.getNombre() + " " + hijo.getApellido(),
        meses.get(i));
    }
    cursor.close();

    cursor = BDHelper.getHijoById("3");
    meses = getMesesNoAplicados("3");
    cursor.moveToFirst();
    hijo = new Hijo(cursor);
    for (int i = 0; i < meses.size(); i++) {
      String fecha = util.calcularFecha(hijo.getFecha_nac(), meses.get(i));
      new Notificacion(getActivity(),
        util.calcularNotificacion(fecha),
        hijo.getId(),
        hijo.getNombre() + " " + hijo.getApellido(),
        meses.get(i));
    }
    cursor.close();
    */
    }

  private void loadHijos() {
    new HijosLoadTask().execute();
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {

  }

  private class HijosLoadTask extends AsyncTask<Void, Void, Wrapper> {

      AlertDialog alertDialog;

      protected void onPreExecute(){
          super.onPreExecute();
          alertDialog = new AlertDialog.Builder(getActivity()).create();

      }

      protected Wrapper doInBackground(Void... params){
          Log.d(TAG, "doInBackground...");
          boolean resul = true;

          hijos = new ArrayList<Hijo>();

          MatrixCursor mc = new MatrixCursor(new String[] {HijosEntry.ID, HijosEntry.NOMBRE, HijosEntry.APELLIDO,
          HijosEntry.FECHA_NAC});

          HttpClient httpClient = new DefaultHttpClient();

          Log.d(TAG, URL_SERVICE + mUsuarioId);

          HttpGet del =
                  new HttpGet(URL_SERVICE+"com.hijo/padre/"+ mUsuarioId);

          del.setHeader("content-type", "application/json");

          try {
              HttpResponse resp = httpClient.execute(del);
              String respStr = EntityUtils.toString(resp.getEntity());

              JSONArray jArray = new JSONArray(respStr);
              if (jArray != null){
                  for (int i=0; i < jArray.length(); i++) {
                      JSONObject jObject = jArray.getJSONObject(i);
                      int id = jObject.getInt("idHijo");
                      String nombre = jObject.getString("nombre");
                      String apellido = jObject.getString("apellido");
                      String fecha_nac = jObject.getString("fechaNac");

                      Log.d(TAG, String.valueOf(id)+", "+nombre+", "+apellido+", "+fecha_nac);
                      mc.addRow(new Object[] {id, nombre, apellido, fecha_nac});
                      Log.d(TAG, "despues de addRow");
                      hijos.add(new Hijo(id, nombre, apellido, fecha_nac));
                      Log.d(TAG, "despues de addHijo");
                  }
              }else{
                  resul = false;
              }
          }catch(Exception e){
              Log.e("ServicioRest", "Error!",e);
              resul = false;
          }
          Wrapper w = new Wrapper();
          w.cursor = mc;
          w.result = resul;
          return w;
      }
      /*
    @Override
    protected Cursor doInBackground(Void... voids) {
      return BDHelper.getAllHijos();
    }

    @Override
    protected void onPostExecute(Cursor cursor) {
      if (cursor != null && cursor.getCount() > 0) {
        mHijosAdapter.swapCursor(cursor);
      } else if (cursor.isAfterLast()){
        cursor.close();
      }
    }


*/
      protected void onPostExecute(Wrapper w) {

          Log.d(TAG,"onPostExecute()");
          if (w.result) {
              if (w.cursor != null && w.cursor.getCount() > 0) {
                  mHijosAdapter.swapCursor(w.cursor);

              } else if (w.cursor.isAfterLast()){
                  w.cursor.close();
              }
          }
          else{
              alertDialog.setTitle("Error");
              alertDialog.setMessage("Correo no encontrado en la base de datos");
              alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                      new DialogInterface.OnClickListener() {
                          public void onClick(DialogInterface dialog, int which) {
                              dialog.dismiss();
                          }
                      });
              alertDialog.show();
          }
      }

  }

    public class Wrapper
    {
        public Boolean result;
        public Cursor cursor;
    }
    private class MesesNoAplicados extends AsyncTask<Void, Void, Boolean> {
        protected Boolean doInBackground(Void... params){

            Log.d(TAG, "MesesNoAplicados");
            int mes;
            String fecha_apl;
            ArrayList<Integer> meses;
            ArrayList<String> fechas;
            Calculador util = new Calculador();
            HttpClient httpClient;
            HttpGet del;

            for (Hijo hijo: hijos){
                meses = new ArrayList<>();
                fechas = new ArrayList<>();
                httpClient = new DefaultHttpClient();

                del =
                        new HttpGet(URL_SERVICE+"com.vacunashijos/vacunasnoapl/"+String.valueOf(hijo.getId())+"/0");

                del.setHeader("content-type", "application/json");

                try {
                    HttpResponse resp = httpClient.execute(del);
                    String respStr = EntityUtils.toString(resp.getEntity());
                    JSONArray jArray = new JSONArray(respStr);
                    if (jArray != null) {
                        for (int i = 0; i < jArray.length(); i++) {
                            JSONObject jObject = jArray.getJSONObject(i);
                            JSONObject jsonMes = jObject.getJSONObject("vacunas");
                            mes = jsonMes.getInt("mesAplicacion");
                            fecha_apl = jObject.getString("fechaApl");
                            if (!meses.contains(mes)){
                                meses.add(mes);
                                fechas.add(fecha_apl);
                            }
                        }
                    }
                }catch(Exception e){
                    Log.e("ServicioRest", "Error!", e);
                }

                for (int i = 0 ; i < meses.size() ; i++) {
                    new Notificacion(getActivity(),
                            util.calcularNotificacion(fechas.get(i)),
                            hijo.getId(),
                            hijo.getNombre() + " " + hijo.getApellido(),
                            meses.get(i));
                }
            }
            return true;
        }
    }
}

