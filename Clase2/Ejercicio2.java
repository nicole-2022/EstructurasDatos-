package Clase2;

public class Ejercicio2 {
    public static void main(String[] args) throws Exception{ 
     // Sueldos de los empleados 
     int [] a = { 10, 20, 15, 8, 12};
     // asignaciones de los empleados 
     int [] b = {2, 3, 4, 1, 2};
     // deducciones 
     int [] c = {3,3, 5, 3, 1};

      
     int [] t =  new int [5]; // Reserva em memoria un arreglo de tamaño 5 par almacenar 
     // la operación del cálculo de cada trabajador 

     for ( int i = 0; i < a.length; i ++) {
        t [i] = a [i] + b[i] - c [i];
        // almacena en elarreglo t la operación establecida en el pdf
     }

     for ( int i = 0; i < a.length; i ++) {
        System.out.print("t["+ i +"]=" + t [i]);
     }

     
     }

     

    }