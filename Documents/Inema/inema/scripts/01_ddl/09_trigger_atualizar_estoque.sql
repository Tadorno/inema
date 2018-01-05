-- FUNCTION: loja_virtual.atualizar_estoque()

-- DROP FUNCTION loja_virtual.atualizar_estoque();

CREATE FUNCTION loja_virtual.atualizar_estoque()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF 
    ROWS 0
AS $BODY$
BEGIN
	UPDATE loja_virtual.estoque SET quantidade = (quantidade - new.quantidade) WHERE id_produto = new.id_produto;
	RETURN NULL;
END;

$BODY$;

ALTER FUNCTION loja_virtual.atualizar_estoque()
    OWNER TO postgres;
    
    
CREATE TRIGGER atualizar_estoque
    AFTER INSERT
    ON loja_virtual.item_pedido
    FOR EACH ROW
    EXECUTE PROCEDURE loja_virtual.atualizar_estoque();
