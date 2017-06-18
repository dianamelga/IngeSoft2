package vacuna;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vacuna.Padre;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-18T17:27:09")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> correo;
    public static volatile SingularAttribute<Usuarios, Integer> id;
    public static volatile SingularAttribute<Usuarios, Padre> idPadre;
    public static volatile SingularAttribute<Usuarios, String> nombre;

}