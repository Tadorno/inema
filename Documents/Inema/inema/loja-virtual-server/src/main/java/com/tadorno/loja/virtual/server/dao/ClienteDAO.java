/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.dao;

import com.tadorno.loja.virtual.server.model.Cliente;
import java.io.Serializable;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements Serializable {

    private static final ClienteDAO INSTANCE = new ClienteDAO();
    
    private ClienteDAO() {}

    public static ClienteDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Class<Cliente> getEntityClass() {
        return Cliente.class;
    }
    
}
