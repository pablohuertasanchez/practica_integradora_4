package org.grupo4.practica_integradora_g4.validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.grupo4.practica_integradora_g4.model.entidades.Usuario;

public class ValidadorClaves implements ConstraintValidator<ComprobarClaves, Usuario> {
    @Override
    public boolean isValid(Usuario u, ConstraintValidatorContext context) {
        String clave= u.getClave();
        String confClave = u.getConfirmarClave();

        return  clave.equals(confClave);
    }
}
