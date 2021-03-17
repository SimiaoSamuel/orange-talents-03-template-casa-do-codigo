package com.orangetalents.casadocodigo.validation;

import com.orangetalents.casadocodigo.autor.AutorRepository;
import com.orangetalents.casadocodigo.categoria.CategoriaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidatorGenerico implements ConstraintValidator<NotDuplicatedGenerico, String> {

    private String atributo;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(NotDuplicatedGenerico constraintAnnotation) {
        this.atributo = constraintAnnotation.fieldName();
        this.klass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = em.createQuery("SELECT 1 FROM " + klass.getName() + " where " + atributo + "=:value");
        query.setParameter("value", value);

        List<?> lista = query.getResultList();
        return lista.size() < 1;
    }
}
