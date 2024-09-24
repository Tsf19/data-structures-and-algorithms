package learning.java.concepts.miscellaneous;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestCustomException {

	public static void main(String[] args) throws Throwable {

		// Chained Exceptions:
		// In this example, the FileNotFoundException is the initial exception.
		// We create a new IOException and set the FileNotFoundException as its cause,
		// providing a more informative error message.
		try {
			// Open a file that doesn't exist
			FileReader reader = new FileReader("nonexistent.txt");
		} catch (FileNotFoundException e) {
			IOException wrappedException = new IOException("Failed to read file", e);
			throw wrappedException;
		}
		
		throw new MyCustomException("MyCustomException");
		//Output: Exception in thread "main" TestCustomException: MyCustomException
		// at learning.java.code.snippets.TestCustomException.main(TestCustomException.java:11)
	
	}
}


class MyCustomException extends Exception {
	
    public MyCustomException(String message) {
        super(message);
    }
}
