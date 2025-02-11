package input;

import java.util.Scanner;

public class Input {
    private final Scanner sc = new Scanner(System.in);
    private int valorInt;
    private float valorFloat;
    private String valorString;

    private void recibirInt() {valorInt = sc.nextInt();}
    public int recibirValorInt() {
        recibirInt();
        return valorInt;
    }

    private void recibirFloat() {valorFloat = sc.nextFloat();}
    public float recibirValorFloat() {
        recibirFloat();
        return valorFloat;
    }

    private void recibirString() {valorString = sc.next();}
    public String recibirValorString() {
        recibirString();
        return valorString;
    }

}
