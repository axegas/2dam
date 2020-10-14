import java.io.*;



// implementando Runnable
class ImprimeNum implements Runnable {
	public void run() {
		for (int b=-10; b<10; b++) System.out.print(" "+b);
		}
	}




public class Test2 {
	public static void main(String args[]) {
		
		Thread in= new Thread(new ImprimeNum()); // tarea creada, pero no se ejecuta todavia
		
		Thread in2= new Thread(new ImprimeNum());
		Thread in3= new Thread(new ImprimeNum());
		
		in3.start();
		in.start(); // ahora arranca
		in2.start();
		
		
		
		
		}
	}
