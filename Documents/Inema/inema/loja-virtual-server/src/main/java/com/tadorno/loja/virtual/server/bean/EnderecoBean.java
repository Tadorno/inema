/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.bean;

import com.tadorno.loja.virtual.server.api.EnderecoEJB;
import com.tadorno.loja.virtual.server.dao.EnderecoDAO;
import com.tadorno.loja.virtual.server.dao.GenericDAO;
import com.tadorno.loja.virtual.server.model.Endereco;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tulio
 */
@Stateless
public class EnderecoBean extends GenericBean<Endereco> implements EnderecoEJB{
    
    @PersistenceContext(unitName = "lojaVirtualPU")
    private EntityManager manager;

    @Override
    GenericDAO<Endereco, Long> getDAO() {
       return EnderecoDAO.getInstance();
    }

    @Override
    EntityManager getManager() {
        return manager;
    }

}
