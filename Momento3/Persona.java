package Momento3;

public abstract class Persona {
    private  String nombre;
    private int identificacion;
    private String email;

    public Persona(String nombre, int identificacion, String email) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public String getEmail() {
        return email;
    }
    public abstract void mostrarInformacion();

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", identificacion=" + identificacion + ", email=" + email + "]";
    }
    


    
}
