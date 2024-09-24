package designpattern._1_creational._001_singleton.example_01_;

public class EnumSingleton_2_Main {

	public static void main(String[] args) {
		
		EnumSingleton_1 instance = EnumSingleton_1.INSTANCE;
		instance.someMethod();
	
	}
}