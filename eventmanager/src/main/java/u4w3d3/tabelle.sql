-- Table: public.persona
 -- DROP TABLE IF EXISTS public.persona;

CREATE TABLE IF NOT EXISTS public.persona ( id integer NOT NULL DEFAULT nextval('persona_id_seq'::regclass),
                                                                        nome character varying(30) COLLATE pg_catalog."default" NOT NULL,
                                                                                                                                cognome character varying(30) COLLATE pg_catalog."default" NOT NULL,
                                                                                                                                                                                           email character varying(64) COLLATE pg_catalog."default" NOT NULL,
                                                                                                                                                                                                                                                    data_di_nascita date NOT NULL,
                                                                                                                                                                                                                                                                         sesso character(1) COLLATE pg_catalog."default" NOT NULL,
                                                                                                                                                                                                                                                                                                                         CONSTRAINT persona_pkey PRIMARY KEY (id)) TABLESPACE pg_default;


ALTER TABLE IF EXISTS public.persona OWNER to postgres;

-- Table: public.partecipazione
 -- DROP TABLE IF EXISTS public.partecipazione;

CREATE TABLE IF NOT EXISTS public.partecipazione
    (id integer NOT NULL DEFAULT nextval('partecipazione_id_seq'::regclass),
                                 persona_id integer NOT NULL,
                                                    stato boolean NOT NULL,
                                                                  evento_id integer NOT NULL,
                                                                                    CONSTRAINT fk_evento
     FOREIGN KEY (evento_id) REFERENCES public.events (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
                                                                                                         CONSTRAINT fk_persona
     FOREIGN KEY (persona_id) REFERENCES public.persona (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE) TABLESPACE pg_default;


ALTER TABLE IF EXISTS public.partecipazione OWNER to postgres;

-- Table: public.location
 -- DROP TABLE IF EXISTS public.location;

CREATE TABLE IF NOT EXISTS public.location (id integer NOT NULL DEFAULT nextval('location_id_seq'::regclass),
                                                                        nome character varying(30) COLLATE pg_catalog."default" NOT NULL,
                                                                                                                                citta character varying(30) COLLATE pg_catalog."default" NOT NULL,
                                                                                                                                                                                         CONSTRAINT location_pkey PRIMARY KEY (id)) TABLESPACE pg_default;


ALTER TABLE IF EXISTS public.location OWNER to postgres;

-- Table: public.events
 -- DROP TABLE IF EXISTS public.events;

CREATE TABLE IF NOT EXISTS public.events
    (id integer NOT NULL DEFAULT nextval('events_id_seq'::regclass),
                                 titolo character varying(50) COLLATE pg_catalog."default" NOT NULL,
                                                                                           data date NOT NULL,
                                                                                                     descrizione character varying(50) COLLATE pg_catalog."default" NOT NULL,
                                                                                                                                                                    tipo_evento character varying(7) COLLATE pg_catalog."default" NOT NULL,
                                                                                                                                                                                                                                  numero_massimo_partecipanti integer, location_id integer, CONSTRAINT events_pkey PRIMARY KEY (id), CONSTRAINT fk_location
     FOREIGN KEY (location_id) REFERENCES public.location (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION) TABLESPACE pg_default;


ALTER TABLE IF EXISTS public.events OWNER to postgres;
