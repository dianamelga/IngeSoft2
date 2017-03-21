package com.fpuna.myfirstapp.modelo;

import android.provider.BaseColumns;

/**
 * Created by diana on 10/03/17.
 */

public class AgendaPediatricaContract {
    public static abstract class HijosEntry implements BaseColumns {
        public static final String TABLE_NAME = "hijo";

        public static final String ID = "id_hijo";
        public static final String NOMBRES = "nombres";
        public static final String APELLIDOS = "apellidos";
        public static final String CI = "ci";
        public static final String FECHA_NACIMIENTO = "fecha_nacimiento";
        public static final String SEXO = "sexo";
        public static final String ID_PADRE ="id_padre";
    }

    public static abstract class PadresEntry implements BaseColumns {
        public static final String TABLE_NAME = "padre";

        public static final String ID = "id_padre";
        public static final String NOMBRES = "nombres";
        public static final String APELLIDOS = "apellidos";
        public static final String CI = "ci";
        public static final String RUC = "ruc";
        public static final String FECHA_NACIMIENTO = "fecha_nacimiento";
        public static final String SEXO = "sexo";
        public static final String CORREO = "correo";
    }

    public static abstract class VacunasEntry implements BaseColumns{
        public static final String TABLE_NAME = "vacuna";

        public static final String ID = "id_vacuna";
        public static final String NOMBRE_VACUNA = "nombre_vacuna";
        public static final String NRO_SEMANA = "nro_semana";
        public static final String CANT_DOSIS = "cant_dosis";
    }

    public static abstract class VacunasHijosEntry implements BaseColumns {
        public static final String TABLE_NAME = "vacunas_hijos";

        public static final String ID_VACUNA = "id_vacuna";
        public static final String ID_HIJO = "id_hijo";
        public static final String EDAD = "edad";
        public static final String FECHA_APLIC = "fecha_aplic";
        public static final String LOTE = "lote";
        public static final String RESPONSABLE = "responsable";
    }
}
