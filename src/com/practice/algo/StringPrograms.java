package com.practice.algo;

import java.util.ArrayList;
import java.util.List;
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

	
	}

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

	private static void checkIfStringCanBeRepeatedByTwoPlaces() {
		String str1 = "amazon";
		String str2 = "onamaz";
		
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