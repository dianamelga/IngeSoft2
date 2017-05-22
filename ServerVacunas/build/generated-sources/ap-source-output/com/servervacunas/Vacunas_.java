package com.servervacunas;

import com.servervacunas.Hijo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T22:35:27")
@StaticMetamodel(Vacunas.class)
public class Vacunas_ { 

    public static volatile SingularAttribute<Vacunas, Character> nombreVacuna;
    public static volatile SingularAttribute<Vacunas, Date> fecha;
    public static volatile SingularAttribute<Vacunas, Hijo> idHijo;
    public static volatile SingularAttribute<Vacunas, Character> responsable;
    public static volatile SingularAttribute<Vacunas, Character> lote;
    public static volatile SingularAttribute<Vacunas, Integer> dosis;
    public static volatile SingularAttribute<Vacunas, Integer> aplicado;
    public static volatile SingularAttribute<Vacunas, Date> fechaAplicacion;
    public static volatile SingularAttribute<Vacunas, Integer> idVacuna;
    public static volatile SingularAttribute<Vacunas, Character> edad;
    public static volatile SingularAttribute<Vacunas, Integer> mesAplicacion;

}