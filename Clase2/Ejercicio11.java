package Clase2;

public class Ejercicio11 {
    public static void main(String[] args) {
        int[] A = {4, 0, -7, 3, 4};
        int N = A.length;

        int ctNegativos = 0;
        int ctcero = 0;
        int countPos = 0;

        for (int i = 0; i < N; i++) {
            if (A[i] < 0) ctNegativos++;
            else if (A[i] == 0) ctcero++;
            else countPos++;
        }

        int[] negativos = new int[ctNegativos];
        int[] ceros = new int[ctcero];
        int[] positivos = new int[countPos];

    
        int iNeg = 0, icero = 0, iPos = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] < 0) {
                negativos[iNeg++] = A[i];
            } else if (A[i] == 0) {
                ceros[icero++] = A[i];
            } else {
                positivos[iPos++] = A[i];
            }
        }

    
        System.out.print("Los negativos del arreglo son:");
        for (int i = 0; i < negativos.length; i++) {
            System.out.print(negativos[i]);
            if (i < negativos.length - 1);
        }

        System.out.print("la cantidad de zeros es:");
        for (int i = 0; i < ceros.length; i++) {
            System.out.print(ceros[i]);
            if (i < ceros.length - 1); 
        }
        

        System.out.print("Los numeros Positivos son: ");
        for (int i = 0; i < positivos.length; i++) {
            System.out.print(positivos[i]);
            if (i < positivos.length - 1);
            }
    }
}