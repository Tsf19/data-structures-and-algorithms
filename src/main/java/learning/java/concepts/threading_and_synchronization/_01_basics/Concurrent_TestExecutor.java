package learning.java.concepts.threading_and_synchronization._01_basics;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

//public class TestMainDriverClass {public static void main(String[] args) {}}


	
/**_____________________________________________________________________________________________________*/
/** java.util.concurrent.Executor:
An object that executes submitted Runnable tasks. This interface provides a way of decoupling 
task submission from the mechanics of how each task will be run, including details of 
thread use, scheduling, etc.

An Executor is normally used instead of explicitly creating threads.
For example, rather than invoking new Thread(new RunnableTask()).start() for each of a set of tasks,
you might use:

Executor executor = anExecutor();
executor.execute(new RunnableTask1());
executor.execute(new RunnableTask2());
...
the Executor interface does not strictly require that execution be asynchronous.
In the simplest case, an executor can run the submitted task immediately in the caller's thread:


More typically, tasks are executed in some thread other than thecaller's thread.
The executor below spawns a new thread for each task.

class ThreadPerTaskExecutor implements Executor {
	public void execute(Runnable r) {
 	new Thread(r).start();
	}
}

Many Executor implementations impose some sort of limitation on how and when tasks are scheduled.
The executor below serializes the submission of tasks to a second executor,
illustrating a composite executor.

class SerialExecutor implements Executor {

	final Queue<Runnable> tasks = new ArrayDeque<>();
	final Executor executor;
	Runnable active;

	SerialExecutor(Executor executor) {
 		this.executor = executor;
	}

	public synchronized void execute(Runnable r) {
 		tasks.add(() -> {
   		...
}

The Executor implementations provided in this package implement ExecutorService,
which is a more extensive interface.

The ThreadPoolExecutor class provides an extensible thread pool implementation.
The Executors class provides convenient factory methods for these Executors. 
*/
/**_____________________________________________________________________________________________________*/
public class Concurrent_TestExecutor {
	
	public static void main(String[] args) {

/**_____________________________________________________________________________________________________
Executors.newSingleThreadExecutor():
Creates an Executor that uses a single worker thread operating off an unbounded queue.

(Note however that if this single thread terminates due to a failure during execution prior to
shutdown, a new one will take its place if needed to execute subsequent tasks.)

Tasks are guaranteed to execute sequentially, and no more than one task will be active at any
given time.

Unlike the otherwise equivalent newFixedThreadPool(1) the returned executor is guaranteed not to be
reconfigurable to use additional threads.

Returns:the newly created single-threaded Executor
_____________________________________________________________________________________________________*/
		Executor singleThreadExecutor = Executors.newSingleThreadExecutor();
		

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

			
/**_____________________________________________________________________________________________________
void execute(Runnable command):
Executes the given command at some time in the future.
The command may execute in a new thread, in a pooled thread, or in the calling thread,
at the discretion of the Executor implementation.

@throws RejectedExecutionException if this task cannot be accepted for execution
@throws NullPointerException if command is null
_____________________________________________________________________________________________________*/
		
		System.out.println("_____________________________________________________________________");
		System.out.println("============== | Executors.newSingleThreadExecutor() | ==============");

		System.out.println("CurrentThreadName: " + Thread.currentThread().getName());
		try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println(e);}

		singleThreadExecutor.execute(runnable1);
		singleThreadExecutor.execute(runnable2);
		singleThreadExecutor.execute(runnable3);

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


		try {Thread.sleep(2500);} catch (InterruptedException e) {System.out.println(e);}

		System.out.println("_____________________________________________________________________");
		System.out.println("============== | Executors.newFixedThreadPool(1) | ==============");

		Executor fixedThreadPoolExecutor = Executors.newFixedThreadPool(1);

		System.out.println("CurrentThreadName: " + Thread.currentThread().getName());
		try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println(e);}

		fixedThreadPoolExecutor.execute(runnable1);
		fixedThreadPoolExecutor.execute(runnable2);
		fixedThreadPoolExecutor.execute(runnable3);

		try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println(e);}
		System.out.println("CurrentThreadName: " + Thread.currentThread().getName());
/*_____________________________________________________________________________________________________
OUTPUT:
============== | Executors.newFixedThreadPool(1) | ==============
CurrentThreadName: main
runnable1 CurrentThreadName: pool-2-thread-1
runnable2 CurrentThreadName: pool-2-thread-1
runnable3 CurrentThreadName: pool-2-thread-1
CurrentThreadName: main

// Always runnable1, runnable2 and runnable3 in sequence
_____________________________________________________________________________________________________*/
			
			
		try {Thread.sleep(2500);} catch (InterruptedException e) {System.out.println(e);}

		System.out.println("_____________________________________________________________________");
		System.out.println("============== | Executors.newFixedThreadPool(2) | ==============");

		Executor fixedThreadPoolExecutor2 = Executors.newFixedThreadPool(2);

		System.out.println("CurrentThreadName: " + Thread.currentThread().getName());
		try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println(e);}

		fixedThreadPoolExecutor2.execute(runnable1);
		fixedThreadPoolExecutor2.execute(runnable2);
		fixedThreadPoolExecutor2.execute(runnable3);

		try {Thread.sleep(500);} catch (InterruptedException e) {System.out.println(e);}
		System.out.println("CurrentThreadName: " + Thread.currentThread().getName());
/*_____________________________________________________________________________________________________
OUTPUT:
============== | Executors.newFixedThreadPool(2) | ==============
CurrentThreadName: main
runnable2 CurrentThreadName: pool-3-thread-2
runnable1 CurrentThreadName: pool-3-thread-1
runnable3 CurrentThreadName: pool-3-thread-2
CurrentThreadName: main

// runnable2, runnable1 and runnable3: sequence not fixed
_____________________________________________________________________________________________________*/
			
	}
}







