package NarasimhaKarumanchi.Java._1_Recursion;

//import java.util.Scanner;

/**
 * @author Tousif
 *
 */
public class _1_Example_1_TreeRecursion {

	public static int fun(int n) {

		System.out.println("n is: " + n);

		if (n <= 1)
			return n;
		else
			return fun(n - 2) + 2 * fun(n - 3);
	}
	
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter: ");
//		int n = sc.nextInt();
		
		int n = 5;
		System.out.println(fun(n));
	
	}

}
