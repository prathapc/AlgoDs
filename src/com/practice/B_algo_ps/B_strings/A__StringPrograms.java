package com.practice.B_algo_ps.B_strings;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

import java.util.*;

public class A__StringPrograms {

	public static void main(String[] args) {
		//noOfSubstringsStartAndEndWithOne("1100010101"); //efficient way:- count no of 1's and nc2 formula i.e n(n-1)/2
		//findSubstringsStartAndEndWithOne("1100010101"); // wrong o/p?
		//checkIfStringCanBeRepeatedByTwoPlaces();
		//romanCharacterToInteger();
		//decodePatternLookAndSaySequence();// 1 11 21 1211 111221 ?
		distinctOccurencesOfSubString();
	}

	/**
	 * Given a binary string, count number of substrings that start and end with 1.
	 * For example, if the input string is “00100101”, then there are three substrings “1001”, “100101” and “101”.
	 */
	private static void noOfSubstringsStartAndEndWithOne(String str) {
		noOfSubstringsStartAndEndWithOneUtil(str, "", 0);
	}

	private static void noOfSubstringsStartAndEndWithOneUtil(String str, String temp, int i) {
		if (i < str.length()) {
			if (str.charAt(i) == '1') {
				if (temp != "") {
					temp += "1";
					System.out.println(temp);
					noOfSubstringsStartAndEndWithOneUtil(str, temp, i+1);
				}
				noOfSubstringsStartAndEndWithOneUtil(str, "1", i+1);
			} else {
				if (temp != "") {
					temp += "0";
				}
				noOfSubstringsStartAndEndWithOneUtil(str, temp, i+1);
			}
		}
	}

	private static void findSubstringsStartAndEndWithOne(String str) {
		int count = 0;
		int n = str.length();
		System.out.println(findSubstringsStartAndEndWithOneUtil(str, 0, n - 1, count));
	}

	private static int findSubstringsStartAndEndWithOneUtil(String str, int start, int end, int count) {
		if (start == end)
			return count;
		if (str.charAt(start) == '0') {
			return findSubstringsStartAndEndWithOneUtil(str, start + 1, end, count);
		} else if (str.charAt(end) == '0') {
			return findSubstringsStartAndEndWithOneUtil(str, start, end - 1, count);
		} else {
			count++;
			System.out.println(str.substring(start, end + 1) + " start:" + start + "end:" + end);
			findSubstringsStartAndEndWithOneUtil(str, start + 1, end, count);
			findSubstringsStartAndEndWithOneUtil(str, start, end - 1, count);
		}
		return count;
	}

	/**
	 * Input  : S = banana, T = ban
	 Output : 3
	 T appears in S as below three subsequences.
	 [ban], [ba  n], [b   an]
	 */
	private static void distinctOccurencesOfSubString() {
		System.out.print(distinctOccurencesOfSubStringUtil1("banana","ban"));
	}

	private static int distinctOccurencesOfSubStringUtil1(String S, String T) {
      int m = T.length(), n = S.length();

      // T can't appear as a subsequence in S
      if (m > n)
        return 0;

      // mat[i][j] stores the count of occurrences of
      // T(1..i) in S(1..j).
      int[][] mat = new int[m + 1][n + 1];

      // Initializing first column with all 0s. An empty
      // string can't have another string as suhsequence
      for (int i = 1; i <= m; i++)
        mat[i][0] = 0;

      // Initializing first row with all 1s. An empty
      // string is subsequence of all.
      for (int j = 0; j <= n; j++)
        mat[0][j] = 1;

      // Fill mat[][] in bottom up manner
      for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          // If last characters don't match, then value
          // is same as the value without last character
          // in S.
          if (T.charAt(i - 1) != S.charAt(j - 1))
            mat[i][j] = mat[i][j - 1];

            // Else value is obtained considering two cases.
            // a) All substrings without last character in S
            // b) All substrings without last characters in
            // both.
          else
            mat[i][j] = mat[i][j - 1] + mat[i - 1][j - 1];
        }
      }

      Utility.printArray(mat, m+1, n+1);
      return mat[m][n];
	}

	// 1 11 21 1211 111221 ?
	private static void decodePatternLookAndSaySequence() {
		int k = 6; //find 5th number in the sequence i.e 312211 
		String result = "";
		String prevNum = "1";
		int count = 1;
		for(int i=2; i<=k; i++) {
			for(int p=0; p<prevNum.length(); p++) {
				
				if(p == prevNum.length()-1) {
					result = result+count+""+prevNum.charAt(p);
					count = 1;
				} else {
					if(prevNum.charAt(p+1) == prevNum.charAt(p)) {
						count++;
					} else {
						result = result+count+""+prevNum.charAt(p);
						count = 1;
					}
				}
				
			}
			prevNum = result;
			result = "";
		}
		result = prevNum;
		System.out.println(result);
	}

	private static void numberToRoman() {
		int number = 1453;

		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");
		int[] bases = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

		String stringNumber = "";
		for (int i : bases) {
			while (number >= i) {
				stringNumber = stringNumber + map.get(i);
				number = number - i;
			}
		}
		System.out.println(stringNumber);
	}

	private static void romanCharacterToInteger() {
		//String str = "MMCMLXXXV";
		String str = "CDMX";
		int result = romanCharToInt(str.charAt(str.length()-1));
		for(int i=str.length()-2; i>=0; i--) {
			if(romanCharToInt(str.charAt(i+1)) > romanCharToInt(str.charAt(i))) {
				result -= romanCharToInt(str.charAt(i));
			} else {
				result += romanCharToInt(str.charAt(i));
			}
		}
		System.out.println(result);
	}
	
	private static int romanCharToInt(char ch) {
		switch(ch) {
		case 'I': return 1;
		case 'V':return 5;
		case 'X':return 10;
		case 'L':return 50;
		case 'C':return 100;
		case 'D':return 500;
		case 'M':return 1000;
		}
		return 0;
	}

	private static boolean checkIfStringCanBeRepeatedByTwoPlaces() {
		String str1 = "amazon";
		String str2 = "onamaz";
		if (str1.length() != str2.length())
			return false;

		String clock_rot = "";
		String anticlock_rot = "";
		int len = str2.length();

		// Initialize string as anti-clockwise rotation
		anticlock_rot = anticlock_rot +
				str2.substring(len-2, len) +
				str2.substring(0, len-2) ;

		// Initialize string as clock wise rotation
		clock_rot = clock_rot +
				str2.substring(2) +
				str2.substring(0, 2) ;

		// check if any of them is equal to string1
		return (str1.equals(clock_rot) ||
				str1.equals(anticlock_rot));
	}
}