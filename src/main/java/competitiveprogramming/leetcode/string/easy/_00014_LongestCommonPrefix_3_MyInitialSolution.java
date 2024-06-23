package competitiveprogramming.leetcode.string.easy;

public class _00014_LongestCommonPrefix_3_MyInitialSolution implements _00014_LongestCommonPrefix_1_Problem {

	@Override
	public String longestCommonPrefix(String[] strs) {

		System.out.println("========== Solution Class: " + this.getClass().getCanonicalName() + " ==========");
		
		if (strs == null || strs.length == 0)
			return "";

		if (strs.length == 1)
			return strs[0];

		String result = "";

		char[] prefixArray = strs[0].toCharArray();

		for (int i = 1; i < strs.length; i++) {

			int prefixArrayLen = prefixArray.length;

			char[] str2Array = strs[i].toCharArray();
			int str2ArrayLen = str2Array.length;

			if (prefixArrayLen == 0 || str2ArrayLen == 0)
				return "";

			int n = prefixArrayLen < str2ArrayLen ? prefixArrayLen : str2ArrayLen;

			String subString = "";

			for (int j = 0; j < n; j++) {

				if (prefixArray[j] == str2Array[j])
					subString = subString + prefixArray[j];
				else
					break;
			}

			result = subString;
			prefixArray = subString.toCharArray();
		}

		return result;
	}

}
