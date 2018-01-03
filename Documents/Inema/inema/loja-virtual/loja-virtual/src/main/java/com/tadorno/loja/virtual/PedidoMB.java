/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual;

import com.tadorno.loja.virtual.server.api.ClienteEJB;
import com.tadorno.loja.virtual.server.api.PedidoEJB;
import com.tadorno.loja.virtual.server.exception.ErroPersistenciaException;
import com.tadorno.loja.virtual.server.exception.MensagemException;
import com.tadorno.loja.virtual.server.exception.ResultadoNaoEncontradoException;
import com.tadorno.loja.virtual.server.model.Cliente;
import com.tadorno.loja.virtual.server.model.Pedido;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author tulio
 */
@ManagedBean(name = "pedidoMB")
@ViewScoped
public class PedidoMB extends ControllerTrait implements Serializable {

    private Cliente cliente = new Cliente();

    private Pedido pedido = new Pedido();

    private String cpfBusca;

    private boolean meuEndereco = false;

    @EJB
    private ClienteEJB clienteEJB;

    @EJB
    private PedidoEJB pedidoEJB;

    public void selectFromCpf() {
        cliente = new Cliente();
        if (!cpfBusca.trim().isEmpty()) {
            try {
                this.cliente = clienteEJB.selectFromCpf(cpfBusca.trim());
            } catch (ErroPersistenciaException ex) {
                this.addMessage(null, "Ocorreu um erro em sua requisição.", "", this.DANGER);
            } catch (ResultadoNaoEncontradoException ex) {
                this.addMessage(null, ex.getMessage(), "", this.DANGER);
                cpfBusca = "";
            }
        }
    }

    public String salvar() {
        pedido.setCliente(cliente);

        try {
            pedidoEJB.salvar(pedido, meuEndereco);
            cliente = new Cliente();
            pedido = new Pedido();
            this.addMessage(null, "Pedido Realizado com Sucesso.", "", this.SUCCESS);
        } catch (MensagemException ex) {
            this.addMessage(null, ex.getMessage(), "", this.WARN);
        } catch (ErroPersistenciaException ex) {
            this.addMessage(null, "Ocorreu um erro em sua requisição.", "", this.DANGER);
        }
        return null;
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

}
