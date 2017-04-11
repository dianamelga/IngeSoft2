package vacunas.app.com.appvacunas.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import vacunas.app.com.appvacunas.clases.Hijo;
import vacunas.app.com.appvacunas.clases.Vacuna;
import vacunas.app.com.appvacunas.clases.Responsable;
import vacunas.app.com.appvacunas.data.HijoContract.HijosEntry;
import vacunas.app.com.appvacunas.data.VacunaContract.VacunasEntry;
import vacunas.app.com.appvacunas.data.ResponsableContract.ResponsablesEntry;

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

    db.execSQL("CREATE TABLE " + ResponsablesEntry.TABLE_NAME + " ("
      + ResponsablesEntry._ID + " INTEGER PRIMARY KEY,"
      + ResponsablesEntry.ID + " INTEGER NOT NULL,"
      + ResponsablesEntry.CI + " INTEGER NOT NULL,"
      + ResponsablesEntry.NOMBRE + " TEXT NOT NULL,"
      + ResponsablesEntry.APELLIDO + " TEXT NOT NULL,"
      + ResponsablesEntry.CORREO + " TEXT NOT NULL,"
      + ResponsablesEntry.FECHA_NAC + " TEXT NOT NULL,"
      + ResponsablesEntry.LUGAR_NAC + " TEXT,"
      + "UNIQUE (" + ResponsablesEntry.ID + "))"
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
      + HijosEntry.BARRIO + " TEXT,"
      + HijosEntry.REFERENCIA + " TEXT,"
      + HijosEntry.NOMBRE_RESPONSABLE + " TEXT NOT NULL,"
      + HijosEntry.TELEFONO + " TEXT,"
      + HijosEntry.SEGURO + " TEXT,"
      + HijosEntry.ID_RESP + " INTEGER NOT NULL,"
      + "UNIQUE (" + HijosEntry.ID + "),"
      + "FOREIGN KEY (" + HijosEntry.ID_RESP + ") REFERENCES "
      + ResponsablesEntry.TABLE_NAME + "(" + ResponsablesEntry.ID + "))"
    );

    db.execSQL("CREATE TABLE " + VacunasEntry.TABLE_NAME + " ("
      //+ VacunasEntry._ID + " INTEGER PRIMARY KEY,"
      + VacunasEntry.ID + " INTEGER NOT NULL,"
      + VacunasEntry.NOMBRE_VAC + " TEXT NOT NULL,"
      + VacunasEntry.ID_HIJO + " INTEGER NOT NULL,"
      + VacunasEntry.EDAD + " TEXT,"
      + VacunasEntry.DOSIS + " INTEGER,"
      + VacunasEntry.FECHA + " TEXT,"
      + VacunasEntry.LOTE + " TEXT,"
      + VacunasEntry.RESPONSABLE + " TEXT,"
      + VacunasEntry.MES_APLICACION + " INTEGER NOT NULL,"
      + VacunasEntry.APLICADO + " INTEGER NOT NULL,"
      //+ "UNIQUE (" + VacunasEntry.ID + "),"
      + " PRIMARY KEY(" + VacunasEntry.ID + ", " + VacunasEntry.ID_HIJO + "), "
      + "FOREIGN KEY (" + VacunasEntry.ID_HIJO + ") REFERENCES "
      + HijosEntry.TABLE_NAME + "(" + HijosEntry.ID + "))"
    );

    insertarDatos(db);
  }


  //INSERTAR DATOS DE PRUEBA
  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
  }

  public void insertarDatos( SQLiteDatabase sqLiteDatabase) {

    //Hijos

    insertarHijos(sqLiteDatabase, new Hijo(1, 4572778, "Mauricio", "Troche", "10/12/2003",
      "San Lorenzo", "M", "Paraguaya", "Calle Capitan Cabral", "Central", "Luque",
      "Cuarto Barrio", null, "Cindy Ortega", "0981444555", null, 1));

    insertarHijos(sqLiteDatabase, new Hijo(2, 5975779, "Mirna", "Troche", "20/02/2017",
      "San Lorenzo", "F", "Paraguaya", "Calle Capitan Cabral", "Central", "Luque",
      "Cuarto Barrio", null, "Cindy Ortega", "0981333355", null, 1));

    insertarHijos(sqLiteDatabase, new Hijo(3, 5775632, "Jimy", "Amarilla", "02/06/2000",
      "Yaguaron", "M", "Paraguaya", "Calle Mcal. Lopex", "Central", "San Lorenzo",
      "Esperanza", null, "Adriana Arce", "0983123321", null, 2));

    insertarHijos(sqLiteDatabase, new Hijo(4, 8764234, "Sofia", "Frutos", "25/04/2012",
      "Luque", "F", "Paraguaya", "Las Residentas", "Paraguari", "Yaguaron",
      "San Roque", null, "Diana Melgarejo", "0971650859", null, 3));


    //Responsables

    insertarResponsable(sqLiteDatabase, new Responsable(1, 3987431, "Cindy", "Ortega",
      "cindyortega@gmail.com", "29/12/1994", "Luque"));

    insertarResponsable(sqLiteDatabase, new Responsable(2, 5218201, "Adriana", "Arce",
      "adrianaarce@gmail.com", "09/05/1995", "Yaguaron"));

    insertarResponsable(sqLiteDatabase, new Responsable(3, 4923823, "Diana", "Melgarejo",
      "dianamelga@gmail.com", "19/03/1990", "Luque"));


    //Datos de las vacunas

    insertarVacuna(sqLiteDatabase, new Vacuna(0, "BCG (Tuberculosis)", 3 , "0 meses", 1,
      "18/07/2016", "H018653", " ", 0, 1));

    insertarVacuna(sqLiteDatabase, new Vacuna(1, "Rotavirus", 3 , "2 meses", 1,
      "31/01/2017", "H018900", " ", 2, 1));

    insertarVacuna(sqLiteDatabase, new Vacuna(2, "IPV", 3, "2 meses", 1,
      "20081/2017", "I032950", " ", 2, 1));

    insertarVacuna(sqLiteDatabase, new Vacuna(3, "PCV 10 Valente", 3, "2 meses", 1,
      "13/01/2013", "P993446", " ", 2, 1));

    insertarVacuna(sqLiteDatabase, new Vacuna(4, "Pentavalente", 3, "2 meses", 1,
      "28/01/2017", "H015963", " ", 2, 1));

    insertarVacuna(sqLiteDatabase, new Vacuna(5, "OPV/IPV", 3, "4 meses", 1,
      "20/05/2017", "P233456", " ", 4, 1));

    insertarVacuna(sqLiteDatabase, new Vacuna(6, "Rotavirus", 3, "4 meses", 2,
      "18/03/2017", "H018901", " ", 4, 1));

    insertarVacuna(sqLiteDatabase, new Vacuna(7, "PCV 10 Valente", 3, " ", 2,
      " ", " ", " ", 4, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(8, "Pentavalente", 3, " ", 2,
      " ", " ", " ", 4, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(9, "OPV/IPV", 3, " ", 2,
      " ", " ", " ", 6, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(10, "Pentavalente", 3, " ", 3,
      " ", " ", " ", 6, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(11, "Influenza 1RA", 3, " ", 1,
      " ", " ", " ", 6, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(12, "Influenza 2RA", 3, " ", 1,
      " ", " ", " ", 6, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(13, "SPR", 3, " ", 1,
      " ", " ", " ", 12, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(14, "PCV 10 REF.", 3, " ", 1,
      " ", " ", " ", 12, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(15, "AA", 3, " ", 1,
      " ", " ", " ", 12, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(16, "Influenza.", 3, " ", 1,
      " ", " ", " ", 12, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(17, "V.V.Z.", 3, " ", 1,
      " ", " ", " ", 15, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(18, "V.H.A.", 3, " ", 1,
      " ", " ", " ", 15, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(19, "OPV/IPV", 3, " ", 3,
      " ", " ", " ", 18, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(20, "D.P.T.", 3, " ", 1,
      " ", " ", " ", 18, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(21, "OPV/IPV", 3, " ", 4,
      " ", " ", " ", 48, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(22, "D.P.T.", 3, " ", 2,
      " ", " ", " ", 48, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(23, "SPR", 3, " ", 2,
      " ", " ", " ", 48, 0));

    insertarTodo(sqLiteDatabase, 1);
    insertarTodo(sqLiteDatabase, 2);
    insertarTodo(sqLiteDatabase, 4);
    insertarTodo(sqLiteDatabase, 5);
  }

  private void insertarTodo(SQLiteDatabase sqLiteDatabase, int i) {
    insertarVacuna(sqLiteDatabase, new Vacuna(0, "BCG (Tuberculosis)", i, " ", 1,
      " ", " ", " ", 0, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(1, "Rotavirus", i , " ", 1,
      " ", " ", " ", 2, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(2, "IPV", i, " ", 1,
      " ", " ", " ", 2, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(3, "PCV 10 Valente", i, " ", 1,
      " ", " ", " ", 2, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(4, "Pentavalente", i, " ", 1,
      " ", " ", " ", 2, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(5, "OPV/IPV", i, " ", 1,
      " ", " ", " ", 4, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(6, "Rotavirus", i, " ", 2,
      " ", " ", " ", 4, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(7, "PCV 10 Valente", i, " ", 2,
      " ", " ", " ", 4, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(8, "Pentavalente", i, " ", 2,
      " ", " ", " ", 4, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(9, "OPV/IPV", i, " ", 2,
      " ", " ", " ", 6, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(10, "Pentavalente", i, " ", 3,
      " ", " ", " ", 6, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(11, "Influenza 1RA", i, " ", 1,
      " ", " ", " ", 6, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(12, "Influenza 2RA", i, " ", 1,
      " ", " ", " ", 6, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(13, "SPR", i, " ", 1,
      " ", " ", " ", 12, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(14, "PCV 10 REF.", i, " ", 1,
      " ", " ", " ", 12, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(15, "AA", i, " ", 1,
      " ", " ", " ", 12, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(16, "Influenza.", i, " ", 1,
      " ", " ", " ", 12, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(17, "V.V.Z.", i, " ", 1,
      " ", " ", " ", 15, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(18, "V.H.A.", i, " ", 1,
      " ", " ", " ", 15, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(19, "OPV/IPV", i, " ", 3,
      " ", " ", " ", 18, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(20, "D.P.T.", i, " ", 1,
      " ", " ", " ", 18, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(21, "OPV/IPV", i, " ", 4,
      " ", " ", " ", 48, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(22, "D.P.T.", i, " ", 2,
      " ", " ", " ", 48, 0));

    insertarVacuna(sqLiteDatabase, new Vacuna(23, "SPR", i, " ", 2,
      " ", " ", " ", 48, 0));
  }

  public long insertarResponsable(SQLiteDatabase db, Responsable responsable){
    return db.insert(
      ResponsablesEntry.TABLE_NAME,
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
    Cursor c = getReadableDatabase().rawQuery("SELECT * FROM "
        + VacunasEntry.TABLE_NAME + " WHERE " +
        VacunasEntry.MES_APLICACION + " = ? AND " +
        VacunasEntry.ID_HIJO + " = ?"
      , new String[]{vacunaMes, hijoId});
    return c;
  }

  public Cursor getNoAplicadas(String hijoId) {
    Cursor c = getReadableDatabase().rawQuery("SELECT * FROM "
        + VacunasEntry.TABLE_NAME + " WHERE " +
        VacunasEntry.APLICADO + " = ? AND " +
        VacunasEntry.ID_HIJO + " = ?"
      , new String[]{"0", hijoId});
    return c;
  }
}
