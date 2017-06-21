package vacunas.app.com.appvacunas;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import vacunas.app.com.appvacunas.R;
import vacunas.app.com.appvacunas.clases.Notificacion;

public class HijosActivity extends AppCompatActivity {

  public static final String EXTRA_HIJO_ID = "extra_hijo_id";
  public static final String TAG = "HijosActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_hijos);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    HijosFragment fragment = (HijosFragment)
      getSupportFragmentManager().findFragmentById(R.id.hijos_container);


      int id = getIntent().getIntExtra(MainActivity.EXTRA_USUARIO_ID,0);

    Log.d(TAG, "fragment is null: "+String.valueOf(fragment));
    if (fragment == null) {
      fragment = HijosFragment.newInstance(id);

      getSupportFragmentManager().beginTransaction().add(R.id.hijos_container, fragment).commit();
    }



    /*Crea las notificaciones solo la primera vez que corre la aplicacion
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

    if (!prefs.getBoolean("firstTime", false)) {
      // <---- run your one time code here
      loadNotificaciones();

      // mark first time has runned.
      SharedPreferences.Editor editor = prefs.edit();
      editor.putBoolean("firstTime", true);
      editor.commit();
    }
  }

  private void loadNotificaciones() {
    new Notificacion(this,"09/04/2017", 1, "Norma", 01);*/
 }
}
