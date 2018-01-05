/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.teste;

import com.tadorno.loja.virtual.server.exception.MensagemException;
import com.tadorno.loja.virtual.server.model.Estoque;
import com.tadorno.loja.virtual.server.model.ItemPedido;
import com.tadorno.loja.virtual.server.model.Pedido;
import com.tadorno.loja.virtual.server.model.Produto;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author tulio
 */
public class PedidoTest {

    public PedidoTest() {
    }

    private Pedido pedido;
    private Produto produto1;
    private Produto produto2;
    private Estoque estoque1;
    private Estoque estoque2;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pedido = new Pedido();

        produto1 = new Produto();
        produto1.setId(1L);
        produto1.setPreco(10.0);

        produto2 = new Produto();
        produto2.setId(2L);
        produto2.setPreco(5.0);

        estoque1 = new Estoque();
        estoque1.setProduto(produto1);
        estoque1.setQuantidade(10);

        estoque2 = new Estoque();
        estoque2.setProduto(produto2);
        estoque2.setQuantidade(5);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAdicionarProduto() throws MensagemException {
        ItemPedido item = new ItemPedido();

        item.setProduto(produto1);
        item.setQuantidade(2);

        pedido.adicionarItemPedido(estoque1, item);
        //Testa o valor total dos produtos adicionados || 10 * 2
        assertEquals(20.0, pedido.getValorTotal(), 0.00001);

        item = new ItemPedido();
        item.setProduto(produto2);
        item.setQuantidade(1);

        pedido.adicionarItemPedido(estoque2, item);
        //Testa o novo valor total || (10 * 2) + 5
        assertEquals(25.0, pedido.getValorTotal(), 0.00001);
        //Testa a quantidade de itens da lista de pedidos
        assertEquals(2, pedido.getItens().size(), 0);

        item = new ItemPedido();
        item.setProduto(produto2);
        item.setQuantidade(3);

        pedido.adicionarItemPedido(estoque2, item);
        //Testa o novo valor total || ((10 * 2) + 5) + (5 * 3)
        assertEquals(40.0, pedido.getValorTotal(), 0.00001);
        //Testa a quantidade de itens da lista de pedidos
        assertEquals(2, pedido.getItens().size(), 0);
    }

    @Test(expected = MensagemException.class)
    public void testQuantidadeMinina() throws MensagemException {
        ItemPedido item = new ItemPedido();

        item.setProduto(produto1);
        item.setQuantidade(0);

        try {
            pedido.adicionarItemPedido(estoque1, item);
        } catch (MensagemException me) {
            //Testa se ocorre erro ao tentar adicionar um item sem a quantidade de venda
            assertEquals("Deve ser inserido uma quantidade maior que 0.", me.getMessage());
            throw me;
        }
    }

    @Test(expected = MensagemException.class)
    public void testProdutoNull() throws MensagemException {
        ItemPedido item = new ItemPedido();

        item.setQuantidade(0);

        try {
            pedido.adicionarItemPedido(estoque1, item);
        } catch (MensagemException me) {
            //Testa se ocorre erro ao tentar adicionar um item sem produto
            assertEquals("Campo Produto é obrigatório.", me.getMessage());
            throw me;
        }
    }

    @Test(expected = MensagemException.class)
    public void testLimiteEstoqueSuperado() throws MensagemException {
        ItemPedido item = new ItemPedido();

        item.setProduto(produto1);
        item.setQuantidade(11);

        try {
            pedido.adicionarItemPedido(estoque1, item);
        } catch (MensagemException me) {
            //Testa se ocorre erro ao tentar adicionar um item sem produto com estoque superado
            System.out.println(me.getMetodo());
            assertEquals("validarLimiteSuperado", me.getMetodo());
            throw me;
        }
    }

    @Test(expected = MensagemException.class)
    public void testLimiteEstoqueSuperado2() throws MensagemException {
        try {
            ItemPedido item = new ItemPedido();

            item.setProduto(produto1);
            item.setQuantidade(4);

            pedido.adicionarItemPedido(estoque1, item);
            
            //Testa a quantidade de itens da lista de pedidos
            assertEquals(1, pedido.getItens().size(), 0);

            item = new ItemPedido();

            item.setProduto(produto1);
            item.setQuantidade(7);

            pedido.adicionarItemPedido(estoque1, item);
        } catch (MensagemException me) {
            //Testa se ocorre erro ao tentar adicionar um item sem produto com estoque superado
            System.out.println(me.getMetodo());
            assertEquals("validarLimiteSuperado", me.getMetodo());
            throw me;
        }
    }
}
