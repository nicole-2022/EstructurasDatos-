package Clase5;

public class Contenedor {
  private int peso;
  private  String origen;
  private int Id;
  public Contenedor(int peso, String origen, int Id) {
    this.peso = peso;
    this.origen = origen;
    this.Id = Id;
  }
  public int getPeso() {
    return peso;
  }
  public void setPeso(int peso) {
    this.peso = peso;
  }
  public String getOrigen() {
    return origen;
  }
  public void setOrigen(String origen) {
    this.origen = origen;
  }
  public int getid() {
    return Id;
  }
  public void setCodigo(int Id) {
    this.Id = Id;
  }

  // i es fila y c es columna 
  public void mostrarEspacio(Contenedor[][] mtzContenedor){
     System.out.println("Espacios disponibles para el contenedor");
    // Recorre las filas
    for(int i = 0; i < mtzContenedor.length; i++){
      //Recorre Columnas
        for(int c = 0; c < mtzContenedor.length; c++){
          // NUll es como decir que no hay contenedor 
            if(mtzContenedor[i][c] == null){
              // print sigue en la misma linea 
                System.out.print("[ ] ");
            }else{
                // Si hay contenedor
                System.out.print("[cd] ");
            }

        }
        // Baja a la otra linea
        System.out.println();
    }

}
// Se le pasa parametros a el metodo para una mejor funcionalidad y darle información
public void registrarContenedores(Contenedor[][]mtzContenedor, int c,int i,  String origen, int peso, int id){
  // No se recorre con for porque solo va directo a el lugar de fila y columna
 //Verifica si el espacio esta vacio
  if (mtzContenedor[i][c] == null){
    // Se crea un nuevo contenedor y se guarda
    mtzContenedor[i][c] = new Contenedor(peso,origen, id);
       System.out.println("Contenedor registrado en fila "+ i +" y columna "+ c);
    }else{
      System.out.println("Espacio ocupado ");
    }

    
  }

  public void pesoTotal(Contenedor[][] mtzContenedor){
    //Variable para guardar la suma
    int pesoTotal = 0;
    //Se recorre las filas 
    for(int i= 0; i < mtzContenedor.length; i++){ 
      //Recorre las columnas
      for(int c =0; c < mtzContenedor[i].length; c++){
        // != es como decir que si hay contenedor para tomar el peso
        if(mtzContenedor[i][c] != null){
          pesoTotal += mtzContenedor[i][c].getPeso();
        }
      }

    }
   System.out.println("El peso total de los contenedores es: " + pesoTotal);    


  }
  public void agruparOrigen(Contenedor[][] mtzcContenedor){

    int Francia = 0;
    int Ecuador = 0;
    int China = 0;
    int otros = 0;

    for(int i = 0; i < mtzcContenedor.length; i++){
        for(int c = 0; c < mtzcContenedor[i].length; c++){

            if(mtzcContenedor[i][c] != null){

                String origen = mtzcContenedor[i][c].getOrigen();

                if(origen.equals("Francia")){
                    Francia++;
                }
                else if(origen.equals("Ecuador")){
                    Ecuador++;
                }
                else if(origen.equals("China")){
                    China++;
                }
                else{
                    otros++;
                }

            }

        }
    }

    System.out.println("El total de los contenedores por pais Fracia:"+Francia + " Ecuador:" + Ecuador + " China:" + China +" Otros: " + otros);
   
}
  
  @Override
  public String toString() {
    return "Contenedor [peso=" + peso + ", origen=" + origen + ", codigo=" + Id + "]";
  }
    
}
