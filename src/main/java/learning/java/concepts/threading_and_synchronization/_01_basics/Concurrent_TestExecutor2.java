package learning.java.concepts.threading_and_synchronization._01_basics;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class Concurrent_TestExecutor2 {
	
	public static void main(String[] args) {

/**_____________________________________________________________________________________________________
void execute(Runnable command):
Executes the given command at some time in the future.
The command may execute in a new thread, in a pooled thread, or in the calling thread,
at the discretion of the Executor implementation.

@throws RejectedExecutionException if this task cannot be accepted for execution
@throws NullPointerException if command is null
_____________________________________________________________________________________________________*/
		
		/**
		Defines an implementation for the execute(Runnable command) method of the Executor interface.
		The lambda expression takes a Runnable (or any functional interface compatible with execute)
		and starts a new thread to execute it.
		The lambda expression: command -> new Thread(command).start() defines the behavior of the Executor object.
		
		It takes a Runnable object as input (represented by the command parameter).
		For each Runnable task submitted to this Executor, it creates a new Thread and starts it.
		
		Potential Issues:
		Unbounded Thread Creation: Creating a new thread for each task can lead to resource exhaustion
		 if the number of tasks is large.
		No Thread Management: The Executor doesn't manage the created threads, and they might remain in the
		 system even after the tasks are completed.
		Lack of Control: You have no control over the execution order of tasks or the number of concurrent threads.
		
		Recommendation:
		 For most practical use cases, using this Executor is not recommended.
		 Instead, consider using ExecutorService implementations like ThreadPoolExecutor or ForkJoinPool
		  that provide better control over thread management and execution.
		 These executors offer features like thread pooling, task queuing, and lifecycle management.
		
		*/
		Executor executor1 = runnableCommand -> new Thread(runnableCommand).start();
		executor1.execute(() -> System.out.println("Task3 executed by : " + Thread.currentThread().getName()));

		
		Runnable runnableCommand3 = () -> {};
		executor1.execute(runnableCommand3);
		
		
		executor1.execute(() -> {});
		executor1.execute(() -> System.out.println("Task3 executed by : " + Thread.currentThread().getName()));
		

		System.out.println("_____________________________________________________________________");
		System.out.println("============== | Executors.newSingleThreadExecutor() | ==============");
		
		System.out.println("CurrentThreadName: " + Thread.currentThread().getName());
		try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println(e);}
		
		
		Runnable runnable1 = () -> {
			try {Thread.sleep(100);} catch (InterruptedException e) {System.out.println(e);}
			System.out.println("runnable1 CurrentThreadName: " + Thread.currentThread().getName());
		};

		Runnable runnable2 = () -> {
			try {Thread.sleep(100);} catch (InterruptedException e) {System.out.println(e);}
			System.out.println("runnable2 CurrentThreadName: " + Thread.currentThread().getName());
		};


		Executor singleThreadExecutor = Executors.newSingleThreadExecutor();

		singleThreadExecutor.execute(runnable1);
		singleThreadExecutor.execute(runnable2);

		try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println(e);}
		System.out.println("CurrentThreadName: " + Thread.currentThread().getName());

		/*_____________________________________________________________________________________________________
OUTPUT:
============== | Executors.newSingleThreadExecutor() | ==============
CurrentThreadName: main
runnable1 CurrentThreadName: pool-1-thread-1
runnable2 CurrentThreadName: pool-1-thread-1
runnable3 CurrentThreadName: pool-1-thread-1
CurrentThreadName: main

// Always runnable1, runnable2 and runnable3 in sequence
_____________________________________________________________________________________________________*/
			
			

		Executor executor2 = Executors.newFixedThreadPool(2);
		executor2.execute(runnable1);
		executor2.execute(runnable2);



		Executor executor3 = Executors.newFixedThreadPool(2);
		executor3.execute(() -> {
			try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println(e);}
			System.out.println("Task2 executed by : " + Thread.currentThread().getName());
		});

			
	}
}







