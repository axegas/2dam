import java.io.*;



public class RunnableFil implements Runnable {

	String strImprimir;

    public RunnableFil(String strP) {
        strImprimir=strP;
    }
    
    public void run(){
        for(int x=0;x<5;x++){
            System.out.println(strImprimir+ " " + x);
        }
            
    }
    
    public static void main(String[] args) {
        
        //Creem dos objecte de la classe RunnableFil 
        
        RunnableFil objRunnable1 = new RunnableFil("Fil 1");
        
        RunnableFil objRunnable2 = new RunnableFil("Fil 2");
        
        //Creem dos Fils i li passem per paràmetres els objecte de la classe RunnableFil 
        Thread primer = new Thread(objRunnable1);
        Thread segon = new Thread(objRunnable2);     
        
           
        // Hem creat dos fils primer i segon, però no s'han executat.
        // Per poder-lo executar s'ha de cridar al mètode start()
        
        primer.start();
        segon.start();
        
        System.out.println("Final Fil Principal");
  
    }  
}
