package competitiveprogramming.leetcode.string.easy;

import java.util.HashMap;
import java.util.Map;

public class _13_RomanToInteger_3_MyInitialSolution implements _13_RomanToInteger_1_Problem {

	@Override
	public int romanToInt(String s) {

		char[] inputStrArr = s.toCharArray();

		Map<Character, Integer> symbolMapValue = new HashMap<>();

		symbolMapValue.put('I', 1);
		symbolMapValue.put('V', 5);
		symbolMapValue.put('X', 10);
		symbolMapValue.put('L', 50);
		symbolMapValue.put('C', 100);
		symbolMapValue.put('D', 500);
		symbolMapValue.put('M', 1000);

		int length = inputStrArr.length;
		
		if (length == 1) {
			return symbolMapValue.get(inputStrArr[0]);
		}

		int total = 0;


		for (int i = 0; i < length; i++) {

			int currVal = symbolMapValue.get(inputStrArr[i]);

			int nextVal = 0;

			if (i == length - 1)
				nextVal = 0;
			else
				nextVal = symbolMapValue.get(inputStrArr[i + 1]);

			if (currVal < nextVal) {
				total = total + (nextVal - currVal);
				i++;
			} else
				total = total + currVal;

		}

		return total;
	}

}