package learning.java.concepts.threading_and_synchronization._01_basics;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestThreadJoin {

	public static void main(String[] args) throws InterruptedException {

		Thread thread1 = new Thread(() -> {
			
			int i = 1;
			while (i <= 5) {
				System.out.println("Thread 1: running  i:" + i);
				try {Thread.sleep(250);} catch (InterruptedException e) {e.printStackTrace();}
				i++;
			}
			
			System.out.println("Thread 1: finished ... ");
		});
		
		
		Thread thread2 = new Thread(() -> {
			
			// thread2 will wait to finish thread1
			try {thread1.join();} catch (InterruptedException e) {System.out.println(e);}
			
			int i = 1;
			while (i <= 5) {
				System.out.println("Thread 2: running  i:" + i);
				try {Thread.sleep(250);} catch (InterruptedException e) {e.printStackTrace();}
				i++;
			}
			System.out.println("Thread 2: finished ... ");
		});
		
		
		Thread thread3 = new Thread(() -> {
			
			// thread3 will wait to finish thread2
			try {thread2.join();} catch (InterruptedException e) {System.out.println(e);}
			
			int i = 1;
			while (i <= 5) {
				System.out.println("Thread 3: running  i:" + i);
				try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
				i++;
			}
			System.out.println("Thread 3: finished ... ");
		});
				
		thread1.start();
		thread2.start();
		thread3.start();
		
		
	}
}