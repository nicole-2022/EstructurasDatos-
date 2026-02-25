package Clase2;

public class Ejercicio4 {
    public static void main (String[] args) throws Exception{
     
        int [] edades = {14, 15, 18 };
        int [] edades2 = {13, 22, 19};
        
        int mayor1 = 0;
        for(int i = 0; i < edades.length; i++ ){
            if (edades[i] > mayor1 ) {
                mayor1 = edades[i];
           }
        }
         System.out.println("La edad mayor es: " + mayor1);
        
         int mayor2 = 0;
        for(int i = 0; i < edades2.length; i++){
            if (edades2[i] > mayor2);
            mayor2 = edades2[i];
        }
        System.out.println("La edad mayor es: " + mayor2);

    }
    
}

