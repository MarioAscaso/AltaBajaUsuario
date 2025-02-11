package input;

import java.util.Scanner;

public class Input {
    private final static Scanner sc = new Scanner(System.in);
    private static int valorInt;
    private static float valorFloat;
    private static String valorString;

    private static void recibirInt() {valorInt = sc.nextInt();}
    public static int recibirValorInt() {
        recibirInt();
        return valorInt;
    }

    private static void recibirFloat() {valorFloat = sc.nextFloat();}
    public static float recibirValorFloat() {
        recibirFloat();
        return valorFloat;
    }

    private static void recibirString() {valorString = sc.next();}
    public static String recibirTexto() {
        recibirString();
        return valorString;
    }

}
