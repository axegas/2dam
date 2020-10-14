import java.io.*;




//Clase con metodo sincronizado puede suspender  o reactivar una tarea

class Q { 
   int n; 
   boolean valueSet = false; 
   
   
   //get de la variable n
	synchronized int get() { 
      
		System.out.println("Inicio de get()");
		if(!valueSet) //no hay valor, no puedo hacer get
			try { 
				//suspende la tarea actual 
				System.out.println("El consumidor en get() llama a wait");
				wait(); 
				} catch(InterruptedException e) { 
					System.out.println("InterruptedException caught"); 
					} 
      
      
		System.out.println("Got: " + n); 
		valueSet = false; 
		
		//notifica a una tarea 
		notify(); 
		
		return n; 
		} 
   
   
	//set o put de la variable n
	synchronized void put(int n) { 
		
		System.out.println("Inicio de put()");
		
		
		if(valueSet) // hay un valor almacenado, no puedo hacer put
			try { 
				
				System.out.println("El productor en put() llama a wait()");
				wait(); 
				
				} catch(InterruptedException e) { 
					System.out.println("InterruptedException caught"); 
					} 
					
		this.n = n; 
		valueSet = true; 
		System.out.println("Put: " + n); 
		notify(); 
		} 
	}



//clase productor
class Producer implements Runnable { 
	
	Q q; 
	
	Producer(Q q) { 
		
		this.q = q; 
		new Thread(this, "Producer").start(); 
		} 
   
	public void run() { 
		
		int i = 0; 
		while(i<10) { 
			q.put(i++); 
			} 
			
		} 
	}



//clase consumidor

class Consumer implements Runnable { 
	
	Q q; 
	Consumer(Q q) { 
		
		this.q = q; 
		new Thread(this, "Consumer").start(); 
		
		} 
   

	public void run() { 
		while(true) { 
			q.get(); 
		} 
		
	} 

}


//clase publica


class PCFixed { 

	public static void main(String args[]) { 
		
		Q q = new Q(); 
		
		new Producer(q); 
		new Consumer(q); 
		
		System.out.println("Press Control-C to stop."); 
		
		} 
}
