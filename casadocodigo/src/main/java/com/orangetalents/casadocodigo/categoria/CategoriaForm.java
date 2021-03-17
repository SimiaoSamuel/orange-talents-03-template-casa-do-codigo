package com.orangetalents.casadocodigo.categoria;

import com.orangetalents.casadocodigo.validation.UniqueCategoriaNome;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {
    @NotBlank @UniqueCategoriaNome
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toCategoria(){
        return new Categoria(nome);
    }
}
