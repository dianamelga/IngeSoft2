package vacuna;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vacuna.Padre;
import vacuna.VacunasHijos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-18T17:27:09")
@StaticMetamodel(Hijo.class)
public class Hijo_ { 

    public static volatile SingularAttribute<Hijo, String> seguro;
    public static volatile SingularAttribute<Hijo, String> barrio;
    public static volatile SingularAttribute<Hijo, Integer> ci;
    public static volatile SingularAttribute<Hijo, String> lugarNac;
    public static volatile SingularAttribute<Hijo, String> municipio;
    public static volatile SingularAttribute<Hijo, String> direccion;
    public static volatile SingularAttribute<Hijo, String> alergia;
    public static volatile SingularAttribute<Hijo, Padre> idPadre;
    public static volatile SingularAttribute<Hijo, String> nombre;
    public static volatile SingularAttribute<Hijo, String> nacionalidad;
    public static volatile SingularAttribute<Hijo, Date> fechaNac;
    public static volatile SingularAttribute<Hijo, Integer> idHijo;
    public static volatile CollectionAttribute<Hijo, VacunasHijos> vacunasHijosCollection;
    public static volatile SingularAttribute<Hijo, String> apellido;
    public static volatile SingularAttribute<Hijo, Character> sexo;
    public static volatile SingularAttribute<Hijo, String> telefono;
    public static volatile SingularAttribute<Hijo, String> referencha;

}