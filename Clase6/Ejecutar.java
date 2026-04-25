package Clase6;
import java.util.Random;

public class Ejecutar {


    public static void main (String[] args){ 
        Random r = new Random();
        int[] energiaContenedores = new int[12];
        int [][] mapaCarga = new int[3][3];
        

        int min = 50;
        int max = 150;
        System.out.print("EnergiaContenedores {");
        for(int i = 0; i < energiaContenedores.length; i++){
            energiaContenedores[i] =(int) r.nextInt((max - min + 1)) + min;
            System.out.print( energiaContenedores[i] + ", ");
        }
        System.out.println("}");
   
        int[] segundoA = new int[12]; 
        int contador =0;   
        
        
        for( int i = 0; i < energiaContenedores.length; i ++){
            if(energiaContenedores[i]%10== 0){
                segundoA[contador] = energiaContenedores[i];
                contador++;
                

            }
        }
        System.out.print("\nSegundo arreglo con los multiplos de 10 {");
        if(contador==0){
            System.out.println("No hay multiplos de 10");
        }else{
            for (int i = 0; i < contador; i++) {
            System.out.print(segundoA[i] + ", "); 

        }
        System.out.println("}");
        System.out.println("\nMatriz");
        int posición =0;
        for(int i = 0; i<mapaCarga.length; i++){
          for(int j =0; j < mapaCarga[i].length; j++){
            //Dice que datos existen (contador) y posición recorre esos datos
          if(posición < contador){
            mapaCarga[i][j]= segundoA[posición];
            posición++;
          }else{
            mapaCarga[i][j]= -1;
          }
          } 
        }

        for(int i = 0; i < mapaCarga.length; i++){
            for(int j = 0; j < mapaCarga[i].length; j++){
            System.out.print("["+ mapaCarga[i][j] +"]"+ " \t ");
        }
        System.out.println();
        }
        
        Suministro[] manifiesto = new Suministro[9];
        int Contador2 = 0;
        for(int i = 0; i < mapaCarga.length; i++){
            for(int j =0; j< mapaCarga[i].length; j++){
                 int energia = mapaCarga[i][j];

                if (energia != -1) {

                    String prioridad;

                    if (energia > 100) {
                        prioridad = "ALTA";
                    } else {
                        prioridad = "ESTANDAR";
                    }

                    String id = "Posición= " + "fila:" + i + " columna:" + j;
                    
                    manifiesto[Contador2] = new Suministro(id, energia, prioridad);

                } else {
                    manifiesto[Contador2] = null;
                }

                Contador2++;
            }
        }


    System.out.println("Lista:");

    for (int i = 0; i < manifiesto.length; i++) {
        if (manifiesto[i] != null) {
        System.out.println("ID: "+
            manifiesto[i].getId() + "\t Energia:"+
            manifiesto[i].getEnergia()  + "\t Prioridad:" +
            manifiesto[i].getPrioridad() 
        );
    } else {
        System.out.println("Null");
    }
    }

         

    }


}


}

