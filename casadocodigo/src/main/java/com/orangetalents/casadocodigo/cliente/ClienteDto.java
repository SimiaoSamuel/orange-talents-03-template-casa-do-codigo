package com.orangetalents.casadocodigo.cliente;

public class ClienteDto {
    private Integer id;

    private String nome;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public ClienteDto(Cliente cliente) {
        this.nome = cliente.getNome();
        this.id = cliente.getId();
    }
}
