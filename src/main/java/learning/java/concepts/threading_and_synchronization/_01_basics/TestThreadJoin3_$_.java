package learning.java.concepts.threading_and_synchronization._01_basics;

import org.junit.Ignore;

/**
 * Demonstrates Thread.join behavior.
 *
 */
public class TestThreadJoin3_$_ {

	static class SampleThread extends Thread {

		public int processingCount;

		SampleThread(int processingCount) {
			this.processingCount = processingCount;
			System.out.println("Thread " + this.getName() + " created");
		}

		@Override
		public void run() {

			System.out.println("Thread " + this.getName() + " started");

			while (processingCount > 0) {

				// Simulate some work being done by thread
				try {Thread.sleep(500);}
				catch (InterruptedException e) {System.out.println("Thread " + this.getName() + " interrupted.");}
				
				processingCount--;
				System.out.println("Inside Thread " + this.getName() + ", processingCount = " + processingCount);
			
			}

			System.out.println("Thread " + this.getName() + " exiting");
		}
	}

	public static void main(String[] args) throws InterruptedException {

		TestThreadJoin3_$_ obj = new TestThreadJoin3_$_();

		obj.givenNewThread_whenJoinCalled_returnsImmediately();

		obj.givenStartedThread_whenJoinCalled_waitsTillCompletion();

		obj.givenStartedThread_whenTimedJoinCalled_waitsUntilTimedout();

		// obj.givenThreadTerminated_checkForEffect_notGuaranteed();

		obj.givenJoinWithTerminatedThread_checkForEffect_guaranteed();

	}

	public void givenNewThread_whenJoinCalled_returnsImmediately() throws InterruptedException {

		System.out.println("----- givenNewThread_whenJoinCalled_returnsImmediately -----");

		Thread t1 = new SampleThread(0);
		System.out.println("1. Thread t1 state is" + t1.getState());
		System.out.println("t1 Invoking join");
		t1.join();
		System.out.println("t1 Returned from join");
		System.out.println("t1.isAlive(): " + t1.isAlive());
		System.out.println("2. Thread t1 state is" + t1.getState());
	}

	public void givenStartedThread_whenJoinCalled_waitsTillCompletion() throws InterruptedException {

		System.out.println("----- givenStartedThread_whenJoinCalled_waitsTillCompletion -----");

		Thread t2 = new SampleThread(1);
		t2.start();
		System.out.println("1. Thread t2 state is" + t2.getState());
		System.out.println("t2 Invoking join");
		t2.join();
		System.out.println("t2 Returned from join");
		System.out.println("t2.isAlive(): " + t2.isAlive());
		System.out.println("2. Thread t2 state is" + t2.getState());
	}

	public void givenStartedThread_whenTimedJoinCalled_waitsUntilTimedout() throws InterruptedException {

		System.out.println("----- givenStartedThread_whenTimedJoinCalled_waitsUntilTimedout -----");

		Thread t3 = new SampleThread(10);
		t3.start();
		System.out.println("1. Thread t3 state is" + t3.getState());
		System.out.println("t3 Invoking join");
		t3.join(1000);
		System.out.println("t3 Returned from join");
		System.out.println("t3.isAlive(): " + t3.isAlive());
		System.out.println("2. Thread t3 state is" + t3.getState());
	}

	@Ignore
	public void givenThreadTerminated_checkForEffect_notGuaranteed() throws InterruptedException {

		System.out.println("----- givenNewThread_whenJoinCalled_returnsImmediately -----");

		SampleThread t4 = new SampleThread(10);
		t4.start();
		// not guaranteed to stop even if t4 finishes.
		do {

		} while (t4.processingCount > 0);
		
		System.out.println("1. Thread t4 state is" + t4.getState());
		System.out.println("t4.isAlive(): " + t4.isAlive());
	}

	public void givenJoinWithTerminatedThread_checkForEffect_guaranteed() throws InterruptedException {

		System.out.println("----- givenJoinWithTerminatedThread_checkForEffect_guaranteed -----");

		SampleThread t5 = new SampleThread(10);
		t5.start();
		do {
			System.out.println("1. Thread t5 state is" + t5.getState());
			System.out.println("t5 Invoking join");
			t5.join(100);
			System.out.println("t5 Returned from join");
			System.out.println("t5.isAlive(): " + t5.isAlive());
			System.out.println("2. Thread t5 state is" + t5.getState());
		} while (t5.processingCount > 0);
		
	}

}