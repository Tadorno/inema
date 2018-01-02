/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.bean;

import com.tadorno.loja.virtual.server.api.PedidoEJB;
import com.tadorno.loja.virtual.server.dao.GenericDAO;
import com.tadorno.loja.virtual.server.dao.PedidoDAO;
import com.tadorno.loja.virtual.server.model.Pedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tulio
 */
@Stateless
public class PedidoBean extends GenericBean<Pedido> implements PedidoEJB{
    
    @PersistenceContext(unitName = "lojaVirtualPU")
    private EntityManager manager;

    @Override
    GenericDAO<Pedido, Long> getDAO() {
       return PedidoDAO.getInstance();
    }

    @Override
    EntityManager getManager() {
        return manager;
    }

}
