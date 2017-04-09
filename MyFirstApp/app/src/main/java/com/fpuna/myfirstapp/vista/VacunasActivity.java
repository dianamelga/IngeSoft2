package com.fpuna.myfirstapp.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;
import android.widget.TextView;

import com.fpuna.myfirstapp.R;

public class VacunasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacunas);


        showToolbar(getResources().getString(R.string.toolbar_title_vistaVacunas),
                false);

        TableLayout tableLayout = (TableLayout) findViewById(R.id.tabla_cuerpo);
        TextView vacuna1 = (TextView) findViewById(R.id.vacuna1);
        TextView vacuna2 = (TextView) findViewById(R.id.vacuna2);
        TextView vacuna3 = (TextView) findViewById(R.id.vacuna3);
        TextView vacuna4 = (TextView) findViewById(R.id.vacuna4);
        TextView vacuna5 = (TextView) findViewById(R.id.vacuna5);

        TextView edad1 = (TextView) findViewById(R.id.edad1);
        TextView edad2 = (TextView) findViewById(R.id.edad2);
        TextView edad3 = (TextView) findViewById(R.id.edad3);
        TextView edad4 = (TextView) findViewById(R.id.edad4);
        TextView edad5 = (TextView) findViewById(R.id.edad5);

        TextView fecha1 = (TextView) findViewById(R.id.fecha1);
        TextView fecha2 = (TextView) findViewById(R.id.fecha2);
        TextView fecha3 = (TextView) findViewById(R.id.fecha3);
        TextView fecha4 = (TextView) findViewById(R.id.fecha4);
        TextView fecha5 = (TextView) findViewById(R.id.fecha5);

        TextView lote1 = (TextView) findViewById(R.id.lote1);
        TextView lote2 = (TextView) findViewById(R.id.lote2);
        TextView lote3 = (TextView) findViewById(R.id.lote3);
        TextView lote4 = (TextView) findViewById(R.id.lote4);
        TextView lote5 = (TextView) findViewById(R.id.lote5);

        TextView responsable1 = (TextView) findViewById(R.id.responsable1);
        TextView responsable2 = (TextView) findViewById(R.id.responsable2);
        TextView responsable3 = (TextView) findViewById(R.id.responsable3);
        TextView responsable4 = (TextView) findViewById(R.id.responsable4);
        TextView responsable5 = (TextView) findViewById(R.id.responsable5);

        vacuna1.setText("ROTAVIRUS"); vacuna2.setText("ROTAVIRUS");
        vacuna3.setText("ROTAVIRUS"); vacuna4.setText("ROTAVIRUS");
        vacuna5.setText("ROTAVIRUS");

        edad1.setText("20"); edad2.setText("20");
        edad3.setText("20"); edad4.setText("20");
        edad5.setText("20");

        fecha1.setText("20-05-2017"); fecha2.setText("20-05-2017");
        fecha3.setText("20-05-2017"); fecha4.setText("20-05-2017");
        fecha5.setText("20-05-2017");

        lote1.setText("--"); lote2.setText("--");
        lote3.setText("--"); lote4.setText("--");
        lote5.setText("--");

        responsable1.setText("juan perez"); responsable2.setText("juan perez");
        responsable3.setText("juan perez"); responsable4.setText("juan perez");
        responsable5.setText("juan perez");



/*
        AgendaPediatricaDbHelper apDbHelper = new AgendaPediatricaDbHelper(this);

        SQLiteDatabase db = apDbHelper.getWritableDatabase();

        String[] projection = {
                AgendaPediatricaContract.VacunasHijosEntry._ID,
                AgendaPediatricaContract.VacunasHijosEntry.ID_VACUNA,
                AgendaPediatricaContract.VacunasHijosEntry.ID_HIJO,
                AgendaPediatricaContract.VacunasHijosEntry.EDAD,
                AgendaPediatricaContract.VacunasHijosEntry.FECHA_APLIC,
                AgendaPediatricaContract.VacunasHijosEntry.LOTE,
                AgendaPediatricaContract.VacunasHijosEntry.RESPONSABLE
        };

        String selection = AgendaPediatricaContract.VacunasHijosEntry._ID+ " = ? "
                + AgendaPediatricaContract.VacunasHijosEntry.ID_VACUNA + " = ? "
                + AgendaPediatricaContract.VacunasHijosEntry.ID_HIJO + " = ? "
                + AgendaPediatricaContract.VacunasHijosEntry.EDAD + " = ? "
                + AgendaPediatricaContract.VacunasHijosEntry.FECHA_APLIC + " = ? "
                + AgendaPediatricaContract.VacunasHijosEntry.LOTE + " = ? "
                + AgendaPediatricaContract.VacunasHijosEntry.RESPONSABLE + " = ? "
                ;

        String[] selectionArgs = {"my Title"};

        String sortOrder =
                AgendaPediatricaContract.VacunasHijosEntry._ID + " DESC";

        Cursor c = db.query(
                AgendaPediatricaContract.HijosEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);

        if (c.moveToFirst()) {

        }
        */
    }



    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         /*para que se vea en versiones anteriores*/
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        /* en caso de que tenga boton de regreso hacemos que sea visible*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }



}
