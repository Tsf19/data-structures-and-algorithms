package NarasimhaKarumanchi.Java._1_Recursion;

//import java.util.Scanner;

/**
 * @author Tousif
 *
 */
public class _1_Example_1_Recursion {

	public static void fun(int n, int sum) {

		System.out.println("n: " + n + ", sum: " + sum);

		int k = 0, j = 0;

		if (n == 0)
			return;

		k = n % 10;
		j = n / 10;

		sum = sum + k;

		fun(j, sum);

		System.out.println("_");
		System.out.print(k + ", ");
	}

	public static void main(String[] args) {

		int a = 2048, sum = 0;
		fun(2048, 0);
		System.out.print("sum: " + sum);

	}

}
