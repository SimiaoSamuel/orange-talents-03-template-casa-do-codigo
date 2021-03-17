package com.orangetalents.casadocodigo.autor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(length = 400, nullable = false)
    private String descricao;

    //@Column(nullable = false)
    private LocalDateTime instanteDeCriacao;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor(String nome, String email, String descricao, LocalDateTime instanteDeCriacao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.instanteDeCriacao = instanteDeCriacao;
    }

    @Deprecated
    public Autor() {
    }
}
