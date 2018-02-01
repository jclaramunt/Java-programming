import java.util.*;

/**
 * Clase que contiene un robot que se mueve por un recinto
 */
public class Robot
{

    /**
     * Constante estatica para la direccion; 
     * es relativa a la orientacion del robot
     */
    public static int DELANTE=Recinto.DELANTE;

    /**
     * Constante estatica para la direccion; 
     * es relativa a la orientacion del robot
     */
    public static int DETRAS=Recinto.DETRAS;

    /**
     * Constante estatica para la direccion; 
     * es relativa a la orientacion del robot
     */
    public static int IZQDA=Recinto.IZQDA;

    /**
     * Constante estatica para la direccion; 
     * es relativa a la orientacion del robot
     */
    public static int DCHA=Recinto.DCHA;
    
    // posicion del robot, en celdas, y angulo, en cuadrantes (0, 1, 2, 3)
    private int posX, posY;
    private int angulo; // expresado en cuadrantes
    // recinto en el que se mueve el robot
    private Recinto rec;

    /**
     * Constructor al que se le pasa la posicion inicial en celdas,
     * y el angulo inicial en grados (multiplo de 90) 
     */
    public Robot(int posX, int posY, int angulo)
    {
        this.angulo=(angulo%360)/90;
        rec=new Recinto();
        if (rec.posicionValida(posX,posY)) {
            this.posX=posX;
            this.posY=posY;
            rec.cambiaRobot(posX, posY,angulo);
        } else {
            System.out.println("La posicion "+posX+","+
               posY+"no es valida");
            System.out.println("Se inicializa el robot en 25,25");
            this.posX=25;
            this.posY=25;
            rec.cambiaRobot(25, 25,angulo);            
        }
    }

    /**
     * Avanza el robot una celda si se puede; 
     * retorna true si avanzo, o false si habia un obstaculo delante
     */
    public boolean avanza()
    {
        if (rec.hayObstaculo(Recinto.DELANTE)) {
            return false;
        } else {
            switch (angulo) {
                case 0: posX++; break;
                case 1: posY--; break;
                case 2: posX--; break;
                case 3: posY++;
            }
            rec.cambiaRobot(posX,posY,angulo*90);
            return true;
        }
    }
    
    /**
     * Gira el robot 90 grados
     */
    public void gira90() {
        angulo=(angulo+1)%4;
        rec.cambiaRobot(posX,posY,angulo*90);
    }
    
    /**
     * Indica si el robot tiene un obstaculo en la direccion indicada
     * La direccion se expresa mediante las constantes estaticas 
     * DELANTE, DETRAS, IZQDA, DCHA, y es relativa al angulo actual del robot
     */
    public boolean hayObstaculo(int direccion) {
        return rec.hayObstaculo(direccion);
    }
    
    /**
     * Pinta el robot y el recinto
     */
    public void pinta() {
        espera(50);
        rec.pinta();
    }
    
    // Espera un rato expresado en milisegundos
     
    private void espera(int milisegundos) {
        try {
           Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
        }
    }
    
    /**
     * Indica si el robot esta dentro del laberinto
     */
    public boolean estaDentroLaberinto() {
        return 30<=posX && posX<=80 && 30<=posY && posY<=80;
    }
}
