/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.api;

import com.tadorno.loja.virtual.server.exception.ErroPersistenciaException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tulio
 * 
 * Interface Genérica para a API
 * @param <T>
 */
public interface GenericEJB<T> {
    
    T find(Long id) throws ErroPersistenciaException;
    
    void salvar(T entidade )throws ErroPersistenciaException;
    
    void delete(T entidade) throws ErroPersistenciaException; 
    
    List<T> select(int first, int max, String sortField, String sortOrder, Map<String, Object> filterMap) throws ErroPersistenciaException;
    
    int getRow(Map<String, Object> filters) throws ErroPersistenciaException;
}
