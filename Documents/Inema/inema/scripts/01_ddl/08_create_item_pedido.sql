-- Table: loja_virtual.item_pedido

CREATE SEQUENCE loja_virtual.item_pedido_id_item_pedido_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE loja_virtual.item_pedido_id_item_pedido_seq
    OWNER TO postgres;

CREATE TABLE loja_virtual.item_pedido
(
    id_item_pedido integer NOT NULL DEFAULT nextval('loja_virtual.item_pedido_id_item_pedido_seq'::regclass),
    id_pedido integer NOT NULL,
    id_produto integer NOT NULL,
    quantidade integer NOT NULL,
    CONSTRAINT item_pedido_pkey PRIMARY KEY (id_item_pedido),
    CONSTRAINT fk_item_pedido_pedido FOREIGN KEY (id_pedido)
        REFERENCES loja_virtual.pedido (id_pedido) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_item_pedido_produto FOREIGN KEY (id_produto)
        REFERENCES loja_virtual.produto (id_produto) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE loja_virtual.item_pedido
    OWNER to postgres;

-- Index: fki_fk_item_pedido_pedido

-- DROP INDEX loja_virtual.fki_fk_item_pedido_pedido;

CREATE INDEX fki_fk_item_pedido_pedido
    ON loja_virtual.item_pedido USING btree
    (id_pedido)
    TABLESPACE pg_default;

-- Index: fki_fk_item_pedido_produto

-- DROP INDEX loja_virtual.fki_fk_item_pedido_produto;

CREATE INDEX fki_fk_item_pedido_produto
    ON loja_virtual.item_pedido USING btree
    (id_produto)
    TABLESPACE pg_default;