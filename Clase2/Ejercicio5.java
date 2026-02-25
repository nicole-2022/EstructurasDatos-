package Clase2;

public class Ejercicio5 {

    public static void main (String[] args ) {
        // 3 arreglos de los precios unitarios, cantidades compradas
        // y descripción de los productos(son 3 productos)
        int [] pu ={8500, 6200,7400};
        int [] cc ={ 2, 4, 3};
        String[] pd ={"libro", "cuaderno", "sombrilla"};
        
        int totalGeneral =0;
        int mayorGasto =0;
        
        
        // Reserva em memoria un arreglo de tamaño 5 par almacenar 
        // la operación del cálculo 
        int [] tg = new int[3];

        // para la operración establecida de tg
        for ( int i =0; i < pu.length; i++){ 
            tg[i] = pu [i] * cc[i];
            totalGeneral += tg[i];
        
        }
        for (int i = 0; i < tg.length; i++){
            if (tg[i] > mayorGasto){
                mayorGasto= tg[i];
            }
        } 

        System.out.println("El total gastado en compras es: "+ totalGeneral);
        System.out.println("Producto con mayor gasto: "+ mayorGasto);
        
    }
    
}

