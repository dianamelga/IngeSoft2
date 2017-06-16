package vacunas.app.com.appvacunas.clases;

import android.content.ContentValues;
import android.database.Cursor;
import vacunas.app.com.appvacunas.data.VacunaHijoContract.VacunaHijosEntry;

/**
 * Created by adriana on 9/4/2017.
 */
//Entidad VacunaHijo, hace referencia a vacunas_hijos de la bd
public class VacunaHijo {
  private int id;
  private int nro_dosis;
  private int id_hijo;
  private String nombre_vac;
  private String fecha_programada;
  private String lote;
  private String responsable;
  private int aplicado;
  private String fecha_aplicacion;
  private int dias_atraso;
  private int mes_aplicacion;
    private int edad;

  public VacunaHijo(int id, int nro_dosis, int id_hijo, String nombre_vac, String fecha_programada,
                    String lote, String responsable, int aplicado, String fecha_aplicacion,
                    int dias_atraso, int mes_aplicacion, int edad) {
        this.id = id;
        this.nro_dosis = nro_dosis;
        this.id_hijo = id_hijo;
        this.nombre_vac = nombre_vac;
        this.fecha_programada = fecha_programada;
        this.lote = lote;
        this.responsable = responsable;
        this.aplicado = aplicado;
        this.fecha_aplicacion = fecha_aplicacion;
        this.dias_atraso = dias_atraso;
        this.mes_aplicacion = mes_aplicacion;
        this.edad = edad; /**/

  }

  public VacunaHijo(Cursor cursor) {
      id = cursor.getInt(cursor.getColumnIndex(VacunaHijosEntry.ID));
      nro_dosis = cursor.getInt(cursor.getColumnIndex(VacunaHijosEntry.NRO_DOSIS));
      id_hijo = cursor.getInt(cursor.getColumnIndex(VacunaHijosEntry.ID_HIJO));
      nombre_vac = cursor.getString(cursor.getColumnIndex(VacunaHijosEntry.NOMBRE_VAC));
      fecha_programada = cursor.getString(cursor.getColumnIndex(VacunaHijosEntry.FECHA_PROGRAMADA));
      lote = cursor.getString(cursor.getColumnIndex(VacunaHijosEntry.LOTE));
      responsable = cursor.getString(cursor.getColumnIndex(VacunaHijosEntry.RESPONSABLE));
      aplicado = cursor.getInt(cursor.getColumnIndex(VacunaHijosEntry.APLICADO));
      fecha_aplicacion = cursor.getString(cursor.getColumnIndex(VacunaHijosEntry.FECHA_APLICACION));
      dias_atraso = cursor.getInt(cursor.getColumnIndex(VacunaHijosEntry.DIAS_ATRASO));
      mes_aplicacion = cursor.getInt(cursor.getColumnIndex(VacunaHijosEntry.MES_APLICACION));

  }

  public ContentValues toContentValues() {
      ContentValues values = new ContentValues();
      values.put(VacunaHijosEntry.ID, id);
      values.put(VacunaHijosEntry.NRO_DOSIS, nro_dosis);
      values.put(VacunaHijosEntry.ID_HIJO, id_hijo);
      values.put(VacunaHijosEntry.NOMBRE_VAC, nombre_vac);
      values.put(VacunaHijosEntry.FECHA_PROGRAMADA, fecha_programada);
      values.put(VacunaHijosEntry.LOTE, lote);
      values.put(VacunaHijosEntry.RESPONSABLE, responsable);
      values.put(VacunaHijosEntry.APLICADO, aplicado);
      values.put(VacunaHijosEntry.FECHA_APLICACION, fecha_aplicacion);
      values.put(VacunaHijosEntry.DIAS_ATRASO, dias_atraso);
      values.put(VacunaHijosEntry.MES_APLICACION, mes_aplicacion);

    return values;
  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNro_dosis() {
        return nro_dosis;
    }

    public void setNro_dosis(int nro_dosis) {
        this.nro_dosis = nro_dosis;
    }

    public int getId_hijo() {
        return id_hijo;
    }

    public void setId_hijo(int id_hijo) {
        this.id_hijo = id_hijo;
    }

    public String getNombre_vac() {
        return nombre_vac;
    }

    public void setNombre_vac(String nombre_vac) {
        this.nombre_vac = nombre_vac;
    }

    public String getFecha_programada() {
        return fecha_programada;
    }

    public void setFecha_programada(String fecha_programada) {
        this.fecha_programada = fecha_programada;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getAplicado() {
        return aplicado;
    }

    public void setAplicado(int aplicado) {
        this.aplicado = aplicado;
    }

    public String getFecha_aplicacion() {
        return fecha_aplicacion;
    }

    public void setFecha_aplicacion(String fecha_aplicacion) {
        this.fecha_aplicacion = fecha_aplicacion;
    }

    public int getDias_atraso() {
        return dias_atraso;
    }

    public void setDias_atraso(int dias_atraso) {
        this.dias_atraso = dias_atraso;
    }

    public int getMes_aplicacion() {
        return mes_aplicacion;
    }

    public void setMes_aplicacion(int mes_aplicacion) {
        this.mes_aplicacion = mes_aplicacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


}
