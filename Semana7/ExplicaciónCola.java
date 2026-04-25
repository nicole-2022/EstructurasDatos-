import java.util.LinkedList;
public class ExplicaciónCola {
    public static void main(String[] args) {
        Queue<Integer> objCola = new LinkedList<>();
        objCola.add(29);
        objCola.add(16);
        objCola.offer(10);
        objCola.offer(34);
        //Mostrar los elementos de la cola 
        System.out.println(objCola);//[29,16,10,34]

        System.out.println("Cabeza de la cola(element): "+ objCola.element());
        System.out.println("Cabeza de cola  (peek): "+ objCola.peek());

        //Eleminar de la cabeza de la cola (poll(), remove())
        System.out.println("Elemeto eleiminado con poll():  "+ objCola.poll());
         System.out.println("Elemeto eleiminado con remove():  "+ objCola.remove());

         System.out.println(objCola);

         System.out.println("Cola vacia "+objCola.size());

    }    
}
