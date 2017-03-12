package com.fpuna.myfirstapp.vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.fpuna.myfirstapp.adapter.HijosAdapter;
import com.fpuna.myfirstapp.R;
import com.fpuna.myfirstapp.modelo.AgendaPediatricaContract;
import com.fpuna.myfirstapp.modelo.AgendaPediatricaDbHelper;
import com.fpuna.myfirstapp.modelo.Hijo;

import java.util.ArrayList;

public class VistaHijosActivity extends AppCompatActivity {

    public static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_hijos);

        showToolbar(getResources().getString(R.string.toolbar_title_vistaHijos),
                false);

        RecyclerView hijosRecycler = (RecyclerView) findViewById(R.id.hijo_recycler);

        /*darle forma*/

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        hijosRecycler.setLayoutManager(linearLayoutManager);

        HijosAdapter hijosAdapterRecyclerView = new HijosAdapter(
                buildHijos(),R.layout.cardview_hijo,this);

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

        String[] projection = {
                AgendaPediatricaContract.HijosEntry._ID,
                AgendaPediatricaContract.HijosEntry.CI,
                AgendaPediatricaContract.HijosEntry.NOMBRE,
                AgendaPediatricaContract.HijosEntry.APELLIDO,
                AgendaPediatricaContract.HijosEntry.SEXO,
                AgendaPediatricaContract.HijosEntry.FECHA_NACIMIENTO
        };

        String selection = AgendaPediatricaContract.HijosEntry.NOMBRE + " = ?";
        String[] selectionArgs = {"My Title" };

        String sortOrder =
                AgendaPediatricaContract.HijosEntry._ID + " DESC";

        Cursor c = db.query(
                AgendaPediatricaContract.HijosEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);


        Log.d(TAG,"Hay datos en la BD? " + String.valueOf(c.moveToFirst()));

        if (c.moveToFirst()) {
            Log.d(TAG, "toma datos de la BD");
            do {
                hijos.add(new Hijo(c.getString(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3),
                        c.getString(4),
                        c.getString(5)));

            }while(c.moveToNext());
        }else{
            Log.d(TAG,"Carga datos...");
            /*cargo datos*/
            hijos.add(new Hijo("1","Diana","Melgarejo", "4484526","25-05-1995","Femenino"));
            hijos.add(new Hijo("2","Diana","Melgarejo", "4484526","25-05-1995","Femenino"));
            hijos.add(new Hijo("3","Diana","Melgarejo", "4484526","25-05-1995","Femenino"));
            hijos.add(new Hijo("4","Diana","Melgarejo", "4484526","25-05-1995","Femenino"));

            try {

                for (int i=0; i<hijos.size(); i++){
                    apDbHelper.saveHijo(hijos.get(i));
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }

        return hijos;
    }


}
