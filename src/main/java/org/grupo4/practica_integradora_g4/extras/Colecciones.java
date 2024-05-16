package org.grupo4.practica_integradora_g4.extras;

import org.grupo4.practica_integradora_g4.model.entidades.Cliente;
import org.grupo4.practica_integradora_g4.model.entidades.Usuario;

import java.util.*;

public class Colecciones {
    private final static Map<String, String> GENEROS = new HashMap<String, String>();
    private final static Map<String, String> PREFIJOS = new LinkedHashMap<String, String>();
    private final static Map<String, String> NACIONALIDADES = new HashMap<String, String>();
    private final static Map<String, String> DEPARTAMENTOS = new LinkedHashMap<String,String>();
    private final static Map<String, Usuario> USUARIOSADMIN = new HashMap<String,Usuario>();
    private final static Map<String, String> TIPO_DOCUMENTO = new HashMap<String,String>();
    private final static Map<String, Cliente> CLIENTES = new HashMap<String,Cliente>();

    private static final List<Usuario> USUARIOS = new ArrayList<>();




    static {

        GENEROS.put("F","Femenino");
        GENEROS.put("M","Masculino");
        GENEROS.put("O","Otro");

        PREFIJOS.put("Sr", "Señor");
        PREFIJOS.put("Sra", "Señora");
        PREFIJOS.put("Ca", "Caballero");
        PREFIJOS.put("Dñ", "Doña");

        NACIONALIDADES.put("ES","España");
        NACIONALIDADES.put("IT","Italia");
        NACIONALIDADES.put("PT","Portugal");
        NACIONALIDADES.put("FR","Francia");
        NACIONALIDADES.put("GR","Grecia");

        DEPARTAMENTOS.put("0", "Selecciona tu departamento");
        DEPARTAMENTOS.put("10", "reseach");
        DEPARTAMENTOS.put("20", "Consulting");
        DEPARTAMENTOS.put("30", "managing");
        DEPARTAMENTOS.put("40", "tecnichian");

        TIPO_DOCUMENTO.put("dni","DNI");
        TIPO_DOCUMENTO.put("pass","Pasaporte");


        USUARIOSADMIN.put("root",new Usuario("root","admin","admin","","",null,0,null));
        USUARIOSADMIN.put("olga",new Usuario("olga","hidalgo","hidalgo","","",null,0,null));

    }

    public static Map<String, String> getGeneros(){ return GENEROS; }
    public static Map<String, String> getGPrefijos(){ return PREFIJOS; }
    public static Map<String, String> getNacionalidades(){ return NACIONALIDADES; }
    public static Map<String, String> getDepartamentos(){ return DEPARTAMENTOS; }
    public static Map<String, Usuario> getUsuariosAdmin(){ return USUARIOSADMIN; }
    public static Map<String, String> getTipoDocumento(){ return TIPO_DOCUMENTO; }

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

//    public static void addUsuario(Usuario u){
//        USUARIOS.put(u.getNombre(),u);
//    }

    public static void addCliente(Cliente cliente){
        CLIENTES.put(cliente.getNombre(),cliente);
    }
}