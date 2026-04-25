package clase9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LinkedListMap {
    public static void main(String[] args) {
        LinkedList<String> historialNavegación = LinkedList<>();
        // agrega las urls
        historialNavegación.add("google.com")
        historialNavegación.add("github.com")
        historialNavegación.add("stackoverflow.com")

        System.out.println(historialNavegación);
        System.out.println(historialNavegación.getLast());
        historialNavegación.removeLast();


        System.out.println(historialNavegación);
        //-------------------------------------
        Map<Integer, String> productos = new LinkedList<>();
        productos.put("Laptop");
        productos.put("Mause");
        productos.put("Teclado");

        System.out.println(productos);
        System.out.println(productos.containsKey(102)); //true
        productos.put(101, "Pantalla");

        System.out.println(productos);

        productos.forEach((key, value) -> {
            System.out.println("Código: [" + key + "] -> Producto: [" + value + "]");
        });
        
        // -----------------Reto final------------

        List<String> ana = new ArrayList<>(List.of("ca,isa", "Pantalon"));
        LinkedList<String> luis = new ArrayList<>(List.of("Zapatos"));

        ana.size();

        


    
    

        




    }
    
}
