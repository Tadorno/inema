/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.bean;

import com.tadorno.loja.virtual.server.api.GenericEJB;
import com.tadorno.loja.virtual.server.dao.GenericDAO;
import com.tadorno.loja.virtual.server.exception.ErroPersistenciaException;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

/**
 *
 * @author tulio
 * @param <T>
 * 
 * Abstração Genérica do Bean com métodos comuns
 */
public abstract class GenericBean<T> implements GenericEJB<T> {
    
    abstract GenericDAO<T, Long> getDAO();
    
    abstract EntityManager getManager();
    
    @Override
    public T find(Long id) throws ErroPersistenciaException{
        try {
            return getDAO().selectFromId(id, getManager());
        } catch (Exception ex) {
            throw new ErroPersistenciaException("find", ex);
        }
    }

    @Override
    public void salvar(T entidade) throws ErroPersistenciaException {
        try {
            getDAO().persist(entidade, getManager());
        } catch (Exception ex) {
            throw new ErroPersistenciaException("salvar", ex);
        }
    }

    @Override
    public void delete(T entidade) throws ErroPersistenciaException {
        try {
            T c = getManager().merge(entidade);
            getDAO().delete(c, getManager());
        } catch (Exception ex) {
            throw new ErroPersistenciaException("delete", ex);
        }
    }

    @Override
    public List<T> select(int first, int max, String sortField, String sortOrder, Map<String, Object> filterMap) throws ErroPersistenciaException {
        try {
            return getDAO().select(first, max, sortField, sortOrder, filterMap, getManager());
        } catch (Exception ex) {
            throw new ErroPersistenciaException("select", ex);
        }
    }

    @Override
    public int getRow(Map<String, Object> filters) throws ErroPersistenciaException {
        try {
            return getDAO().getRow(filters, getManager());
        } catch (Exception ex) {
            throw new ErroPersistenciaException("getRow", ex);
        }
    }
    
}
