package Clase3.TrabajoIndependiente;

public class Ejecutar {
    public static void main(String[] args) {

        Curso[] c = new Curso[5];

        c[0] = new Curso("Logica matematica", 0402, 20, "MARCOS GONSALEZ");
        c[1] = new Curso("Ingles1", 0102, 19, "Carlos ");
        c[2] = new Curso("Logica matematica", 002, 27, "KEVIN");
        c[3] = new Curso("Naturales", 007, 25, "SARA ");
        c[4] = new Curso("Humanidades", 0407, 23, "LUCIA");
        
        int suma =0;
         for(int i =0; i < c.length; i++){
            suma += c[i].getCantidadEstudiantes();
            System.out.println("La cantidad de estudiantes de los cursos es: " + suma );
         }
        }
         
}
