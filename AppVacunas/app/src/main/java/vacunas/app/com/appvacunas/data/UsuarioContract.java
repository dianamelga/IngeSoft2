package vacunas.app.com.appvacunas.data;

import android.provider.BaseColumns;

/**
 * Created by adriana on 9/4/2017.
 */

//Esquema de la base de datos para usuarios, representaria a los responsables
public class UsuarioContract {
  public static abstract class UsuariosEntry implements BaseColumns {

  public static final String TABLE_NAME ="usuarios";

  public static final String ID = "id";
  //public static final String CI = "ci";
  public static final String NOMBRE = "nombre";
  //public static final String APELLIDO = "apellido";
  public static final String CORREO = "correo";
      public static final String ID_PADRE = "id_padre";
  //public static final String FECHA_NAC = "fecha_nac";
  //public static final String LUGAR_NAC = "lugar_nac";
}
}
