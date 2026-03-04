package Clase4;

import java.util.Arrays;

public class Iventario {

    private Producto [] producto;

    public Iventario(Producto[] producto) {
        this.producto = producto;
    }

    public Producto[] getProducto() {
        return producto;
    }

    public void setProducto(Producto[] producto) {
        this.producto = producto;
    }
     
    public Producto buscarPorId(int id){
        String cadena = "";
        for (int i = 0; i < producto.length; i++){
            if (id == producto[i].getId()){
                cadena = producto[i].toString();
            }else{
                cadena = "Producto no encontrado ";
            }
        }
        return cadena;
    }

    @Override
    public String toString() {
        return "Iventario [producto=" + Arrays.toString(producto) + "]";
    }
 


        
    


        

    




        
    
    
}
