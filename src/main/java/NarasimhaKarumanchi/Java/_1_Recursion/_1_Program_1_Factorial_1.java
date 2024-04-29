package NarasimhaKarumanchi.Java._1_Recursion;

import java.util.Scanner;

/**
 * @author Tousif
 *
 */
public class _1_Program_1_Factorial_1 {

	public static int factorial(int number) {

		System.out.println("n is: " + number);

		if (number == 0)
			return 1;
		else
			return number * factorial(number - 1);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter: ");
	
		int number = sc.nextInt();
		System.out.println(factorial(number));
	
	}

}
