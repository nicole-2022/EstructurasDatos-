package Clase8;

import java.util.*;

public class Ejecutar {
    public static void main(String[] args) {

        Scanner usuario = new Scanner(System.in);

        Contenedor[] manifiesto = new Contenedor[3];
        Contenedor[][] patio = new Contenedor[5][5];
        Queue<Contenedor> inspeccion = new LinkedList<>();
        Stack<Contenedor> buque = new Stack<>();

        double pesoTotal = 0;

        
        for (int i = 0; i < manifiesto.length; i++) {

            System.out.println("Dime  id:");
            String id = usuario.next();

            System.out.println("Dime peso:");
            double peso = usuario.nextDouble();

            System.out.println("Dime prioridad:");
            int prioridad = usuario.nextInt();

            Contenedor c = new Contenedor(id, peso, prioridad);
            manifiesto[i] = c;

            pesoTotal += peso;
        }

        System.out.println("Peso total del manifiesto: " + pesoTotal);

        
        for (Contenedor c : manifiesto) {

            if (c != null) {

                
                if (!Contenedor.insertarEnPatio(patio, c)) {
                    System.out.println("Puerto lleno");
                }

                
                if (c.getPrioridad() > 5) {
                    inspeccion.add(c);
                }

                
                Contenedor.apilarSeguro(buque, c);
            }
        }

        
        Contenedor.pesoTotal(patio);

        Contenedor.procesarInspeccion(inspeccion);

        System.out.println("\n--- BUQUE ---");
        for (Contenedor c : buque) {
            System.out.println(c.getId() + " - Peso: " + c.getPeso());
        }

        Contenedor.eliminarFondo(buque);

        usuario.close();
        
    }
}