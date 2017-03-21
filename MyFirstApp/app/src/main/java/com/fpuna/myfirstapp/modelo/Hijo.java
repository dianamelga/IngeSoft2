package com.fpuna.myfirstapp.modelo;

import android.content.ContentValues;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by diana on 09/03/17.
 */

public class Hijo {
    private String id;
    private String nombre;
    private String apellido;
    private String ci;
    private String fecha_nacimiento;
    private String sexo;
    private int edad;


    public Hijo(){
        this.id = "default";
        this.nombre = "name";
        this.apellido = "lastname";
        this.ci = "0";
        this.fecha_nacimiento = "01-01-1995";
        this.sexo = "N/A";
        this.edad = calculaEdad(fecha_nacimiento);

    }


    public Hijo(String id, String nombre, String apellido, String ci, String fecha_nacimiento, String sexo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.edad = calculaEdad(fecha_nacimiento);
    }

    public String getSexo() {
        return sexo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    private int calculaEdad(String fecha_nacimiento){
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = null;
        Date hoy = new Date();

        try {
            fecha = formatoDelTexto.parse(fecha_nacimiento);

        }catch(ParseException e){
            e.printStackTrace();
        }

        return (hoy.getYear() - fecha.getYear());

    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(AgendaPediatricaContract.HijosEntry.ID, id);
        values.put(AgendaPediatricaContract.HijosEntry.NOMBRES, nombre);
        values.put(AgendaPediatricaContract.HijosEntry.APELLIDOS, apellido);
        values.put(AgendaPediatricaContract.HijosEntry.SEXO, sexo);
        values.put(AgendaPediatricaContract.HijosEntry.CI, ci);
        values.put(AgendaPediatricaContract.HijosEntry.FECHA_NACIMIENTO, fecha_nacimiento);
        return values;
    }

}
