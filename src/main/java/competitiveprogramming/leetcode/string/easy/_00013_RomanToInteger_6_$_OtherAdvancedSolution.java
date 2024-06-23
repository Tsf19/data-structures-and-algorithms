package competitiveprogramming.leetcode.string.easy;

public class _00013_RomanToInteger_6_$_OtherAdvancedSolution implements _00013_RomanToInteger_1_Problem {
    
// Its starting from the last number. So at most you get 3 times I before getting a V. If you have the num I and the answer is already higher than 4 it must be a number used as a negative.

	@Override
	public int romanToInt(String s) {
		
		int total = 0, value = 0;
		
		for (int i = s.length() - 1; i >= 0; i--) {
			
			switch(s.charAt(i)) {
				case 'I': value = 1; break;
				case 'V': value = 5; break;
				case 'X': value = 10; break;
				case 'L': value = 50; break;
				case 'C': value = 100; break;
				case 'D': value = 500; break;
				case 'M': value = 1000; break;
			}
			
			if (4 * value < total)
				total -= value;
			else
				total += value;
		}
		
		return total;
	}

}