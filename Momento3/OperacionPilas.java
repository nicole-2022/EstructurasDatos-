package Momento3;

public class OperacionPilas {
    private String tipo;
    private Estudiante estudiante;
    private Materia materia;

    public OperacionPilas (String tipo, Estudiante estudiante, Materia materia) {
        this.tipo = tipo;
        this.estudiante = estudiante;
        this.materia = materia;
    }

    public String getTipo()           {
        return tipo;
     }
    public Estudiante getEstudiante() {
        return estudiante;
    }
    public Materia getMateria()       { 
        return materia; 
    }
}
