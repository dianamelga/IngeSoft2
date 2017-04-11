package com.fpuna.myfirstapp.vista;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.fpuna.myfirstapp.adapter.HijosRecyclerViewAdapter;
import com.fpuna.myfirstapp.R;
import com.fpuna.myfirstapp.modelo.AgendaPediatricaDbHelper;
import com.fpuna.myfirstapp.modelo.Hijo;

import java.util.ArrayList;

public class VistaHijosActivity extends AppCompatActivity {

    public static final String TAG = "TAG";
    private ArrayList<Hijo> hijos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_hijos);


        Log.d(TAG, "vistaHijosActivity");


        showToolbar(getResources().getString(R.string.toolbar_title_vistaHijos),
                false);

        RecyclerView hijosRecycler = (RecyclerView) findViewById(R.id.hijo_recycler);

        hijos = buildHijos();


        /*darle forma*/

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        hijosRecycler.setLayoutManager(linearLayoutManager);

        HijosRecyclerViewAdapter hijosAdapterRecyclerView = new HijosRecyclerViewAdapter(
                hijos,R.layout.cardview_hijo,this);

        hijosRecycler.setAdapter(hijosAdapterRecyclerView);

    }

    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         /*para que se vea en versiones anteriores*/
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        /* en caso de que tenga boton de regreso hacemos que sea visible*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }

    public ArrayList<Hijo> buildHijos(){
        Log.d(TAG,"buildHijos");

        ArrayList<Hijo> hijos = new ArrayList<>();
        AgendaPediatricaDbHelper apDbHelper = new AgendaPediatricaDbHelper(this);

        SQLiteDatabase db = apDbHelper.getReadableDatabase();

        Cursor hijosCursor = apDbHelper.getAllHijos();

        if (hijosCursor != null &&  hijosCursor.getCount() > 0) {
            while (hijosCursor.moveToNext()){
                hijos.add(new Hijo(Integer.valueOf(hijosCursor.getString(0)),
                        Integer.valueOf(hijosCursor.getString(1)),
                        hijosCursor.getString(2),
                        hijosCursor.getString(3),
                        hijosCursor.getString(4),
                        hijosCursor.getString(5),
                        hijosCursor.getString(6)));
                Log.d(TAG,"Creando array...");
            }
        }

        return hijos;
    }






}
