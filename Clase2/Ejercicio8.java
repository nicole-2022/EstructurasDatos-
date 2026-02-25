package Clase2;
public class Ejercicio8 {
    public static void main(String[] args) {
        // Arreglo de 30 numeros
        int[] numeros = {5, 40, 3, 8, 30, 9, 1, 9, 4, 9, 7, 60, 10, 15, 20, 2, 3, 1, 25, 30, 9, 8, 7, 6, 5, 4, 3, 2, 1, 5};

        // Se empieza desde la posicion 0
        int mayor = numeros[0];
        int menor = numeros[0];

    
        for (int i = 1; i < numeros.length; i++) {
            // Se utiliza la condicion para mirar si un numero mayor 
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
            if (numeros[i] < menor) { // para mirar el menor
                menor = numeros[i];//guarda el menor(actualiza)
            }
        }

        // Para mirar cuantas veces se repiten los numeros mayores o menores
        int contMayor = 0;
        int contMenor = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == mayor) {
                contMayor++;
            }
            if (numeros[i] == menor) {
                contMenor++;
            }
        }

        System.out.println("El número mayor es: " + mayor + " y las veces que se repite so: " + contMayor);
        System.out.println("El número menor es: " + menor + " y las veces que se repiten son: " + contMenor );
    }
}
