package vacunas.app.com.appvacunas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import vacunas.app.com.appvacunas.R;

public class VacunasActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_vacunas);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    VacunasFragment fragment = (VacunasFragment)
      getSupportFragmentManager().findFragmentById(R.id.vacunas_container);

    int id = getIntent().getIntExtra(HijosActivity.EXTRA_HIJO_ID, 0);

    if (fragment == null) {
      fragment = VacunasFragment.newInstance(id);
      getSupportFragmentManager().beginTransaction().add(R.id.vacunas_container, fragment).commit();
    }

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }
}
