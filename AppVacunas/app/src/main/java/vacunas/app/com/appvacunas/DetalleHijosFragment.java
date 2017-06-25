package vacunas.app.com.appvacunas;

//import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.design.widget.CollapsingToolbarLayout;

import vacunas.app.com.appvacunas.R;
import com.bumptech.glide.Glide;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import vacunas.app.com.appvacunas.clases.Hijo;
import vacunas.app.com.appvacunas.data.BDHelper;
import vacunas.app.com.appvacunas.data.HijoContract;


/**
 * Created by adriana on 9/4/2017.
 */

public class DetalleHijosFragment extends Fragment {
    private static final String URL_SERVICE = "http://192.168.0.9:8080/VacunasRest/webresources/";
    private static final String TAG = "DetalleHijosFragment";
  private static final String ARG_HIJO_ID = "hijoId";
  private int mHijoId;

  private CollapsingToolbarLayout mCollapsingView;
  private ImageView mAvatar;
  private TextView mCedula;
  private TextView mFechaNac;
  private TextView mSexo;
  private TextView mLugarNac;
  private TextView mNacionalidad;
  private TextView mDepartamento;
  private TextView mMunicipio;
  private TextView mBarrio;
  private TextView mDireccion;


  private BDHelper BDHelper;


  public DetalleHijosFragment() {
    // Required empty public constructor
  }

  public static DetalleHijosFragment newInstance(int hijoId) {
      Log.d(TAG,"newInstance. hijoId: "+String.valueOf(hijoId));
    DetalleHijosFragment fragment = new DetalleHijosFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_HIJO_ID, hijoId);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

      Log.d(TAG, "getArguments(): "+String.valueOf(getArguments()));
    if (getArguments() != null) {
      mHijoId = getArguments().getInt(ARG_HIJO_ID);
    }

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
      Log.d(TAG, "onCreateView");
    View root = inflater.inflate(R.layout.fragment_hijos_detalle, container, false);
    mCollapsingView = (CollapsingToolbarLayout) getActivity().findViewById(R.id.toolbar_layout);
    mAvatar = (ImageView) getActivity().findViewById(R.id.iv_avatar);
    mCedula = (TextView) root.findViewById(R.id.tv_cedula);
    mFechaNac = (TextView) root.findViewById(R.id.tv_fecha_nac);
    mSexo = (TextView) root.findViewById(R.id.tv_sexo);
    mLugarNac = (TextView) root.findViewById(R.id.tv_lugar_nac);
    mNacionalidad = (TextView) root.findViewById(R.id.tv_nac);
    mDepartamento = (TextView) root.findViewById(R.id.tv_departamento);
    mMunicipio = (TextView) root.findViewById(R.id.tv_municipio);
    mBarrio = (TextView) root.findViewById(R.id.tv_barrio);
    mDireccion = (TextView) root.findViewById(R.id.tv_direccion);

    BDHelper = new BDHelper(getActivity());

    loadHijo();

    return root;
  }

  private void loadHijo() {
    new GetHijoByIdTask().execute();
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    // Acciones
  }

  private void showLawyer(Hijo hijo) {
    String nombre = hijo.getNombre() + " " + hijo.getApellido();
    mCollapsingView.setTitle(nombre);
    Glide.with(this)
      .load(Uri.parse("file:///android_asset/" + ""))
      .centerCrop()
      .into(mAvatar);
    System.out.println(nombre);
    mCedula.setText(String.valueOf(hijo.getCi()));
    mFechaNac.setText(hijo.getFecha_nac());
    mSexo.setText(hijo.getSexo());
    mLugarNac.setText(hijo.getLugar_nac());
    mNacionalidad.setText(hijo.getNacionalidad());
    mDepartamento.setText(hijo.getDepartamento());
    mMunicipio.setText(hijo.getMunicipio());
    mBarrio.setText(hijo.getBarrio());
    mDireccion.setText(hijo.getDireccion());
  }

  private void showLoadError() {
    Toast.makeText(getActivity(),
      "Error al cargar información", Toast.LENGTH_SHORT).show();
  }

  private class GetHijoByIdTask extends AsyncTask<Void, Void, Cursor> {

    @Override
    protected Cursor doInBackground(Void... voids) {
      //return BDHelper.getHijoById(String.valueOf(mHijoId));

        MatrixCursor mc = new MatrixCursor(new String[] {"_id",
                HijoContract.HijosEntry.NOMBRE,
                HijoContract.HijosEntry.APELLIDO,
                HijoContract.HijosEntry.CEDULA,
                HijoContract.HijosEntry.FECHA_NAC,
                HijoContract.HijosEntry.SEXO,
                HijoContract.HijosEntry.LUGAR_NAC,
                HijoContract.HijosEntry.NACIONALIDAD,
                HijoContract.HijosEntry.DEPARTAMENTO,
                HijoContract.HijosEntry.MUNICIPIO,
                HijoContract.HijosEntry.BARRIO,
                HijoContract.HijosEntry.DIRECCION,
                HijoContract.HijosEntry.ID_PADRE});

        HttpClient httpClient = new DefaultHttpClient();

        HttpGet del =
                new HttpGet(URL_SERVICE +"com.hijo/"+ mHijoId );
        del.setHeader("content-type", "application/json");

        try {
            HttpResponse resp = httpClient.execute(del);
            String respStr = EntityUtils.toString(resp.getEntity());
            String nombre, apellido, fecha_nac, sexo, lugar_nac, nacionalidad, departamento,
                    municipio, barrio, direccion;
            int id, ci, id_usuario;

            JSONObject jObject = new JSONObject(respStr);
            id = jObject.getInt("idHijo");
            nombre = jObject.getString("nombre");
            apellido = jObject.getString("apellido");
            ci = jObject.getInt("ci");
            fecha_nac = jObject.getString("fechaNac");
            sexo = jObject.getString("sexo");
            lugar_nac = jObject.getString("lugarNac");
            nacionalidad = jObject.getString("nacionalidad");
            departamento = jObject.getString("departamento");
            municipio = jObject.getString("municipio");
            barrio = jObject.getString("barrio");
            direccion = jObject.getString("direccion");
            id_usuario = jObject.getJSONObject("idPadre").getInt("idPadre");
            mc.addRow(new Object[] {id, nombre, apellido, ci, fecha_nac, sexo, lugar_nac,
            nacionalidad, departamento, municipio, barrio, direccion, id_usuario});

        }catch (Exception e){

            Log.d(TAG, "ServicioRest: "+e.getMessage());
        }

        return mc;
    }

    @Override
    protected void onPostExecute(Cursor cursor) {
      if (cursor != null && cursor.moveToLast()) {
        showLawyer(new Hijo(cursor));
      } else {
        showLoadError();
      }
    }

  }

}
