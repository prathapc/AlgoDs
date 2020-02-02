package com.practice.algo.dp;

import java.util.List;
import java.util.Scanner;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 * 2nd problem to find that string
 *
 */
public class LongestCommonSubSequence {

	public static void main(String[] args) {
		//String str1 = "abcde";
		//String str2 = "ace";

		String str1 = "apqdec";
		String str2 = "azcd";

		System.out.println(longestCommonSubSequenceLength(str1, str2));
		System.out.println(longestCommonSubSequence(str1, str2));

	}

	private static int longestCommonSubSequenceLength(String str1, String str2) {
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		for(int i=1; i<str1.length()+1; i++) {
			for(int j=1; j<str2.length()+1; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[str1.length()][str2.length()];
	}

	//output wrong for "apqdec", "azcd"??
	private static String longestCommonSubSequence(String str1, String str2) {
		int[][] m = new int[str1.length()+1][str2.length()+1];
		StringBuffer sb = new StringBuffer();
		for(int i=1; i<str1.length()+1; i++) {
			for(int j=1; j<str2.length()+1; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					m[i][j] = m[i-1][j-1] + 1;
					sb.append(str1.charAt(i-1));
				} else {
					m[i][j] = Math.max(m[i-1][j], m[i][j-1]);
				}
			}
		}
		return sb.toString();
	}
}
