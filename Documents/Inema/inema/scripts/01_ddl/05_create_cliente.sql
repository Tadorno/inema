-- Table: loja_virtual.cliente

CREATE SEQUENCE loja_virtual.cliente_id_cliente_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE loja_virtual.cliente_id_cliente_seq
    OWNER TO postgres;

CREATE TABLE loja_virtual.cliente
(
    id_cliente integer NOT NULL DEFAULT nextval('loja_virtual.cliente_id_cliente_seq'::regclass),
    nome character varying(100) COLLATE pg_catalog."default" NOT NULL,
    cpf character varying(14) COLLATE pg_catalog."default" NOT NULL,
    id_endereco integer NOT NULL,
    CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente),
    CONSTRAINT fk_cliente_endereco FOREIGN KEY (id_endereco)
        REFERENCES loja_virtual.endereco (id_endereco) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE loja_virtual.cliente
    OWNER to postgres;

-- Index: fki_fk_cliente_endereco

-- DROP INDEX loja_virtual.fki_fk_cliente_endereco;

CREATE INDEX fki_fk_cliente_endereco
    ON loja_virtual.cliente USING btree
    (id_endereco)
    TABLESPACE pg_default;