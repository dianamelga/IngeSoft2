package com.fpuna.myfirstapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.fpuna.myfirstapp.modelo.AgendaPediatricaContract;
import com.fpuna.myfirstapp.modelo.Hijo;

/**
 * Created by diana on 12/03/17.
 */

public class BDAdapter {

    private static final String NOMBRE_BASE_DATOS =
            "mibasededatos.db";
    private static final String TABLA_BASE_DATOS = "mainTable";
    private static final int VERSION_BASE_DATOS = 1;
    // Nombre de la columna de clave primaria
    public static final String CP_ID="_id";
    // El nombre e índice de cada columna en la base de datos
    public static final String COLUMNA_NOMBRE="nombre";
    public static final int COLUMNA_INDICE = 1;
    // PENDIENTE: crear campos adicionales para el resto de columnas
// de la base de datos
// Sentencia SQL para crear una nueva base de datos
    private static final String CREAR_BASE_DATOS = "create table " +
            TABLA_BASE_DATOS + " (" + CP_ID +
            " integer primary key autoincrement, " +
            COLUMNA_NOMBRE + " text not null);";
    // Variable para almacenar la instancia de la base de datos
    private SQLiteDatabase db;
    // Contexto de la aplicación que está usando la base de datos
    private final Context contexto;
    // Clase helper, usada para crear o actualizar la base de datos
// (hablamos de ella en la siguiente sección)
    private miHelperBD dbHelper;
    // Crea la base de datos con ayuda del helper

    public BDAdapter(Context _contexto) {
        contexto = _contexto;
        dbHelper = new miHelperBD(contexto, NOMBRE_BASE_DATOS,
                null,
                VERSION_BASE_DATOS);
    }
    // Abre una base de datos ya existente
    public BDAdapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    // Cierra la base de datos, cuando ésta ya no va a ser utilizada
    public void close() {
        db.close();
    }
// Método para insertar un elemento en la tabla de la base de datos
    public int insertar(Hijo hijo) {
// PENDIENTE: crear nuevos elementos ContentValues para representar
// al objeto e insertarlos en la base de datos
// Devolvemos el índice del nuevo elemento en la base de datos

        SQLiteDatabase sqLiteDatabase = miHelperBD.getWritableDatabase();

        return sqLiteDatabase.insert(
                AgendaPediatricaContract.HijosEntry.TABLE_NAME,
                null,
                hijo.toContentValues());

    }
    // Método para eliminar un elemento de la tabla de la base de datos
    // Devuelve un valor booleano indicando el éxito o no de la
// operación
    public boolean eliminar(long _indiceFila) {

        return db.delete(TABLA_BASE_DATOS, CP_ID + "=" +
                _indiceFila, null) > 0;
    }
// Método para obtener un Cursor que apunte a todas las filas contenidas
    // en la tabla de la base de datos
    public Cursor obtenerTodos () {
        return db.query(TABLA_BASE_DATOS, new String[] {CP_ID,
                        COLUMNA_NOMBRE},
                null, null, null, null,
                null);
    }
    // Método para obtener un elemento determinado de la base de datos
// a partir de su índice de fila
    public MiObjeto getObjeto(long _indiceFila) {
// PENDIENTE: obtener un cursor a una fila de la base
// de datos y usar sus valores para inicializar una
// instancia de MiObjeto
        return objectInstance;
    }


// Método para actualizar un elemento de la tabla de la base de datos
    public boolean actualizar(long _indiceFila, MiObjeto _miObjeto) {
// PENDIENTE: crear nuevos ContentValues a partir del objeto
// y usarlos para actualizar una fila en la tabla correspondiente
        return true;
    }

    // Clase privada auxiliar para ayudar en la creación y actualización
    // de la base de datos
    private static class miHelperBD extends SQLiteOpenHelper {
        public miHelperBD(Context contexto, String nombre,
                          SQLiteDatabase.CursorFactory factory, int version) {
            super(contexto, nombre, factory, version);
        }
// Método llamado cuando la base de datos no existe en el disco
// y la clase Helper necesita crearla desde cero
        @Override
        public void onCreate(SQLiteDatabase _db) {
            _db.execSQL(CREAR_BASE_DATOS);
        }
        // Método llamado cuando la versión de la base de
// datos en disco es diferente a la indicada; en
// este caso la base de datos en disco necesita ser
// actualizada
        @Override
        public void onUpgrade(SQLiteDatabase _db, int
                _versionAnterior,
                              int _versionNueva) {
// Mostramos en LogCat la operación
            Log.w("AdaptadorBD", "Actualizando desde la versión " +
                    _versionAnterior + " a la versión " +

                            _versionNueva + ", lo cual borrará los datos previamente almacenados");
// Actualizamos la base de datos para que se adapte a la nueva versión.
// La forma más sencilla de llevar a cabo dicha actualización es
// eliminar la tabla antigua y crear una nueva
                    _db.execSQL("DROP TABLE IF EXISTS " +
                            TABLA_BASE_DATOS);
            onCreate(_db);
        }
    }
}

