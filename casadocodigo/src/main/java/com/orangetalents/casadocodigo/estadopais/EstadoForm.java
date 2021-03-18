package com.orangetalents.casadocodigo.estadopais;

import com.orangetalents.casadocodigo.validation.Exist;
import com.orangetalents.casadocodigo.validation.NotDuplicatedGenerico;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Locale;

public class EstadoForm {
    @NotBlank @NotDuplicatedGenerico(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @NotNull
    @Exist(domainClass = Pais.class, fieldName = "id")
    private Integer paisId;

    public Estado toEstado(PaisRepository paisRepository) {
        Pais pais = paisRepository.findById(paisId).get();
        return new Estado(nome,pais);
    }

    public EstadoForm(String nome,Integer paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }
}
