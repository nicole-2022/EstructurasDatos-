package Momento3;

import java.util.LinkedList;
import java.util.Queue;

import Momento3.Expciones.ColaDeEsperaVaciaException;
import Momento3.Expciones.CupoLlenoException;
import Momento3.Expciones.EstudianteNoEncontradoException;
import Momento3.Expciones.PreRequisitoNoAprobadoException;

public class Materia {
    private String nombre;
    private  int codigo;
    private int cuposMax;
    private int creditos;
    private int cuposDisponibles;
    private LinkedList<Estudiante> estudiantesInscritos;
    private LinkedList<Materia> prerequisitos;
    private Queue<Estudiante> EstudianteEspera;
    
    public Materia(String nombre, int codigo, int cuposMax, int creditos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cuposMax = cuposMax;
        this.creditos = creditos;
        this.cuposDisponibles = cuposMax;
        this.estudiantesInscritos = new LinkedList<>();
        this.prerequisitos = new LinkedList<>();
        this.EstudianteEspera = new LinkedList<>();
        
    }
    public int getCuposMax() {
        return cuposMax;
    }
    
    public int getCreditos() {
        return creditos;
    }
    
    public LinkedList<Materia> getPrerequisitos() {
        return prerequisitos;
    }
   
    public LinkedList<Estudiante> getEstudiantesInscritos(){
        return estudiantesInscritos;
    }
    public int getCuposDisponibles(){
        return cuposDisponibles;
    }
    public Queue<Estudiante> getEstudianteEspera() {
        return EstudianteEspera;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getCodigo() {
        return codigo;
    }
    public void agregarPreriquisito(Materia materia){
        prerequisitos.add(materia);
        
    }
    
    public void mostrarPrerequisito(){
        for(Materia prerequisito: prerequisitos ){
            System.out.println("prerequisito "+ prerequisito.getNombre());
        }
    }

    public void inscribirEstudiante(Estudiante estudiante) throws CupoLlenoException, PreRequisitoNoAprobadoException {
    for (int i = 0; i < prerequisitos.size(); i++) {

        boolean encontrado = false;
        for (int j = 0; j < estudiante.getHistorialMaterias().size(); j++) {
            // Compara el codigo de las materias
            if (prerequisitos.get(i).getCodigo() == estudiante.getHistorialMaterias().get(j).getCodigo()) {
                encontrado = true;
            }
        }
        if (!encontrado) {
            throw new PreRequisitoNoAprobadoException("No cumple prerequisitos");

        }
    }
    if (cuposDisponibles > 0) {

        estudiantesInscritos.add(estudiante);

        cuposDisponibles--;

        System.out.println( "Inscripción exitosa");

    } else {
        EstudianteEspera.add(estudiante);
        System.out.println("Materia llena. Agregado a cola de espera." );

        }
    }
    public void cancelarInscripcion(Estudiante estudiante) throws EstudianteNoEncontradoException {

        if (!estudiantesInscritos.contains(estudiante)) { throw new EstudianteNoEncontradoException( "El estudiante " + estudiante.getNombre()  + " no está inscrito en " + this.nombre );
        }
        estudiantesInscritos.remove(estudiante);
        cuposDisponibles++;
        System.out.println("Inscripción cancelada para: "  + estudiante.getNombre());
    
        if (!EstudianteEspera.isEmpty()) {
            Estudiante siguiente = EstudianteEspera.poll(); 
            estudiantesInscritos.add(siguiente);
            cuposDisponibles--;
            System.out.println("Cupo asignado automáticamente a: " + siguiente.getNombre());
        }
    }


    public void mostrarColaEspera() throws ColaDeEsperaVaciaException {
    
        if (EstudianteEspera.isEmpty()) {
    
            throw new ColaDeEsperaVaciaException("No hay estudiantes en cola de espera" );
        }
    
        System.out.println("Cola de espera");
    
        for (Estudiante estudiante : EstudianteEspera) {
    
            System.out.println(estudiante.getNombre());
    
        }

}

    
}
