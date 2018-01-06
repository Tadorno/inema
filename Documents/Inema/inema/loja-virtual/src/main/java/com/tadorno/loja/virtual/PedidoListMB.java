/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual;

import com.tadorno.loja.virtual.lazy.LazyPedido;
import com.tadorno.loja.virtual.server.api.PedidoEJB;
import com.tadorno.loja.virtual.server.model.Pedido;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author tulio
 */
@ManagedBean(name = "pedidoListMB")
@ViewScoped
public class PedidoListMB extends ControllerTrait implements Serializable{
    
    @PostConstruct
    public void init(){
        lazyModel = new LazyPedido(pedidoEJB); 
    }

    private LazyDataModel<Pedido> lazyModel;
    
    private Pedido pedido;

    @EJB
    private PedidoEJB pedidoEJB;
    
    public LazyDataModel<Pedido> getLazyModel() {
        return lazyModel;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public void detalhar(Pedido pedido) {
        this.pedido = pedido;
    }
}
