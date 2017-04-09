package com.fpuna.myfirstapp.modelo;

import android.content.ContentValues;
import android.database.Cursor;
import com.fpuna.myfirstapp.modelo.AgendaPediatricaContract.*;

/**
 * Created by diana on 09/04/17.
 */

public class Vacuna {
    private int id;
    private String nombre_vac;
    private int id_hijo;
    private String edad;
    private int dosis;
    private String fecha;
    private String lote;
    private String responsable;
    private int mes_aplicacion;
    private int aplicado;
    private String fecha_apl;

    public Vacuna(int id, String nombre_vac, int id_hijo, String edad, int dosis, String fecha,
                  String lote, String responsable, int mes_aplicacion, int aplicado) {
        this.id = id;
        this.nombre_vac = nombre_vac;
        this.id_hijo = id_hijo;
        this.edad = edad;
        this.dosis = dosis;
        this.fecha = fecha;
        this.lote = lote;
        this.responsable = responsable;
        this.mes_aplicacion = mes_aplicacion;
        this.aplicado = aplicado;
    }

    public Vacuna(Cursor cursor) {
        id = cursor.getInt(cursor.getColumnIndex(VacunasEntry.ID));
        nombre_vac = cursor.getString(cursor.getColumnIndex(VacunasEntry.NOMBRE_VAC));
        id_hijo = cursor.getInt(cursor.getColumnIndex(VacunasEntry.ID_HIJO));
        edad = cursor.getString(cursor.getColumnIndex(VacunasEntry.EDAD));
        dosis = cursor.getInt(cursor.getColumnIndex(VacunasEntry.DOSIS));
        fecha = cursor.getString(cursor.getColumnIndex(VacunasEntry.FECHA));
        lote = cursor.getString(cursor.getColumnIndex(VacunasEntry.LOTE));
        responsable = cursor.getString(cursor.getColumnIndex(VacunasEntry.RESPONSABLE));
        mes_aplicacion = cursor.getInt(cursor.getColumnIndex(VacunasEntry.MES_APLICACION));
        aplicado = cursor.getInt(cursor.getColumnIndex(VacunasEntry.APLICADO));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(VacunasEntry.ID, id);
        values.put(VacunasEntry.NOMBRE_VAC, nombre_vac);
        values.put(VacunasEntry.ID_HIJO, id_hijo);
        values.put(VacunasEntry.EDAD, edad);
        values.put(VacunasEntry.DOSIS, dosis);
        values.put(VacunasEntry.FECHA, fecha);
        values.put(VacunasEntry.LOTE, lote);
        values.put(VacunasEntry.RESPONSABLE, responsable);
        values.put(VacunasEntry.MES_APLICACION, mes_aplicacion);
        values.put(VacunasEntry.APLICADO, aplicado);
        return values;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_vac() {
        return nombre_vac;
    }

    public void setNombre_vac(String nombre_vac) {
        this.nombre_vac = nombre_vac;
    }

    public int getId_hijo() {
        return id_hijo;
    }

    public void setId_hijo(int id_hijo) {
        this.id_hijo = id_hijo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getMes_aplicacion() {
        return mes_aplicacion;
    }

    public void setMes_aplicacion(int mes_aplicacion) {
        this.mes_aplicacion = mes_aplicacion;
    }

    public int getAplicado() {
        return aplicado;
    }

    public void setAplicado(int aplicado) {
        this.aplicado = aplicado;
    }

    public String getFecha_apl() {
        return fecha_apl;
    }

    public void setFecha_apl(String fecha_apl) {
        this.fecha_apl = fecha_apl;
    }
}

