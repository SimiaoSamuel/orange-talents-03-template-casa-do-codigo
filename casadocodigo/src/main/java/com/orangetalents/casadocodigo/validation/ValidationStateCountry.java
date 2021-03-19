package com.orangetalents.casadocodigo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidatorStateCountry.class)
@Target({ElementType.CONSTRUCTOR, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidationStateCountry {
    String message() default "Verifique seu estado, ele só pode ser nulo se o pais não tiver estado" +
            ", é preciso ter um estado na requisição se o pais tiver estado" +
            ", é preciso passar um estado que o pais possui";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
