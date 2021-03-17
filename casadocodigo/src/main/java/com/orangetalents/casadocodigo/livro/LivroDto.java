package com.orangetalents.casadocodigo.livro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.orangetalents.casadocodigo.autor.Autor;
import com.orangetalents.casadocodigo.categoria.Categoria;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LivroDto {
    private Integer id;

    private String titulo;

    private String resumo;

    private String sumario;

    private BigDecimal preco;

    private Integer numeroDePaginas;

    private String isbn;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;

    private String categoria;

    private String autor;

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

    public String getCategoria() {
        return categoria;
    }

    public String getAutor() {
        return autor;
    }

    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.categoria = livro.getCategoria().getNome();
        this.autor = livro.getAutor().getNome();
    }

    public static List<LivroDto> toListOfLivroDto(List<Livro> livros){
        return livros.stream().map(LivroDto::new).collect(Collectors.toList());
    }
}
