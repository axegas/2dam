import java.io.*;


 
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

   /**
     * Calculate average of numbers. Sum all the int values and divide it by
     * total count.
     */
    
class Average implements Runnable {
	
	Integer[] values;
	float mean;
 
	Average(Integer[] values) {
		this.values = values;
        }
 
	@Override
	public void run() {
		
		mean = 0;
		int n = values.length;
		
		for (int i : values) {
			
			mean += i;
            }
            
        System.out.println("Suma media aritmética= "+mean);
            
		mean /= n;
		
		System.out.println("Media aritmética= "+mean);
        
		
        
        } //ACABA RUN
 
	public float getMean() {
		return mean;
        }
    }
 


    /**
     * Sorts the given int list and calculates the median value. If size is
     * even, the mean of middle and middle-1.
     *
     */

class Median implements Runnable {
	
	Integer[] values;
	float median;
 
 
	Median(Integer[] values) {
		this.values = values;
        }
 
	@Override
	public void run() {
            
    List<Integer> sortedList = Arrays.asList(values); //Returns a fixed-size list backed by the specified array.
            
	Collections.sort(sortedList); //Sorts the specified list into ascending order, according to the natural ordering of its elements.
	
    int n = values.length;
    
    int middle = n / 2;
    
    //MUESTRA ARRAY
		System.out.print("Array ordenado: ");
		for (Integer componente: sortedList){ 
				System.out.print(" "+componente);
			}
		System.out.println();
    
    
    System.out.println("Mediana= " +middle);
    
    
    
	if (n % 2 == 0) {
		median =  (sortedList.get(middle) + sortedList.get(middle - 1)) / 2;
		
		} 
		else {
			median = sortedList.get(middle);
			}

	
	
			
	}//ACABA RUN
 
 
	public float getMedian() {
		
		return median;
		
		}
 
    }




 //CLASE PUBLICA
public class ThreadJoinExample {
 
	public static void main(String[] args) {
		
		Integer[] values =  new Integer[] { 3, 1, 14, 3, 4, 5, 6, 7, 8, 9, 11, 3, 2, 1 };
		
		//MUESTRA ARRAY
		System.out.print("Array inicial: ");
		for (Integer componente: values){ 
				System.out.print(" "+componente);
			}
		System.out.println();
		
		
		Average avg = new Average(values);
		
		Median median = new Median(values);
		
		Thread t1 = new Thread(avg, "t1");
		
		Thread t2 = new Thread(median, "t2");

		System.out.println("t1.toString= "+t1.toString());

		System.out.println("t2.toString= "+t2.toString());	




		
		System.out.println("Start the thread t1 to calculate average");
		
		t1.start();
		
		System.out.println("Start the thread t2 to calculate median");
		
		t2.start();
		
		
		
		
		try {
			
			System.out.println("Join on t1 (media aritmética)");
			
			t1.join();
			
			System.out.println("t1 has done with its job of calculating average");
			
			} catch (InterruptedException e) {
				
				System.out.println(t1.getName() + " interrupted");
				
				}
		try {
			
			System.out.println("Join on t2 (mediana)");
			
			t2.join();
			
			System.out.println("t2 has done with its job of calculating median");
			
			} catch (InterruptedException e) {
				
				System.out.println(t2.getName() + " interrupted");
				
				}
	
	
	
			System.out.println("Average: " + avg.getMean() + ", Median: "+ median.getMedian());
    
			}
    
    
	}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
