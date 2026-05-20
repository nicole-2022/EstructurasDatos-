package Momento3;

import java.util.HashMap;
import java.util.Stack;

import Momento3.Expciones.EstudianteNoEncontradoException;
import Momento3.Expciones.PilaDeshacerVaciaException;

public class GestionEstudiante {
    //Esta clase trabaja con estudiantes y materias
    private HashMap<Integer, Estudiante> MpEstudiantes;
    private Stack<OperacionPilas> pilaDeshacer;
    private Stack<OperacionPilas> pilaRehacer;
    private HashMap<Integer, Materia> MpMateria;

    public GestionEstudiante(HashMap<Integer, Estudiante> mpEstudiantes, Stack<OperacionPilas> pilaDeshacer,
        HashMap<Integer, Materia> mpMateria, Stack<OperacionPilas> pilaRehacer) {
      MpEstudiantes = mpEstudiantes;
      this.pilaDeshacer = pilaDeshacer;
      MpMateria = mpMateria;
      this.pilaRehacer = new Stack<>();
    }

    

    public void registrarEstudiante(Estudiante estudiante){
        // para guardar la identificación
        MpEstudiantes.put(estudiante.getIdentificacion(), estudiante);
      System.out.println("Estudiante registrado");
    }

    public Estudiante buscarEstudiante (int identificacion) throws  EstudianteNoEncontradoException {
        //Condición como para mirar si exite la identificación o si no muestra la excepción
        if (!MpEstudiantes.containsKey(identificacion)) { throw new EstudianteNoEncontradoException("No existe estudiante con ID: " + identificacion);

         }
          return MpEstudiantes.get(identificacion);// Si existe
    }
    public void eliminarEstudiante(int identificacion) throws EstudianteNoEncontradoException {
        //Para mirar si esta la identificacion del Estudiante
      if(MpEstudiantes.containsKey(identificacion)){
      
      Estudiante estudiante =MpEstudiantes.get(identificacion);
       
      OperacionPilas operacion = new OperacionPilas("ELIMINAR_ESTUDIANTE", estudiante, null);
      
      pilaDeshacer.push(operacion);

        MpEstudiantes.remove(identificacion);
        System.out.println("Estudiante eliminado");
      }else{
        throw new EstudianteNoEncontradoException("No existe estudiante con esta identificación" + identificacion);
      }
    }

    

    public void listarMpEstudiantes (){
        
        for(Estudiante estudiante : MpEstudiantes.values()){
            estudiante.mostrarInformacion();
        }
    }

    public void crearMateria(Materia materia){
      MpMateria.put(materia.getCodigo(), materia);
    
    System.out.println("Materia registrada");
    }


    public Materia buscarMateria(
        int codigoMateria) {

    return MpMateria.get(codigoMateria);
    }

    
    public void cancelarInscripcionConDeshacer(Estudiante estudiante, Materia materia) throws EstudianteNoEncontradoException {    

        OperacionPilas op = new OperacionPilas("Cancelar_Inscricion", estudiante, materia);
        pilaDeshacer.push(op);
        pilaRehacer.clear(); //Eliminar o vaciar

    
        materia.cancelarInscripcion(estudiante);
    }

    
    public void deshacer() throws PilaDeshacerVaciaException {
    
        if (pilaDeshacer.isEmpty()) {throw new PilaDeshacerVaciaException("No hay operaciones para deshacer.");
        }
    
        OperacionPilas op = pilaDeshacer.pop();
        pilaRehacer.push(op);
    
        switch (op.getTipo()) {
    
            case "INSCRIBIR_ESTUDIANTE":
                op.getMateria().getEstudiantesInscritos().remove(op.getEstudiante());
                System.out.println("Deshecho: " + op.getEstudiante().getNombre() + " ya NO está inscrito en " + op.getMateria().getNombre());
                break;
    
            case "CANCELAR_INSCRIPCION":
                op.getMateria().getEstudiantesInscritos().add(op.getEstudiante());
                System.out.println("Deshecho: " + op.getEstudiante().getNombre() + " vuelve a estar inscrito en " + op.getMateria().getNombre());
                break;
    
            case "ELIMINAR_ESTUDIANTE":
                MpEstudiantes.put(op.getEstudiante().getIdentificacion(),op.getEstudiante());
                System.out.println("Deshecho: estudiante " + op.getEstudiante().getNombre() + " restaurado.");
                break;
    
            case "REGISTRAR_NOTA":
                op.getEstudiante().deshacerUltimaNota();
                System.out.println("Deshecho: última nota eliminada.");
                break;
    
            default:
                System.out.println("Operación desconocida.");
                break;
            }
    }
    
    public void rehacer() throws PilaDeshacerVaciaException {
    
        if (pilaRehacer.isEmpty()) {throw new PilaDeshacerVaciaException("No hay operaciones para rehacer.");
        }
    
        OperacionPilas op = pilaRehacer.pop();
        pilaDeshacer.push(op);
    
        switch (op.getTipo()) {
    
            case "INSCRIBIR_ESTUDIANTE":
                op.getMateria().getEstudiantesInscritos().add(op.getEstudiante());
                System.out.println("Rehecho: " + op.getEstudiante().getNombre() + " inscrito en " + op.getMateria().getNombre());
                break;
    
            case "CANCELAR_INSCRIPCION":
                op.getMateria().getEstudiantesInscritos().remove(op.getEstudiante());
                System.out.println("Rehecho: inscripción de " + op.getEstudiante().getNombre() + " cancelada nuevamente.");
                break;
    
            case "ELIMINAR_ESTUDIANTE":
                MpEstudiantes.remove(op.getEstudiante().getIdentificacion());
                System.out.println("Rehecho: estudiante " + op.getEstudiante().getNombre() + " eliminado nuevamente.");
                break;
    
            case "REGISTRAR_NOTA":
                op.getEstudiante().rehacerUltimaNota();
                System.out.println("Rehecho: nota restaurada.");
                break;
    
            default:
                System.out.println("Operación desconocida.");
                break;
        }
    }
        
}
    
        
    
    
            
    
        
        
        
    
    