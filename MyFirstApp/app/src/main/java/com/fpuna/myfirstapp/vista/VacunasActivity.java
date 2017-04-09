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
