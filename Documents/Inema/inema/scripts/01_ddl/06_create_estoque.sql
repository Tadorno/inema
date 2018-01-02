-- Table: loja_virtual.estoque

CREATE SEQUENCE loja_virtual.estoque_id_estoque_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE loja_virtual.estoque_id_estoque_seq
    OWNER TO postgres;

CREATE TABLE loja_virtual.estoque
(
    id_estoque integer NOT NULL DEFAULT nextval('loja_virtual.estoque_id_estoque_seq'::regclass),
    nome character varying(100) COLLATE pg_catalog."default" NOT NULL,
    quantidade integer NOT NULL,
    id_produto integer,
    CONSTRAINT estoque_pkey PRIMARY KEY (id_estoque),
    CONSTRAINT fk_estoque_produto FOREIGN KEY (id_produto)
        REFERENCES loja_virtual.produto (id_produto) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE loja_virtual.estoque
    OWNER to postgres;

-- Index: fki_fk_estoque_produto

-- DROP INDEX loja_virtual.fki_fk_estoque_produto;

CREATE INDEX fki_fk_estoque_produto
    ON loja_virtual.estoque USING btree
    (id_produto)
    TABLESPACE pg_default;

	
ALTER TABLE loja_virtual.estoque DROP COLUMN nome;