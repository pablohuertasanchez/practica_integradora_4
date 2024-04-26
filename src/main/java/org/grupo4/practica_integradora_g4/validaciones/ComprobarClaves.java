package org.grupo4.practica_integradora_g4.validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;

import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorClaves.class)
@ReportAsSingleViolation
public @interface ComprobarClaves {
    String message() default "{validarClaves.confirmarClave}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
