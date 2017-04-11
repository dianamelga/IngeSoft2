package com.fpuna.myfirstapp.vista;

import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;

import com.fpuna.myfirstapp.R;
import com.fpuna.myfirstapp.Utiles;
import com.fpuna.myfirstapp.modelo.AgendaPediatricaDbHelper;
import com.fpuna.myfirstapp.modelo.Hijo;
import com.fpuna.myfirstapp.modelo.Vacuna;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.fpuna.myfirstapp.modelo.ExpandableListAdapter;

public class VacunasActivity extends AppCompatActivity {

    private static final String ARG_HIJO_ID = "hijoId";
    private int mHijoId;
    private AgendaPediatricaDbHelper apDBHelper;

    private ExpandableListView mVacunasList;
    private ExpandableListAdapter mVacunasAdapter;
    List<String> listDataHeader;
    HashMap<String, List<Vacuna>> listDataChild;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacunas);

        //mHijoId = Integer.valueOf(getIntent().getExtras().getString(ARG_HIJO_ID));



        showToolbar(getResources().getString(R.string.toolbar_title_vistaVacunas),
                false);

        mVacunasList = (ExpandableListView) findViewById(R.id.lvExp);
        apDBHelper = new AgendaPediatricaDbHelper(this);
        prepareListData();
        mVacunasAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        mVacunasList.setAdapter(mVacunasAdapter);

    }


    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         /*para que se vea en versiones anteriores*/
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        /* en caso de que tenga boton de regreso hacemos que sea visible*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }


    private class DatosLoadTask extends AsyncTask<String, Void, ArrayList> {

        @Override
        protected ArrayList<Vacuna> doInBackground(String... par) {
            Cursor cursor = apDBHelper.getVacunasByMes(par[0], par[1]);
            Cursor cHIjo = apDBHelper.getAllHijos();
            //Cursor cHIjo = apDBHelper.getHijoById(String.valueOf(mHijoId));
            cHIjo.moveToFirst();
            Hijo hijo = new Hijo(cHIjo);
            String fecha;
            ArrayList<Vacuna> mArrayList = new ArrayList<Vacuna>();
            for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                // The Cursor is now set to the right position
                Vacuna v = new Vacuna(cursor);
                Utiles ut = new Utiles();
                fecha = ut.calcularFechaAAplicar(hijo.getFecha_nac(), v.getMes_aplicacion());
                v.setFecha_apl(fecha);
                mArrayList.add(v);
            }
            cHIjo.close();
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
