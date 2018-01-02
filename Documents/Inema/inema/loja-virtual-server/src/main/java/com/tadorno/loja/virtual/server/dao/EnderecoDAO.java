/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.dao;

import com.tadorno.loja.virtual.server.model.Endereco;
import java.io.Serializable;

public class EnderecoDAO extends GenericDAO<Endereco, Long> implements Serializable {

    private static final EnderecoDAO INSTANCE = new EnderecoDAO();
    
    private EnderecoDAO() {}

    public static EnderecoDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Class<Endereco> getEntityClass() {
        return Endereco.class;
    }
    
}
