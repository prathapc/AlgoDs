package com.practice.B_algo.I_dp;

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

		System.out.println(longestCommonSubSequenceLength_recursion(str1, str2, str1.length(), str2.length()));
		System.out.println(longestCommonSubSequenceLength_dp(str1, str2));
	}

	public static int longestCommonSubSequenceLength_recursion(String X, String Y, int m, int n) {
		// return if the end of either sequence is reached
		if (m == 0 || n == 0) {
			return 0;
		}

		// if the last character of `X` and `Y` matches
		if (X.charAt(m - 1) == Y.charAt(n - 1)) {
			return longestCommonSubSequenceLength_recursion(X, Y, m - 1, n - 1) + 1;
		}

		// otherwise, if the last character of `X` and `Y` don't match
		return Integer.max(longestCommonSubSequenceLength_recursion(X, Y, m, n - 1),
				longestCommonSubSequenceLength_recursion(X, Y, m - 1, n));
	}

	private static int longestCommonSubSequenceLength_dp(String str1, String str2) {
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

}
