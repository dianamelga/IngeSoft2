package vacuna;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vacuna.Hijo;
import vacuna.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-18T17:27:09")
@StaticMetamodel(Padre.class)
public class Padre_ { 

    public static volatile SingularAttribute<Padre, Date> fechaNac;
    public static volatile CollectionAttribute<Padre, Hijo> hijoCollection;
    public static volatile SingularAttribute<Padre, Integer> cedula;
    public static volatile SingularAttribute<Padre, String> municipio;
    public static volatile SingularAttribute<Padre, String> apellido;
    public static volatile CollectionAttribute<Padre, Usuarios> usuariosCollection;
    public static volatile SingularAttribute<Padre, Integer> idPadre;
    public static volatile SingularAttribute<Padre, Character> sexo;
    public static volatile SingularAttribute<Padre, String> nombre;
    public static volatile SingularAttribute<Padre, String> nacionalidad;

}