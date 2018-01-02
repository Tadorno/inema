/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.dao;

import com.tadorno.loja.virtual.server.model.Estoque;
import java.io.Serializable;

public class EstoqueDAO extends GenericDAO<Estoque, Long> implements Serializable {

    private static final EstoqueDAO INSTANCE = new EstoqueDAO();
    
    private EstoqueDAO() {}

    public static EstoqueDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Class<Estoque> getEntityClass() {
        return Estoque.class;
    }
    
}
