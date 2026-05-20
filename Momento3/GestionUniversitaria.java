package Momento3;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import Momento3.Expciones.ColaDeEsperaVaciaException;
import Momento3.Expciones.EstudianteNoEncontradoException;
import Momento3.Expciones.HorarioConflictivoException;
import Momento3.Expciones.PilaDeshacerVaciaException;


public class GestionUniversitaria {
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);
        GestionEstudiante gestionEstudiante = new GestionEstudiante(new HashMap<>(), new Stack<>(), new HashMap<>(), new Stack<>());
        int opcion = 0;
        Materia Calculo1= new Materia("calculo1", 444, 2, 3);
        Materia Calculo2 = new Materia("Calculo2", 3330, 2, 5);
        Materia Fisica = new Materia("Fisica", 222, 15, 7);
        Materia Fisica2 = new Materia("Fisica2", 555, 20, 9);
        Materia Programacion = new Materia("Programación", 111, 15, 8);

        Calculo2.agregarPreriquisito(Calculo1);
        gestionEstudiante.crearMateria(Calculo1);
        gestionEstudiante.crearMateria(Calculo2);
        gestionEstudiante.crearMateria(Fisica);
        gestionEstudiante.crearMateria(Fisica2);
        gestionEstudiante.crearMateria(Programacion);
        

        GestionHorarios gestionHorarios = new GestionHorarios();
        gestionHorarios.agregarAula("01");
        gestionHorarios.agregarAula("02");
        gestionHorarios.agregarAula("03");

        Desplazamiento rutaEdificio = new Desplazamiento();
        rutaEdificio.agregarEdificio(0, "Aministración");
        rutaEdificio.agregarEdificio(1, "Papeleria");
        rutaEdificio.agregarEdificio(2, "Cafeteria");
        rutaEdificio.agregarEdificio(3, "Auditorio");
        rutaEdificio.agregarEdificio(4, "Laboratorio");
        rutaEdificio.agregarConexion( 0, 2, 210);
        rutaEdificio.agregarConexion( 2, 4, 280);
        rutaEdificio.agregarConexion( 4, 1, 290);
        rutaEdificio.agregarConexion( 1, 3, 320);

        
            

        while (opcion != 22) { 
            System.out.println("=====================================================");
            System.out.println("  PLANIFICACIÓN ACADÉMICA - SISTEMA UNIVERSITARIO");
            System.out.println("=====================================================");
            System.out.println("Gestion estudiantes");
            System.out.println("1. Registrar estudiantes");
            System.out.println("2. Buscar estudiante por Id");                  
            System.out.println("3. Listar todos los estudiantes");
            System.out.println("4. Eliminar estudiante");
            System.out.println("GESTION DE MATERIAS");
            System.out.println("5. Crear materia");
            System.out.println( "6. Mostrar prerequisito  " );
            System.out.println( "7. Inscribir estudiante" );
            System.out.println( "8. Mostrar cola de espera" );
            System.out.println( "9. Cancelar inscrición" );
            System.out.println( "GESTION DE HORARIOS" );
            System.out.println( "11. Reservar aula" );
            System.out.println( "12. Liberar horario" ); 
            System.out.println( "13. Consultar desponibilidad" ); 
            System.out.println( "RUTAS" ); 
            System.out.println( "14. agregar conexion entre edificios" ); 
            System.out.println( "15. Calcular ruta corta" ); 
            System.out.println( "16. Registrar nota" ); 
            System.out.println( "17. ver reporte academico " ); 
            System.out.println( "18. Navegador de reportes" ); 
            System.out.println( "SISTEMA DESHACER/REHACER" ); 
            System.out.println( "19. Deshacer ultima operacion" ); 
            System.out.println( "20. Rehacer ultima operación" ); 
            System.out.println( "22. Salir" );
            System.out.println("escoga una opción");
            
            
             // Se coloca la opcion porque no vuelva a pedir la opción 
             //scanner.nextLine()volvia a pedir la opción 
            opcion = Integer.parseInt(scanner.nextLine());
        
 

            switch (opcion) { 
            case 1:
                System.out.println("Registro de estudiante ");
                System.out.print("Identificación: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Correo: "); 
                String email = scanner.nextLine();
                System.out.print("Semestre en el que se encuentra: "); 
                int sem = Integer.parseInt(scanner.nextLine());
                //Se cra un objecto de estudiante para utilizar sus datos
                Estudiante EstudianteRegistrar = new Estudiante(nombre, id, email, sem);
                gestionEstudiante.registrarEstudiante(EstudianteRegistrar);
                break;
            case 2:
                System.out.println("Buscar estudiante");
                System.out.print("Ingrese su Identificación: ");
                int identificacion = Integer.parseInt(scanner.nextLine());

                try {
                     Estudiante estudiante = gestionEstudiante.buscarEstudiante(identificacion);
                         

                    System.out.println("Estudiante encontrado");
                    estudiante.mostrarInformacion();
                    } catch (EstudianteNoEncontradoException e) {
                    System.out.println("Error: "   + e.getClass().getSimpleName() +":"+ e.getMessage());
                    
                }
                break;

            case 3:
                System.out.println("Listar todos los estudiantes");
                gestionEstudiante.listarMpEstudiantes();
                break;
            case 4:
                System.out.println("Eliminar Estudiante");
                System.out.println("Ingrese la Identificación");
                int ide = Integer.parseInt(scanner.nextLine());
                try {
                    gestionEstudiante.eliminarEstudiante(ide);
                } catch (EstudianteNoEncontradoException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            
            case 5:

                System.out.println(" Crear materias nuevas");
            
                System.out.print("Nombre de la materia: ");
                String nombreMateria = scanner.nextLine();
            
                System.out.print("Código de la materia: ");
                int codigo = Integer.parseInt(scanner.nextLine());
            
                System.out.print("Cupos máximos en la materia: ");
                int cuposMax = Integer.parseInt(scanner.nextLine());
            
                System.out.print("Créditos: ");
                int creditos = Integer.parseInt(scanner.nextLine());
                Materia nuevaMateria = new Materia(nombreMateria, codigo, cuposMax, creditos);
                gestionEstudiante.crearMateria(nuevaMateria);
                break;

            case 6:
                
                System.out.println("Mostar prerequisito");
                System.out.print("Código de la materia: ");
                int codPre = Integer.parseInt(scanner.nextLine());
                Materia matPre = gestionEstudiante.buscarMateria(codPre);
                if (matPre != null) {
                    matPre.mostrarPrerequisito();
                } else {
                    System.out.println("Materia no encontrada.");
                }
                break;
            case 7:

                System.out.println("Inscribir estudiante ");
            
                System.out.print("Identificación del estudiante: ");
                int idEstudiante = Integer.parseInt(scanner.nextLine());
            
                System.out.print("Código de la materia: ");
                int codigoMateria = Integer.parseInt(scanner.nextLine());
            
                try {
            
                    Estudiante estudiante = gestionEstudiante.buscarEstudiante(idEstudiante);
            
                    Materia materia =gestionEstudiante.buscarMateria(codigoMateria);
            
                    if (materia != null) {
            
                        materia.inscribirEstudiante(estudiante);
            
                    } else {
            
                        System.out.println("Materia no encontrada");
            
                    }
            
                } catch (Exception e) {
            
                    System.out.println(e.getMessage());
            
                }
            
                break;
                                
            case 8:
                try {
                    System.out.println("Cola de calculo1");
                    Calculo1.mostrarColaEspera();
                    System.out.println("Cola de calculo2");
                    Calculo2.mostrarColaEspera();
                    System.out.println("Cola de Fisca");
                    Fisica.mostrarColaEspera();
                    System.out.println("Cola de Fisica2");
                    Fisica2.mostrarColaEspera();
                    System.out.println("Cola de programacion");
                    Programacion.mostrarColaEspera();
                    
                } catch (ColaDeEsperaVaciaException e) {
                System.out.println("Error: " +  e.getClass().getSimpleName()+ ": " + e.getMessage());
                }
                break;
            case 9:
                
                System.out.println("Cancelar inscrición");
                
                System.out.print("Identificación del estudiante: ");
                int idCancelar = Integer.parseInt(scanner.nextLine());
                
                System.out.print("Código de la materia: ");
                int codigoCancelar = Integer.parseInt(scanner.nextLine());
                
                try {
                    Estudiante estCancelar = gestionEstudiante.buscarEstudiante(idCancelar);
                    Materia materiaCancelar = gestionEstudiante.buscarMateria(codigoCancelar);
                    gestionEstudiante.cancelarInscripcionConDeshacer(estCancelar, materiaCancelar);
                    
                } catch (EstudianteNoEncontradoException e) {
                    System.out.println("Error: " + e.getMessage());
                
                }
                break;        
            case 11:
                System.out.println("Reservar Horario");
                gestionHorarios.mostrarAulas();
            
                System.out.print("Nombre del aula: ");
                String aulaReservar = scanner.nextLine();
            
                System.out.println("Lunes(1) Martes(2) Miércoles(3) Jueves (4) viernes(5) Sabado(6) Domingo(0)");
                System.out.print("Día: ");
                int diaReservar = Integer.parseInt(scanner.nextLine());
            
                System.out.print("Hora inicio (0-23): ");
                int horaReservar = Integer.parseInt(scanner.nextLine());
            
                System.out.print("Duración en horas: ");
                int durReservar = Integer.parseInt(scanner.nextLine());
            
                try {
                    gestionHorarios.reservar(aulaReservar, diaReservar,
                        horaReservar, durReservar);
                } catch (HorarioConflictivoException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

            case 12:
                System.out.println("Liberar Horario");
                gestionHorarios.mostrarAulas();
                System.out.print("Nombre del aula: ");
                String aulaLib = scanner.nextLine();
                System.out.println("Lunes(1) Martes(2) Miércoles(3) Jueves (4) viernes(5) Sabado(6) Domingo(0)");
                System.out.print("Día: ");
                int diaLib = Integer.parseInt(scanner.nextLine());
                System.out.print("Hora inicio (0-23): ");
                int horaLib = Integer.parseInt(scanner.nextLine());
                System.out.print("Duración en horas: ");
                int durLib = Integer.parseInt(scanner.nextLine());
                gestionHorarios.liberar(aulaLib, diaLib, horaLib, durLib);
                break;
            case 13:
                System.out.println("Consultar disponibilidad");
                gestionHorarios.mostrarAulas();
                System.out.print("Nombre del salon: ");
                String aulaCon = scanner.nextLine();
                System.out.println("Lunes(1) Martes(2) Miércoles(3) Jueves (4) viernes(5) Sabado(6) Domingo(0)");
                System.out.print("Dia: ");
                int diaCon = Integer.parseInt(scanner.nextLine());
                System.out.print("Hora (0-23): ");
                int horaCon = Integer.parseInt(scanner.nextLine());
                gestionHorarios.consultarDisponibilidad(aulaCon, diaCon, horaCon);
                break;
            case 14:
                 
                System.out.println("Agregar conexión");
                rutaEdificio.mostrarEdificios();
                System.out.print("Edificio origen: ");
                int edOrigen = Integer.parseInt(scanner.nextLine());
                System.out.print("Edificio destino: ");
                int edDestino = Integer.parseInt(scanner.nextLine());
                System.out.print("Distancia en metros: ");
                int distancia = Integer.parseInt(scanner.nextLine());
                rutaEdificio.agregarConexion(edOrigen, edDestino, distancia);
                System.out.println("Conexión agregada.");
                break;
            case 15:
                System.out.println("Calcular ruta cerca");
                rutaEdificio.mostrarEdificios();
                System.out.print("Índice edificio origen: ");
                int rutaOrigen = Integer.parseInt(scanner.nextLine());
                System.out.print("Índice edificio destino: ");
                int rutaDestino = Integer.parseInt(scanner.nextLine());
                rutaEdificio.calcularRutaMasCorta(rutaOrigen, rutaDestino);
                break;
            case 16: 
                System.out.println("Registrar nota");
                System.out.print("Identificación del estudiante: ");
                int idNota = Integer.parseInt(scanner.nextLine());
                try {
                Estudiante estNota = gestionEstudiante.buscarEstudiante(idNota);
                System.out.print("Semestre (1-10): ");
                int semNota = Integer.parseInt(scanner.nextLine());
                System.out.print("Nombre materia: ");
                String matNota = scanner.nextLine();
                System.out.print("Nota ( 0- 10): ");
                double nota = Double.parseDouble(scanner.nextLine());
                estNota.registrarNota(semNota, matNota, nota);
                } catch (EstudianteNoEncontradoException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

            case 17:
                System.out.println("Reporte academico");
                System.out.print("Iditificación estudiante: ");
                int idRep = Integer.parseInt(scanner.nextLine());
                try {
                Estudiante estReporte = gestionEstudiante.buscarEstudiante(idRep);
                System.out.println("1. Ver semestre especifico");
                System.out.println("2. Ver promedio acumulado");
                System.out.println("3. Ver materias reprobadas");
                System.out.print("Opción: ");
                int opcionR = Integer.parseInt(scanner.nextLine());
                if (opcionR== 1) {
                    System.out.print("Semestre (1-10): ");
                    int semestre = Integer.parseInt(scanner.nextLine());
                    estReporte.verReporte(semestre);
                } else if (opcionR == 2) {
                    System.out.println("Promedio acumulado: " + ( estReporte.calcularPromedio()));
                } else if (opcionR == 3) { 
                    estReporte.verMateriasReprobadas();
                    }
                } catch (EstudianteNoEncontradoException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
        
            case 18:
                System.out.println("Navegador de trasporte");
                System.out.print("Ididentificaccción del estudiante: ");
                int idNav = Integer.parseInt(scanner.nextLine());
                try {
                    Estudiante estNav = gestionEstudiante.buscarEstudiante(idNav);
                    System.out.println("1. Ver semestre");
                    System.out.println("2. Volver atras");
                    System.out.print("Opción: ");
                    int opNav = Integer.parseInt(scanner.nextLine());
                    if (opNav == 1) {
                        System.out.print("Semestre (1-10): ");
                        int semNav = Integer.parseInt(scanner.nextLine());
                        estNav.verReporte(semNav);
                    } else if (opNav == 2) {
                        estNav.navegarAtras();
                    }
                } catch (EstudianteNoEncontradoException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 19:
                System.out.println("Deshaser");
                try {
                    gestionEstudiante.deshacer();
                } catch (PilaDeshacerVaciaException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

            case 20:
                System.out.println("Rehacer");
                try {
                    gestionEstudiante.rehacer();
                } catch (PilaDeshacerVaciaException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

            case 22:
                System.out.println("Saliendo del sistema.");
                break;
            
            default:
               System.out.println("Opción inválida.");
               break;
            
            }
        
            }
        scanner.close();
    }
    
}
