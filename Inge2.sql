-- Table: public.hijo

-- DROP TABLE public.hijo;

CREATE TABLE public.hijo
(
  id_hijo integer NOT NULL,
  ci integer,
  nombre "char",
  apellido "char",
  "lugarNac" "char",
  "fechaNac" date,
  sexo "char",
  nacionalidad "char",
  direccion "char",
  municipio "char",
  id_usuario integer,
  CONSTRAINT pk2 PRIMARY KEY (id_hijo),
  CONSTRAINT fk FOREIGN KEY (id_usuario)
      REFERENCES public.usuarios (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.hijo
  OWNER TO postgres;

 -- Table: public.padre

-- DROP TABLE public.padre;

CREATE TABLE public.padre
(
  id_padre integer NOT NULL,
  nombre "char",
  apellido "char",
  cedula integer,
  "fechaNac" date,
  sexo "char",
  nacionalidad "char",
  municipio "char",
  CONSTRAINT pk PRIMARY KEY (id_padre)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.padre
  OWNER TO postgres;

 -- Table: public.usuarios

-- DROP TABLE public.usuarios;

CREATE TABLE public.usuarios
(
  id integer NOT NULL DEFAULT nextval('usuarios_id_seq'::regclass),
  nombre character varying(32) NOT NULL,
  correo character varying(32) NOT NULL,
  CONSTRAINT usuarios_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.usuarios
  OWNER TO postgres;
-- Table: public.vacunas

-- DROP TABLE public.vacunas;

CREATE TABLE public.vacunas
(
  nombre_vacuna "char",
  edad "char",
  dosis integer,
  fecha date,
  lote "char",
  responsable "char",
  mes_aplicacion integer,
  aplicado integer,
  fecha_aplicacion date,
  id_vacuna integer NOT NULL,
  id_hijo integer,
  CONSTRAINT pk3 PRIMARY KEY (id_vacuna),
  CONSTRAINT fk3 FOREIGN KEY (id_hijo)
      REFERENCES public.hijo (id_hijo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.vacunas
  OWNER TO postgres;
