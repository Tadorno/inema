-- Table: loja_virtual.endereco

CREATE SEQUENCE loja_virtual.endereco_id_endereco_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE loja_virtual.endereco_id_endereco_seq
    OWNER TO postgres;

CREATE TABLE loja_virtual.endereco
(
    id_endereco integer NOT NULL DEFAULT nextval('loja_virtual.endereco_id_endereco_seq'::regclass),
    logradouro character varying(300) COLLATE pg_catalog."default" NOT NULL,
    bairro character varying(50) COLLATE pg_catalog."default" NOT NULL,
    cidade character varying(50) COLLATE pg_catalog."default" NOT NULL,
    numero integer,
    cep character varying(9) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT endereco_pkey PRIMARY KEY (id_endereco)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE loja_virtual.endereco
    OWNER to postgres;