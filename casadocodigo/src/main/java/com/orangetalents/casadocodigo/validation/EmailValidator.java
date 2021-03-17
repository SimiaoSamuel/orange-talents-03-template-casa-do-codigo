package com.orangetalents.casadocodigo.validation;

import com.orangetalents.casadocodigo.autor.Autor;
import com.orangetalents.casadocodigo.autor.AutorRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class EmailValidator implements ConstraintValidator<UniqueEmail,String> {

    private final AutorRepository autorRepository;

    public EmailValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Autor> byEmail = autorRepository.findByEmailIgnoreCase(email);
        return byEmail.isEmpty();
    }
}
