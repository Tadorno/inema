/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.server.model;

import com.tadorno.loja.virtual.server.aspecto.ObjetoComId;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author tulio
 */
@Entity
@Table(name = "cliente")
public class Cliente extends ObjetoComId implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public Cliente(){
        this.endereco = new Endereco();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;
    
    @NotEmpty(message = "Campo Nome é obrigatório.")
    @Column(name = "nome")
    private String nome;
    
    @NotNull(message = "Campo CPF é obrigatório.")
    @Column(name = "cpf")
    private String cpf;
    
    @NotNull(message = "Campo Endereço é obrigatório.")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
    
    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
