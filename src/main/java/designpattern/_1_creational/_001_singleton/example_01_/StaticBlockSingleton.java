package designpattern._1_creational._001_singleton.example_01_;

/*public class EagerInitializedSingleton {

	// instance is final
	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

	// private constructor to avoid client applications using the constructor
	private EagerInitializedSingleton() {}

	public static EagerInitializedSingleton getInstance() {
		return instance;
	}
}*/

public class StaticBlockSingleton {

	private static StaticBlockSingleton instance;

	// private constructor to avoid client applications using the constructor
	private StaticBlockSingleton() {}

	// static block initialization for exception handling
	static {
		
		System.out.println("StaticBlockSingleton static block");
		
		System.out.println(Thread.currentThread().getName());
		try{Thread.sleep(2500);}catch(Exception e){}
		
		try {
			instance = new StaticBlockSingleton();
		} catch (Exception e) {
			throw new RuntimeException("Exception occurred in creating singleton instance");
		}
	}

	public static StaticBlockSingleton getInstance() {
		System.out.println("StaticBlockSingleton.getInstance()");
		return instance;
	}
}
