package Clase2;

public class Ejercicio9 {
    public static void main(String[] args) {
        // un arreglo de numeros enteros 
        int[] enteros={4,6,8,2,4};
        
        int numero = 4;
        // Es una variable que despues se la utiliza para mirar cuantos 4 hay en el arreglo
        int contador =0;
        // Recorre el arreglo y despues con la condicio y el contador se mira
        // cuantas veces aparece 4 en el arrreglo
        for(int i=0; i< enteros.length; i++){
            //Para comparar cada elemento 
            if(enteros[i]== numero){
             contador++;
            }
        }
        System.out.println("La veces que se repite el numero son; " + contador);

    }
    
    
}