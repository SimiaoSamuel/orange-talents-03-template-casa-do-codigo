package com.orangetalents.casadocodigo.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidatorExist implements ConstraintValidator<Exist, String> {
    private String atributo;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(Exist constraintAnnotation) {
        this.atributo = constraintAnnotation.fieldName();
        this.klass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = em.createQuery("SELECT 1 FROM " + klass.getName() + " where " + atributo + "=:value");
        query.setParameter("value", value);

        List<?> lista = query.getResultList();
        return lista.size() >= 1;
    }
}
