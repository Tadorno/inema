/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.aspecto;

import java.util.Objects;

/**
 *
 * @author tulio
 * @param <T>
 * 
 * Interface para utilização futuras como validadores, filtros, conversores e etc
 */
public abstract class ObjetoComId<T> {
   
   public abstract Long getId(); 
   
   public abstract void setId(Long id);
    
   @Override
   public boolean equals(Object object){
        //Se o objeto a ser testado for nulo retorna false
        if(object == null){
            return false;
        }
        //Se o objeto nao for uma instancia de ObjetoComId retorna false
        if(!(object instanceof ObjetoComId)){
            return false;
        }
        //Se os objetos testados não forem de mesma classe retorna false
        //Superclasse e subclasses devem retornar false no teste
        if(!(this.getClass() == object.getClass())){
            return false;
        }
        //Se o id for 0 retorna false, pois e como se a entidade não tivesse sido
        //iniciada
        if(this.getId() == 0 || ((ObjetoComId) object).getId()== 0){
            return false;
        }   
        //Se os id's forem diferentes retorna false
        if(this.getId() != ((ObjetoComId) object).getId()){
            return false;
        }
        return true;
   }

    @Override
    public int hashCode() {
        int hash = Objects.hashCode(getId());
        return hash;
    }
    
}
