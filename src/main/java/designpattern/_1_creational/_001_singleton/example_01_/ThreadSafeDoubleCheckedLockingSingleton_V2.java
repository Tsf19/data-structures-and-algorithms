package designpattern._1_creational._001_singleton.example_01_;

/*public class ThreadSafeDoubleCheckedLockingSingleton {

	private static volatile ThreadSafeDoubleCheckedLockingSingleton instance;

	// private constructor to avoid client applications using the constructor
	private ThreadSafeDoubleCheckedLockingSingleton() {}

	public static ThreadSafeDoubleCheckedLockingSingleton getInstance() {
		
	    if (instance == null) {
	    	
	        synchronized (ThreadSafeDoubleCheckedLockingSingleton.class) {
	        	
	            if (instance == null) {
	                instance = new ThreadSafeDoubleCheckedLockingSingleton();
	            }
	        }
	    }
	    return instance;
	}
}*/
public class ThreadSafeDoubleCheckedLockingSingleton_V2 {

	private static volatile ThreadSafeDoubleCheckedLockingSingleton_V2 instance;
	private static Object mutex = new Object();

	// private constructor to avoid client applications using the constructor
	private ThreadSafeDoubleCheckedLockingSingleton_V2() {}

	public static ThreadSafeDoubleCheckedLockingSingleton_V2 getInstance() {
		
		// instance is volatile
		ThreadSafeDoubleCheckedLockingSingleton_V2 result = instance;
		
		if (result == null) { // First check (no locking)
			
			synchronized (mutex) {
				
				result = instance;
				
				if (result == null) // Second check (with locking)
					instance = result = new ThreadSafeDoubleCheckedLockingSingleton_V2();
			
			}
		
		}
		
		return result;
	}

/**
The local variable result seems unnecessary.
But, it’s there to improve the performance of our code.
In cases where the instance is already initialized (most of the time),
the volatile field is only accessed once (due to “return result;” instead of “return instance;”).
This can improve the method’s overall performance by as much as 25 percent.*/
}