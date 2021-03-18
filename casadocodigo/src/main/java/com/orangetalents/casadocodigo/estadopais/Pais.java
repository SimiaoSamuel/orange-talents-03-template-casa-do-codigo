package com.orangetalents.casadocodigo.estadopais;

import javax.persistence.*;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nome;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais(String nome){
        this.nome = nome;
    }

    @Deprecated
    public Pais() {
    }
}
