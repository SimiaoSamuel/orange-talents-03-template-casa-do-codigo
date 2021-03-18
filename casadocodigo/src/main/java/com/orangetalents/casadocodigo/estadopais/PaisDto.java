package com.orangetalents.casadocodigo.estadopais;

public class PaisDto {
    private Integer id;
    private String nome;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public PaisDto(Pais pais) {
        this.nome = pais.getNome();
        this.id = pais.getId();
    }
}
