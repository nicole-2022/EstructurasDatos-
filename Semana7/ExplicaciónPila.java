import java.util.Stack;
public class ExplicaciónPila {
    public static void main(String[] args) {

        Stack<String> objPila = new Stack<>();
        objPila.push("Camilo");
        objPila.push("Daniela ");
        objPila.push("Francisco");
        objPila.push("Andrea");            
        //
        System.out.println("Tope de la pila"+objPila.peek());//[Camilo, Daniela, Franciso,Andrea,darrio]
 
        System.out.println("Pila vacia "+ objPila.empty());// false 

        // Eleminar el elmento el tope
        System.out.println("Elemento removido"+objPila.pop());//Dario
        //Posiciones de los elementos respectoa a  la fila
        System.out.println("Posición"+objPila.search("Camilo")); //4
        System.out.println("Posición"+objPila.search("Daniela"));//3
        System.out.println("Posición"+objPila.search("Francisco"));//2
        System.out.println("Posición"+objPila.search("Andrea"));//1
       

    }
}