package learning.java.concepts.threading_and_synchronization._01_basics;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestThreadJoin2 {

	public static void main(String[] args) {
		
		Runnable task = () -> {

			for (int i = 1; i <= 5; i++) {

				System.out.println(i + " from " + Thread.currentThread().getName());

				if(Thread.currentThread().getName().equals("Thread-3")) {
					
					try {Thread.currentThread().join();} catch (InterruptedException e) {System.out.println(e);}
				}
				
				try {Thread.sleep(250);} catch (InterruptedException e) {System.out.println(e);}
			}

		};
		
		Thread t1 = new Thread(task);
		
		Thread t2 = new Thread(() -> {
			
			for (int i = 1; i <= 5; i++) {
				
				System.out.println(i + " from " + Thread.currentThread().getName());

				System.out.println(i + " from " + "1. Thread t1 state is" + t1.getState());
				try {t1.join();} catch (InterruptedException e) {System.out.println(e);}
				
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
			
		});
		
		Thread t3 = new Thread(task);
		Thread t4 = new Thread(task);

		t1.setName("Thread-1");
		t2.setName("Thread-2");
		
		t3.setName("Thread-3");
		t4.setName("Thread-4");
		
		
		t2.start();
		t1.start();
		
		try {Thread.sleep(2500);} catch (InterruptedException e) {System.out.println(e);}
		System.out.println("--------------------------------------------------");
		
		t4.start();
		t3.start();

//		System.out.println("currentThread : " + Thread.currentThread().getName() + "  isAlive()? : " + Thread.currentThread().isAlive());
	}

// OUTPUT:

//	1 from Thread-1
//	1 from Thread-2
//	1 from 1. Thread t1 state isWAITING // OR // 1 from 1. Thread t1 state isRUNNABLE
//	2 from Thread-1
//	3 from Thread-1
//	4 from Thread-1
//	5 from Thread-1
//	1 from 2. Thread t1 state isTERMINATED
//	2 from Thread-2
//	2 from 1. Thread t1 state isTERMINATED
//	2 from 2. Thread t1 state isTERMINATED
//	3 from Thread-2
//	3 from 1. Thread t1 state isTERMINATED
//	3 from 2. Thread t1 state isTERMINATED
//	4 from Thread-2
//	4 from 1. Thread t1 state isTERMINATED
//	4 from 2. Thread t1 state isTERMINATED
//	5 from Thread-2
//	5 from 1. Thread t1 state isTERMINATED
//	5 from 2. Thread t1 state isTERMINATED
	
/*
Main Thread           |   t1 (Thread)          |   t2 (Thread)
----------------------|------------------------|---------------------
Start t2              |   Start running        |
Start t1              |                        |   Start running
                      |   Running              |   Running
                      |                        |   t1.join()
                      |   Running              |   Wait for t1 to finish
                      |   Running              |   Wait for t1 to finish
                      |   Running              |   Wait for t1 to finish
                      |   Running              |   Wait for t1 to finish
                      |   Finished             |   Running
                      |   Finished             |   Running
                      |   Finished             |   Running
                      |   Finished             |   Running
                      |                        |   Finished
Main thread continues execution ...
 */
	
}