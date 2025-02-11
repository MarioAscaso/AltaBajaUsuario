package output;

import rangoTrabajo.Subordinado;

public class Output {

    public static void mostrarMenu() {
        System.out.print("""
                
                1. - Dar Alta Usuario
                2. - Listar Usuarios
                3. - Modificar Salario
                4. - Dar Baja Usuario
                5. - Salir
                
                Elija opción a realizar:""");
    }
    public static void preguntarRango() {
        System.out.print("""
                10. - Subordinado
                11. - Mando Intermedio
                Introduce (numéricamente) su rango:""");
    }
    public static void pedirNombre() {System.out.print("Introduce su nombre: ");}
    public static void pedirApellido() {System.out.print("Introduce su primer apellido: ");}
    public static void pedirEdad() {System.out.print("Introduce su fecha de nacimiento: ");}
    public static void pedirFechaAlta() {System.out.print("Introduce fecha de alta: ");}
    public static void pedirSalario() {System.out.print("Introduce su salario: ");}
    public static void pedirComision() {System.out.print("Introduce su comisión por venta: ");}
    public static void mostrarUsuarios(Subordinado subordinado) {System.out.println(subordinado);}
    public static void mensajeDespedida() {System.out.println("Cierre de sesión.");}
}
