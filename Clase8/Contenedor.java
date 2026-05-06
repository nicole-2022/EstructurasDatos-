package Clase8;

import java.util.Stack;
import java.util.Queue;

public class Contenedor {
    private String id;
    private double peso;
    private int prioridad;

    public Contenedor(String id, double peso, int prioridad) {
        this.id = id;
        this.peso = peso;
        this.prioridad = prioridad;
    }

    public String getId() {
        return id;
    }

    public double getPeso() {
        return peso;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public static void pesoTotal(Contenedor[][] mtzPatio) {
        double total = 0;

        for (int i = 0; i < mtzPatio.length; i++) {
            for (int j = 0; j < mtzPatio[i].length; j++) {
                if (mtzPatio[i][j] != null) {
                    total += mtzPatio[i][j].getPeso();
                }
            }
        }

        System.out.println("Peso total en patio: " + total);
    }

    public static boolean insertarEnPatio(Contenedor[][] patio, Contenedor c) {
        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {
                if (patio[i][j] == null) {
                    patio[i][j] = c;
                    return true;
                }
            }
        }
        return false;
    }

    public static void procesarInspeccion(Queue<Contenedor> inspeccion) {
        System.out.println("\n--- INSPECCIÓN ---");
        while (!inspeccion.isEmpty()) {
            Contenedor c = inspeccion.poll();
            System.out.println("Inspeccionando: " + c.getId());
        }
    }

    public static void apilarSeguro(Stack<Contenedor> buque, Contenedor c) {
        if (buque.isEmpty() || c.getPeso() <= buque.peek().getPeso()) {
            buque.push(c);
        } else {
            System.out.println("No se puede apilar: " + c.getId());
        }
    }

    public static void eliminarFondo(Stack<Contenedor> pila) {
        Stack<Contenedor> aux = new Stack<>();

        while (pila.size() > 1) {
            aux.push(pila.pop());
        }

        if (!pila.isEmpty()) {
            System.out.println("Eliminado: " + pila.pop().getId());
        }

        while (!aux.isEmpty()) {
            pila.push(aux.pop());
        }
    }
}