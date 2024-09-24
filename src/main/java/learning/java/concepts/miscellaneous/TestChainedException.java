package learning.java.concepts.miscellaneous;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestChainedException {

	public static void main(String[] args) throws Throwable {

		// Chained Exceptions:
		// In this example, the FileNotFoundException is the initial exception.
		// We create a new IOException and set the FileNotFoundException as its cause,
		// providing a more informative error message.
		/**try {
			// Open a file that doesn't exist
			FileReader reader = new FileReader("nonexistent.txt");
		} catch (FileNotFoundException e) {
			IOException wrappedException = new IOException("Failed to read file", e);
			throw wrappedException;
		}*/
		
		try {
			// Creating an exception
			NumberFormatException ex = new NumberFormatException("Exception");

			// Setting a cause of the exception
			ex.initCause(new NullPointerException("This is actual cause of the exception"));

			// Throwing an exception with cause.
			throw ex;
		
		} catch (NumberFormatException ex) {
			// displaying the exception
			System.out.println(ex);

			// Getting the actual cause of the exception
			System.out.println(ex.getCause());
		}
	
		// java.lang.NumberFormatException: Exception
		// java.lang.NullPointerException: This is actual cause of the exception
	}
}


