    /**
     *
     */
    public int movimientoAleatorio()
    {
        // put your code here
        int suma=0;
        while(eva.estaDentroLaberinto()){

          
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
        return suma;
    }
    
    
    
    
    
    