package NarasimhaKarumanchi.Java._3_Stacks._4_StackProblemsAndSolutions;

public interface StackService <T> {

	int size();

	boolean isEmpty();

	T top() throws Exception;

	void push(T data);

	T pop() throws Exception;

}
