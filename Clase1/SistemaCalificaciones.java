public class SistemaCalificaciones {
    public static void main (String [] args){
        String[] estudiantes = {"Ana", "Carlos","Maria","Pedro"};
        int[] calificaciones = {85,92,78,96};

        System.out.println("Reporte de calificaciones:");

        for (int i = 0; i < estudiantes.length; i++){
            System.out.println(estudiantes[i] + ":" + calificaciones[i]);
        }
    }
    
}
