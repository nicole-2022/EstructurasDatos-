package Clase2;

public class Ejercicio7 {
    public static void main(String[] args) throws Exception {
        //Arreglo A que tiene 10 elemntos, son numeros impares y pares 
        int[] a ={1,2,3,4,5,6,7,8,9,10};
        // Arreglo donde solo van los pares
        int[] pares ={2,6,4,8,10};
        //Arreglo donde van solo los impares
        int[] impares={1,3,5,7,9};
       int mostrarPares =0;
       int mostrarImapres =0;
       for ( int i =0; i< a.length; i++){
           if(a[i]% 2 == 0){
            pares[mostrarPares] =a[i];
            mostrarPares++;
           }else{
            impares[mostrarImapres] = a[i];
            mostrarImapres++;
           }
       }
         
        for(int i = 0; i < mostrarPares; i++){
        System.out.println("Los numeros pares del arreglo A son:" +pares[i]);
        }

        
        for(int i = 0; i < mostrarImapres; i++){
        System.out.println("Los numeros impares del arreglo A son:" +impares[i]);
        }

    }
    
}
