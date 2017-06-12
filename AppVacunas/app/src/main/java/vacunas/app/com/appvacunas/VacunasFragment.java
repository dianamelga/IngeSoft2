package vacunas.app.com.appvacunas;

import android.app.Activity;
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
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vacunas.app.com.appvacunas.R.id;
import vacunas.app.com.appvacunas.Calculador;
import vacunas.app.com.appvacunas.clases.Hijo;
import vacunas.app.com.appvacunas.clases.ListAdapter;
import vacunas.app.com.appvacunas.clases.Vacuna;
import vacunas.app.com.appvacunas.data.BDHelper;

/**
 * Created by adriana on 9/4/2017.
 */

public class VacunasFragment extends Fragment {
  private static final String ARG_HIJO_ID = "hijoId";
  private int mHijoId;

  private BDHelper mDQbdHelper;

  private ExpandableListView mVacunasList;
  private ListAdapter mVacunasAdapter;

  List<String> listDataHeader;
  HashMap<String, List<Vacuna>> listDataChild;


  public VacunasFragment() {
    // Required empty public constructor
  }

  public static VacunasFragment newInstance(int hijoId) {
    Log.d("HijosActivity", "hijoId: "+String.valueOf(hijoId));
    VacunasFragment fragment = new VacunasFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_HIJO_ID, hijoId);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
      Log.d("HijosActivity", "onCreateView");
    View root = inflater.inflate(R.layout.fragment_vacunas, container, false);
    mVacunasList = (ExpandableListView) root.findViewById(R.id.lvExp);
    mDQbdHelper = new BDHelper(getActivity());
    prepareListData();
    mVacunasAdapter = new ListAdapter(getActivity(), listDataHeader, listDataChild);
    mVacunasList.setAdapter(mVacunasAdapter);

    return root;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

      Log.d("HijosActivity", "onCreate");
    if (getArguments() != null) {
      mHijoId = getArguments().getInt(ARG_HIJO_ID);
        Log.d("HijosActivity", "mHijoId: "+String.valueOf(mHijoId));
    }

    setHasOptionsMenu(true);

  }

  public boolean onOptionsItemSelected(MenuItem item) {
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

  private class DatosLoadTask extends AsyncTask<String, Void, ArrayList> {

    @Override
    protected ArrayList<Vacuna> doInBackground(String... par) {
      Cursor cursor = mDQbdHelper.getVacunasByMes(par[0], par[1]);
      Cursor cHIjo = mDQbdHelper.getHijoById(String.valueOf(mHijoId));
      cHIjo.moveToFirst();
      Hijo hijo = new Hijo(cHIjo);
      String fecha;
      ArrayList<Vacuna> mArrayList = new ArrayList<Vacuna>();
        Log.d("HijosActivity", String.valueOf(!cursor.isAfterLast()));
      for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
        // The Cursor is now set to the right position
        Vacuna v = new Vacuna(cursor);
        Calculador ut = new Calculador();
        fecha = ut.calcularFecha(hijo.getFecha_nac(), v.getMes_aplicacion());
        v.setFecha_apl(fecha);
        mArrayList.add(v);
      }
      cHIjo.close();
        Log.d("HijosActivity", "mArrayList.size(): "+String.valueOf(mArrayList.size()));
      return  mArrayList;
    }
  }



  private void prepareListData() {
    listDataHeader = new ArrayList<String>();
    listDataChild = new HashMap<String, List<Vacuna>>();

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
    List<Vacuna> lista = new DatosLoadTask().doInBackground("0", String.valueOf(mHijoId));

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
}
