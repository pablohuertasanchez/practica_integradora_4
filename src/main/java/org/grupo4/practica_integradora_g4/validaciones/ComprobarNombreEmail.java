package org.grupo4.practica_integradora_g4.validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorNombreEmail.class)
public @interface ComprobarNombreEmail {
    String message() default "Este nombre ya está registrado. Por favor, introduzca uno nuevo";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
