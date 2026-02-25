package Clase2;

public class Ejercicio13 {
     
    public static void main(String[] args) throws Exception {

        // Se crea un arreglo para despues recorerlo y calcular la media 
        // y mirar los numeros mayores y menores de la media
        int[] N ={2,4,7,3};
        // Se declara la variable de suma para despues utilizarla dentro de for
        int suma=0;
        //Con for se recorre el arreglo de N
        for(int i =0; i < N.length; i++){
           // MSe realiza la suma para despues calcular la media
           suma = suma + N[i];
        }

        // Se calcula la media (si quieres en decimales se coloca (double) antes de la suma)
        int media = suma / N.length;
        // se hace otro for para recorrer el arreglo N y comparar sus elementos
        for(int i = 0; i < N.length; i++){
            // se compara si N es menor que la media, se va para los menores
            if (N[i] < media){
                System.out.println("El numero es menor que la media ("+N[i]+")");

            }else if (N[i] > media){
                System.out.println("El numero es mayor que la media ("+N[i]+")");

            }
        }

        //Falta vectores 
        
    }
}

