import fundamentos.Dibujo;
import fundamentos.ColorFig;

/**
 * Clase que representa un recinto con obstaculos, en el que se
 * mueve un robot movil
 */
public class Recinto
{

    /**
     *  Constante para la direccion de movimiento; 
     *  es relativa a la orientacion del robot
     */
    public static int DELANTE=0;

    /**
     *  Constante para la direccion de movimiento; 
     *  es relativa a la orientacion del robot
     */
    public static int DETRAS=2;

    /**
     *  Constante para la direccion de movimiento; 
     *  es relativa a la orientacion del robot
     */
    public static int IZQDA=1;

    /**
     *  Constante para la direccion de movimiento; 
     *  es relativa a la orientacion del robot
     */
    public static int DCHA=3;
    
    // ventana para hacer el dibujo
    private Dibujo dib;
    
    // iconos disponibles
    private static final String[] fichIcono=
       {"icono0.png","icono90.png","icono180.png","icono270.png"}; 
    
    // posicion del icono
    private int posX=0, posY=0;
    // icono a usar 0, 1, 2, 3, para 0, 90, 180, 270 grados
    private int icono=0; 
    
    //celda del recinto, que define los obstaculos a dibujar
    // true indica que la celda esta ocupada por un obstaculo
    private boolean[][] celda;
    // obstaculos a usar, teniendo en cuenta que el robot mide mas
    // de una celda. Contiene el dibijo de las celdas, aumentado
    // true indica que la celda esta ocupada por un obstaculo
    private boolean[][] obstaculo;
    
    // maximo numero de celdas contenidas en el recinto
    private int maxX=120;
    private int maxY=120;
    
    //Tamano de las celdas del dibujo
    private int paso=5;
    
    // margen que debe librarse alrededor del robot, en celdas
    // el robot mide (2*margen+1)*paso
    private int margen=2;

    // limites del dibujo
    private int limiteX=paso*(maxX+2);
    private int limiteY=paso*(maxY+2);

    /**
     * Constructor que da un valor concreto al recinto
     */
    public Recinto()
    {
        dib= new Dibujo("Recinto",limiteX,limiteY);
        celda= new boolean[maxX][maxY]; // se inicializa a false por omision
        obstaculo= new boolean[maxX][maxY]; // se inicializa a false por omision
        // colocar los bordes superior e inferior del recinto
        for (int i=0; i<maxX; i++) {
            celda[i][0]=true;
            celda[i][maxY-1]=true;
        }
        // colocar los bordes izqdo y dcho del recinto
        for (int i=0; i<maxY; i++) {
            celda[0][i]=true;
            celda[maxX-1][i]=true;
        }
        
        // crear un laberinto en el centro
        // lineas horizontales
        for (int i=30; i<=80; i++) {
            celda[i][30]=true;
        }
        for (int i=30; i<=70; i++) {
            celda[i][40]=true;
        }
        for (int i=40; i<=50; i++) {
            celda[i][50]=true;
        }
        for (int i=60; i<=70; i++) {
            celda[i][50]=true;
        }
        for (int i=40; i<=50; i++) {
            celda[i][70]=true;
        }
        for (int i=30; i<=80; i++) {
            celda[i][80]=true;
        }
        // lineas verticales
        for (int i=40; i<=80; i++) {
            celda[30][i]=true;
        }
        for (int i=40; i<=50; i++) {
            celda[40][i]=true;
        }
        for (int i=50; i<=70; i++) {
            celda[50][i]=true;
        }
        for (int i=60; i<=80; i++) {
            celda[60][i]=true;
        }
        for (int i=40; i<=70; i++) {
            celda[70][i]=true;
        }
        for (int i=30; i<=80; i++) {
            celda[80][i]=true;
        }
        // Colocar los obstaculos
        for (int i=0; i<maxX; i++) {
            for (int j=0; j<maxY; j++) {
                if (celda[i][j]) {
                    for (int x=Math.max(0,i-margen); 
                        x<=Math.min(maxX-1,i+margen); x++) 
                    {
                        for (int y=Math.max(0,j-margen); 
                            y<=Math.min(maxY-1,j+margen); y++) 
                        {
                            obstaculo[x][y]=true;
                        }
                    }
                }
            }
        }
    }
    
    // transforma coordenada x de celda al dibujo
    private int coordX(int x) {
        return x*paso+paso;
    }

    // transforma coordenada x de celda al dibujo
    private int coordY(int y) {
        return y*paso+paso;
    }

    /**
     * Pintar el dibujo
     */
    public void pinta()
    {
        dib.borra(ColorFig.blanco);
        dib.ponGrosorLapiz(1);
        dib.ponColorLapiz(ColorFig.rojo);
        dib.ponRelleno(ColorFig.rojo);
        for (int x=0; x<maxX; x++) {
            for (int y=0; y<maxX; y++) {
                if (celda[x][y]) {
                    dib.dibujaRectangulo(coordX(x),coordY(y),coordX(x)+paso,coordY(y)+paso);
                }
            }
        }
        dib.dibujaImagen(coordX(posX)-margen*paso,coordY(posY)-margen*paso,fichIcono[icono]);
        dib.pinta();
    }
    
    /**
     * Cambia la posicion y angulo del robot.
     * El angulo debe ser multiplo de 90
     */
    public void cambiaRobot(int posX, int posY, int angulo) {
        this.posX=posX;
        this.posY=posY;
        angulo=angulo%360;
        icono=angulo/90;
    }
    
    /**
     * Indica si el robot tiene un obstaculo en la direccion indicada
     */
    public boolean hayObstaculo(int direccion) {
        switch ((icono+direccion)%4) {
           case 0: return obstaculo[posX+1][posY];
           case 1: return obstaculo[posX][posY-1];
           case 2: return obstaculo[posX-1][posY];
           case 3: return obstaculo[posX][posY+1];
           default: return false;
        }
    }
    
    /**
     * Indica si estas coordenadas son validas para poner el robot
     */
    public boolean posicionValida(int x, int y) {
        return !obstaculo[x][y];
    }
}
