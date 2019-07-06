package NarasimhaKarumanchi.Java._3_Stacks._4_StackProblemsAndSolutions;

public class _6_StackReversalUsingRecursion {

	static StackService<Character> stack = new StackServiceImplementation<>();

	public static void reverseStack() throws Exception{

		if(stack.isEmpty())
			return;
		char temp = stack.pop();
		reverseStack();
		insertAtBottom(temp);
	}

	private static void insertAtBottom(char data) throws Exception {
		if(stack.isEmpty()) {
			stack.push(data);
		}else {
			char temp = stack.pop();
			insertAtBottom(data);
			stack.push(temp);
		}
	}


	public static void main(String[] args) throws Exception {

		stack.push('A');
		stack.push('B');
		stack.push('C');
		stack.push('D');
		System.out.println(stack.toString());
		reverseStack();
		System.out.println(stack.toString());
	}

}
