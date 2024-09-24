package designpattern._1_creational._001_singleton.example_01_;

public class EagerInitializedSingleton {

	// instance is final
	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

	// private constructor to avoid client applications using the constructor
	private EagerInitializedSingleton() {
	}

	public static EagerInitializedSingleton getInstance() {
		System.out.println("EagerInitializedSingleton.getInstance()");
		return instance;
	}
}