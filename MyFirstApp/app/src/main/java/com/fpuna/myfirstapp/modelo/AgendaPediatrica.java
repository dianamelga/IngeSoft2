package com.fpuna.myfirstapp.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by diana on 10/03/17.
 */

public class AgendaPediatrica extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "AgendaPediatrica.db";
    public static final String TAG = "TAG";

    public AgendaPediatrica(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
   }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate AgendaPediatrica");

        db.execSQL("CREATE TABLE " + AgendaPediatricaContract.HijosEntry.TABLE_NAME + " ("
                + AgendaPediatricaContract.HijosEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AgendaPediatricaContract.HijosEntry.ID + " TEXT NOT NULL,"
                + AgendaPediatricaContract.HijosEntry.NOMBRES + " TEXT NOT NULL,"
                + AgendaPediatricaContract.HijosEntry.APELLIDOS + " TEXT NOT NULL,"
                + AgendaPediatricaContract.HijosEntry.CI + " TEXT NOT NULL,"
                + AgendaPediatricaContract.HijosEntry.FECHA_NACIMIENTO + " TEXT NOT NULL,"
                + AgendaPediatricaContract.HijosEntry.SEXO + " TEXT NOT NULL,"
                + AgendaPediatricaContract.HijosEntry.ID_PADRE + "INTEGER NOT NULL,"
                + "UNIQUE (" + AgendaPediatricaContract.HijosEntry.ID + "))");

        db.execSQL("CREATE TABLE " + AgendaPediatricaContract.PadresEntry.TABLE_NAME + " ("
                + AgendaPediatricaContract.PadresEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AgendaPediatricaContract.PadresEntry.ID + " TEXT NOT NULL, "
                + AgendaPediatricaContract.PadresEntry.NOMBRES + " TEXT NOT NULL, "
                + AgendaPediatricaContract.PadresEntry.APELLIDOS + " TEXT NOT NULL, "
                + AgendaPediatricaContract.PadresEntry.CI + " TEXT NOT NULL, "
                + AgendaPediatricaContract.PadresEntry.RUC + " TEXT NOT NULL, "
                + AgendaPediatricaContract.PadresEntry.FECHA_NACIMIENTO + " TEXT NOT NULL, "
                + AgendaPediatricaContract.PadresEntry.SEXO + " TEXT NOT NULL, "
                + AgendaPediatricaContract.PadresEntry.CORREO + " TEXT NOT NULL, "
                + " UNIQUE (" + AgendaPediatricaContract.PadresEntry.ID + "))"
        );

        db.execSQL("CREATE TABLE " + AgendaPediatricaContract.VacunasEntry.TABLE_NAME + " ("
                + AgendaPediatricaContract.VacunasEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AgendaPediatricaContract.VacunasEntry.ID + " TEXT NOT NULL, "
                + AgendaPediatricaContract.VacunasEntry.NOMBRE_VACUNA + " TEXT NOT NULL, "
                + AgendaPediatricaContract.VacunasEntry.NRO_SEMANA + " INTEGER NOT NULL, "
                + AgendaPediatricaContract.VacunasEntry.CANT_DOSIS + " INTEGER NOT NULL, "
                + "UNIQUE (" + AgendaPediatricaContract.VacunasEntry.ID + "))");


        db.execSQL("CREATE TABLE " + AgendaPediatricaContract.VacunasHijosEntry.TABLE_NAME + " ("
                + AgendaPediatricaContract.VacunasHijosEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AgendaPediatricaContract.VacunasHijosEntry.ID_VACUNA + " TEXT NOT NULL, "
                + AgendaPediatricaContract.VacunasHijosEntry.ID_HIJO + " TEXT NOT NULL, "
                + AgendaPediatricaContract.VacunasHijosEntry.EDAD + " INTEGER NOT NULL, "
                + AgendaPediatricaContract.VacunasHijosEntry.FECHA_APLIC + " TEXT NOT NULL, "
                + AgendaPediatricaContract.VacunasHijosEntry.LOTE + " TEXT NOT NULL, "
                + AgendaPediatricaContract.VacunasHijosEntry.RESPONSABLE + " TEXT NOT NULL, "
                + " UNIQUE (" + AgendaPediatricaContract.VacunasHijosEntry.ID_HIJO + ", "
                + AgendaPediatricaContract.VacunasHijosEntry.ID_VACUNA + "))");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("CREATE TABLE " + AgendaPediatricaContract.HijosEntry.TABLE_NAME + " ("
                + AgendaPediatricaContract.HijosEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AgendaPediatricaContract.HijosEntry.ID + " TEXT NOT NULL,"
                + AgendaPediatricaContract.HijosEntry.NOMBRES + " TEXT NOT NULL,"
                + AgendaPediatricaContract.HijosEntry.APELLIDOS + " TEXT NOT NULL,"
                + AgendaPediatricaContract.HijosEntry.CI + " TEXT NOT NULL,"
                + AgendaPediatricaContract.HijosEntry.FECHA_NACIMIENTO + " TEXT NOT NULL,"
                + AgendaPediatricaContract.HijosEntry.SEXO + " TEXT NOT NULL,"
                + AgendaPediatricaContract.HijosEntry.ID_PADRE + "INTEGER NOT NULL,"
                + "UNIQUE (" + AgendaPediatricaContract.HijosEntry.ID + "))");

        db.execSQL("CREATE TABLE " + AgendaPediatricaContract.PadresEntry.TABLE_NAME + " ("
                + AgendaPediatricaContract.PadresEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AgendaPediatricaContract.PadresEntry.ID + " TEXT NOT NULL, "
                + AgendaPediatricaContract.PadresEntry.NOMBRES + " TEXT NOT NULL, "
                + AgendaPediatricaContract.PadresEntry.APELLIDOS + " TEXT NOT NULL, "
                + AgendaPediatricaContract.PadresEntry.CI + " TEXT NOT NULL, "
                + AgendaPediatricaContract.PadresEntry.RUC + " TEXT NOT NULL, "
                + AgendaPediatricaContract.PadresEntry.FECHA_NACIMIENTO + " TEXT NOT NULL, "
                + AgendaPediatricaContract.PadresEntry.SEXO + " TEXT NOT NULL, "
                + AgendaPediatricaContract.PadresEntry.CORREO + " TEXT NOT NULL, "
                + " UNIQUE (" + AgendaPediatricaContract.PadresEntry.ID + "))"
        );

        db.execSQL("CREATE TABLE " + AgendaPediatricaContract.VacunasEntry.TABLE_NAME + " ("
                + AgendaPediatricaContract.VacunasEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AgendaPediatricaContract.VacunasEntry.ID + " TEXT NOT NULL, "
                + AgendaPediatricaContract.VacunasEntry.NOMBRE_VACUNA + " TEXT NOT NULL, "
                + AgendaPediatricaContract.VacunasEntry.NRO_SEMANA + " INTEGER NOT NULL, "
                + AgendaPediatricaContract.VacunasEntry.CANT_DOSIS + " INTEGER NOT NULL, "
                + "UNIQUE (" + AgendaPediatricaContract.VacunasEntry.ID + "))");


        db.execSQL("CREATE TABLE " + AgendaPediatricaContract.VacunasHijosEntry.TABLE_NAME + " ("
                + AgendaPediatricaContract.VacunasHijosEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AgendaPediatricaContract.VacunasHijosEntry.ID_VACUNA + " TEXT NOT NULL, "
                + AgendaPediatricaContract.VacunasHijosEntry.ID_HIJO + " TEXT NOT NULL, "
                + AgendaPediatricaContract.VacunasHijosEntry.EDAD + " INTEGER NOT NULL, "
                + AgendaPediatricaContract.VacunasHijosEntry.FECHA_APLIC + " TEXT NOT NULL, "
                + AgendaPediatricaContract.VacunasHijosEntry.LOTE + " TEXT NOT NULL, "
                + AgendaPediatricaContract.VacunasHijosEntry.RESPONSABLE + " TEXT NOT NULL, "
                + " UNIQUE (" + AgendaPediatricaContract.VacunasHijosEntry.ID_HIJO + ", "
                + AgendaPediatricaContract.VacunasHijosEntry.ID_VACUNA + "))");

    }


    public long saveHijo(Hijo hijo) {
        Log.d(TAG,"saveHijo AgendaPediatrica");
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                AgendaPediatricaContract.HijosEntry.TABLE_NAME,
                null,
                hijo.toContentValues());

    }

    public Cursor getHijos() {
        return getReadableDatabase()
                .query(
                        AgendaPediatricaContract.HijosEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getHijosById(String lawyerId) {
        Cursor c = getReadableDatabase().query(
                AgendaPediatricaContract.HijosEntry.TABLE_NAME,
                null,
                AgendaPediatricaContract.HijosEntry.ID + " LIKE ?",
                new String[]{lawyerId},
                null,
                null,
                null);
        return c;
    }

}
