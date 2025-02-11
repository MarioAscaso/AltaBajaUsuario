package rangoTrabajo;

public class Subordinado {
    protected String nombre;
    protected String apellido;
    protected String fechaNacimiento;
    protected String fechaAlta;
    protected float salario;

    public Subordinado(String nombre, String apellido, String fechaNacimiento, String fechaAlta, float salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaAlta = fechaAlta;
        this.salario = salario;
    }

    public String getNombre(){
        return nombre;
    }
    public void setSalario(float salario){
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Fecha de nacimiento: " + fechaNacimiento + ", Fecha de alta: " + fechaAlta + ", Salario: " + salario;
    }

}
