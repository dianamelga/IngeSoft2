package vacunas.app.com.appvacunas.clases;

import android.content.ContentValues;
import android.database.Cursor;

import vacunas.app.com.appvacunas.data.VacunaContract;
import vacunas.app.com.appvacunas.data.VacunaHijoContract;

/**
 * Created by dianamelgarejo on 6/15/2017.
 */

public class Vacuna {

    private int id;
    private int nro_dosis;
    private String nombre_vacuna;
    private int mes_aplicacion;
    private int cant_dosis;

    public Vacuna(int id, int nro_dosis, String nombre_vacuna, int mes_aplicacion, int cant_dosis) {
        this.id = id;
        this.nro_dosis = nro_dosis;
        this.nombre_vacuna = nombre_vacuna;
        this.mes_aplicacion = mes_aplicacion;
        this.cant_dosis = cant_dosis;
    }
    public Vacuna(Cursor cursor) {
        id = cursor.getInt(cursor.getColumnIndex(VacunaContract.VacunasEntry.ID));
        nro_dosis = cursor.getInt(cursor.getColumnIndex(VacunaContract.VacunasEntry.NRO_DOSIS));
        nombre_vacuna = cursor.getString(cursor.getColumnIndex(VacunaContract.VacunasEntry.NOMBRE_VACUNA));
        mes_aplicacion = cursor.getInt(cursor.getColumnIndex(VacunaContract.VacunasEntry.MES_APLICACION));
        cant_dosis = cursor.getInt(cursor.getColumnIndex(VacunaContract.VacunasEntry.CANT_DOSIS));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(VacunaContract.VacunasEntry.ID, id);
        values.put(VacunaContract.VacunasEntry.NRO_DOSIS, nro_dosis);
        values.put(VacunaContract.VacunasEntry.NOMBRE_VACUNA, nombre_vacuna);
        values.put(VacunaContract.VacunasEntry.MES_APLICACION, mes_aplicacion);
        values.put(VacunaContract.VacunasEntry.CANT_DOSIS, cant_dosis);
        return values;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNro_dosis() {
        return nro_dosis;
    }

    public void setNro_dosis(int nro_dosis) {
        this.nro_dosis = nro_dosis;
    }

    public String getNombre_vacuna() {
        return nombre_vacuna;
    }

    public void setNombre_vacuna(String nombre_vacuna) {
        this.nombre_vacuna = nombre_vacuna;
    }

    public int getMes_aplicacion() {
        return mes_aplicacion;
    }

    public void setMes_aplicacion(int mes_aplicacion) {
        this.mes_aplicacion = mes_aplicacion;
    }

    public int getCant_dosis() {
        return cant_dosis;
    }

    public void setCant_dosis(int cant_dosis) {
        this.cant_dosis = cant_dosis;
    }
}
