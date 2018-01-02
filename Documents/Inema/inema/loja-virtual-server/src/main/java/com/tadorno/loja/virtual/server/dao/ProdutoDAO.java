/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.dao;

import com.tadorno.loja.virtual.server.model.Produto;
import java.io.Serializable;

public class ProdutoDAO extends GenericDAO<Produto, Long> implements Serializable {

    private static final ProdutoDAO INSTANCE = new ProdutoDAO();
    
    private ProdutoDAO() {}

    public static ProdutoDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Class<Produto> getEntityClass() {
        return Produto.class;
    }
    
}
