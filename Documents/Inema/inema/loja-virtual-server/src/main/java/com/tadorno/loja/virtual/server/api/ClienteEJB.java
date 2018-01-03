/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.api;

import com.tadorno.loja.virtual.server.exception.ErroPersistenciaException;
import com.tadorno.loja.virtual.server.exception.MensagemException;
import com.tadorno.loja.virtual.server.model.Cliente;


/**
 *
 * @author tulio
 */
public interface ClienteEJB extends GenericEJB<Cliente>{
    
    Cliente selectFromCpf(String cpf) throws ErroPersistenciaException, MensagemException;
    
}
