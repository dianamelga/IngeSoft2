package com.fpuna.myfirstapp.modelo;

import android.content.ContentValues;
import android.database.Cursor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fpuna.myfirstapp.modelo.AgendaPediatricaContract.*;

/**
 * Created by diana on 09/03/17.
 */

public class Hijo {
    private int id;
    private int ci;
    private String nombre;
    private String apellido;
    private String fecha_nac;
    private String lugar_nac;
    private String sexo;
    private String nacionalidad;
    private String direccion;
    private String departamento;
    private String municipio;
    private String barrio;
    private String referencia;
    private String nombre_resp;
    private String tel;
    private String seguro;
    private String alergias;
    private int id_resp;

    public Hijo(int id, int ci, String nombre, String apellido,
                String fecha_nac, String lugar_nac, String sexo){
        this.id = id;
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nac = fecha_nac;
        this.lugar_nac = lugar_nac;
        this.sexo = sexo;
    }

    public Hijo(int id, int ci, String nombre, String apellido,
                String fecha_nac, String lugar_nac, String sexo,
                String nacionalidad, String direccion,
                String departamento, String municipio,
                String barrio, String referencia,
                String nombre_resp, String tel,
                String seguro, String alergias, int id_resp){
        this.id = id;
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nac = fecha_nac;
        this.lugar_nac = lugar_nac;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.departamento = departamento;
        this.municipio = municipio;
        this.barrio = barrio;
        this.referencia = referencia;
        this.nombre_resp = nombre_resp;
        this.tel = tel;
        this.seguro = seguro;
        this.alergias = alergias;
        this.id_resp = id_resp;
    }

    public Hijo(Cursor cursor) {
        id = cursor.getInt(cursor.getColumnIndex(HijosEntry.ID));
        ci = cursor.getInt(cursor.getColumnIndex(HijosEntry.CI));
        nombre = cursor.getString(cursor.getColumnIndex(HijosEntry.NOMBRE));
        apellido = cursor.getString(cursor.getColumnIndex(HijosEntry.APELLIDO));
        fecha_nac = cursor.getString(cursor.getColumnIndex(HijosEntry.FECHA_NAC));
        lugar_nac = cursor.getString(cursor.getColumnIndex(HijosEntry.LUGAR_NAC));
        sexo = cursor.getString(cursor.getColumnIndex(HijosEntry.SEXO));
        nacionalidad = cursor.getString(cursor.getColumnIndex(HijosEntry.NACIONALIDAD));
        direccion = cursor.getString(cursor.getColumnIndex(HijosEntry.DIRECCION));
        departamento = cursor.getString(cursor.getColumnIndex(HijosEntry.DEPARTAMENTO));
        municipio = cursor.getString(cursor.getColumnIndex(HijosEntry.MUNICIPIO));
        barrio = cursor.getString(cursor.getColumnIndex(HijosEntry.BARRIO));
        referencia = cursor.getString(cursor.getColumnIndex(HijosEntry.REFERENCIA));
        nombre_resp = cursor.getString(cursor.getColumnIndex(HijosEntry.NOMBRE_RESPONSABLE));
        tel = cursor.getString(cursor.getColumnIndex(HijosEntry.TEL));
        seguro = cursor.getString(cursor.getColumnIndex(HijosEntry.SEGURO));
        alergias = cursor.getString(cursor.getColumnIndex(HijosEntry.ALERGIA));
        id_resp = cursor.getInt(cursor.getColumnIndex(HijosEntry.ID_RESP));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(HijosEntry.ID, id);
        values.put(HijosEntry.CI, ci);
        values.put(HijosEntry.NOMBRE, nombre);
        values.put(HijosEntry.APELLIDO, apellido);
        values.put(HijosEntry.FECHA_NAC, fecha_nac);
        values.put(HijosEntry.LUGAR_NAC, lugar_nac);
        values.put(HijosEntry.SEXO, sexo);
        values.put(HijosEntry.NACIONALIDAD, nacionalidad);
        values.put(HijosEntry.DIRECCION, direccion);
        values.put(HijosEntry.DEPARTAMENTO, departamento);
        values.put(HijosEntry.MUNICIPIO, municipio);
        values.put(HijosEntry.BARRIO, barrio);
        values.put(HijosEntry.REFERENCIA, referencia);
        values.put(HijosEntry.NOMBRE_RESPONSABLE, nombre_resp);
        values.put(HijosEntry.TEL, tel);
        values.put(HijosEntry.SEGURO, seguro);
        values.put(HijosEntry.ALERGIA, alergias);
        values.put(HijosEntry.ID_RESP, id_resp);
        return values;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getLugar_nac() {
        return lugar_nac;
    }

    public void setLugar_nac(String lugar_nac) {
        this.lugar_nac = lugar_nac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre_resp() {
        return nombre_resp;
    }

    public void setNombre_resp(String nombre_resp) {
        this.nombre_resp = nombre_resp;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public int getId_resp() {
        return id_resp;
    }

    public void setId_resp(int id_resp) {
        this.id_resp = id_resp;
    }

    public int getEdad(){
        return 15; /*por ahora*/
    }
}
