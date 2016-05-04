package tresenraya;

/**
 * Esta clase recoge las estadísticas
 * de los jugadores
 * @author teo17
 */
public class Estadisticas {
    
    /**
     * Atributos de la clase
     */
    private int PartidasGanadas;
    private int PartidasPerdidas;
    private int PartidasEmpatadas;
    
    /**
     * Constructor sin parametros
     */
    
    public Estadisticas(){
        
    }

    /**
     * Constructor con parametros
     */
    
    public Estadisticas(int PartidasGanadas, int PartidasPerdidas, int PartidasEmpatadas) {
        this.PartidasGanadas = PartidasGanadas;
        this.PartidasPerdidas = PartidasPerdidas;
        this.PartidasEmpatadas = PartidasEmpatadas;
    }
    
    //Metodos get y set

    public void setPartidasGanadas(int PartidasGanadas) {
        this.PartidasGanadas = PartidasGanadas;
    }

    public void setPartidasPerdidas(int PartidasPerdidas) {
        this.PartidasPerdidas = PartidasPerdidas;
    }

    public void setPartidasEmpatadas(int PartidasEmpatadas) {
        this.PartidasEmpatadas = PartidasEmpatadas;
    }

    public int getPartidasGanadas() {
        return PartidasGanadas;
    }

    public int getPartidasPerdidas() {
        return PartidasPerdidas;
    }

    public int getPartidasEmpatadas() {
        return PartidasEmpatadas;
    }
    
    
    
    
    
}
