package Momento3;

import java.util.TreeMap;

import Momento3.Expciones.HorarioConflictivoException;

public class GestionHorarios {

    private TreeMap<String, boolean[][]> aulas;

    public GestionHorarios() {
        this.aulas = new TreeMap<>();//Mantiene un orden
    }

    public void agregarAula(String nombre) {
        if (aulas.containsKey(nombre)) {
            System.out.println("El aula " + nombre + " ya existe.");
            return;
        }
        aulas.put(nombre, new boolean[7][24]);
        System.out.println("Aula " + nombre + " registrada.");
    }

    public void reservar(String aula, int dia, int hora, int duracion) throws HorarioConflictivoException {

        boolean[][] horario = buscarAula(aula);
        if (horario == null) return;

        for (int i = hora; i < hora + duracion; i++) {
            if (horario[dia][i]) { throw new HorarioConflictivoException( "Conflicto: " + nombreDia(dia) + " " + i + ":00 ya está reservado en aula " + aula );
            }
        }
        for (int i = hora; i < hora + duracion; i++) {
            horario[dia][i] = true;
        }
        System.out.println("Reserva exitosa en aula " + aula);
    }

    public void liberar(String aula, int dia, int hora, int duracion) {
        boolean[][] horario = buscarAula(aula);
        if (horario == null) return;

        for (int i = hora; i < hora + duracion; i++) {
            horario[dia][i] = false;
        }
        System.out.println("Horario liberado en aula " + aula);
    }

    public void consultarDisponibilidad(String aula, int dia, int hora) {
        boolean[][] horario = buscarAula(aula);
        if (horario == null) 
        return;

        boolean libre = !horario[dia][hora];
        System.out.println("Aula " + aula + " —> " + nombreDia(dia) + " " + hora + ":00 → " + (libre ? "LIBRE" : "OCUPADO"));
    }

    public void mostrarAulas() {
        if (aulas.isEmpty()) {
            System.out.println("No hay aulas guardadas");
            return;
        }
        
        for (String nombre : aulas.keySet()) {
            System.out.println("Aulas guardadas: " + nombre);
        }
    }

    private boolean[][] buscarAula(String aula) {
        boolean[][] horario = aulas.get(aula);
        if (horario == null) {
            System.out.println("Error: aula " + aula + " no encontrada.");
        }
        return horario;
    }

    private String nombreDia(int dia) {
        switch (dia) {
            case 0: return "Domingo";
            case 1: return "Lunes";
            case 2: return "Martes";
            case 3: return "Miércoles";
            case 4: return "Jueves";
            case 5: return "Viernes";
            case 6: return "Sábado";
            default: return "Día inválido";
        }
    }
}