package designpattern._1_creational._001_singleton.example_01_;

/*public class ThreadSafeSingleton {

	private static ThreadSafeSingleton instance;

	// private constructor to avoid client applications using the constructor
	private ThreadSafeSingleton() {}

	public static synchronized ThreadSafeSingleton getInstance() {
		
		if (instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}

}*/

public class ThreadSafeDoubleCheckedLockingSingleton {

	private static volatile ThreadSafeDoubleCheckedLockingSingleton instance;

	// private constructor to avoid client applications using the constructor
	private ThreadSafeDoubleCheckedLockingSingleton() {}

	public static ThreadSafeDoubleCheckedLockingSingleton getInstance() {
		
	    if (instance == null) { // First check (no locking)
	    	
	        synchronized (ThreadSafeDoubleCheckedLockingSingleton.class) {
	        	
	            if (instance == null) { // Second check (with locking)
	                instance = new ThreadSafeDoubleCheckedLockingSingleton();
	            }
	        }
	    }
	    return instance;
	}
}