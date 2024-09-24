package learning.java.concepts.threading_and_synchronization._01_basics;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class Concurrent_TestExecutorService {

	public static void main(String[] args) {

		Runnable runnable1 = () -> {
			try {Thread.sleep(100);} catch (InterruptedException e) {System.out.println(e);}
			System.out.println("runnable1 CurrentThreadName: " + Thread.currentThread().getName());
		};

		Runnable runnable2 = () -> {
			try {Thread.sleep(100);} catch (InterruptedException e) {System.out.println(e);}
			System.out.println("runnable2 CurrentThreadName: " + Thread.currentThread().getName());
		};
		
		Runnable runnable3 = () -> {
			try {Thread.sleep(100);} catch (InterruptedException e) {System.out.println(e);}
			System.out.println("runnable3 CurrentThreadName: " + Thread.currentThread().getName());
		};
		
		ExecutorService executorService1 = Executors.newFixedThreadPool(2);

		System.out.println("_____________________________________________________________________");
		System.out.println("============== | ExecutorService.execute(runnable) | ==============");

		System.out.println("CurrentThreadName: " + Thread.currentThread().getName());
		try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println(e);}
		
		executorService1.execute(runnable1);
		executorService1.execute(runnable2);
		executorService1.execute(runnable3);
		
		
		executorService1.shutdown();
		
		System.out.println("CurrentThreadName: " + Thread.currentThread().getName());
		try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println(e);}
		
/**_____________________________________________________________________________________________________*/
		
		
		System.out.println("_____________________________________________________________________");
		System.out.println("============== | ExecutorService.submit(runnable) | ==============");
		System.out.println("CurrentThreadName: " + Thread.currentThread().getName());
		try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println(e);}

		
		ExecutorService executorService2 = Executors.newFixedThreadPool(2);
		
		//NOT executor.execute() BUT executor.submit()
		executorService2.submit(runnable1);
		executorService2.submit(runnable2);
		executorService2.submit(runnable3);
		
		executorService2.shutdown();
		
/**_____________________________________________________________________________________________________*/
		
		
		System.out.println("_____________________________________________________________________");
		System.out.println("============== | ExecutorService.submit(callable) | ==============");
		System.out.println("CurrentThreadName: " + Thread.currentThread().getName());
		try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println(e);}
		
		Callable<String> callable1 = () -> {
			try {Thread.sleep(100);} catch (InterruptedException e) {System.out.println(e);}
			return "callable1 CurrentThreadName: " + Thread.currentThread().getName();
		};
		
		Callable<String> callable2 = () -> "callable2 CurrentThreadName: " + Thread.currentThread().getName();

		
		ExecutorService executorService3 = Executors.newFixedThreadPool(2);

		Future<String> future3_1 = executorService3.submit(callable1);
		
		try {
			String string = future3_1.get();
			System.out.println(string);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		
		
		try {
			String string = executorService3.submit(callable2).get();
			System.out.println(string);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		
		Future<?> future3_2 = executorService3.submit(() -> {
			return "callable CurrentThreadName: " + Thread.currentThread().getName();
		});
		
		
		
		Future<?> future3_3 = executorService3.submit(() -> {
			try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println(e);}
			System.out.println("Task executed");
			try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println(e);}
		});

		
		// Check if the task is complete
		while (!future3_3.isDone()) {
			try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println(e);}
			System.out.println("Task is done");
		}
		
		executorService3.shutdown();










	}
}







