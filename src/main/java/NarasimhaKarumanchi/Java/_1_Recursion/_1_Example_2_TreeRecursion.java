package NarasimhaKarumanchi.Java._1_Recursion;

//import java.util.Scanner;

/**
 * @author Tousif
 *
 */
public class _1_Example_2_TreeRecursion {

	public static void fun(int n) {

		if (n <= 0)
			return;
		
		fun(n - 1);
		fun(n - 2);
		
		System.out.print(n + ", ");
	}
	
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter: ");
//		int n = sc.nextInt();
		
		int n = 4;
		fun(n);
	
	}

}
