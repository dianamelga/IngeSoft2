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

public class AgendaPediatricaDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "AgendaPediatrica.db";
    public static final String TAG = "TAG";

    public AgendaPediatricaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
   }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG,"onCreate AgendaPediatricaDbHelper");

        db.execSQL("CREATE TABLE " + AgendaPediatricaContract.HijosEntry.TABLE_NAME + " ("
                + AgendaPediatricaContract.HijosEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + AgendaPediatricaContract.HijosEntry.ID + " TEXT NOT NULL,"
                + AgendaPediatricaContract.HijosEntry.NOMBRE + " TEXT NOT NULL,"
                + AgendaPediatricaContract.HijosEntry.APELLIDO + " TEXT NOT NULL,"
                + AgendaPediatricaContract.HijosEntry.CI + " TEXT NOT NULL,"
                + AgendaPediatricaContract.HijosEntry.FECHA_NACIMIENTO + " TEXT NOT NULL,"
                + AgendaPediatricaContract.HijosEntry.SEXO + " TEXT NOT NULL,"
                + "UNIQUE (" + AgendaPediatricaContract.HijosEntry.ID + "))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    public long saveHijo(Hijo hijo) {
        Log.d(TAG,"saveHijo AgendaPediatricaDbHelper");
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
