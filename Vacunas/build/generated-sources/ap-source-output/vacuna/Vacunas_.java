package vacuna;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vacuna.VacunasHijos;
import vacuna.VacunasPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-18T17:27:09")
@StaticMetamodel(Vacunas.class)
public class Vacunas_ { 

    public static volatile SingularAttribute<Vacunas, String> nombreVacuna;
    public static volatile CollectionAttribute<Vacunas, VacunasHijos> vacunasHijosCollection;
    public static volatile SingularAttribute<Vacunas, Integer> cantDosis;
    public static volatile SingularAttribute<Vacunas, VacunasPK> vacunasPK;
    public static volatile SingularAttribute<Vacunas, Integer> mesAplicacion;

}