package com.fpuna.myfirstapp.modelo;

import android.provider.BaseColumns;

/**
 * Created by diana on 10/03/17.
 */

public class AgendaPediatricaContract {
    public static abstract class HijosEntry implements BaseColumns {
        public static final String TABLE_NAME = "hijo";

        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String APELLIDO = "apellido";
        public static final String CI = "ci";
        public static final String FECHA_NACIMIENTO = "fecha_nacimiento";
        public static final String SEXO = "sexo";
    }
}
