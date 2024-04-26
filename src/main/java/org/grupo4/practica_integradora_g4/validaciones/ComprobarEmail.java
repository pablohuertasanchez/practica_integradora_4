package org.grupo4.practica_integradora_g4.validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = ValidadorEmail.class)
@Documented
public @interface ComprobarEmail {
    String message() default "Patron de email no aceptado";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
