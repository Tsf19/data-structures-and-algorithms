package learning.java.concepts.threading_and_synchronization._01_basics;

//Thread creation by extending the Thread class
class MultithreadingDemo_2_ extends Thread {

	// If static, The final value of str could be a combination of multiple thread IDs and spaces
	// If non-static, The final value of str could be a combination of multiple thread IDs and spaces
	static String str = "str : ";
	static StringBuffer strBuffer = new StringBuffer("strBuffer : ");
	static StringBuilder strBuilder = new StringBuilder("strBuilder : ");
	
	// This is the entry point for this thread
	@Override
	public void run() {
		try {
			
			// Displaying the thread that is running
			System.out.println("Thread " + Thread.currentThread().getId() + " is going inside the loop");
			
			for (int i = 0; i < 5; i++) {
//				System.out.println("Thread " + Thread.currentThread().getId() + " is running");
				
				str = str + Thread.currentThread().getId() 	+ " ";
				System.out.println(Thread.currentThread().getId() 	+ " " + "str: " + str);
				
				strBuffer.append(Thread.currentThread().getId());
				strBuffer.append(" ");
				System.out.println(Thread.currentThread().getId() 	+ " " + "strBuffer: " + strBuffer);
				
				strBuilder.append(Thread.currentThread().getId());
				strBuilder.append(" ");
				System.out.println(Thread.currentThread().getId() 	+ " " + "strBuilder: " + strBuilder);
				
//				System.out.println("Thread " + Thread.currentThread().getId() + " is running");
				Thread.sleep(250);
			}
			
			System.out.println("Thread " + Thread.currentThread().getId() + " is out of the loop");
			
		} catch (Exception e) {
			System.out.println("Exception is caught");
		}
	}
}

//Main Class
public class _002_TestThreading {
	
	public static void main(String[] args) {
		
		int n = 5; // Number of threads
		
		for (int i = 0; i < n; i++) {
			MultithreadingDemo_2_ object = new MultithreadingDemo_2_();
			object.start();
		}
		
	}
}
