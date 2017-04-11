package vacunas.app.com.appvacunas.data;

import android.provider.BaseColumns;

/**
 * Created by adriana on 9/4/2017.
 */

//Esquema de la base de datos para vacuna
public class VacunaContract {
  public static abstract class VacunasEntry implements BaseColumns {
    public static final String TABLE_NAME ="vacunas";

    public static final String ID = "id";
    public static final String NOMBRE_VAC = "nombre_vac";
    public static final String ID_HIJO = "id_hijo";
    public static final String EDAD = "EDAD";
    public static final String DOSIS = "dosis";
    public static final String FECHA = "fecha";
    public static final String LOTE = "lote";
    public static final String RESPONSABLE = "responsable";
    public static final String MES_APLICACION = "mes_aplicacion";
    public static final String APLICADO = "aplicado";
  }
}
