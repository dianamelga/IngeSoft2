package com.servervacunas;

import com.servervacunas.Usuarios;
import com.servervacunas.Vacunas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-21T22:35:27")
@StaticMetamodel(Hijo.class)
public class Hijo_ { 

    public static volatile SingularAttribute<Hijo, Date> fechaNac;
    public static volatile SingularAttribute<Hijo, Integer> idHijo;
    public static volatile SingularAttribute<Hijo, Integer> ci;
    public static volatile SingularAttribute<Hijo, Character> lugarNac;
    public static volatile SingularAttribute<Hijo, Character> municipio;
    public static volatile SingularAttribute<Hijo, Usuarios> idUsuario;
    public static volatile SingularAttribute<Hijo, Character> apellido;
    public static volatile SingularAttribute<Hijo, Character> direccion;
    public static volatile CollectionAttribute<Hijo, Vacunas> vacunasCollection;
    public static volatile SingularAttribute<Hijo, Character> sexo;
    public static volatile SingularAttribute<Hijo, Character> nombre;
    public static volatile SingularAttribute<Hijo, Character> nacionalidad;

}