/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.model;

import com.tadorno.loja.virtual.server.aspecto.ObjetoComId;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author tulio
 */
@Entity
@Table(name = "endereco")
public class Endereco extends ObjetoComId implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public Endereco(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long id;
    
    @NotEmpty(message = "Campo Logradouro é obrigatório.")
    @Column(name = "logradouro")
    private String logradouro;
    
    @NotEmpty(message = "Campo CEP é obrigatório.")
    @Column(name = "cep")
    private String cep;
    
    @NotEmpty(message = "Campo Bairro é obrigatório.")
    @Column(name = "bairro")
    private String bairro;
    
    @NotEmpty(message = "Campo Cidade é obrigatório.")
    @Column(name = "cidade")
    private String cidade;
    
    @NotNull(message = "Campo Número é obrigatório.")
    @Column(name = "numero")
    private int numero;
    

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
