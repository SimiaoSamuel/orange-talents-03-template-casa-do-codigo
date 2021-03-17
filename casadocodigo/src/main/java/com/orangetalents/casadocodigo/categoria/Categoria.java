package com.orangetalents.casadocodigo.categoria;

import javax.persistence.*;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String nome;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria() {
    }
}
