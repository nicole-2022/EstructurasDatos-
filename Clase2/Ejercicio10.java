package Clase2;
public class Ejercicio10 {
   public static void main(String[] args) {
        // un arreglo de 5 elemtos
       int[] A = {3,4,8,4,3};
       //3+3=6 posicción 0
       //4+4=8 y 8

        // 
        int tamañoB; // tamaño seria 3

        if (A.length % 2 == 0 ){
            tamañoB = A.length/ 2; // Si en el arreglo A es par 
        }else{
            tamañoB= (A.length / 2)+1; // Si es impar
        }// mirar las posiciones del arreglo b

         // El nuevo arreglo B
        int[] B = new int[tamañoB];
        // Recorre el arreglo A y suma los dos elementos opuestos 
        for (int i = 0; i < tamañoB; i++) {
            B[i] = A[i] + A[A.length - 1 - i];// Para guardar lo elementos  sumados del arreglo a y los guarad en el b
        } // -1 -i es para retroceder desde el final

    
        for (int i = 0; i < B.length; i++) {
            System.out.println("Arreglo resultante " + B[i]);
        }
    }
}
