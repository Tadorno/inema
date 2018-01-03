/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.bean;

import com.tadorno.loja.virtual.server.api.ClienteEJB;
import com.tadorno.loja.virtual.server.dao.ClienteDAO;
import com.tadorno.loja.virtual.server.dao.GenericDAO;
import com.tadorno.loja.virtual.server.exception.ErroPersistenciaException;
import com.tadorno.loja.virtual.server.exception.MensagemException;
import com.tadorno.loja.virtual.server.exception.ResultadoNaoEncontradoException;
import com.tadorno.loja.virtual.server.model.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tulio
 */
@Stateless
public class ClienteBean extends GenericBean<Cliente> implements ClienteEJB{
    
    @PersistenceContext(unitName = "lojaVirtualPU")
    private EntityManager manager;

    @Override
    GenericDAO<Cliente, Long> getDAO() {
       return ClienteDAO.getInstance();
    }

    @Override
    EntityManager getManager() {
        return manager;
    }

    @Override
    public Cliente selectFromCpf(String cpf)  throws ErroPersistenciaException, MensagemException{
        try{
            Cliente cliente = ClienteDAO.getInstance().selectFromCpf(cpf, manager);
            if(cliente == null){
                throw new ResultadoNaoEncontradoException("selectFromCpf", new Exception("Cliente não encontrado"));
            }
            
            return cliente;
        }catch(NoResultException ex){
            throw new MensagemException("selectFromCpf", new Exception("Cliente não encontrado"));
        }
        catch(Exception e){
            throw new ErroPersistenciaException("selectFromCpf", e);
        }
    }

}
