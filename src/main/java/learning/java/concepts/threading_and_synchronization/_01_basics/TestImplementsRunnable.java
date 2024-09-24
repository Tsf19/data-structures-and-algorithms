package learning.java.concepts.threading_and_synchronization._01_basics;

//Thread creation by extending the Thread class
class ImplementsRunnableDemo implements Runnable {

	// This is the entry point for this thread
	@Override
	public void run() {
		try {
			
			// Displaying the thread that is running
			System.out.println("Thread " + Thread.currentThread().getId() + " is going inside the loop");
			
			for (int i = 0; i < 3; i++) {
				System.out.println("Thread " + Thread.currentThread().getId() + " is running");
				Thread.sleep(250);
			}
			
			System.out.println("Thread " + Thread.currentThread().getId() + " is out of the loop");
			
		} catch (Exception e) {
			System.out.println("Exception is caught");
		}
	}
}

//Main Class
public class TestImplementsRunnable {
	
	public static void main(String[] args) {
		
		int n = 2; // Number of threads
		
		for (int i = 0; i < n; i++) {
			ImplementsRunnableDemo object = new ImplementsRunnableDemo();
			
			Thread threadObject = new Thread(object);
			threadObject.start();
		}
		
	}
}
