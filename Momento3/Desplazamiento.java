package Momento3;

public class Desplazamiento {
    // es un arreglo de distancias entre edificios 
    //despues utilizarlo para calcular la distancia entre dos edificios en cm
    private int[][] distancias;
    // Nombrar los edificios
    private String[] edificios;
    public Desplazamiento() {
        edificios = new String[5];
        distancias = new int[5][5];
    }

    public void agregarEdificio(int posicion, String nombre) {
        //Cualquiera de las ccondiones se cumple pasa el error de posición
        if (posicion < 0 || posicion >= 5) {
            System.out.println("Numero incorrecto");
            return;
        }
        // permite hacer esto agregarEdificio(2, "Cafeteria");
        // el indice muestra la posicion y con el nombre es para el nombre del lugar
        edificios[posicion] = nombre;
    }

    public void agregarConexion(int origen, int destino, int distancia) {
        distancias[origen][destino] = distancia;
        distancias[destino][origen] = distancia;
    }

    public void mostrarEdificios() {
        System.out.println("Edificios(5)");
        for (int i = 0; i < edificios.length; i++) {
            System.out.println(i + ": " + edificios[i]);
        }
    }

    public void calcularRutaMasCorta(int origen, int destino) {
        //Guarda los edificios registrados anteriormente 
        int n = edificios.length;
        int[] distancia = new int[n];
        boolean[] visitado = new boolean[n];
        int[] anterior = new int[n];

        for (int i = 0; i < n; i++) {
            distancia[i] = Integer.MAX_VALUE;// infinito distancia
            visitado[i] = false;
            anterior[i] = -1;
        }
        distancia[origen] = 0;

        
        for (int i = 0; i < n - 1; i++) {

        
            int u = -1; //todavia no se ha eligido
            for (int j = 0; j < n; j++) {//recorre edificios
                //lugar mas cercano
                if (!visitado[j] && (u == -1 || distancia[j] < distancia[u])) {
                    u = j;// j se conviert ela distancia mas sercana
                }
            }
            visitado[u] = true;
            //V: posible destino

            for (int v = 0; v < n; v++) {
                //mira que v no sea visitado
                if (!visitado[v]
                        && distancias[u][v] != 0//Mira si hay conexion u y v
                        && distancia[u] != Integer.MAX_VALUE
                        && distancia[u] + distancias[u][v] < distancia[v]) {

                    distancia[v] = distancia[u] + distancias[u][v];//guarda nueva distancia
                    anterior[v] = u;
                }
            }
        }
        if (distancia[destino] == Integer.MAX_VALUE) {
            System.out.println("No hay ruta entre " + edificios[origen] + " y " + edificios[destino]);
            return;
        }

        System.out.println("Resulatdo");
        System.out.print("Ruta más corta: ");
        mostrarRuta(anterior, destino);
        System.out.println("Distancia TOTAL: " + distancia[destino] + " metros");
    }

    private void mostrarRuta(int[] anterior, int destino) {
        if (anterior[destino] == -1) {
            System.out.print(edificios[destino]);
            return;
        }
        mostrarRuta(anterior, anterior[destino]);
        int anteriorNodo = anterior[destino];
        System.out.print(edificios[destino] + " (" + distancias[anteriorNodo][destino] + "m)");
    }
    
    
}