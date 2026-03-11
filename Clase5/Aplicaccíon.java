package Clase5;

import java.util.Scanner;

public class Aplicaccíon {

    public static void main (String [] args){
        

        Scanner usuario = new Scanner(System.in);
        Buques[] buques = new Buques[10];
        Contenedor[][] mtzConectedor = new Contenedor[10][10];

        Buques bq = new Buques("", 0, "");
        Contenedor ctd= new Contenedor(0, "", 0);
    
        while (true) {
            System.out.println("Ingrese nombre del buque:");
            String nombre = usuario.nextLine();
            usuario.nextLine();
            System.out.println("Puedes ingresar el id del buque (Numero)");
            int id = usuario.nextInt();
            System.out.println("Puedes ingresar el lugar de donde viene  el buque");
            String lugar = usuario.next();
                
            bq.registrarBuque(buques, id, nombre, id, lugar);
            
            ctd.mostrarEspacio(mtzConectedor);
            System.out.println("Dime el peso del contenedor");
            int peso = usuario.nextInt();
            usuario.nextLine();

            System.out.println("Dime el pais de donde viene el contenedor  ");
            String origen = usuario.nextLine();
                

            System.out.println("Dime el id del contenedor");
            int Id= usuario.nextInt();
                
            System.out.println("Escogue una columna ");
            int c = usuario.nextInt();
            
            System.out.println("Escogue una fila ");
            int i = usuario.nextInt();


            ctd.registrarContenedores(mtzConectedor, c, i, origen, peso, Id);
            
            System.out.println("Nesecitas registrar otro contenedor (1:si, 2:no");
            int repetir = usuario.nextInt();
            if (repetir == 2){
                break;
            }
        }
            
        ctd.pesoTotal(mtzConectedor);
            
        ctd.agruparOrigen(mtzConectedor); 
        System.out.println("Saliendo del programa..");     
     usuario.close();
        
    }
    
}   
     
    

