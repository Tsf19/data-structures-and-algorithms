package learning.java.concepts.miscellaneous;

public class TestFinalizeOverride {

	@Override
	protected void finalize() throws Throwable {
		
		try {
			System.out.println("inside demo's finalize()");
		} catch (Throwable e) {

			throw e;
		
		} finally {

			System.out.println("Calling finalize method of the Object class");
			// Calling finalize() of Object class
			super.finalize();
		}
	}

	public static void main(String[] args) throws Throwable {

		TestFinalizeOverride obj = new TestFinalizeOverride();

		obj.finalize();
	}
}




