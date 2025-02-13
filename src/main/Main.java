package main;

import input.Input;
import output.Output;
import rangoTrabajo.MandoIntermedio;
import rangoTrabajo.Subordinado;
import validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int ALTA = 1;
    public static final int LISTAR = 2;
    public static final int MODIFICAR = 3;
    public static final int BAJA = 4;
    public static final int SALIR = 5;
    public static final int SUBORDINADO = 10;
    public static final int MANDO_INTERMEDIO = 11;

    private static List<Subordinado> usuarios;

    private static String nombre;
    private static float salario;

    public static void main(String[] args) {
        usuarios = new ArrayList<>();
        int opcionMenu;
        do {
            opcionMenu = getOpcionMenu();
            accion(opcionMenu);
        } while (!Validator.usuarioQuiereSalir(opcionMenu));
    }

    private static int getOpcionMenu() {
        int opcionMenu;
        do {
            opcionMenu = mostrarYrecibirOpcion();
        } while (!Validator.validarOpcionMenu(opcionMenu));
        return opcionMenu;
    }


    private static int mostrarYrecibirOpcion(){
        Output.mostrarMenu();
        return Input.recibirValorInt();
    }

    private static void accion(int opcionMenu){
        switch (opcionMenu) {
            case ALTA: altaUsuario();
                break;
            case LISTAR: mostrarListaUsuarios(usuarios);
                break;
            case MODIFICAR: cambioSalario();
                break;
            case BAJA: bajaUsuario();
                break;
            case SALIR: Output.mensajeDespedida();
                break;
            default:
        }
    }

    private static void altaUsuario() {
        boolean estaEnRango;
        int rangoTrabajo;
        do {
            Output.preguntarRango();
            rangoTrabajo = Input.recibirValorInt();
            estaEnRango = Validator.validarRangoTrabajador(rangoTrabajo);
        } while (!estaEnRango);
        Object[] datos = pedirDatos();
        if(rangoTrabajo == SUBORDINADO) {
            usuarios.add(new Subordinado((String)datos[0], (String)datos[1], (String)datos[2], (String)datos[3], Float.parseFloat((String)datos[4])));
        }
        if(rangoTrabajo == MANDO_INTERMEDIO){
            Output.pedirComision();
            int comision = Input.recibirValorInt();
            usuarios.add(new MandoIntermedio((String)datos[0], (String)datos[1], (String)datos[2], (String)datos[3], Float.parseFloat((String)datos[4]), comision));
        }
    }



    private static void mostrarListaUsuarios(List<Subordinado> usuarios) {
        for (Subordinado subordinado : usuarios) {
            if (null != subordinado) {
                Output.mostrarUsuarios(subordinado);
            }
        }
    }

    private static void cambioSalario(){
        Output.pedirNombre();
        nombre = Input.recibirTexto();
        boolean encontrado = false;
        int i = 0;
        while(!encontrado){
            Subordinado sub = usuarios.get(i);
            if(sub.getNombre().equals(nombre)) {
                Output.pedirSalario();
                salario = Input.recibirValorFloat();
                sub.setSalario(salario);
                encontrado = true;
            }
            i++;
        }
    }

    private static void bajaUsuario(){
        Output.pedirNombre();
        nombre = Input.recibirTexto();
        boolean encontrado = false;
        int i = 0;
        while(!encontrado){
            Subordinado sub = usuarios.get(i);
            if(sub.getNombre().equals(nombre)) {
                usuarios.remove(sub);
                encontrado = true;
            }
            i++;
        }
    }

    private static Object[] pedirDatos() {
        Object[] datos = new Object[5];
        Output.pedirNombre();
        nombre = Input.recibirTexto();
        datos[0] = nombre;
        Output.pedirApellido();
        String apellido = Input.recibirTexto();
        datos[1] = apellido;
        Output.pedirEdad();
        String fechaNacimiento = Input.recibirTexto();
        datos[2] = fechaNacimiento;
        Output.pedirFechaAlta();
        String fechaAlta = Input.recibirTexto();
        datos[3] = fechaAlta;
        Output.pedirSalario();
        salario = Input.recibirValorFloat();
        datos[4] = salario;

        return datos;
    }
}
