package main;

import input.Input;
import output.Output;
import rangoTrabajo.MandoIntermedio;
import rangoTrabajo.Subordinado;
import validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int ALTA = 1;
    private static final int LISTAR = 2;
    private static final int MODIFICAR = 3;
    private static final int BAJA = 4;
    private static final int SALIR = 5;

    private static Output output;
    private static Input input;
    private static List<Subordinado> usuarios;

    private static String nombre;
    private static String apellido;
    private static String fechaNacimiento;
    private static String fechaAlta;
    private static float salario;
    private static int comision;


    //HACERLO CON HASHMAP


    public static void main(String[] args) {

        output = new Output();
        input = new Input();
        usuarios = new ArrayList<>();

        int opcionMenu;
        do {
            boolean esValidaOpcionMenu;
            do {
                mostrarMenu();
                opcionMenu = recibirValorInt();
                esValidaOpcionMenu = validarOpcionMenu(opcionMenu);
            } while (!esValidaOpcionMenu);

            switch (opcionMenu) {
                case ALTA:
                    int rangoTrabajo;
                    boolean estaEnRango;
                    do {
                        preguntarRango();
                        rangoTrabajo = recibirValorInt();
                        estaEnRango = validarRangoTrabajador(rangoTrabajo);
                    } while (!estaEnRango);
                    if(rangoTrabajo == 1) {
                        altaUsuarioSubordinado();
                        usuarios.add(new Subordinado(nombre, apellido, fechaNacimiento, fechaAlta, salario));
                    }else{
                        if(rangoTrabajo == 2){
                            altaUsuarioMandoIntermedio();
                            usuarios.add(new MandoIntermedio(nombre, apellido, fechaNacimiento, fechaAlta, salario, comision));
                        }
                    }
                    break;
                case LISTAR:
                    mostrarListaUsuarios(usuarios);
                    break;
                case MODIFICAR:
                    cambioSalario();
                    break;
                case BAJA:
                    bajaUsuario();
                    break;
                case SALIR:
                    mensajeDespedida();
                    break;
                default:
            }
        } while (opcionMenu != SALIR);
    }

    private static void mostrarMenu() {output.mostrarMenu();}
    private static void preguntarRango() {output.preguntarRango();}
    private static void mostrarListaUsuarios(List<Subordinado> usuarios) {
        for (Subordinado subordinado : usuarios) {
            if (null != subordinado) {
                output.mostrarUsuarios(subordinado);
            }
        }
    }
    private static void mensajeDespedida(){output.mensajeDespedida();}

    private static int recibirValorInt() {return input.recibirValorInt();}
    private static float recibirValorFloat() {return input.recibirValorFloat();}
    private static String recibibirValorString() {return input.recibirValorString();}

    private static boolean validarOpcionMenu(int opcionMenu) {return Validator.validarMenu(opcionMenu);}
    private static boolean validarRangoTrabajador(int rangoTrabajador) {return Validator.validarRangoTrabajador(rangoTrabajador);}

    private static void altaUsuarioSubordinado() {
        output.pedirNombre();
        nombre = recibibirValorString();
        output.pedirApellido();
        apellido = recibibirValorString();
        output.pedirEdad();
        fechaNacimiento = recibibirValorString();
        output.pedirFechaAlta();
        fechaAlta = recibibirValorString();
        output.pedirSalario();
        salario = recibirValorFloat();
    }
    private static void altaUsuarioMandoIntermedio(){
        altaUsuarioSubordinado();
        output.pedirComision();
        comision = recibirValorInt();
    }
    private static void cambioSalario(){
        output.pedirNombre();
        nombre = recibibirValorString();
        boolean encontrado = false;
        for(int i = 0; !encontrado; i++){
            Subordinado sub = usuarios.get(i);
            if(sub.getNombre().equals(nombre)) {
                output.pedirSalario();
                salario = recibirValorFloat();
                sub.setSalario(salario);
                encontrado = true;
            }
        }
    }

    private static void bajaUsuario(){
        output.pedirNombre();
        nombre = recibibirValorString();
        boolean encontrado = false;
        for(int i = 0; !encontrado; i++){
            Subordinado sub = usuarios.get(i);
            if(sub.getNombre().equals(nombre)) {
                usuarios.remove(sub);
                encontrado = true;
            }
        }
    }
}
