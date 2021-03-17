package com.orangetalents.casadocodigo.livro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.orangetalents.casadocodigo.autor.Autor;
import com.orangetalents.casadocodigo.autor.AutorRepository;
import com.orangetalents.casadocodigo.categoria.Categoria;
import com.orangetalents.casadocodigo.categoria.CategoriaRepository;
import com.orangetalents.casadocodigo.validation.Exist;
import com.orangetalents.casadocodigo.validation.NotDuplicatedGenerico;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class LivroForm {
    @NotBlank
    @NotDuplicatedGenerico(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(value = 20)
    private BigDecimal preco;

    @NotNull
    @Min(value = 100)
    private Integer numeroDePaginas;

    @NotBlank
    @NotDuplicatedGenerico(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @NotNull
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @NotBlank
    @Exist(fieldName = "nome", domainClass = Categoria.class)
    private String categoria;

    @NotBlank
    @Exist(fieldName = "nome", domainClass = Autor.class)
    private String autor;

    public Livro toLivro(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
        Optional<Categoria> categoriaEncontrada = categoriaRepository.findByNomeIgnoreCase(categoria);
        Optional<Autor> autorEncontrado = autorRepository.findByNome(autor);
        return new Livro(titulo, resumo, sumario, preco, numeroDePaginas, isbn, dataPublicacao,
                    categoriaEncontrada.get(), autorEncontrado.get());
    }

    public LivroForm(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroDePaginas,
                     String isbn, String categoria, String autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.categoria = categoria;
        this.autor = autor;
    }
}
