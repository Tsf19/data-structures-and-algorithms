/**
 * 
 */
package designpattern._1_creational._001_singleton.example_01_;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Tousif
 *
 */

public class SingletonApp {

	public static void main(String[] args) {
		
		SingletonApp obj = new SingletonApp();
		obj.nonStaticTest();
		
	}
	
	public void nonStaticTest() {

		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		System.out.println("_____________________________________________________________________");
		System.out.println("============== | Example of LazyInitializedSingleton | ==============");
//		LazyInitializedSingleton lazyInitializedSingleton = LazyInitializedSingleton.getInstance();
		
		executor.execute(() -> System.out.println(LazyInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(LazyInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(LazyInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(LazyInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(LazyInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(LazyInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(LazyInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(LazyInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(LazyInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(LazyInitializedSingleton.getInstance().hashCode()));

/*_____________________________________________________________________________________________________
OUTPUT:
============== | LazyInitializedSingleton | ==============
pool-1-thread-1
pool-1-thread-2
1660260469
1464020234
1464020234
_____________________________________________________________________________________________________*/
		
		try{Thread.sleep(700);}catch(Exception e){}
		System.out.println("_____________________________________________________________________");
		System.out.println("============== | Example of EagerInitializedSingleton | ==============");
//		EagerInitializedSingleton eagerInitializedSingleton = EagerInitializedSingleton.getInstance();
		
		executor.execute(() -> System.out.println(EagerInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(EagerInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(EagerInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(EagerInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(EagerInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(EagerInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(EagerInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(EagerInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(EagerInitializedSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(EagerInitializedSingleton.getInstance().hashCode()));
		
		
		
		try{Thread.sleep(700);}catch(Exception e){}
		System.out.println("_____________________________________________________________________");
		System.out.println("============== | Example of StaticBlockSingleton | ==============");
//		StaticBlockSingleton staticBlockSingleton = StaticBlockSingleton.getInstance();
		executor.execute(() -> System.out.println(StaticBlockSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(StaticBlockSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(StaticBlockSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(StaticBlockSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(StaticBlockSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(StaticBlockSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(StaticBlockSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(StaticBlockSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(StaticBlockSingleton.getInstance().hashCode()));
		executor.execute(() -> System.out.println(StaticBlockSingleton.getInstance().hashCode()));
		
		executor.shutdown();

		
	}
}