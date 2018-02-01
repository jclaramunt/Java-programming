
/**
 * Write a description of class MuestraRobot here.
 * 
 * @Juan 
 * @03/05/2011
 */
public class MueveRobot
{
    // creamos un objeto de la clase robot como atributo
    private Robot eva;
    /**
     * Constructor de la clase MueveRobot al que se le pasan las posiciones x e y del robot 
     * y el angulo.
     */
    public MueveRobot(int x, int y, int angulo){
        //damos valores al objeto de la clase Robot
        eva = new Robot(x, y, angulo);
    }

    /**
     *avanza en línea recta hasta que encuentra un obstáculo delante
     */
    public void avanzaRecto()
    {
        // utilizamos un bucle del tipo while
        while(eva.avanza()){
        
            eva.pinta();

        }
    }

    /**
     *repite en 4 ocasiones avanza 10 pasos y gira 90º
     */
    public void avanzaEnCuadrado()
    {
        // utilizamos un bucle for para repetir las instrucciones 4 veces

        for(int i=0;i<4 ;i++){
            //utilizamos un bucle for para avanzar 10 pasos
            for(int j=0;j<10;j++){
                eva.avanza();
                eva.pinta();
            }
            eva.gira90();
            eva.pinta();
        }
    }

    /**
     *realiza en 20 ocasiones avanzar en línea recta hasta encontrar un obstáculo 
     *y girar 90 grados
     */
    public void avanzaEvitando()
    {
        // utilizamos un bucle por para que repita las instrucciones 20 veces
        for(int i=0;i<20 ;i++){

            avanzaRecto();
            eva.gira90();
            eva.pinta();
        }
    }
    
    /**
     * repite en 100 ocasiones avanzar en linea recta hasta encontrar un obstáculo 
     * y gira un angulo aleatorio de 90,180 o 270 grados
     */
        public void avanzaAleatorio()
    {
        //Bucle for para que repita 100 veces
        for (int k=1; k<=100; k++) {
            avanzaRecto();
            //creamos un numero aleatorio entre 1 y 3
            int n=(int) (Math.random()*3+1);
            //repetimos las instrucciones tantas veces como sea el numero aleatorio mediante un bucle del tipo for
            for (int l=1; l<=n; l++){
                eva.gira90();
                eva.pinta();
            }
        }
    }

    /**
     *
     */
    public void avanzaAleatorio2()
    {
        // put your code here

        for(int i=0;i<100 ;i++){

            avanzaRecto();
            double aleatorio=Math.random()*270;
            if(aleatorio<=90){
                eva.gira90();
            }else if(90<aleatorio && aleatorio<=180){
                for(int j=0;j<2;j++){
                    eva.gira90();
                }
            }else{
                for(int k=0;k<3;k++){
                    eva.gira90();
                
                }
            }
            eva.pinta();
        }
    }
   
    /**
     *mientras el robot esta en el laberinto repite lo siguiente: 
     *gira un angulo aleatorio de 0,90,180 o 270 grados 
     *y avana un numero aleatorio de pasos entre 1 y 10.
     */
    public int movimientoAleatorio()
    {
        // inicializamos una variable que hará las veces de contador
        int suma=0;
        while(eva.estaDentroLaberinto()){
            //creamos un numero aleatorio para el giro 
            int aleatorio2=(int) (Math.random()*4+1);
            for(int i=1;i<=aleatorio2;i++){
                eva.gira90();
                eva.pinta();
            }
            //creamos un numero aleatorio para los pasos
            int aleatorio3=(int) (Math.random()*11);
            for (int j=0;j<=aleatorio3;j++){
                eva.avanza();
                eva.pinta();
                //aumentamos el contador con cada llamada a avanza
                suma ++;
            }
        }
        System.out.println("El robot salió del laberinto tras"+suma+"avances");
        return suma;
    }
    
    public int movimientoAleatorio2()
    {
        // put your code here
        int suma=0;
        while(eva.estaDentroLaberinto()){

            double aleatorio2=Math.random()*360;
            if(aleatorio2<90){
                eva.gira90();
            }else if(90<=aleatorio2 && aleatorio2<180){
                for(int j=0;j<2;j++){
                    eva.gira90();
                }
            }else if(180<=aleatorio2 && aleatorio2<270){
                for(int k=0;k<3;k++){
                    eva.gira90();
                
                }
            }else{
                
            }
            double aleatorio3=Math.random()*11;
            if(aleatorio3<1){
                eva.avanza();
            }else if (aleatorio3<=1 && aleatorio3<2){
                for(int a=0;a<2;a++){
                    eva.avanza();
                }
            }else if (aleatorio3<=2 && aleatorio3<3){
                for(int b=0;b<3;b++){
                    eva.avanza();
                }
            }else if (aleatorio3<=3 && aleatorio3<4){
                for(int c=0;c<4;c++){
                    eva.avanza();
                }
            }else if (aleatorio3<=4 && aleatorio3<5){
                for(int d=0;d<5;d++){
                    eva.avanza();
                }
            }else if (aleatorio3<=5 && aleatorio3<6){
                for(int e=0;e<6;e++){
                    eva.avanza();
                }
            }else if (aleatorio3<=6 && aleatorio3<7){
                for(int f=0;f<7;f++){
                    eva.avanza();
                }
            }else if (aleatorio3<=7 && aleatorio3<8){
                for(int g=0;g<8;g++){
                    eva.avanza();
                }
            }else if (aleatorio3<=8 && aleatorio3<9){
                for(int h=0;h<9;h++){
                    eva.avanza();
                }
            }else if (aleatorio3<=9 && aleatorio3<10){
                for(int l=0;l<10;l++){
                    eva.avanza();
                }
            }else {
            
            }
            suma ++;
            eva.pinta();
        }
        System.out.println("El robot salió del laberinto tras"+suma+"avances");
        return suma;
    }
     /**
     *Avanza en linea recta hasta encontrar un obstaculo, gira 90 grados 
     *y avanza pegado a la pared de la derecha
     */
    public int avanzaConManoDerecha()
    {
       // inicializamos la variable contador
       
       int suma2=0;
       
       //avanzamos hasta encontrar una pared y giramos 90 grados
       avanzaRecto();
       eva.gira90();
       eva.pinta();
        while(eva.estaDentroLaberinto()){
            //miramos si hay obstaculo a la derecha
            if(eva.hayObstaculo(Robot.DCHA)){ 
                //miramos si hay obstaculo delante
                if(eva.hayObstaculo(Robot.DELANTE)) 
                {
                    //giramos 90 grados
                    eva.gira90();
                    eva.pinta();
                }else{ //si no hay obstaculo avanzamos
                    eva.avanza();
                    eva.pinta();
                    //aumentamos el contador con cada llamada a avanza
                    suma2++;
                }
            }else{ //si no hay obstaculo a la derecha
                //giramos 270 grados
                eva.gira90();
                eva.gira90();
                eva.gira90();
                eva.avanza();
                eva.pinta();
                //aumentamos el contador con cada llamada a avanza
                suma2++; 
            

        
        }
       
       }
       System.out.println("El robot salió del laberinto tras "+suma2+" avances");
       return suma2;
    }    

}
