package vacuna;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vacuna.Hijo;
import vacuna.Vacunas;
import vacuna.VacunasHijosPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-17T16:14:49")
@StaticMetamodel(VacunasHijos.class)
public class VacunasHijos_ { 

    public static volatile SingularAttribute<VacunasHijos, VacunasHijosPK> vacunasHijosPK;
    public static volatile SingularAttribute<VacunasHijos, String> responsable;
    public static volatile SingularAttribute<VacunasHijos, Integer> diasAtrasoApl;
    public static volatile SingularAttribute<VacunasHijos, Character> lote;
    public static volatile SingularAttribute<VacunasHijos, Hijo> hijo;
    public static volatile SingularAttribute<VacunasHijos, Integer> aplicado;
    public static volatile SingularAttribute<VacunasHijos, Date> fechaAplicacion;
    public static volatile SingularAttribute<VacunasHijos, Date> fechaProgramada;
    public static volatile SingularAttribute<VacunasHijos, Vacunas> vacunas;

}