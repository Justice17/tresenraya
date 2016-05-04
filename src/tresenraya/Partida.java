package tresenraya;
import java.util.*;

/**
 * Esta clase realiza las partidas
 * de el tres en raya
 * @author teo17
 */
public class Partida {
    /**
     * Los atributos de la clase
     */
    private int npartida;
    private boolean turnos = true;
    private int ganadas1;
    private int ganadas2;
    private int perdidas1;
    private int perdidas2;
    private int empatadas;
    
    /**
     * Objetos
     */
    //Objetos jugador 1 y jugador 2
    Jugador jugador1 = new Jugador();
    Jugador jugador2 = new Jugador();
    
    //Objetos de estadisitcas del j1 y del j2
    Estadisticas ejugador1 = new Estadisticas();
    Estadisticas ejugador2 = new Estadisticas();
    
    //Objeto de el tablero
    Tablero campo = new Tablero();
     
    
    /**
     * Constructor con parametros
     */
    
    public Partida(int npartida, boolean turnos) {
        this.npartida = npartida;
        this.turnos = turnos;
    }
    
    /**
     * Contructor sin parametros
     */
    
    public Partida(){
        
    }
    
    
    /**
     * Lo que viene a continuación
     * es el menu y su ejecución
     */
    
    public void Menu(){
        System.out.println("\n Bienvenido a el programa de ");
        System.out.println("  ------  El 3 en raya --------");
        System.out.println("| - Menu principal -           |");
        System.out.println(" ------------------------------ ");
        System.out.println(" 1. Nueva partida               ");
        System.out.println(" 2. Cargar partida(Proximamente)");
        System.out.println(" 3. Instrucciones               ");
        System.out.println(" ------------------------------ ");
        System.out.println("Nota, para salir pulse 0.------ ");
        
        
    }
    
    public void EjecucionMenu(){
    Scanner leer = new Scanner(System.in);    
        int opcion;
        Menu();//Llamamos el metodo menú para mostrarlo
        do{
            System.out.println("Escoga una opción: ");
            opcion = leer.nextInt();
        
                switch(opcion){
                    case 1:
                        ModosDeJuego();
                        break;
                    case 2:
                        System.out.println("Lo sentimos");
                        System.out.println("Esta funcion estará disponible en la siguiente actualización");
                        break;
                    case 3:
                        MostrarInstrucciones();
                        //Llamamos al de isntrucciones
                        break;
                }        
        }while(opcion>0);
    } //Fin metodo menu y ejecucion
    
    //Metodo para instrucciones
    public void MostrarInstrucciones(){
        System.out.println("---------- Instrucciones -----------");
        System.out.println("El juego consiste en usar coordenadas");
        System.out.println("para implementar nuestra O o nuestra X");
        System.out.println("para ganar la partida hay que insertar");
        System.out.println("tres seguidos, tanto horizontal, vertical");
        System.out.println("o diagonal. Las coordenadas van del 0 al 2");
        System.out.println("Suerte.");
    }
    
    
    
    
    /**
     * Los siguientes metodos son para iniciar la partida
     * el jugador introduciendo sus nombres y la ejecucion de la partida
     */
    
    //Empezamos con pedir modo de juego que quieren realizar de un jugador o de dos jugadores
    public void ModosDeJuego(){
        
        System.out.println("Escoga uno de los dos modos de juego: ");
        System.out.println(" ----------------------------------------------- ");
        System.out.println("| 1. Modo dos jugadores                         |");
        System.out.println("|Diviertase jugando con un amigo                |");
        System.out.println("| 2. Modo de un jugador                         |");
        System.out.println("|Si cree que puede inténtelo contra la gran CPU.|");
        System.out.println("| 3. Estadisticas.                              |");
        System.out.println("| 4. Volver a atras.                            |");
        System.out.println(" ----------------------------------------------- ");
        
        VerificarModo();
        
    }
    
    public void VerificarModo(){
    Scanner leer = new Scanner(System.in);
        int opcion=8;
        //ModosDeJuego();
        
        do{
            
            System.out.println("Escoga un modo por favor: ");
            opcion=leer.nextInt();
                
            switch(opcion){
                case 1:
                    EmpezarUnovsUno();
                    //Llamamos el metodo para iniciar este modo de juego.
                    break;
                case 2: 
                    System.out.println("Lo sentimos este modo esta solo para la version premium.");
                    ModosDeJuego();
                    //Llamamos el metodo para iniciar este modo de juego.
                    break;
                case 3:
                    MostrarEstadisticas();
                    //Llamamos el metodo para ver las estadísticas de los jugadores.
                    break;
                case 4:
                    EjecucionMenu();
                    //Llamamos el metodo del menu principal.
                    break;
                    
            }
            
       }while(opcion>0);
    }// Aqui se termina la eleccion del modo
    
    /**
     * Los siguientes metodos son para el modo de dos jugadores
     */
    
    //Empezamos con el metodo para empezar el modo introduciendo el nombre de los jugadores
    public void EmpezarUnovsUno(){
    Scanner leer = new Scanner(System.in);    

        System.out.println("Introduzca nombre de el jugador 1: ");
        jugador1.setNombre(leer.nextLine());
        System.out.println("Introduzca nombre de el jugador 2: ");
        jugador2.setNombre(leer.nextLine());
        
        npartida++;
        UnovsUno();
    }
    
    //Ahora empezará la partida
    public void UnovsUno(){
    Scanner leer = new Scanner(System.in);    
        int contador=9;
        int filas=0;
        int columnas=0;
        int X=0, O=0;

       do{
            
        campo.ElTablero(campo.getTablero());// Mostramos el campo
       
        
            if(turnos==true){
                System.out.println("Turno de "+jugador1.getNombre()+" usara O");
                System.out.println("Introduzca fila en la posicion de la tirada: ");
                filas=leer.nextInt();
                System.out.println("Introduzca columna en la posicion de la tirada: ");
                columnas=leer.nextInt();
                
                if(campo.ComprobarTablero(jugador1.getO())==false){
                   
                    campo.setTableroFC(filas,columnas);
                    turnos=false;
                    contador--;
                }   
                else if(campo.ComprobarTablero(jugador1.getO())==true){
                    
                    ejugador1.setPartidasGanadas(ganadas1++);
                    ejugador2.setPartidasPerdidas(perdidas2++);
                    Ganador(jugador1.getNombre());
                    
                }
                
                
            }
            else{
                System.out.println("Turno de "+jugador2.getNombre()+" usara X");
                System.out.println("Introduzca fila en la posicion de la tirada: ");
                filas=leer.nextInt();
                System.out.println("Introduzca columna en la posicion de la tirada: ");
                columnas=leer.nextInt();
                
                if(campo.ComprobarTablero(jugador2.getX())==false){
                    campo.setTableroFX(filas,columnas);
                    turnos=true;
                    contador--;
                }
                
               else if(campo.ComprobarTablero(jugador2.getX())==true){
                   
                    ejugador2.setPartidasGanadas(ganadas2++);
                    ejugador1.setPartidasPerdidas(perdidas1++);
                    Ganador(jugador2.getNombre());
                    
                }
                 
            }
        }while(contador!=0); // || //campo.ComprobarTablero(jugador2.getX())==false || campo.ComprobarTablero(jugador1.getX())==false);
        
        
        //Para el empate
        if(contador==0){
            System.out.println("Empate");
            ejugador1.setPartidasEmpatadas(empatadas++);
            ejugador2.setPartidasEmpatadas(empatadas++);
            OpcionesPostPartida();
        }
        
        
        
    }
    
    /**
     * El siguiente metodo es para tener un ganador y dar opciones al jugador despues de la partida
     * @param nombre
     */
    
     public void Ganador(String nombre){
         System.out.println("El ganador es "+nombre);
         System.out.println("Fin de la partida");
         OpcionesPostPartida();
       }
     
     public void OpcionesPostPartida(){
     Scanner leer = new Scanner(System.in); 
        int opcion = 0;
        char[][] reinicio = new char[3][3];
        
         System.out.println("--- 1. Revancha                 ---");
         System.out.println("--- 2. Estadisticas             ---");
         System.out.println("--- 3. Salir                    ---");
         System.out.println("Eliga una opcion: ");
         opcion = leer.nextInt();
         
         switch(opcion){
             case 1:
                 campo.setTablero(reinicio);
                 UnovsUno();
                 break;
             case 2:
                 MostrarEstadisticas();
                 break;
             case 3:
                 System.out.println("Gracias por jugar.");
                 EjecucionMenu();
                 break;
                 
         }
     }
     
     // Metodo para mostrar estadisticas
    
    public void MostrarEstadisticas(){
        
        System.out.println("Estadisticas "+jugador1.getNombre());
        System.out.println("Partidas Ganadas: "+ejugador1.getPartidasGanadas());
        System.out.println("Partidas Perdidas: "+ejugador1.getPartidasPerdidas());
        System.out.println("Partidas Empatadas: "+ejugador1.getPartidasEmpatadas());
        
        System.out.println("Estadisticas "+jugador2.getNombre());
        System.out.println("Partidas Ganadas: "+ejugador2.getPartidasGanadas());
        System.out.println("Partidas Perdidas: "+ejugador2.getPartidasPerdidas());
        System.out.println("Partidas Empatadas: "+ejugador2.getPartidasEmpatadas());
        
        
    }
    
    
}
