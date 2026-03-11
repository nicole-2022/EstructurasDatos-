package Clase3;

public class EjecutarMoto {

    public static void main(String[] args) {
        
        Moto[] m = new Moto[8];
        //Creacion de los objectos de tipo Moto y almacenamiento en cada posición del arreglo
        m[0] = new Moto(2026, "AKT Turing", "Negra ", 125.0, 1250.0);
        m[1]= new Moto(2025, "Kawasaki", "Verde", 400.0, 25000.0);
        m[2]= new Moto(2026, "Honda", "Roja", 350.0, 4000.0);
        m[3]= new Moto(2027, "Honda c90", "DoradoNegro", 90.0, 10000.0);
        m[4]= new Moto(2015, "Sym Automatica", "Blanca ", 225.0, 1340.0);
        m[5]= new Moto(2020, "Susuki", "Azul", 400.0, 15000.0);
        m[6]= new Moto(2016, "Bmw", "Gris", 450.0, 4000.0);
        m[7]= new Moto(2018, "Harley Davidson", "DoradoNegro", 80.0, 8000.0);
        
        //Operaciones con los  objetos del arreglo

        //Obetener el promedio de los modelos del arreglo
        
        int suma = 0;
        for (int i = 0; i < m.length; i++){
            suma += m[i].getModelo();
        }
            System.out.println("El promedio de los modelos de las motos del arreglo es: "+ (suma/ m.length) );
        
            //Obtener las motos que puedo comprar con un presupuesto de 20000 dólares.
            String cad ="\n";
            for(int i = 0; i < m.length; i++){
                if(m[i].getPrecio() <= 20000.0){
                    cad += m[i].getMarca() + m[i].getPrecio() + "\n";
                }
            }
            
            System.out.println("Las motos que puedo comprar con 20000.0US son: " + cad);

    
    }
    
}

