package Clase2;
public class Ejercicio6 {
    public static void main (String [] args) throws Exception{
        // Arreglo de 3 posiciones de los alquileres que cobran mesualmente
        int [] alquileres ={4200,5500,9500};
        int [] porcentajes = {20,30,25};

        // Se crea otro arreglo para guardar las ganancias
        int [] ganancias = new int[3];
       // Se calcula la ganancia 
        for(int i = 0; i < alquileres.length; i++){
            ganancias[i] = alquileres[i] * porcentajes[i]/100;
        }
        
        for (int i = 0; i < alquileres.length; i++){
            System.out.println("Las ganancias por vivienda" + i +":" +ganancias[i]);

        }


      

    }
    
}

