package vacunas.app.com.appvacunas.data;

import android.provider.BaseColumns;

/**
 * Created by dianamelgarejo on 6/15/2017.
 */

public class PadreContract {
    public static abstract class PadresEntry implements BaseColumns {

        public static final String TABLE_NAME = "padre";

        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String APELLIDO = "apellido";
        public static final String CEDULA = "cedula";
        public static final String FECHA_NAC = "fecha_nac";
        public static final String SEXO = "sexo";
        public static final String NACIONALIDAD = "nacionalidad";
        public static final String MUNICIPIO = "municipio";
    }
}
