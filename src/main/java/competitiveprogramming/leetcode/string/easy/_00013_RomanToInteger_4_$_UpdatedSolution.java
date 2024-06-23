package competitiveprogramming.leetcode.string.easy;

import java.util.HashMap;
import java.util.Map;

public class _00013_RomanToInteger_4_$_UpdatedSolution implements _00013_RomanToInteger_1_Problem {

	@Override
	public int romanToInt(String s) {

		Map<Character, Integer> symbolMapValue = new HashMap<>();

		symbolMapValue.put('I', 1);
		symbolMapValue.put('V', 5);
		symbolMapValue.put('X', 10);
		symbolMapValue.put('L', 50);
		symbolMapValue.put('C', 100);
		symbolMapValue.put('D', 500);
		symbolMapValue.put('M', 1000);

		int total = 0;

		for (int i = 0; i < s.length(); i++) {

			if (i < s.length() - 1 && symbolMapValue.get(s.charAt(i)) < symbolMapValue.get(s.charAt(i + 1)))
				total -= symbolMapValue.get(s.charAt(i));
			else
				total += symbolMapValue.get(s.charAt(i));
		}

		return total;
	}

}