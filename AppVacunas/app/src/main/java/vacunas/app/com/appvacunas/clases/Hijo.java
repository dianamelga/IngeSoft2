package vacunas.app.com.appvacunas.clases;

import android.content.ContentValues;
import android.database.Cursor;

import vacunas.app.com.appvacunas.data.HijoContract.HijosEntry;
/**
 * Created by adriana on 9/4/2017.
 */

//Entidad hijo
public class Hijo {
  private int id;
  private int cedula;
  private String nombre;
  private String apellido;
  private String fecha_nac;
  private String lugar_nac;
  private String sexo;
  private String nacionalidad;
  private String direccion;
  private String departamento;
  private String municipio;
  private int id_padre;
  private String barrio;
  private String referencia;
  private String telefono;
  private String seguro;


  public Hijo(int id, int cedula, String nombre, String apellido,
              String fecha_nac, String lugar_nac, String sexo,
              String nacionalidad, String direccion,
              String departamento, String municipio, int id_padre,
              String barrio, String referencia
              , String telefono,
              String seguro){
    this.id = id;
    this.cedula = cedula;
    this.nombre = nombre;
    this.apellido = apellido;
    this.fecha_nac = fecha_nac;
    this.lugar_nac = lugar_nac;
    this.sexo = sexo;
    this.nacionalidad = nacionalidad;
    this.direccion = direccion;
    this.departamento = departamento;
    this.municipio = municipio;
    this.id_padre = id_padre;
    this.barrio = barrio;
    this.referencia = referencia;

    this.telefono = telefono;
    this.seguro = seguro;

  }

  public Hijo(Cursor cursor) {
    id = cursor.getInt(cursor.getColumnIndex(HijosEntry.ID));
    cedula = cursor.getInt(cursor.getColumnIndex(HijosEntry.CEDULA));
    nombre = cursor.getString(cursor.getColumnIndex(HijosEntry.NOMBRE));
    apellido = cursor.getString(cursor.getColumnIndex(HijosEntry.APELLIDO));
    fecha_nac = cursor.getString(cursor.getColumnIndex(HijosEntry.FECHA_NAC));
    lugar_nac = cursor.getString(cursor.getColumnIndex(HijosEntry.LUGAR_NAC));
    sexo = cursor.getString(cursor.getColumnIndex(HijosEntry.SEXO));
    nacionalidad = cursor.getString(cursor.getColumnIndex(HijosEntry.NACIONALIDAD));
    direccion = cursor.getString(cursor.getColumnIndex(HijosEntry.DIRECCION));
    departamento = cursor.getString(cursor.getColumnIndex(HijosEntry.DEPARTAMENTO));
    municipio = cursor.getString(cursor.getColumnIndex(HijosEntry.MUNICIPIO));
    id_padre = cursor.getInt(cursor.getColumnIndex(HijosEntry.ID_PADRE));
    barrio = cursor.getString(cursor.getColumnIndex(HijosEntry.BARRIO));
    referencia = cursor.getString(cursor.getColumnIndex(HijosEntry.REFERENCIA));

    telefono = cursor.getString(cursor.getColumnIndex(HijosEntry.TELEFONO));
    seguro = cursor.getString(cursor.getColumnIndex(HijosEntry.SEGURO));

  }

  public ContentValues toContentValues() {
    ContentValues values = new ContentValues();
    values.put(HijosEntry.ID, id);
    values.put(HijosEntry.CEDULA, cedula);
    values.put(HijosEntry.NOMBRE, nombre);
    values.put(HijosEntry.APELLIDO, apellido);
    values.put(HijosEntry.FECHA_NAC, fecha_nac);
    values.put(HijosEntry.LUGAR_NAC, lugar_nac);
    values.put(HijosEntry.SEXO, sexo);
    values.put(HijosEntry.NACIONALIDAD, nacionalidad);
    values.put(HijosEntry.DIRECCION, direccion);
    values.put(HijosEntry.DEPARTAMENTO, departamento);
    values.put(HijosEntry.MUNICIPIO, municipio);
    values.put(HijosEntry.ID_PADRE, id_padre);
    values.put(HijosEntry.BARRIO, barrio);
    values.put(HijosEntry.REFERENCIA, referencia);
    values.put(HijosEntry.TELEFONO, telefono);
    values.put(HijosEntry.SEGURO, seguro);

    return values;
  }

  public int getId() {
    return id;
  }

  public int getCi() {
    return cedula;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public String getFecha_nac() {
    return fecha_nac;
  }

  public String getLugar_nac() {
    return lugar_nac;
  }

  public String getSexo() {
    return sexo;
  }

  public String getNacionalidad() {
    return nacionalidad;
  }

  public String getDireccion() {
    return direccion;
  }

  public String getDepartamento() {
    return departamento;
  }

  public String getMunicipio() {
    return municipio;
  }

  public String getBarrio() {
    return barrio;
  }

  public String getReferencia() {
    return referencia;
  }


  public String getTel() {
    return telefono;
  }

  public String getSeguro() {
    return seguro;
  }

  public int getId_padre() {
    return id_padre;
  }

  public void setId_padre(int id_padre) {
    this.id_padre = id_padre;
  }
}
