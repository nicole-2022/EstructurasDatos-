import java.util.Scanner;
import java.util.Stack;

public class DeshacerPila {

    public static void main(String[] args) {
        Scanner usu = new Scanner(System.in);
        Stack<Character> pila = new Stack<>();

        System.out.println("Dime una expresión con paréntesis:");
        String texto = usu.nextLine();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                if (pila.isEmpty()) {
                    System.out.println("Error: hay un ) sin abrir");
                    return;
                } else {
                    pila.pop();
                }
            }
        }

        if (pila.isEmpty()) {
            System.out.println("Paréntesis correctos ");
        } else {
            System.out.println("Error: faltan cerrar paréntesis ");
        }

        usu.close();
    }
}