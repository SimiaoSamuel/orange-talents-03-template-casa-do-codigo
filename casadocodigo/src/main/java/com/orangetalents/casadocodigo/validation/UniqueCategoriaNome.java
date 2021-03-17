package com.orangetalents.casadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CategoriaValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCategoriaNome {
    String message() default "Já existe uma categoria com esse nome registrada!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
