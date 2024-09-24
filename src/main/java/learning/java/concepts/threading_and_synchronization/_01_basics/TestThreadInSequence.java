package learning.java.concepts.threading_and_synchronization._01_basics;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestThreadInSequence {
	
	public static void main(String[] args) {

		{
		System.out.println("start ... ");

		final int[] order = { 0, 1, 2 };

		final int[] current = {0};

		final Object mutex = new Object();

		Thread t1 = new Thread(() -> {
			synchronized (mutex) {
				for (int i = 0; i < 5; i++) {
					while (current[0] != 0)
						try {mutex.wait();} catch (InterruptedException e) {}
					System.out.print(" This ");
					current[0] = 1;
					mutex.notifyAll();
				}
			}
		});
		
		Thread t2 = new Thread(() -> {
			synchronized (mutex) {
				for (int i = 0; i < 5; i++) {
					while (current[0] != 1)
						try {mutex.wait();} catch (InterruptedException e) {}
					System.out.print(" Is ");
					current[0] = 2;
					mutex.notifyAll();
				}
			}
		});
		
		Thread t3 = new Thread(() -> {
			synchronized (mutex) {
				for (int i = 0; i < 5; i++) {
					while (current[0] != 2)
						try {mutex.wait();} catch (InterruptedException e) {}
					System.out.println(" In Sequence ");
					current[0] = 0;
					mutex.notifyAll();
				}
			}
		});



		t1.start();
		t2.start();
		t3.start();

		System.out.println("end ... ");
		}
		
		
		{
			
		
	        final AtomicInteger current = new AtomicInteger(0); // Shared state for current word
	        final Object mutex = new Object();

	        ExecutorService executor = Executors.newFixedThreadPool(3);

	        CompletableFuture<Void> t1 = CompletableFuture.runAsync(() -> {
	            synchronized (mutex) {
	                for (int i = 0; i < 5; i++) {
	                    while (current.get() != 0) {
	                        try {
	                            mutex.wait();
	                        } catch (InterruptedException e) {
	                            Thread.currentThread().interrupt();
	                        }
	                    }
	                    System.out.print(" This ");
	                    current.set(1); // Next word is "Is"
	                    mutex.notifyAll();
	                }
	            }
	        }, executor);

	        CompletableFuture<Void> t2 = CompletableFuture.runAsync(() -> {
	            synchronized (mutex) {
	                for (int i = 0; i < 5; i++) {
	                    while (current.get() != 1) {
	                        try {
	                            mutex.wait();
	                        } catch (InterruptedException e) {
	                            Thread.currentThread().interrupt();
	                        }
	                    }
	                    System.out.print(" IS ");
	                    current.set(2); // Next word is "Test"
	                    mutex.notifyAll();
	                }
	            }
	        }, executor);

	        CompletableFuture<Void> t3 = CompletableFuture.runAsync(() -> {
	            synchronized (mutex) {
	                for (int i = 0; i < 5; i++) {
	                    while (current.get() != 2) {
	                        try {
	                            mutex.wait();
	                        } catch (InterruptedException e) {
	                            Thread.currentThread().interrupt();
	                        }
	                    }
	                    System.out.println(" Test ");
	                    current.set(0); // Next word is "This"
	                    mutex.notifyAll();
	                }
	            }
	        }, executor);

	        CompletableFuture.allOf(t1, t2, t3).join(); // Wait for all tasks to complete
	        executor.shutdown();

	        System.out.println("end ... ");
			
			
		}
	}

}







