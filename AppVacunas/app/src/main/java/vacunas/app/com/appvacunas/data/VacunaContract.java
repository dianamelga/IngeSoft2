package vacunas.app.com.appvacunas.data;

import android.provider.BaseColumns;

/**
 * Created by dianamelgarejo on 6/15/2017.
 */

public class VacunaContract {
    public static abstract class VacunasEntry implements BaseColumns {
        public static final String TABLE_NAME = "vacunas";

        public static final String ID = "id";
        public static final String NRO_DOSIS = "nro_dosis";
        public static final String NOMBRE_VACUNA = "nombre_vacuna";
        public static final String MES_APLICACION = "mes_aplicacion";
        public static final String CANT_DOSIS = "cant_dosis";

    }
}
