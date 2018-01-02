/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.bean;

import com.tadorno.loja.virtual.server.api.ProdutoEJB;
import com.tadorno.loja.virtual.server.dao.GenericDAO;
import com.tadorno.loja.virtual.server.dao.ProdutoDAO;
import com.tadorno.loja.virtual.server.model.Produto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tulio
 */
@Stateless
public class ProdutoBean extends GenericBean<Produto> implements ProdutoEJB{
    
    @PersistenceContext(unitName = "lojaVirtualPU")
    private EntityManager manager;

    @Override
    GenericDAO<Produto, Long> getDAO() {
       return ProdutoDAO.getInstance();
    }

    @Override
    EntityManager getManager() {
        return manager;
    }

}
