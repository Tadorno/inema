/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.dao;

import com.tadorno.loja.virtual.server.model.Pedido;
import java.io.Serializable;

public class PedidoDAO extends GenericDAO<Pedido, Long> implements Serializable {

    private static final PedidoDAO INSTANCE = new PedidoDAO();
    
    private PedidoDAO() {}

    public static PedidoDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Class<Pedido> getEntityClass() {
        return Pedido.class;
    }
    
}
