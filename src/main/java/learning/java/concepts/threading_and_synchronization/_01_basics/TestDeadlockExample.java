package learning.java.concepts.threading_and_synchronization._01_basics;

public class TestDeadlockExample {

	public static final Object lock1 = new Object();
	public static final Object lock2 = new Object();

	public static void main(String[] args) {
		
		Thread thread1 = new Thread(() -> {
			
			synchronized (lock1) {
				
				System.out.println("Thread 1: Holding lock1");
				
				try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace();}
				
				System.out.println("Thread 1: Waiting for lock2");
				synchronized (lock2) {
					System.out.println("Thread 1: Holding lock1 and lock2");
				}
			}
		});

		Thread thread2 = new Thread(() -> {
			
			synchronized (lock2) {
			
				System.out.println("Thread 2: Holding lock2");
				try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace();}
				
				System.out.println("Thread 2: Waiting for lock1");
				synchronized (lock1) {
					System.out.println("Thread 2: Holding lock2 and lock1");
				}
			}
		});

		thread1.start();
		thread2.start();
	}
}