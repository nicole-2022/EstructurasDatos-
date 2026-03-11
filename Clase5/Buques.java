package Clase5;

public class Buques {
    private String nombre;
    private int id;
    private String lugar;
    public Buques(String nombre, int id, String lugar) {
        this.nombre = nombre;
        this.id = id;
        this.lugar = lugar;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLugar() {
        return lugar;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void registrarBuque(Buques[] buques, int i, String nombre,int id, String lugar){
        
            if(i < buques.length){
                buques[i] = new Buques(nombre,id, lugar);
                System.out.println("Buque registrado");
            }else{ 
                System.out.println("No hay espacio para más buques");
            }
    }
    @Override
    public String toString() {
        return "Buques [nombre=" + nombre + ", id=" + id + ", lugar=" + lugar + "]";
    }
    

    
}
