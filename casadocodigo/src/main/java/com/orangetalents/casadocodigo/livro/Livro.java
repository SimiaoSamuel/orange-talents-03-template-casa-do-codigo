package com.orangetalents.casadocodigo.livro;

import com.orangetalents.casadocodigo.autor.Autor;
import com.orangetalents.casadocodigo.categoria.Categoria;
import com.orangetalents.casadocodigo.validation.NotDuplicatedGenerico;
import org.springframework.context.annotation.DependsOn;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    private String resumo;

    private String sumario;

    private BigDecimal preco;

    private Integer numeroDePaginas;

    private String isbn;

    private LocalDate dataPublicacao;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroDePaginas,
                 String isbn, LocalDate dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    @Deprecated
    public Livro() {
    }
}
