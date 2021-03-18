package com.orangetalents.casadocodigo.estadopais;

import com.orangetalents.casadocodigo.validation.NotDuplicatedGenerico;

import javax.validation.constraints.NotBlank;

public class PaisForm {
    @NotBlank @NotDuplicatedGenerico(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais toPais(){
        return new Pais(nome);
    }
}
