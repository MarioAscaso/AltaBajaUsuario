package validator;

import main.Main;

public class Validator {
    public static boolean validarOpcionMenu(int opcionMenu) {
        return Main.ALTA < opcionMenu && opcionMenu <= Main.SALIR;
    }

    public static boolean validarRangoTrabajador(int rangoTrabajo) {
        return rangoTrabajo >= Main.SUBORDINADO && rangoTrabajo <= Main.MANDO_INTERMEDIO;
    }

    public static boolean usuarioQuiereSalir(int opcionMenu) {
        return opcionMenu == Main.SALIR;
    }
}
