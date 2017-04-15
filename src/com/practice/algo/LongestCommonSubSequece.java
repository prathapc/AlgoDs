package com.practice.algo;

import java.util.Scanner;

public class LongestCommonSubSequece {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();
		System.out.println(longestCommonSubSequence(str1, str2));
	}
	
	private static String longestCommonSubSequence(String str1, String str2) {
		int[][] m = new int[str2.length()+1][str1.length()+1];
		StringBuffer sb = new StringBuffer("");
		for(int i=1; i<str2.length()+1; i++) {
			for(int j=1; j<str1.length()+1; j++) {
				if(str1.charAt(j-1) == str2.charAt(i-1)) {
					m[i][j] = m[i-1][j-1] + 1;
					sb.append(str2.charAt(i-1));
				} else {
					m[i][j] = max(m[i-1][j], m[i][j-1]);
				}
			}
		}
		return sb.toString();
	}
	
	private static int max(int i, int j) {
		if(i > j) {
			return i;
		} else {
			return j;
		}
	}

}
