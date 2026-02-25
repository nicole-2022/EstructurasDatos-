package Clase2;

public class Ejercicio14 {

    public static void main(String[] args) {
        // Se crea un arreglo N
        int[] N ={2,4,8,2,9,6,4,8};
        // 2-6= -4
        // 8-2 = 6 y asi los demas

        //Se crea un arreglo b (se hacen 7 restas) (N- 1)
        int[] b = new int[N.length -1];// length es para mirar el tamaño de N
        
        // Si no se coloca el -1 no se dara un resultado en el terminal
        // Con el -1 no llega el ultimo elemento
        for(int i =0; i < N.length -1; i++){
            // se restan  y sigue restando con el sieguiente
            b[i] = N[i]- N[i+1];
        }

        for(int i = 0; i< b.length; i++){
            System.out.println("El arreglo b es: "+b[i]);
        }
        // el for se ejecuta varias veces por eso imprime y baja linea
    }
    
}

