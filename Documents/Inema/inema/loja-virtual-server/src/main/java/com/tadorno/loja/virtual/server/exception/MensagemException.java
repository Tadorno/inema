/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author tulio
 */
@ApplicationException(rollback = true)
public class MensagemException extends Exception {

    private final String metodo;

    public MensagemException(String metodo, Exception error) {
        super(error);
        this.metodo = metodo;
    }

    public String getMetodo() {
        return metodo;
    }
    
    @Override
    public String getMessage(){
        return super.getCause().getMessage();
    }

    @Override
    public String toString() {
        return "MensagemException{" + "metodo=" + metodo + ", error=" + this.getMessage() + '}';
    }

}
