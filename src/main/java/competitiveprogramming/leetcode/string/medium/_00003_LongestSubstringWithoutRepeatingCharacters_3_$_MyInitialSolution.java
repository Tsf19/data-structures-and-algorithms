package competitiveprogramming.leetcode.string.medium;

public class _00003_LongestSubstringWithoutRepeatingCharacters_3_$_MyInitialSolution implements _00003_LongestSubstringWithoutRepeatingCharacters_1_$_Problem {

	@Override
	public int lengthOfLongestSubstring(String s) {
		System.out.println("========== Solution Class: " + this.getClass().getCanonicalName() + " ==========");

		if (s == null || s.length() == 0)
			return 0;

		if (s.length() == 1)
			return 1;

		int max = 1;
		String subStr = "";
		int n = s.length();

		for (int i = 0; i < n; i++) {

			subStr = subStr + s.charAt(i);

			max = subStr.length() > max ? subStr.length() : max;

			if (i + 1 < n && subStr.indexOf(s.charAt(i + 1)) != -1) {
				subStr = subStr.substring(subStr.indexOf(s.charAt(i + 1)) + 1, subStr.length());
			}

		}

		return max;
	}

}
