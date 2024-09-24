package learning.java.concepts.java008.lambdas;

//public class TestMainDriverClass {public static void main(String[] args) {}}

interface TstFnctnlInrfc {
    
    public int strLength(String str);
    
}

public class TestMethodToLambdaSteps {
	
	public static void main (String[] args) {
		
		TstFnctnlInrfc test;
		
		 test = (String str) -> { return str.length();};
		 
         test = (str) -> { return str.length();}; // Removed argument data type
	   
        //test = (str) -> return str.length(); // Error: Removed body but not return statement
         
        test = (str) -> str.length(); // Removed return statement
        
        test = str -> str.length(); // Removed argument parenthesis
	    
	    System.out.println("length of str as int : " + test.strLength("Test"));
		
	}

}







