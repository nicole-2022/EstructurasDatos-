package Clase2;

public class Ejercicio15 {

    public static void main(String[] args) {
        String[] Nombres={"Salome","Paola", "Valery","Dilan", "Nairo", "Julio" };
        int[]    Sueldos={2000, 5000, 7000,6000, 9000, 5800 };
         int suma = 0;
        // se realiza la suma de los sueldos 
        for(int i =0; i < Sueldos.length; i++){
            suma = suma + Sueldos[i];

        }
        // para calcular el promedio de los sueldos
        int promedio = suma / Nombres.length; 
        int contador =0;
        for(int i =0; i < Sueldos.length; i++){
            // Para mirar si el sueldo es igual a el promedio
           if (Sueldos[i] == promedio){
            System.out.println("Los nombres de los que tienen un sueldo promedio son: " + Nombres[i]);
            // para mirar cuantas personas un sueldo promedio
             contador++;
           }
        }
        System.out.println("Las personas que tienen un sueldo promedio son:" + contador);


    }
    
}
