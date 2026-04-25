package Clase6;

public class Suministro {

    private String id;
    private int Energia;
    private  String prioridad;
    public Suministro(String id, int energia, String prioridad) {
        this.id = id;
        Energia = energia;
        this.prioridad = prioridad;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getEnergia() {
        return Energia;
    }
    public void setEnergia(int energia) {
        Energia = energia;
    }
    public String getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    @Override
    public String toString() {
        return "Suministro [id=" + id + ", Energia=" + Energia + ", prioridad=" + prioridad + "]";
    }
    
}