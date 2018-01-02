/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.bean;

import com.tadorno.loja.virtual.server.api.EstoqueEJB;
import com.tadorno.loja.virtual.server.dao.EstoqueDAO;
import com.tadorno.loja.virtual.server.dao.GenericDAO;
import com.tadorno.loja.virtual.server.model.Estoque;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tulio
 */
@Stateless
public class EstoqueBean extends GenericBean<Estoque> implements EstoqueEJB{
    
    @PersistenceContext(unitName = "lojaVirtualPU")
    private EntityManager manager;

    @Override
    GenericDAO<Estoque, Long> getDAO() {
       return EstoqueDAO.getInstance();
    }

    @Override
    EntityManager getManager() {
        return manager;
    }

}
