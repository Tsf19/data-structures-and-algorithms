package designpattern._1_creational._001_singleton.example_01_;

/*public class LazyInitializedSingleton {

	private static LazyInitializedSingleton instance;

	// private constructor to avoid client applications using the constructor
	private LazyInitializedSingleton() {}

	public static LazyInitializedSingleton getInstance() {

		System.out.println("LazyInitializedSingleton.getInstance()");
		if (instance == null) {
			
			System.out.println(Thread.currentThread().getName());
			try{Thread.sleep(500);}catch(Exception e){}
			
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}

}*/

public class ThreadSafeSingleton {

	private static ThreadSafeSingleton instance;

	// private constructor to avoid client applications using the constructor
	private ThreadSafeSingleton() {}

	public static synchronized ThreadSafeSingleton getInstance() {
		
		if (instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}

}