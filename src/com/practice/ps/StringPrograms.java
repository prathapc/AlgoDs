package com.practice.ps;

import java.util.*;

public class StringPrograms {

	public static void main(String[] args) {
		//noOfSubstringsStartAndEndWithOne("1100010101"); //efficient way:- count no of 1's and nc2 formula i.e n(n-1)/2
		//findSubstringsStartAndEndWithOne("1100010101"); // wrong o/p?

		//checkIfStringCanBeRepeatedByTwoPlaces();
		//romanCharacterToInteger();
		//decodePatternLookAndSaySequence();// 1 11 21 1211 111221 ?
		//distinctOccurencesOfSubString();
		//sherlockStrings();
		//alphaNumericPalindrom("A man, a plan, a canal: Panama");
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

	private static int alphaNumericPalindrom(String a) {
		a = a.toLowerCase();
		char[] c = a.toCharArray();

		int start = 0, end = c.length-1;

		while(start<end) {
			int startAsciiValue = (int) c[start];
			int endAsciiValue = (int) c[end];

			if(!((startAsciiValue >= 48 && startAsciiValue<=57) || (startAsciiValue>= 65 && startAsciiValue<=90) || (startAsciiValue >= 97 && startAsciiValue<= 122))) {
				start++;
				continue;
			}

			if(!((endAsciiValue >= 48 && endAsciiValue<=57) || (endAsciiValue>= 65 && endAsciiValue<=90) || (endAsciiValue >= 97 && endAsciiValue<= 122))) {
				end--;
				continue;
			}

			if(startAsciiValue != endAsciiValue) {
				return 0;
			}
			start++;
			end--;

		}
		return 1;
	}

	//https://github.com/RyanFehr/HackerRank/blob/master/Algorithms/Strings/Sherlock%20and%20Valid%20String/Solution.java
	//Note:: Output is wrong for "abcccc"
	private static void sherlockStrings() {
		Scanner scan = new Scanner(System.in);
		String watson = scan.nextLine();
		Map<Character, Integer> countChar = new HashMap<>();
		Map<Integer, Integer> countCount = new HashMap<>();
		int length = watson.length();
		int i;
		for (i = 0; i < length; i++) {
			char c = watson.charAt(i);
			if (countChar.containsKey(c)) {
				countChar.put(c, countChar.get(c) + 1);
			} else {
				countChar.put(c, 1);
			}
		}

		for(Map.Entry<Character, Integer> entry : countChar.entrySet()){
			if(countCount.containsKey(entry.getValue())){
				countCount.put(entry.getValue(), countCount.get(entry.getValue())+1);
			}
			else{
				countCount.put(entry.getValue(), 1);
			}

		}
		if(countCount.size() == 1){
			System.out.println("YES");
		}
		else if(countCount.size() == 2){
			if(countCount.containsValue(1)){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
		else{
			System.out.println("NO");
		}
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

		List<String> stringNumbers = new ArrayList<>();

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
		int result = 0;
		for(int i=str.length()-1; i>=0; i--) {
			if(i==str.length()-1) {
				result += romanCharToInt(str.charAt(i));
			} else {
				if(romanCharToInt(str.charAt(i+1)) > romanCharToInt(str.charAt(i))) {
					result -= romanCharToInt(str.charAt(i));
				} else {
					result += romanCharToInt(str.charAt(i));
				}
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