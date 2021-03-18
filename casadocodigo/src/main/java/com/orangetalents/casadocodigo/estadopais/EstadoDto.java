package com.orangetalents.casadocodigo.estadopais;

public class EstadoDto {
    private Integer id;
    private String nome;
    private String pais;

    public EstadoDto(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.pais = estado.getPais().getNome();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }
}
