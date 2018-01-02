-- Table: loja_virtual.pedido


CREATE SEQUENCE loja_virtual.pedido_id_pedido_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE loja_virtual.pedido_id_pedido_seq
    OWNER TO postgres;

CREATE TABLE loja_virtual.pedido
(
    id_pedido integer NOT NULL DEFAULT nextval('loja_virtual.pedido_id_pedido_seq'::regclass),
    data date NOT NULL,
    id_endereco integer NOT NULL,
    id_cliente integer NOT NULL,
    CONSTRAINT pedido_pkey PRIMARY KEY (id_pedido),
    CONSTRAINT fk_pedido_cliente FOREIGN KEY (id_cliente)
        REFERENCES loja_virtual.cliente (id_cliente) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_pedido_endereco FOREIGN KEY (id_endereco)
        REFERENCES loja_virtual.endereco (id_endereco) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE loja_virtual.pedido
    OWNER to postgres;

-- Index: fki_fk_pedido_cliente

-- DROP INDEX loja_virtual.fki_fk_pedido_cliente;

CREATE INDEX fki_fk_pedido_cliente
    ON loja_virtual.pedido USING btree
    (id_cliente)
    TABLESPACE pg_default;

-- Index: fki_fk_pedido_endereco

-- DROP INDEX loja_virtual.fki_fk_pedido_endereco;

CREATE INDEX fki_fk_pedido_endereco
    ON loja_virtual.pedido USING btree
    (id_endereco)
    TABLESPACE pg_default;