package designpattern._1_creational._001_singleton.example_01_;

/**
Notice the private inner static class that contains the instance of the singleton class.
When the singleton class is loaded, SingletonHelper class is not loaded into memory
and only when someone calls the getInstance() method, this class gets loaded and
creates the singleton class instance.
This is the most widely used approach for the singleton class as it doesn’t require synchronization.
*/
public class BillPughSingleton {

	// Private constructor prevents instantiation from other classes
	private BillPughSingleton() {
		// Initialization code here
	}

	// Static inner class - inner classes are not loaded until they are referenced
	private static class SingletonHelper {
		// Static to ensure only one instance is created
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}

	// Global point of access
	public static BillPughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
}
