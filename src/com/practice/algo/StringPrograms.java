package com.practice.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StringPrograms {

	public static void main(String[] args) {
		// noOfSubstringsStartAndEndWithOne(); //count no of 1's and nc2 formula
		// i.e n(n-1)/2
		//findSubstringsStartAndEndWithOne(); // wrong o/p
		//checkIfStringCanBeRepeatedByTwoPlaces();
		//romanCharacterToInteger();
		//decodePatternLookAndSaySequence();// 1 11 21 1211 111221 ?
		distinctOccurencesOfSubString();

		//deleteCharactersToMakeAnagrams();
		//sherlockStrings();
		//alphaNumericPalindrom("A man, a plan, a canal: Panama");

	
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

	private static void deleteCharactersToMakeAnagrams() {
		Scanner s = new Scanner(System.in);
		String str1 = s.next().toLowerCase();
		String str2 = s.next().toLowerCase();

		int a[] = new int[26];
		int b[] = new int[26];

		int result = 0;
		for (int i = 0; i < str1.length(); i++) {
			a[str1.charAt(i)-'a']++;
		}

		for (int i = 0; i < str2.length(); i++) {
			b[str2.charAt(i)-'a']++;
		}

		for(int j = 0; j<26; j++) {
			result += Math.abs(a[j] - b[j]);
		}

		if(result != 0) {
			System.out.println(result);
		}else {
			System.out.println("TWO STRINGS ARE ALREADY ANAGRAMS");
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
		int[][] table = new int[S.length() + 1][T.length() + 1];

		for (int i = 0; i < S.length(); i++)
			table[i][0] = 1;

		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					table[i][j] += table[i - 1][j] + table[i - 1][j - 1];
				} else {
					table[i][j] += table[i - 1][j];
				}
			}
		}
		return table[S.length()][T.length()];
	}

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


	private static void romanCharacterToInteger() {
		String str = "MMCMLXXXV";
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

	private static void findSubstringsStartAndEndWithOne() {
		String str = "001001010101";
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
}