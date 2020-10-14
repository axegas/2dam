import java.io.*;




public class HeretaFil extends Thread {

    String strImprimir;
    
    public HeretaFil(String strP) {
        strImprimir=strP;
    }
    
    public void run(){
        for(int x=0;x<5;x++){
            System.out.println(strImprimir+ "x= " + x);
        }
            
    }
    
    public static void main(String[] args) {
        
        Thread primer = new HeretaFil("Fil 1: ");
        
        Thread segon = new HeretaFil("Fil 2: ");
        
        // Hem creat dos fils primer i segon, però no s'han executat.
        // Per poder-lo executar s'ha de cridar al mètode start()
        
        primer.start();
        segon.start();
        
        System.out.println("Final Fil Principal");
        
    }
}
