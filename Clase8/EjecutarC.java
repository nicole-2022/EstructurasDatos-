package Clase8;

import java.util.*;

public class Ejecutar {
    public static void main(String[] args) {

        Scanner usuario = new Scanner(System.in);

        Contenedor2[] manifiesto = new Contenedor2[3];
        Contenedor2[][] patio = new Contenedor2[5][5];
        Queue<Contenedor2> inspeccion = new LinkedList<>();
        Stack<Contenedor2> buque = new Stack<>();

        double pesoTotal = 0;

        
        for (int i = 0; i < manifiesto.length; i++) {

            System.out.println("Dime  id:");
            String id = usuario.next();

            System.out.println("Dime peso:");
            double peso = usuario.nextDouble();

            System.out.println("Dime prioridad:");
            int prioridad = usuario.nextInt();

            Contenedor2 c = new Contenedor2(id, peso, prioridad);
            manifiesto[i] = c;

            pesoTotal += peso;
        }

        System.out.println("Peso total del manifiesto: " + pesoTotal);

        
        for (Contenedor2 c : manifiesto) {

            if (c != null) {

                
                if (!Contenedor2.insertarEnPatio(patio, c)) {
                    System.out.println("Puerto lleno");
                }

                
                if (c.getPrioridad() > 5) {
                    inspeccion.add(c);
                }

                
                Contenedor2.apilarSeguro(buque, c);
            }
        }

        
        Contenedor2.pesoTotal(patio);

        Contenedor2.procesarInspeccion(inspeccion);

        System.out.println("\n--- BUQUE ---");
        for (Contenedor2 c : buque) {
            System.out.println(c.getId() + " - Peso: " + c.getPeso());
        }

        Contenedor2.eliminarFondo(buque);

        usuario.close();
        
    }
}