package com.orangetalents.casadocodigo.autor;

import com.orangetalents.casadocodigo.validation.NotDuplicatedGenerico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Locale;

public class AutorForm {
    @NotBlank
    private String nome;

    @Email
    @NotBlank
    @NotDuplicatedGenerico(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    private final LocalDateTime instanteDeCriacao = LocalDateTime.now().withNano(0);

    public Autor toAutor() {
        return new Autor(nome, email, descricao, instanteDeCriacao);
    }

    public AutorForm(@NotBlank String nome,@NotBlank @Email String email,@NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
}
