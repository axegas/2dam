import java.io.*;


// como extensión de Thread
class ImprimeNum extends Thread {
	
	
	public void run() {
		for (int b= -10; b<10; b++){ 
		
			System.out.print(" "+b);
			}
		}
	}

public class Test1 {
	
	
	
	public static void main(String args[]) {
		
		ImprimeNum in = new ImprimeNum(); // tarea creada, pero no se ejecuta todavia
		
		in.start(); // ahora arranca
		
		}
	}
