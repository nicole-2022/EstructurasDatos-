package Clase2;

public class Ejercicio3 {
    public static void main(String[] args) {
        int [] a ={2,7,6,9,4,5};
        int sumaImpar = 0;
        int sumaPar = 0;

        for (int i = 0; i < a.length; i++){ 
           if (a[i] % 2 == 0) {
            sumaPar += a[i];
        }else{
            sumaImpar += a[i];
        }
        }
        System.out.println("La suma de los numeros del arreglo pares es: " + sumaPar);
        System.out.println("La suma de los numeros del arreglo Impares es: " + sumaImpar);
     
    }
    
}
