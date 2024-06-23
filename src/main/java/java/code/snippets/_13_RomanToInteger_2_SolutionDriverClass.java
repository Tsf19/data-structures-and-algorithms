//package java.code.snippets;
//
//import java.util.HashMap;
//import java.util.Map;
//
//class _13_RomanToInteger_2_SolutionDriverClass {
//
//	
//	public static void main(String[] args) {
//
//		_13_RomanToInteger_1_Problem solution = new _13_RomanToInteger_3_MyInitialSolution();
//
////    	System.out.println(solution.romanToInt("III")); // Output: 3
//    	System.out.println(solution.romanToInt("IV")); // Output: 4
//        System.out.println(solution.romanToInt("LVIII")); // Output: 58
//        System.out.println(solution.romanToInt("MCMXCIV")); // Output: 1994 // M:1000 
//		
////        *  Symbol       Value
////        *  I             1
////        *  V             5
////        *  X             10
////        *  L             50
////        *  C             100
////        *  D             500
////        *  M             1000
//        
//	}
//
//}
//
//class _13_RomanToInteger_3_MyInitialSolution implements _13_RomanToInteger_1_Problem {
//
//	@Override
//	public int romanToInt(String s) {
//
//		char[] inputStrArr = s.toCharArray();
//
//		Map<Character, Integer> symbolMapValue = new HashMap<>();
//
//		symbolMapValue.put('I', 1);
//		symbolMapValue.put('V', 5);
//		symbolMapValue.put('X', 10);
//		symbolMapValue.put('L', 50);
//		symbolMapValue.put('C', 100);
//		symbolMapValue.put('D', 500);
//		symbolMapValue.put('M', 1000);
//
//		int length = inputStrArr.length;
//		
//		if (length == 1) {
//			return symbolMapValue.get(inputStrArr[0]);
//		}
//
//		int sum = 0;
//
//
//		for (int i = 0; i < length; i++) {
//
//			int currVal = symbolMapValue.get(inputStrArr[i]);
//
//			int nextVal = 0;
//
//			if (i == length - 1)
//				nextVal = 0;
//			else
//				nextVal = symbolMapValue.get(inputStrArr[i + 1]);
//
//			if (currVal < nextVal) {
//				sum = sum + (nextVal - currVal);
//				i++;
//			} else
//				sum = sum + currVal;
//
//		}
//
//		return sum;
//	}
//
//	
//	
//	
//	
//    public int romanToInt2(String s) {
//    	
//        Map<Character, Integer> m = new HashMap<>();
//        
//        m.put('I', 1);
//        m.put('V', 5);
//        m.put('X', 10);
//        m.put('L', 50);
//        m.put('C', 100);
//        m.put('D', 500);
//        m.put('M', 1000);
//        
//        int ans = 0;
//        
//        for (int i = 0; i < s.length(); i++) {
//            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
//                ans -= m.get(s.charAt(i));
//            } else {
//                ans += m.get(s.charAt(i));
//            }
//        }
//        
//        return ans;
//    }
//	
//    
//    
////    Its starting from the last number. So at most you get 3 times I before getting a V. If you have the num I and the answer is already higher than 4 it must be a number used as a negative.
//    
//    public int romanToInt(String s) {
//        int ans = 0, num = 0;
//       for (int i = s.length()-1; i >= 0; i--) {
//           switch(s.charAt(i)) {
//               case 'I': num = 1; break;
//               case 'V': num = 5; break;
//               case 'X': num = 10; break;
//               case 'L': num = 50; break;
//               case 'C': num = 100; break;
//               case 'D': num = 500; break;
//               case 'M': num = 1000; break;
//           }
//           if (4 * num < ans) ans -= num;
//           else ans += num;
//       }
//       return ans;
//   
//    
//    
//    
//       public int romanToInt(String s) {
//           
//           int total = 0, previous = 0;
//           //Read from Right to Left
//           for (int i = s.length() - 1; i >= 0; i--) {
//
//               var current = switch (s.charAt(i)) {
//                   case 'I' -> 1;
//                   case 'V' -> 5;
//                   case 'X' -> 10;
//                   case 'L' -> 50;
//                   case 'C' -> 100;
//                   case 'D' -> 500;
//                   case 'M' -> 1000;
//                   default -> 0;
//               };
//
//               if (previous > current) { // 4 = IV, 9 = IX for example
//                   total -= current;
//               } else {
//                   total += current; // 6 = VI, 11 = XI for example
//                   previous = current;
//               }
//           }
//
//           return total;
//       }
//    
//    
//    
//}

//int _no_prefix_decimal = 45;
//		System.out.println("_no_prefix_decimal 45 : " + _no_prefix_decimal); // _no_prefix_decimal 45 : 45
//		System.out.println("45 : " + 45); // 45 : 45
//		
//		int _0_prefix_octal = 045;
//		System.out.println("_0_prefix_octal 045 : " + _0_prefix_octal); // _0_prefix_octal 045 : 37
//		System.out.println("045 : " + 045); // 045 : 37
//		
//		int _0x_prefix_hexadecimal = 0x45;
//		System.out.println("_0x_prefix_hexadecimal 0x45 : " + _0x_prefix_hexadecimal); // _0x_prefix_hexadecimal 0x45 : 69
//		System.out.println("0x45 : " + 0x45); // 0x45 : 69
//		
//		int _0X_hexadecimal = 0X45;
//		System.out.println("_0X_hexadecimal 0X45 : " + _0X_hexadecimal); // _0X_hexadecimal 0X45 : 69
//		System.out.println("0X45 : " + _0X_hexadecimal); // 0X45 : 69
//		
//		int _0b_binary = 0b01000101;
//		System.out.println("_0b_binary 0b01000101 : " + _0b_binary); // _0b_binary 0b01000101 : 69
//		System.out.println("0b01000101 : " + _0b_binary); // 0b01000101 : 69
//		
//		int _0B_binary = 0B01000101;
//		System.out.println("_0b_binary 0B01000101 : " + _0B_binary); // _0b_binary 0B01000101 : 69
//		System.out.println("0B01000101 : " + _0B_binary); // 0B01000101 : 69

//		System.out.println("this.getClass().getCanonicalName(): " + this.getClass().getCanonicalName());
//		System.out.println("this.getClass().getName(): " + this.getClass().getName());
//		System.out.println("this.getClass().getTypeName(): " + this.getClass().getTypeName());
//		System.out.println("this.getClass().getSimpleName(): " + this.getClass().getSimpleName());

		/** NOTE:
		 indexOf():
		  
		 Variants:
		 - int indexOf(int ch) // ch: An int value representing a character (Unicode code point) to search for.
		 - int indexOf(int ch, int fromIndex)
		 - int indexOf(String str)
		 - int indexOf(String str, int fromIndex)
		 - int indexOf(int ch, int beginIndex, int endIndex)
		 - int indexOf(String str, int beginIndex, int endIndex)
		  
		 indexOf(String str):
		 Returns the index within this string of the first occurrence of the specified substring. 
		 The returned index is the smallest value k for which: this.startsWith(str, k)
		 If no such value of k exists, then -1 is returned.
		  
		 Tip: Use the lastIndexOf method to return the position of the last occurrence of specified character(s) in a string. */
