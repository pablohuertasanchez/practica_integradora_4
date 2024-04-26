package org.grupo4.practica_integradora_g4;

import org.grupo4.practica_integradora_g4.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Colecciones {
    private static final List<Usuario> USUARIOS = new ArrayList<>();
    public static List<Usuario> devuelveUsu() {
        return USUARIOS;
    }
    public static void agregarUsuario(Usuario usuario) {
        USUARIOS.add(usuario);
    }
    public static List<String> obtenerEmailUsuarios() {
        List<String> emailUsuarios = new ArrayList<>();
        for (Usuario usuario : USUARIOS) {
            emailUsuarios.add(usuario.getEmail());
        }
        return emailUsuarios;
    }
}
