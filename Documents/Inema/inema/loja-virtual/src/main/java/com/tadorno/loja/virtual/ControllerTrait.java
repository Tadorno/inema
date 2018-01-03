/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 *
 * @author tulio
 */
public class ControllerTrait {
    
    final Severity SUCCESS = FacesMessage.SEVERITY_INFO;
    final Severity WARN = FacesMessage.SEVERITY_WARN;
    final Severity DANGER = FacesMessage.SEVERITY_ERROR;
    
    public void addMessage(String id, String msg){
        FacesContext face = FacesContext.getCurrentInstance();
        face.addMessage(id, new FacesMessage(msg));
    }
    
    public void addMessage(String id, String msg, String detail, Severity tipo){
        FacesContext face = FacesContext.getCurrentInstance();
        face.addMessage(id, new FacesMessage(tipo, msg, detail));
    }
    
    public String redirect(String view) {
        FacesContext.getCurrentInstance()
            .getExternalContext()
            .getFlash()
            .setKeepMessages(true);
        return view + "?faces-redirect=true";
    }
}
