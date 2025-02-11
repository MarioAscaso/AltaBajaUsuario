package output;

import rangoTrabajo.MandoIntermedio;
import rangoTrabajo.Subordinado;

public class Output {

    public void mostrarMenu() {
        System.out.print("""
                
                1. - Dar Alta Usuario
                2. - Listar Usuarios
                3. - Modificar Salario
                4. - Dar Baja Usuario
                5. - Salir
                
                Elije opcion a realizar:""");
    }
    public void preguntarRango() {
        System.out.print("""
                1. - Subordinado
                2. - Mando Intermedio
                Introduce (numericamente) su rango:""");
    }

    public void pedirNombre() {System.out.print("Introduce su nombre: ");}
    public void pedirApellido() {System.out.print("Introduce su primer apellido: ");}
    public void pedirEdad() {System.out.print("Introduce su fecha de nacimiento: ");}
    public void pedirFechaAlta() {System.out.print("Introduce fecha de alta: ");}
    public void pedirSalario() {System.out.print("Introduce su salario: ");}
    public void pedirComision() {System.out.print("Introduce su comision por venta: ");}
    public void mostrarUsuarios(Subordinado subordinado) {System.out.println(subordinado);}


    public void mensajeDespedida(){System.out.println("Cierre de sesion.");}
}
