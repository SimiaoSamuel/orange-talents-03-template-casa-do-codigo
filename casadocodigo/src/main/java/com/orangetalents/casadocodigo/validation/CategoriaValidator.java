package com.orangetalents.casadocodigo.validation;

import com.orangetalents.casadocodigo.categoria.CategoriaRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoriaValidator implements ConstraintValidator<UniqueCategoriaNome, String> {

    private final CategoriaRepository categoriaRepository;

    public CategoriaValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void initialize(UniqueCategoriaNome constraintAnnotation) {

    }

    @Override
    public boolean isValid(String categoriaNome, ConstraintValidatorContext constraintValidatorContext) {
        return categoriaRepository.findByNomeIgnoreCase(categoriaNome).isEmpty();
    }
}
