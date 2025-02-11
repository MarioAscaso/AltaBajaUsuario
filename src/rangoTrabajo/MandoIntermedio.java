package rangoTrabajo;

public class MandoIntermedio extends Subordinado {
    private final int comision;

    public MandoIntermedio(String nombre, String apellido, String fechaNacimiento, String fechaAlta, float salario, int comision) {
        super(nombre, apellido, fechaNacimiento, fechaAlta, salario);
        this.comision = comision;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Fecha de nacimiento: " + fechaNacimiento + ", Fecha de alta: " + fechaAlta + ", Salario: " + salario + ", Comision: " + comision;
    }
}
