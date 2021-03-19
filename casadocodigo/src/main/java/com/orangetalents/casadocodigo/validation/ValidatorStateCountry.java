package com.orangetalents.casadocodigo.validation;

import com.orangetalents.casadocodigo.cliente.ClienteForm;
import com.orangetalents.casadocodigo.estadopais.Estado;
import com.orangetalents.casadocodigo.estadopais.EstadoRepository;
import com.orangetalents.casadocodigo.estadopais.Pais;
import com.orangetalents.casadocodigo.estadopais.PaisRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ValidatorStateCountry implements ConstraintValidator<ValidationStateCountry, ClienteForm> {

    private final EstadoRepository estadoRepository;
    private final PaisRepository paisRepository;

    public ValidatorStateCountry(EstadoRepository estadoRepository, PaisRepository paisRepository) {
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @Override
    public void initialize(ValidationStateCountry constraintAnnotation) {
    }

    @Override
    public boolean isValid(ClienteForm clienteForm, ConstraintValidatorContext constraintValidatorContext) {
        Integer estadoId = clienteForm.getEstadoId();
        Integer paisId = clienteForm.getPaisId();
        List<Estado> estado = new ArrayList<>();

        Optional<Pais> pais = paisRepository.findById(paisId);
        if(pais.isPresent())
            estado = estadoRepository.findByPais(pais.get());

        boolean isValuePresent = !estado.isEmpty();

        if(isValuePresent && estadoId == null) {
            return false;
        }
        else if(isValuePresent){
            return estado.stream().anyMatch(e -> e.getId().equals(estadoId));
        }
        else return estadoId == null;
    }
}
