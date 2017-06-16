package vacunas.app.com.appvacunas.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

import vacunas.app.com.appvacunas.clases.Hijo;
import vacunas.app.com.appvacunas.clases.Usuario;
import vacunas.app.com.appvacunas.clases.Vacuna;
import vacunas.app.com.appvacunas.clases.VacunaHijo;
import vacunas.app.com.appvacunas.data.PadreContract.PadresEntry;
import vacunas.app.com.appvacunas.data.VacunaContract.VacunasEntry;

import vacunas.app.com.appvacunas.data.HijoContract.HijosEntry;
import vacunas.app.com.appvacunas.data.VacunaHijoContract.VacunaHijosEntry;
import vacunas.app.com.appvacunas.data.UsuarioContract.UsuariosEntry;

/**
 * Created by adriana on 9/4/2017.
 */

public class BDHelper extends SQLiteOpenHelper {

  public static final int DATABASE_VERSION = 1;
  public static final String DATABASE_NAME = "DQ.db";

  public BDHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {

    db.execSQL("CREATE TABLE " + UsuariosEntry.TABLE_NAME + " ("
            + UsuariosEntry._ID + " INTEGER PRIMARY KEY,"
            + UsuariosEntry.ID + " INTEGER NOT NULL,"
            + UsuariosEntry.NOMBRE + " TEXT NOT NULL,"
            + UsuariosEntry.CORREO + " TEXT NOT NULL,"
            + UsuariosEntry.ID_PADRE + " INTEGER NOT NULL,"
            + "UNIQUE (" + UsuariosEntry.ID + "))"
    );

    db.execSQL("CREATE TABLE " + HijosEntry.TABLE_NAME + " ("
      + HijosEntry._ID + " INTEGER PRIMARY KEY,"
      + HijosEntry.ID + " INTEGER NOT NULL,"
      + HijosEntry.CEDULA + " INTEGER NOT NULL,"
      + HijosEntry.NOMBRE + " TEXT NOT NULL,"
      + HijosEntry.APELLIDO + " TEXT NOT NULL,"
      + HijosEntry.FECHA_NAC + " TEXT NOT NULL,"
      + HijosEntry.LUGAR_NAC + " TEXT,"
      + HijosEntry.SEXO + " TEXT NOT NULL,"
      + HijosEntry.NACIONALIDAD + " TEXT NOT NULL,"
      + HijosEntry.DIRECCION + " TEXT,"
      + HijosEntry.DEPARTAMENTO + " TEXT,"
      + HijosEntry.MUNICIPIO + " TEXT,"
            + HijosEntry.ID_PADRE + " INTEGER NOT NULL, "
      + HijosEntry.BARRIO + " TEXT,"
      + HijosEntry.REFERENCIA + " TEXT,"
      + HijosEntry.TELEFONO + " TEXT,"
      + HijosEntry.SEGURO + " TEXT,"
      + "UNIQUE (" + HijosEntry.ID + "),"
      + "FOREIGN KEY (" + HijosEntry.ID_PADRE + ") REFERENCES "
      + PadresEntry.TABLE_NAME + "(" + PadresEntry.ID + "))"
    );

      db.execSQL("CREATE TABLE "+ VacunasEntry.TABLE_NAME + " ("
      + VacunasEntry.ID + " INTEGER NOT NULL, "
      + VacunasEntry.NRO_DOSIS + " INTEGER NOT NULL, "
      + VacunasEntry.NOMBRE_VACUNA + " TEXT NOT NULL, "
      + VacunasEntry.MES_APLICACION + " INTEGER NOT NULL, "
      + VacunasEntry.CANT_DOSIS + " INTEGER NOT NULL, "
      + " PRIMARY KEY ("+ VacunasEntry.ID + "))");

    db.execSQL("CREATE TABLE " + VacunaHijosEntry.TABLE_NAME + " ("
      //+ VacunasEntry._ID + " INTEGER PRIMARY KEY,"
      + VacunaHijosEntry.ID + " INTEGER NOT NULL,"
            + VacunaHijosEntry.NRO_DOSIS + " INTEGER NOT NULL,"

            + VacunaHijosEntry.ID_HIJO + " INTEGER NOT NULL, "
            + VacunaHijosEntry.FECHA_PROGRAMADA + " TEXT NOT NULL, "
            + VacunaHijosEntry.LOTE + " TEXT NOT NULL, "
            + VacunaHijosEntry.RESPONSABLE + " TEXT NOT NULL, "
            + VacunaHijosEntry.APLICADO + " INTEGER NOT NULL, "
            + VacunaHijosEntry.FECHA_APLICACION + " TEXT NOT NULL, "
            + VacunaHijosEntry.DIAS_ATRASO + " INTEGER NOT NULL, "
            + VacunaHijosEntry.MES_APLICACION + " INTEGER NOT NULL, "
            + VacunaHijosEntry.NOMBRE_VAC + " TEXT NOT NULL,"

      //+ "UNIQUE (" + VacunasEntry.ID + "),"
      + " PRIMARY KEY(" + VacunaHijosEntry.ID + ", " + VacunaHijosEntry.NRO_DOSIS +
            ", " + VacunaHijosEntry.ID_HIJO + "))"
            /*+ "), "
      + "FOREIGN KEY (" + VacunaHijosEntry.ID_HIJO + ") REFERENCES "
      + HijosEntry.TABLE_NAME + "(" + HijosEntry.ID + "), "
            + "FOREIGN KEY (" + VacunaHijosEntry.ID + ", "
            + VacunaHijosEntry.NRO_DOSIS + ") REFERENCES "
            + VacunasEntry.TABLE_NAME + "(" + VacunasEntry.ID + ", "
            + VacunasEntry.NRO_DOSIS + "))"*/
    );

    insertarDatos(db);
  }


  //INSERTAR DATOS DE PRUEBA
  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
  }

  public void insertarDatos( SQLiteDatabase sqLiteDatabase) {

      Log.d("HijosActivity", "*********insertarDatos********");

    //Hijos
      ArrayList<Hijo> hijos = new ArrayList<>();
      hijos.add( new Hijo(1, 4572778, "Mauricio", "Troche", "10/12/2003",
              "San Lorenzo", "M", "Paraguaya", "Calle Capitan Cabral", "Central", "Luque",1,
              "Cuarto Barrio", null, "0981444555", null));
      hijos.add(new Hijo(2, 5975779, "Mirna", "Troche", "20/02/2017",
              "San Lorenzo", "F", "Paraguaya", "Calle Capitan Cabral", "Central", "Luque", 1,
              "Cuarto Barrio", null, "0981333355", null));

      hijos.add(new Hijo(3, 5775632, "Jimy", "Amarilla", "02/06/2000",
              "Yaguaron", "M", "Paraguaya", "Calle Mcal. Lopex", "Central", "San Lorenzo",1,
              "Esperanza", null, "0983123321", null));
      hijos.add(new Hijo(4, 8764234, "Sofia", "Frutos", "25/04/2012",
              "Luque", "F", "Paraguaya", "Las Residentas", "Paraguari", "Yaguaron",1,
              "San Roque", null, "0971650859", null));


      for (int i=0; i < hijos.size(); i++){
          long result = insertarHijos(sqLiteDatabase, hijos.get(i));
          Log.d("HijosActivity"," result insertarHijos: "+String.valueOf(result));
      }


    //Usuarios Responsables

    insertarUsuario(sqLiteDatabase, new Usuario(1, 3987431, "Cindy",
      "cindyortega@gmail.com", 1));

      insertarUsuario(sqLiteDatabase, new Usuario(2, 5218201, "Adriana",
      "adrianaarce@gmail.com", 1));

      insertarUsuario(sqLiteDatabase, new Usuario(3, 4923823, "Diana",
      "di.melgarejo@gmail.com", 1));


    //Datos de las vacunas

      ArrayList<Vacuna> vacunas = new ArrayList<Vacuna>();
      vacunas.add(new Vacuna(1, 1, "BCG (Tuberculosis)", 0, 1));
      vacunas.add(new Vacuna(2,1, "Rotavirus", 2 , 2));
      vacunas.add(new Vacuna(2,2, "Rotavirus", 4 , 2));
      vacunas.add(new Vacuna(3, 1, "IPV", 2, 5));
      vacunas.add(new Vacuna(3, 2, "IPV", 4, 5));
      vacunas.add(new Vacuna(3, 3, "IPV", 6, 5));
      vacunas.add(new Vacuna(3, 4, "IPV", 18, 5));
      vacunas.add(new Vacuna(3, 5, "IPV", 48, 5));
      vacunas.add(new Vacuna(4, 1, "PCV 10 Valente", 2, 3));
      vacunas.add(new Vacuna(4, 2, "PCV 10 Valente", 4, 3));
      vacunas.add(new Vacuna(4, 3, "PCV 10 Valente", 12, 3));
      vacunas.add(new Vacuna(5,1, "Pentavalente", 2, 2));
      vacunas.add(new Vacuna(5,2, "Pentavalente", 4, 2));
      vacunas.add(new Vacuna(5,3, "Pentavalente", 6, 2));
      vacunas.add( new Vacuna(6, 1, "OPV/IPV", 4, 4));
      vacunas.add( new Vacuna(6, 2, "OPV/IPV", 6, 4));
      vacunas.add(new Vacuna(6, 3, "OPV/IPV", 18, 4));
      vacunas.add(new Vacuna(6, 4, "OPV/IPV", 48, 4));
      vacunas.add(new Vacuna(7, 1, "Influenza 1ra", 6, 1));
      vacunas.add(new Vacuna(8, 1, "Influenza 2ra", 6, 1));
      vacunas.add(new Vacuna(9, 1, "S.P.R", 12, 2));
      vacunas.add(new Vacuna(9, 2, "S.P.R", 12, 2));
      vacunas.add(new Vacuna(10, 1, "A.A", 12, 1));
      vacunas.add(new Vacuna(12, 1, "V.V.Z", 15, 1));
      vacunas.add( new Vacuna(13, 1, "V.H.A", 15, 1));
      vacunas.add(new Vacuna(14, 1, "D.P.T", 18, 1));


      long result;

          for (int i = 0; i < vacunas.size(); i++) {
              result = insertarVacuna(sqLiteDatabase, vacunas.get(i));
              Log.d("HijosActivity", "result insertarVacuna: "+String.valueOf(result));
              for (int j = 0; j < hijos.size(); j++) {
                  result = insertarTodo(sqLiteDatabase, vacunas.get(i), hijos.get(j));

                  Log.d("HijosActivity", "result insertarTodo: "+String.valueOf(result));
              }

          }
      Log.d("HijosActivity", " FIN FOR VACUNAS");

  }


  public long insertarTodo(SQLiteDatabase db, Vacuna vacuna, Hijo hijo) {
      Log.d("HijosActivity", "insertar todo...");
      VacunaHijo vacunaHijo = new VacunaHijo(
              vacuna.getId(),
              vacuna.getNro_dosis(),
              hijo.getId(),
              vacuna.getNombre_vacuna(),
              "15/06/2017",
              "",
              "Dr.Duarte",
              0,/*aplicado*/
              "15/06/2017",
              0,
              vacuna.getMes_aplicacion(),
              0
      );

      long insert =0;
      try {
          insert = db.insert(
                  VacunaHijosEntry.TABLE_NAME,
                  null,
                  vacunaHijo.toContentValues());
      }catch(Exception e){
          Log.d("HijosActivity", "SQLException: "+e.getMessage());
      }
      return insert;

  }

  public long insertarUsuario(SQLiteDatabase db, Usuario responsable){
    return db.insert(
      UsuariosEntry.TABLE_NAME,
      null,
      responsable.toContentValues());
  }

  public long insertarHijos(SQLiteDatabase db, Hijo hijo){
    return db.insert(
      HijosEntry.TABLE_NAME,
      null,
      hijo.toContentValues());
  }

  public long insertarVacuna(SQLiteDatabase db, Vacuna vacuna){
    return db.insert(
      VacunasEntry.TABLE_NAME,
      null,
      vacuna.toContentValues());
  }

  public Cursor getAllHijos() {
    return getReadableDatabase()
      .query(
        HijosEntry.TABLE_NAME,
        null,
        null,
        null,
        null,
        null,
        null);
  }

  public Cursor getHijoById(String hijoId) {
    Cursor c = getReadableDatabase().query(
      HijosEntry.TABLE_NAME,
      null,
      HijosEntry.ID + " = ?",
      new String[]{hijoId},
      null,
      null,
      null);
    return c;
  }

  public Cursor getHijoBySex(String hijoSexo) {
    Cursor c = getReadableDatabase().query(
      HijosEntry.TABLE_NAME,
      null,
      HijosEntry.SEXO + " = ?",
      new String[]{hijoSexo},
      null,
      null,
      null);
    return c;
  }

  public Cursor getVacunasByMes(String vacunaMes, String hijoId) {
      String query = " SELECT * FROM "
              + VacunaHijosEntry.TABLE_NAME + " WHERE " +
              VacunaHijosEntry.MES_APLICACION + " = ? AND " +
              VacunaHijosEntry.ID_HIJO + " = ? ";

      Log.d("HijosActivity", "query: "+query+ " "+ vacunaMes + " " + hijoId);

    Cursor c = getReadableDatabase().rawQuery(query
      , new String[]{vacunaMes, hijoId});
    return c;
  }

  public Cursor getNoAplicadas(String hijoId) {
    Cursor c = getReadableDatabase().rawQuery("SELECT * FROM "
        + VacunaHijosEntry.TABLE_NAME + " WHERE " +
                    VacunaHijosEntry.APLICADO + " = ? AND " +
                    VacunaHijosEntry.ID_HIJO + " = ?"
      , new String[]{"0", hijoId});
    return c;
  }
}
