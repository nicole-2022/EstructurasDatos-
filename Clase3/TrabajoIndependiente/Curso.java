public class Curso {
    private String Nombre;
    private int id;
    private int cantidadEstudiantes;
    private String profesor;
    public Curso(String nombre, int id, int cantidadEstudiantes, String profesor) {
        Nombre = nombre;
        this.id = id;
        this.cantidadEstudiantes = cantidadEstudiantes;
        this.profesor = profesor;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }
    public void setCantidadEstudiantes(int cantidadEstudiantes) {
        this.cantidadEstudiantes = cantidadEstudiantes;
    }
    public String getProfesor() {
        return profesor;
    }
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
    @Override
    public String toString() {
        return "Curso [Nombre=" + Nombre + ", id=" + id + ", cantidadEstudiantes=" + cantidadEstudiantes + ", profesor="
                + profesor + "]";
    }

    

    


    
}
