package validator;

public class Validator {
    public static boolean validarMenu(int opcionMenu) {return 0 <= opcionMenu && opcionMenu <= 5;}
    public static boolean validarRangoTrabajador(int rangoTrabajo) {return rangoTrabajo >= 1 && rangoTrabajo <= 2;}
}
