package vacunas.app.com.appvacunas;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.apache.http.client.*;

import java.net.URL;

import vacunas.app.com.appvacunas.clases.Usuario;


public class MainActivity extends AppCompatActivity implements
  GoogleApiClient.OnConnectionFailedListener,
  View.OnClickListener {
  private GoogleApiClient client;
  private static final String TAG = "MainActivity";
  private static final int RC_SIGN_IN = 9001;
    public static final String EXTRA_USUARIO_ID = "extra_usuario_id";   //Extra para HijosActivity
  private GoogleApiClient mGoogleApiClient;
  private TextView mStatusTextView;
  private ProgressDialog mProgressDialog;
    private Usuario u;
    private String correoUsu;

    private final String  URL_SERVICE = "http://192.168.0.9:8080/VacunasRest/webresources/com.usuarios";
  /**
   * ATTENTION: This was auto-generated to implement the App Indexing API.
   * See https://g.co/AppIndexing/AndroidStudio for more information.
   */
  private GoogleApiClient client2;

  @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Views
    mStatusTextView = (TextView) findViewById(R.id.status);

    // Button listeners
    findViewById(R.id.sign_in_button).setOnClickListener(this);
    findViewById(R.id.sign_out_button).setOnClickListener(this);
   // findViewById(R.id.disconnect_button).setOnClickListener(this);
    findViewById(R.id.next_button).setOnClickListener(this);

    // [START configure_signin]
    // Configure sign-in to request the user's ID, email address, and basic
    // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
    GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
      .requestEmail()
      .build();
    // [END configure_signin]

    // [START build_client]
    // Build a GoogleApiClient with access to the Google Sign-In API and the
    // options specified by gso.
    mGoogleApiClient = new GoogleApiClient.Builder(this)
      .enableAutoManage(this /* FragmentActivity */, (GoogleApiClient.OnConnectionFailedListener) this /* OnConnectionFailedListener */)
      .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
      .build();
    // [END build_client]

    // [START customize_button]
    // Set the dimensions of the sign-in button.
    SignInButton signInButton = (SignInButton) findViewById(R.id.sign_in_button);
    signInButton.setSize(SignInButton.SIZE_STANDARD);
    // [END customize_button]
    // ATTENTION: This was auto-generated to implement the App Indexing API.
    // See https://g.co/AppIndexing/AndroidStudio for more information.
    client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
  }

  @Override
  public void onStart() {
    super.onStart();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.
    client2.connect();

    OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
    if (opr.isDone()) {
      // If the user's cached credentials are valid, the OptionalPendingResult will be "done"
      // and the GoogleSignInResult will be available instantly.
      Log.d(TAG, "Got cached sign-in");
      GoogleSignInResult result = opr.get();
      handleSignInResult(result);
    } else {
      // If the user has not previously signed in on this device or the sign-in has expired,
      // this asynchronous branch will attempt to sign in the user silently.  Cross-device
      // single sign-on will occur in this branch.
      showProgressDialog();
      opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
        @Override
        public void onResult(GoogleSignInResult googleSignInResult) {
          hideProgressDialog();
          handleSignInResult(googleSignInResult);
        }
      });
    }
    // ATTENTION: This was auto-generated to implement the App Indexing API.
    // See https://g.co/AppIndexing/AndroidStudio for more information.
    AppIndex.AppIndexApi.start(client2, getIndexApiAction0());
  }

  // [START onActivityResult]
  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
    if (requestCode == RC_SIGN_IN) {
      GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
      handleSignInResult(result);
    }
  }
  // [END onActivityResult]

  // [START handleSignInResult]

  private void handleSignInResult(GoogleSignInResult result) {
    Log.d(TAG, "handleSignInResult:" + result.isSuccess());
    if (result.isSuccess()) {
      // Signed in successfully, show authenticated UI.
      GoogleSignInAccount acct = result.getSignInAccount();
      mStatusTextView.setText(getString(R.string.signed_in_fmt, acct.getDisplayName()));
        correoUsu = acct.getEmail();
      updateUI(true);
    } else {
      // Signed out, show unauthenticated UI.
      updateUI(false);
    }
  }
  // [END handleSignInResult]

  // [START signIn]
  private void signIn() {
    Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
    startActivityForResult(signInIntent, RC_SIGN_IN);
  }
  // [END signIn]

  // [START signOut]
  private void signOut() {
    Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
      new ResultCallback<Status>() {
        @Override
        public void onResult(Status status) {
          // [START_EXCLUDE]
          updateUI(false);
          // [END_EXCLUDE]
        }
      });
  }
  // [END signOut]

  // [START revokeAccess]
  private void revokeAccess() {
    Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(
      new ResultCallback<Status>() {
        @Override
        public void onResult(Status status) {
          // [START_EXCLUDE]
          updateUI(false);
          // [END_EXCLUDE]
        }
      });
  }
  // [END revokeAccess]

  @Override
  public void onConnectionFailed(ConnectionResult connectionResult) {
    // An unresolvable error has occurred and Google APIs (including Sign-In) will not
    // be available.
    Log.d(TAG, "onConnectionFailed:" + connectionResult);
  }

  private void showProgressDialog() {
    Log.d("HijosActivity", "processDialog: " +String.valueOf(mProgressDialog));
    if (mProgressDialog == null) {
      mProgressDialog = new ProgressDialog(this);
      mProgressDialog.setMessage(getString(R.string.loading));
      mProgressDialog.setIndeterminate(true);
    }

    mProgressDialog.show();
  }

  private void hideProgressDialog() {
    if (mProgressDialog != null && mProgressDialog.isShowing()) {
      mProgressDialog.hide();
    }
  }

  private void updateUI(boolean signedIn) {
    if (signedIn) {
      findViewById(R.id.sign_in_button).setVisibility(View.GONE);
      findViewById(R.id.sign_out_and_disconnect).setVisibility(View.VISIBLE);
      findViewById(R.id.next_button).setVisibility(View.VISIBLE);
    } else {
      mStatusTextView.setText(R.string.signed_out);

      findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
      findViewById(R.id.sign_out_and_disconnect).setVisibility(View.GONE);
      findViewById(R.id.next_button).setVisibility(View.GONE);
    }
  }

    public void goToHijosActivity(){
        Intent intent = new Intent(this, HijosActivity.class);
        startActivity(intent);
    }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.sign_in_button:
        signIn();
        break;
      case R.id.sign_out_button:
        signOut();
        break;
      /*case R.id.disconnect_button:
        revokeAccess();
        break;*/
      case R.id.next_button:
          Log.d("HijosActivity","confirm()");
          confirm();
        //goToHijosActivity();
        break;
    }
  }


  /**
   * ATTENTION: This was auto-generated to implement the App Indexing API.
   * See https://g.co/AppIndexing/AndroidStudio for more information.
   */
  public Action getIndexApiAction0() {
    Thing object = new Thing.Builder()
      .setName("Main Page") // TODO: Define a title for the content shown.
      // TODO: Make sure this auto-generated URL is correct.
      .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
      .build();
    return new Action.Builder(Action.TYPE_VIEW)
      .setObject(object)
      .setActionStatus(Action.STATUS_TYPE_COMPLETED)
      .build();
  }

    private void confirm() {
        Log.d("HijosActivity","Consultar().execute()");
        new Consultar().execute();
    }   //consultar si se encuentra en la bd

    //Despues de verificar, pasa a la siguiente actividad, enviando como parametro
    //el id del usuario
    private void siguiente() {
        Intent confint = new Intent(this, HijosActivity.class);
        confint.putExtra(EXTRA_USUARIO_ID, u.getId_padre());
        startActivity(confint);
    }

  //obtener datos de la bd
    private class Consultar extends AsyncTask<Void, Void, Boolean> {

      //datos que se obtendran de la bd
      private int idUsu;
      private int ciUsu;
      private String nombreUsu;
      private int idPadreUsu;
      AlertDialog alertDialog;


      protected void onPreExecute(){
          Log.d("HijosActivity","onPreExecute()");
          //Alerta en caso de que no se encuentre en la bd
          super.onPreExecute();
          alertDialog = new AlertDialog.Builder(MainActivity.this).create();

      }

      @Override
      protected Boolean doInBackground(Void... params) {
          Log.d("HijosActivity","doInBackground()");
          boolean resul = true;

          HttpClient httpClient = new DefaultHttpClient();


          //servicio rest
          String param = URL_SERVICE+"/mail/"+correoUsu;
          Log.d("HijosActivity", "param: "+param);

          HttpGet del =
                  new HttpGet(param);

          del.setHeader("content-type", "application/json");

          /*
          HttpPost post = new HttpPost(URL_SERVICE);
          post.setHeader("content-type", "application/json");


**/
          try {
              /**
              JSONObject dato = new JSONObject();
              dato.put("correo", correoUsu);

              StringEntity entity = new StringEntity(dato.toString());
              post.setEntity(entity);
              **/


              Log.d("HijosActivity","httpClient.execute()");
              HttpResponse resp = httpClient.execute(del);
              Log.d("HijosActivity","EntityUtils.toString");
              String respStr = EntityUtils.toString(resp.getEntity());

              //se obitene el Json del usuario
              Log.d("HijosActivity","obteniendo JSON");
              JSONObject respJSON = new JSONObject(respStr);
              Log.d("HijosActivity", "JSON: "+String.valueOf(respJSON));
              idUsu = respJSON.getInt("id");

              nombreUsu = respJSON.getString("nombre");
              correoUsu = respJSON.getString("correo");
              JSONObject jsonPadre = respJSON.getJSONObject("idPadre");

              idPadreUsu = jsonPadre.getInt("idPadre");

          }catch(Exception e){
              Log.e("ServicioRest", "Error!", e);
              resul = false;
          }

          return resul;
      }

      protected void onPostExecute(Boolean result){
          Log.d("HijosActivity", "onPostExecute() -result: "+String.valueOf(result));
          if (result) {
              u = new Usuario(idUsu, nombreUsu, correoUsu, idPadreUsu);
              siguiente();
              //si no hay error pasa a la siguiente actividad
          }else{
              alertDialog.setTitle("Error");
              alertDialog.setMessage("No registrado en la base de datos");
              alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                      new DialogInterface.OnClickListener(){
                          public void onClick(DialogInterface dialog, int wich){
                              dialog.dismiss();
                          }
                      });
              alertDialog.show();
          }
      }
  }
}


