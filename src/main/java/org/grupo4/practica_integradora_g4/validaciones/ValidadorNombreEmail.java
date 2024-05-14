package org.grupo4.practica_integradora_g4.validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.grupo4.practica_integradora_g4.extras.Colecciones;

public class ValidadorNombreEmail implements ConstraintValidator <ComprobarNombreEmail,String> {
    public boolean isValid(String nombre, ConstraintValidatorContext context) {
//valido que no exista el email de usuario
        return !emailYaRegistrado(nombre);
    }
    //Metodo para comprobar si el email ya existe
    public boolean emailYaRegistrado(String email) {
        for(String e : Colecciones.obtenerEmailUsuarios()) {
            if(e.equals(email)) {
                return true;
            }
        }
        return false;
    }
}
