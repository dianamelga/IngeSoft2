package com.fpuna.myfirstapp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.fpuna.myfirstapp.R;
import com.fpuna.myfirstapp.modelo.Hijo;
import com.fpuna.myfirstapp.vista.VacunasActivity;

import java.util.ArrayList;

/**
 * Created by diana on 10/03/17.
 */

public class HijosRecyclerViewAdapter extends RecyclerView.Adapter<HijosRecyclerViewAdapter.HijosViewHolder> {
    private static final String ARG_HIJO_ID = "hijoId";

    private ArrayList<Hijo> hijos;
    private int resource;/*recurso o cardview layout*/
    private Activity activity;


    public HijosRecyclerViewAdapter(ArrayList<Hijo> hijos, int resource, Activity activity) {
        this.hijos = hijos;
        this.resource = resource; /*cardview.xml*/
        this.activity = activity;
    }


    @Override
    public HijosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent,false);
        return new HijosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final HijosViewHolder holder, int position) {
        /*aca se trabaja con la lista de elementos, asignamos los datos
        * al cardview */

        Hijo hijo = hijos.get(position);
        holder.nombre_hijo.setText(hijo.getNombre()+ " "+hijo.getApellido());
        holder.edad_hijo.setText(Integer.toString(hijo.getEdad()));
        holder.sexo_hijo.setText(hijo.getSexo());
        holder.button_detalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVacunasActivity();// hay que pasarle id Hijo
            }
        });

    }


    @Override
    public int getItemCount() {
        return hijos.size();
    }


    public class HijosViewHolder extends RecyclerView.ViewHolder{
        /* todos los views que componen al cardview*/

        //private ImageView picture_card;
        private TextView nombre_hijo;
        private TextView edad_hijo;
        private TextView sexo_hijo;
        private Button button_detalle;
        private TextView id_hijo;

        public HijosViewHolder(View itemView) {
            super(itemView);

            nombre_hijo = (TextView) itemView.findViewById(R.id.nombre_hijo);
            edad_hijo = (TextView) itemView.findViewById(R.id.edad_hijo);
            sexo_hijo = (TextView) itemView.findViewById(R.id.sexo_hijo);
            button_detalle = (Button) itemView.findViewById(R.id.button_detalle);
            id_hijo = (TextView) itemView.findViewById(R.id.id_hijo);
        }
    }

    public void goToVacunasActivity(){
        //llamado por boton detalle en cardview hijo
        Intent intent = new Intent(activity, VacunasActivity.class);
        //intent.putExtra(ARG_HIJO_ID,hijoId);
        activity.startActivity(intent);

    }
}
