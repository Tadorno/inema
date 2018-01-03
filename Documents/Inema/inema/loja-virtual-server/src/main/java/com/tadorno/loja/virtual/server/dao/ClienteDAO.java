/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.dao;

import com.tadorno.loja.virtual.server.model.Cliente;
import java.io.Serializable;
import javax.persistence.EntityManager;

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
    
    public Cliente selectFromCpf(String cpf, EntityManager manager) throws Exception {
        StringBuilder query = new StringBuilder();
        query.append("FROM")
                .append(" Cliente c")
                .append(" JOIN c.endereco e")
                .append(" WHERE c.cpf='")
                .append(cpf)
                .append("'");
        
        Object[] result = super.selectSingle(query.toString(), manager);
        return (Cliente) result[0];
    }
}
