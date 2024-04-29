package NarasimhaKarumanchi.Java._1_Recursion;

//import java.util.Scanner;

/**
 * @author Tousif
 *
 */
public class _1_Example_1_RecursionWithStatic {

	static int n = 3;
	
	public static void fun() {

		++n;
		System.out.print(n + ", ");
		
		if (n <= 5)
			fun();
		
		System.out.print(n + "; ");
	}
	
	public static void main(String[] args) {
		
		fun(); // n = 3 --> 4, 5, 6, 6; 6; 6; 
	
	}

}
