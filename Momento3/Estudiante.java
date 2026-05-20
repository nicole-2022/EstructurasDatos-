package Momento3;

import java.util.LinkedList;
import java.util.Stack;

public class Estudiante extends Persona {

    private int semestre;
    private double[][] notas;
    private String[][] nombreMaterias;   
    private int[] contadorMaterias;   //Es como decir cuantas materias tiene el semestre   
    private LinkedList<Materia> historialMaterias;
    // Es como guardar información de lo visto
    private Stack<Integer> pilaNavegacion;
    private int ultimaNota = -1; // el -1 es como indicar que aun no hay nota
    private int ultimaPos = -1;

    public Estudiante(String nombre, int identificacion, String email, int semestre) {
        super(nombre, identificacion, email);
        this.semestre = semestre;
        this.notas = new double[10][20];// se crea la matriz
        this.nombreMaterias = new String[10][20];
        this.contadorMaterias = new int[10];
        this.historialMaterias = new LinkedList<>();
        this.pilaNavegacion = new Stack<>();
    }

    public int getSemestre() {
        return semestre; 
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    public double[][] getNotas() {
        return notas; 
    }
   
    public LinkedList<Materia> getHistorialMaterias() {
         return historialMaterias; 
        }
    public void setHistorialMaterias(LinkedList<Materia> h) {
        this.historialMaterias = h; 
        }

    public void registrarHistorialMateria(Materia materia) {
        historialMaterias.add(materia);
    }

    public void registrarNota(int semestre, String nombreMateria, double nota) {
        //Converción eje: de 1 a posición 0
        int sem = semestre - 1;
        //Las condiciones es erronea en la primera el programa se sale y no verifica las otras
        if (sem < 0 || sem >= 10) {
            System.out.println("Semestre inválido. Debe ser entre 1 y 10.");
            return;
        }
        if (contadorMaterias[sem] >= 20) {
            System.out.println("Semestre " + semestre + " ya tiene 20 materias.");
            return;
        }
        if (nota < 0.0 || nota > 10) {
            System.out.println("Nota inválida. Debe ser entre 0 y 10");
            return;
        }
        
        int pos = contadorMaterias[sem];
        notas[sem][pos] = nota;
        nombreMaterias[sem][pos] = nombreMateria;
        contadorMaterias[sem]++;

        System.out.println("Nota registrada: " + nombreMateria  +":"+  nota  + "En el Semestre " + semestre );
         ultimaNota = sem;
         ultimaPos = pos;
        
    }
    

    public void verReporte(int semestre) {

        int sem = semestre - 1;

        if (sem < 0 || sem >= 10) {
            System.out.println("Error del semestre");
            return;
        }
        if (contadorMaterias[sem] == 0) {
            System.out.println("No hay notas en el semestre " + semestre);
            return;
        }
        pilaNavegacion.push(semestre);

        System.out.println("Reporte del semestre" + semestre );
        double suma = 0;
        int reprobadas = 0;

        for (int i = 0; i < contadorMaterias[sem]; i++) {
            System.out.println(nombreMaterias[sem][i] + ": " + notas[sem][i]);
            suma += notas[sem][i];
            if (notas[sem][i] < 5.0) {//para las reprobadas
                reprobadas++;
            }
        }

        System.out.println("Promedio del semestre " + semestre +":"+ (  suma / contadorMaterias[sem]));
        System.out.println("Materias reprobadas: " + reprobadas);
    }
    public void verMateriasReprobadas() {

        System.out.println("Materias reprobadas ");
        boolean hayReprobadas = false;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < contadorMaterias[i]; j++) {
                if (notas[i][j] < 5.0) {
                    System.out.println("Semestre "+ (i + 1) +"_"+  nombreMaterias[i][j] + ": " + notas[i][j]);
                    hayReprobadas = true;
                }
            }
        }

        if (!hayReprobadas) {// Es la condición en el caso de que no hay materias reprobadas
            System.out.println("No hay materias reprobadas.");
        }
    }

    public void navegarAtras() {

        if (pilaNavegacion.isEmpty()) {
            System.out.println("No hay reportes anteriores.");
            return;
        }

        pilaNavegacion.pop(); 

        if (pilaNavegacion.isEmpty()) {
            System.out.println("No hay más reportes anteriores.");
            return;
        }

        int semAnterior = pilaNavegacion.peek();
        System.out.println("Volviendo al semestre " + semAnterior );

        int sem = semAnterior - 1;
        System.out.println("Reporte semestre " + semAnterior );

        double suma = 0;
        int reprobadas = 0;

        for (int i = 0; i < contadorMaterias[sem]; i++) {
            System.out.println(nombreMaterias[sem][i] + ": " + notas[sem][i]);
            suma += notas[sem][i];
            if (notas[sem][i] < 5.0) {
                reprobadas++;
            }
        }

        System.out.println("Promedio " + (suma/ contadorMaterias[sem]));
        System.out.println("Materias reprobadas: " + reprobadas);
    }

    public double calcularPromedio() {

        double suma = 0;
        int cantidadNotas = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < contadorMaterias[i]; j++) {
                suma += notas[i][j];
                cantidadNotas++;
            }
        }

        if (cantidadNotas > 0) {
            return suma / cantidadNotas;
        }
        return 0;
    }

    public void deshacerUltimaNota() {
    if (ultimaNota == -1) {
        System.out.println("No hay nota para deshacer.");
        return;
    }
    notas[ultimaNota][ultimaPos] = 0;
    nombreMaterias[ultimaNota][ultimaPos] = null;
    contadorMaterias[ultimaNota]--;
    }
    public void rehacerUltimaNota() {
        if (ultimaNota == -1) {
            System.out.println("No hay nota para rehacer.");
            return;
        }
        contadorMaterias[ultimaNota]++;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Identificación: " + getIdentificacion());
        System.out.println("Email: " + getEmail());
        System.out.println("Semestre: " + semestre);
        System.out.println("Promedio acumulado: " + String.format("%.2f", calcularPromedio()));
    }
}