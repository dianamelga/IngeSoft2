package vacunas.app.com.appvacunas.clases;

import android.content.ContentValues;
import android.database.Cursor;

import vacunas.app.com.appvacunas.data.UsuarioContract.UsuariosEntry;

/**
 * Created by adriana on 9/4/2017.
 */

//Entidad Usuario Responsable
public class Usuario {
  private int id;

  private String nombre;
  private String correo;
  private int id_padre;

  public Usuario(int id, String nombre,
                     String correo, int id_padre) {

    this.id = id;
    this.nombre = nombre;
    this.correo = correo;
    this.id_padre = id_padre;

  }

  public Usuario(Cursor cursor) {
    id = cursor.getInt(cursor.getColumnIndex(UsuariosEntry.ID));
    nombre = cursor.getString(cursor.getColumnIndex(UsuariosEntry.NOMBRE));
    correo = cursor.getString(cursor.getColumnIndex(UsuariosEntry.CORREO));
    id_padre = cursor.getInt(cursor.getColumnIndex(UsuariosEntry.ID_PADRE));

  }

  public ContentValues toContentValues() {
      ContentValues values = new ContentValues();
      values.put(UsuariosEntry.ID, id);
      values.put(UsuariosEntry.NOMBRE, nombre);
      values.put(UsuariosEntry.CORREO, correo);
      values.put(UsuariosEntry.ID_PADRE, id_padre);

    return values;
  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_padre() {
        return id_padre;
    }

    public void setId_padre(int id_padre) {
        this.id_padre = id_padre;
    }
}
