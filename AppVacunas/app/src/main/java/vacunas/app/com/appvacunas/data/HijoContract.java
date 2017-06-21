package vacunas.app.com.appvacunas.data;

import android.provider.BaseColumns;

/**
 * Created by adriana on 9/4/2017.
 */

//Esquema de la base de datos para hijo
public class HijoContract {

  public static abstract class HijosEntry implements BaseColumns {
    public static final String TABLE_NAME ="hijos";

    public static final String ID = "_id";
    public static final String CEDULA = "cedula";
    public static final String NOMBRE = "nombre";
    public static final String APELLIDO = "apellido";
    public static final String FECHA_NAC = "fecha_nac";
    public static final String LUGAR_NAC = "lugar_nac";
    public static final String SEXO = "sexo";
    public static final String NACIONALIDAD = "nacionalidad";
    public static final String DIRECCION = "direccion";
    public static final String DEPARTAMENTO = "departamento";
    public static final String MUNICIPIO = "municipio";
    public static final String ID_PADRE = "id_padre";
    public static final String BARRIO = "barrio";
    public static final String REFERENCIA = "referencia";
   // public static final String NOMBRE_RESPONSABLE = "nombre_responsable";
    public static final String TELEFONO = "tel";
    public static final String SEGURO = "seguro";
    public static final String ALERGIA = "alergia";
    //public static final String ID_RESP = "id_resp";
  }
}
