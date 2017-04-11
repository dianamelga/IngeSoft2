package vacunas.app.com.appvacunas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import vacunas.app.com.appvacunas.R;


public class DetalleHijosActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detalle_hijos);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    int id = getIntent().getIntExtra(HijosActivity.EXTRA_HIJO_ID, 0);

    DetalleHijosFragment fragment = (DetalleHijosFragment)
      getSupportFragmentManager().findFragmentById(R.id.hijos_detalle_container);
    if (fragment == null) {
      fragment = DetalleHijosFragment.newInstance(id);
      getSupportFragmentManager()
        .beginTransaction()
        .add(R.id.hijos_detalle_container, fragment)
        .commit();
    }


  }

  @Override
  public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }

}
