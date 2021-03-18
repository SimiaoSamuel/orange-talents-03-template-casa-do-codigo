package com.orangetalents.casadocodigo.categoria;

public class CategoriaDto {
    private Integer id;
    private String nome;

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public CategoriaDto(Categoria categoria) {
        this.nome = categoria.getNome();
        this.id = categoria.getId();
    }
}
