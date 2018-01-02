--CARGA DE PRODUTO
INSERT INTO loja_virtual.produto(
	nome, descricao, preco)
	VALUES ('P1', 'Produto 1', 10.3);

INSERT INTO loja_virtual.produto(
	nome, descricao, preco)
	VALUES ('P2', 'Produto 2', 50.0);

--CARGA DE ENDEREÇO
INSERT INTO loja_virtual.endereco(
	logradouro, bairro, cidade, numero, cep)
	VALUES ('Logradouro 1', 'Bairro 1', 'Cidade 1', 0, '41720-025');

--CARGA DE CLIENTE
INSERT INTO loja_virtual.cliente(
	 nome, cpf, id_endereco)
	VALUES ('C1', '028.723.995-00', 1);
    
INSERT INTO loja_virtual.cliente(
	 nome, cpf, id_endereco)
	VALUES ('C2', '000.000.000-00', 1);
    
INSERT INTO loja_virtual.estoque(
	 quantidade, id_produto)
	VALUES (10, 1);

--CARGA DE ESTOQUE
INSERT INTO loja_virtual.estoque(
	 quantidade, id_produto)
	VALUES (99, 2);