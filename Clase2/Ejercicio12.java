package Clase2;

public class Ejercicio12 {
    public static void main(String[] args) {
        
    // se tiene un arreglo A, que despues se mira la posicio de x
    int[] A ={4,8,4,7,4,6};
   //La variable es para mirar en que posicion esta el 4
    int x = 4; 
    // la varible es para mirar x cuantas aparece
    int contador = 0;


    // El for es para recorrer las posiciones del arreglo A
    for(int i = 0; i < A.length; i++){
        if(A[i]== x){
            // para aumentar x en el contador
            contador++;
        }

    }
    // Variable para avanzar en en arreglo B
    int avanzar = 0;
    // se crea el arreglo b 
    int[] B = new int [3];

    //Se vuelve a recorrer el arreglo A
    for(int i = 0; i < A.length; i++){
        if (A[i] == x){
            B[avanzar] = i; // para mirar en que posicion esta x
            avanzar++;
        }

    }
    
        for (int i = 0; i < B.length; i++) {
            System.out.println("Posiciones donde aparece " + x+ "{" + B[i] +"}" );
            
        }
    

   }  
}
