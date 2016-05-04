package tresenraya;

/**
 * En esta clase se recogera el 
 * nombre de los jugadores
 * @author teo17
 */
public class Jugador {
    
    /**
     * Atributos de la clase
     */
    private String nombre;
    private char O='O';//lo usara el jugador 1
    private char X='X';//lo usara el jugador 2
    
    /**
     * Constructor sin parametros
     */
    
    public Jugador(){
        
    }
    
    /**
     * Constructor con parametros
     * @param nombre
     */
    public Jugador(String nombre) {
        
        this.nombre=nombre;
        
    }
    
    /**
     * Metodos get y set
     * @return 
     */
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public char getO(){
        return O;
    }
    
    public void setO(char O){
        this.O='O';
    }
    
    public char getX(){
        return X;
    }
    
    public void setX(char X){
        this.X='X';
    }
    
}
