package learning.java.concepts.threading_and_synchronization._01_basics;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class Concurrent_TestExecutor3_CallableFuture {
	
	public static void main(String[] args) {

		System.out.println("_____________________________________________________________________");
		System.out.println("============== | Example of Asynchronous Task Execution | ==============");
		
		try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println(e);}
		System.out.println("CurrentThreadName: " + Thread.currentThread().getName());

		
		ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<Integer> callableTask = () -> {
            TimeUnit.SECONDS.sleep(1);
            return 123;
        };

        Future<Integer> future = executorService.submit(callableTask);

        try {
        	
            System.out.println("Doing something else while the task is running...");
            
            Integer result = future.get(); // Blocks until the result is available
            
            System.out.println("Result of the asynchronous task: " + result);

            System.out.println("Done... ");
            
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        


		/*_____________________________________________________________________________________________________
OUTPUT:
============== | Executors.newSingleThreadExecutor() | ==============
CurrentThreadName: main
Doing something else while the task is running...
Result of the asynchronous task: 123
Done...
_____________________________________________________________________________________________________*/
			
			

			
	}
}







