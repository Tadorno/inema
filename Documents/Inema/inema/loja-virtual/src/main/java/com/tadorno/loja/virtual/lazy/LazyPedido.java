/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.lazy;

import com.tadorno.loja.virtual.server.api.GenericEJB;
import com.tadorno.loja.virtual.server.api.PedidoEJB;
import com.tadorno.loja.virtual.server.model.Pedido;

/**
 *
 * @author tulioasc
 */
public class LazyPedido extends GenericLazy<Pedido> {
    
    
    private final PedidoEJB pedidoEJB;
    
    public LazyPedido(PedidoEJB pedidoEJB){
        this.pedidoEJB = pedidoEJB;
    }

    @Override
    public GenericEJB getEJB() {
        return pedidoEJB;
    }
    

}
