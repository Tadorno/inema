/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.model;

import com.tadorno.loja.virtual.server.aspecto.ObjetoComId;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author tulio
 */
@Entity
@Table(name = "pedido")
public class Pedido extends ObjetoComId implements Serializable {

    private static final long serialVersionUID = 1L;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.endereco = new Endereco();
        this.cliente = new Cliente();
        this.data = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<ItemPedido> itens;

    @NotNull(message = "Campo Cliente é obrigatório.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @NotNull(message = "Campo Endereço é obrigatório.")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "data")
    private Date data;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Double getValorTotal() {
        Double valor = 0.0;
        if (this.itens != null) {
            for (ItemPedido i : this.itens) {
                if(i.getProduto()!= null){
                    valor += i.getProduto().getPreco() * i.getQuantidade();
                }
            }
        }
        return valor;
    }
    
    public void adicionarItemPedido(ItemPedido item){
        boolean existeProduto = false;

        for (ItemPedido itemAux : this.itens) {
            if (itemAux.getProduto().equals(item.getProduto())) {
                itemAux.addQuantidade(item.getQuantidade());
                existeProduto = true;
                break;
            }
        }

        if (!existeProduto) {
            itens.add(item);
        }

    }

}
