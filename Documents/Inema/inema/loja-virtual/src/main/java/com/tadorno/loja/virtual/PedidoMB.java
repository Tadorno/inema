/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual;

import com.tadorno.loja.virtual.server.api.ClienteEJB;
import com.tadorno.loja.virtual.server.api.EstoqueEJB;
import com.tadorno.loja.virtual.server.api.PedidoEJB;
import com.tadorno.loja.virtual.server.exception.ErroPersistenciaException;
import com.tadorno.loja.virtual.server.exception.MensagemException;
import com.tadorno.loja.virtual.server.model.Cliente;
import com.tadorno.loja.virtual.server.model.Estoque;
import com.tadorno.loja.virtual.server.model.ItemPedido;
import com.tadorno.loja.virtual.server.model.Pedido;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author tulio
 */
@ManagedBean(name = "pedidoMB")
@ViewScoped
public class PedidoMB extends ControllerTrait implements Serializable {

    private Cliente cliente = new Cliente();

    private Pedido pedido = new Pedido();

    private ItemPedido item = new ItemPedido(pedido);

    private String cpfBusca;

    private boolean meuEndereco = false;

    private List<SelectItem> produtos;

    //Mapa de produto por ID para evitar ir ao banco quando realizar o bind do itemProduto
    private Map<Long, Estoque> mapEstoque = new HashMap();

    @EJB
    private ClienteEJB clienteEJB;

    @EJB
    private PedidoEJB pedidoEJB;

    @EJB
    private EstoqueEJB estoqueEJB;

    public void selectFromCpf() {
        cliente = new Cliente();
        if (!cpfBusca.trim().isEmpty()) {
            try {
                this.cliente = clienteEJB.selectFromCpf(cpfBusca.trim());
            } catch (MensagemException ex) {
                this.addMessage(null, ex.getMessage(), "", this.WARN);
                cpfBusca = "";
            } catch (ErroPersistenciaException ex) {
                this.addMessage(null, "Ocorreu um erro em sua requisição.", "", this.DANGER);
            }
        }
    }

    public String salvar() {
        if (pedido.getItens().isEmpty()) {
            this.addMessage(null, "Insira ao menos um Produto.", "", this.DANGER);
        } else {

            pedido.setCliente(cliente);

            try {
                pedidoEJB.salvar(pedido, meuEndereco);
                cliente = new Cliente();
                pedido = new Pedido();
                meuEndereco = false;
                cpfBusca = "";
                produtos = null; //Apenas para atualizar o estoque na combo. O ideal é criar uma lógica mais elaborada
                this.addMessage(null, "Pedido Realizado com Sucesso.", "", this.SUCCESS);
            } catch (MensagemException ex) {
                this.addMessage(null, ex.getMessage(), "", this.WARN);
            } catch (ErroPersistenciaException ex) {
                this.addMessage(null, "Ocorreu um erro em sua requisição.", "", this.DANGER);
            }
        }
        return null;
    }

    public void adicionarProduto() {
        item.setProduto(mapEstoque.get(item.getProduto().getId()).getProduto());

        try {
            pedido.adicionarItemPedido(mapEstoque.get(item.getProduto().getId()), item);
            item = new ItemPedido(pedido);
        } catch (MensagemException me) {
            this.addMessage(null, me.getMessage(), "", this.WARN);
        }
    }

    public void removerItemPedido(ItemPedido item) {
        //TODO: Reavaliar equals para remoção de objetos pelo método remove do ArrayList
        //pedido.getItens().remove(item);
        for (int i = 0; i < pedido.getItens().size(); i++) {
            ItemPedido  itemAux = pedido.getItens().get(i);
            if (itemAux.getProduto().equals(item.getProduto())) {
                pedido.getItens().remove(i);
                break;
            }
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCpfBusca() {
        return cpfBusca;
    }

    public void setCpfBusca(String cpfBusca) {
        this.cpfBusca = cpfBusca;
    }

    public boolean isMeuEndereco() {
        return meuEndereco;
    }

    public void setMeuEndereco(boolean meuEndereco) {
        this.meuEndereco = meuEndereco;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public ItemPedido getItem() {
        return item;
    }

    public void setItem(ItemPedido item) {
        this.item = item;
    }

    public List<SelectItem> getProdutos() {
        if (produtos == null) {
            produtos = new ArrayList<>();
            try {
                List<Estoque> estoques = estoqueEJB.select(0, 9999, "produto.nome", "ASC", new HashMap<String, Object>());
                for (Estoque model : estoques) {
                    mapEstoque.put(model.getProduto().getId(), model);
                    produtos.add(new SelectItem(model.getProduto().getId(), model.getProduto().getNome() + " / " + model.getQuantidade()));
                }
            } catch (ErroPersistenciaException ex) {
                ex.printStackTrace();
            }
        }
        return produtos;
    }
}
