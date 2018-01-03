/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author tulio
 */
@ManagedBean
@ApplicationScoped
public class ParametrosMB {
    private final String APLICATION = "E-Commerce";  
    private final String ROOT_PATH = "/loja-virtual/";
    private final String RESOURCES = ROOT_PATH + "resources/";
    private final String PARTIAL = ROOT_PATH + "partial/";
    private final String RODAPE = "Todos os direitos"; 
    private final String VERSAO = "Versão: 1.0";
        
    public String getAPLICATION() {
        return APLICATION;
    }

    public String getRESOURCES() {
        return RESOURCES;
    }

    public String getRODAPE() {
        return RODAPE;
    }

    public String getVERSAO() {
        return VERSAO;
    } 

    public String getPARTIAL() {
        return PARTIAL;
    }
    
    public String getROOTPATH(){
        return ROOT_PATH;
    }
    
}
