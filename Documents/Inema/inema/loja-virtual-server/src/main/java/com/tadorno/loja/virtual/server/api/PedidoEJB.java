/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.api;

import com.tadorno.loja.virtual.server.exception.ErroPersistenciaException;
import com.tadorno.loja.virtual.server.exception.MensagemException;
import com.tadorno.loja.virtual.server.model.Pedido;


/**
 *
 * @author tulio
 */
public interface PedidoEJB extends GenericEJB<Pedido>{
    
    /**
     * 
     * @param pedido entidade Pedido
     * @param usarMeuEndereco flag que indica se é para usar endereço do cliente ou o informado em tela
     * @throws ErroPersistenciaException
     * @throws MensagemException 
     */
    void salvar(Pedido pedido, boolean usarMeuEndereco) throws ErroPersistenciaException, MensagemException;
}
