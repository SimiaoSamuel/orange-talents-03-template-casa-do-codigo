package com.orangetalents.casadocodigo.categoria;

public class CategoriaDto {
    private String nome;

    public String getNome() {
        return nome;
    }

    public CategoriaDto(Categoria categoria) {
        this.nome = categoria.getNome();
    }
}
