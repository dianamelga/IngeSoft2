package vacunas.app.com.appvacunas.data;

import android.provider.BaseColumns;

/**
 * Created by adriana on 9/4/2017.
 */

//Esquema de la base de datos para vacuna
public class VacunaHijoContract {
  public static abstract class VacunaHijosEntry implements BaseColumns {
    public static final String TABLE_NAME ="vacunashijos";

    public static final String ID = "id";
      public static final String NOMBRE_VAC = "nombre_vac";
    public static final String NRO_DOSIS = "nro_dosis";

    public static final String ID_HIJO = "id_hijo";
    public static final String FECHA_PROGRAMADA = "fecha_programada";
    public static final String LOTE = "lote";
    public static final String RESPONSABLE = "responsable";
    public static final String APLICADO = "aplicado";
    public static final String FECHA_APLICACION = "fecha_aplicacion";
    public static final String DIAS_ATRASO = "dias_atraso";

    public static final String MES_APLICACION = "mes_aplicacion";

  }
}
