-- Table: loja_virtual.produto

CREATE SEQUENCE loja_virtual.produto_id_produto_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE loja_virtual.produto_id_produto_seq
    OWNER TO postgres;


CREATE TABLE loja_virtual.produto
(
    id_produto integer NOT NULL DEFAULT nextval('loja_virtual.produto_id_produto_seq'::regclass),
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    descricao character varying(300) COLLATE pg_catalog."default",
    preco double precision,
    CONSTRAINT produto_pkey PRIMARY KEY (id_produto)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE loja_virtual.produto
    OWNER to postgres;