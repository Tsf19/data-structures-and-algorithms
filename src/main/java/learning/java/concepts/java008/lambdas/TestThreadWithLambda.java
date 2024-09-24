package learning.java.concepts.java008.lambdas;

//public class TestMainDriverClass {public static void main(String[] args) {}}

public class TestThreadWithLambda {
	
	static String string = "Hello";
	
	public void updateString() {
		
		System.out.println("I'm Thread " + Thread.currentThread().getId());
		
		int i = 0;
		while(i < 5) {
			string = string + Thread.currentThread().getId();
			i++;
			System.out.println(i + " string: " + string);
		}
	}
	
	public static void main(String[] args) {
		
		TestThreadWithLambda mainObj = new TestThreadWithLambda();
		
		//1.
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				mainObj.updateString();
			}
		});
		
		thread1.start();
		

		
		//2.
		Runnable runnable = () -> mainObj.updateString();
		Thread thread2 = new Thread(runnable);
		thread2.start();
		
		

		//3.
		Thread thread3 = new Thread(() -> mainObj.updateString());
		thread3.start();
		
		
		
		//4.
		new Thread(() -> mainObj.updateString()).start();
		
		System.out.println("Finished: " + string);
		
	}

}







