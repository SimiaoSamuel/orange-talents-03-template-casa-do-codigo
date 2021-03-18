package com.orangetalents.casadocodigo.categoria;

import com.orangetalents.casadocodigo.validation.NotDuplicatedGenerico;

import javax.validation.constraints.NotBlank;
import java.util.Locale;

public class CategoriaForm {
    @NotBlank
    @NotDuplicatedGenerico(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toCategoria() {
        return new Categoria(nome);
    }
}
