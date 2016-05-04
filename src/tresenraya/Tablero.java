package tresenraya;

/**
 * En esta clase se generará un tablero
 * para jugar
 * @author teo17
 */
public class Tablero {
    
    /**
     * Atributos de la clase
     */
    private char[][] tablero;

   
    /**
     * El constructor sin parametros
     */
    
     public Tablero() {
        this.tablero = new char[3][3];
        
         for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 3; j++) {
                 tablero[i][j]='-';
                 
             }
             
         }
    }
    
     /**
      * El constructor con parametros
      */
     
     public Tablero(char[][] tablero) {
        this.tablero = tablero;
    }

  
     
    /**
     * Metodos get y set
     */
    
    public char[][] getTablero() {
        return tablero;
    }
    
    public char getTablero(int fila, int columna){
        return tablero[fila][columna];
    }

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }
    
    public void setTableroFC(int fila, int columna){
        this.tablero[fila][columna] = 'O';
    }
    
    public void setTableroFX(int fila, int columna){
        this.tablero[fila][columna] = 'X';
    }
     
     
     
     
     /**
      * El tablero
     * @param tablero
      */
     
     public void ElTablero(char[][] tablero){
         
         for (int i = 0; i <tablero.length; i++) {
             
             System.out.print("*");
             for (int j = 0; j < tablero.length; j++) {
                 System.out.print(tablero[i][j]);
                 if (j!=tablero[i].length-1) {
                     System.out.print("\t");                    
                 }
                 
             }
             System.out.println("*");
         }    
     } // Fin tablero
     
     /**
      * Metodos para comprobar el tablero
     * @param valor
     * @return 
      */
     public boolean ComprobarFilasyColumnas(char valor){
           boolean comprobacion=false;
           

               if(tablero[0][0] == valor && tablero[0][1] == valor && tablero[0][2] == valor){
                   comprobacion = true;
               }
               else if(tablero[1][0] == valor && tablero[1][1] == valor && tablero[1][2]==valor){
                   comprobacion = true;
               }
               else if(tablero[2][0]==valor && tablero[2][1] == valor && tablero[2][2] == valor){
                   comprobacion = true;
               }
               else
                   comprobacion = false;
               
           
           return comprobacion;
       }
             
       public boolean ComprobarDiagonales(char valor){
           boolean comprobacion = false;

                   if(tablero[0][0]==valor && tablero[1][1]==valor && tablero[2][2]==valor){
                       comprobacion = true;
                   }
                   
                   else{
                       comprobacion = false;
                   }
                   //La diagonal inversa del tablero
                   if(tablero[0][2]==valor && tablero[1][1]==valor && tablero[2][0]==valor){
                       comprobacion = true;
                   }
                   
                   else{
                       comprobacion = false;
                   }

           return comprobacion;
       }
       
       public boolean ComprobarTablero(char valor){
           boolean comprobacion = true;
           
                if(ComprobarFilasyColumnas(valor)==true || ComprobarDiagonales(valor)== true){
                    comprobacion=true;
                }
                else if (ComprobarFilasyColumnas(valor)==false || ComprobarDiagonales(valor)== false){
                    comprobacion=false;
                }
           return comprobacion;
       }
    
}
