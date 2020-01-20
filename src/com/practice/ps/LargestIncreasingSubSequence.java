package com.practice.ps;

import java.util.LinkedList;
import java.util.Queue;

public class LargestIncreasingSubSequence {

	public static void main(String[] args) {
		int a[] = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80};
		longestIncreasingSubSequence(a);
	}

	private static void longestIncreasingSubSequence(int[] a) {

		//intialise lis arr with 1's (single number lis is 1)
		int[] lis = new int[a.length];
		for (int i=0; i<lis.length; i++) {
			lis[i] = 1;
		}

		//fill lis such that lis ending at that number
		for (int i=1; i<lis.length; i++) {
			for (int j=0; j<i; j++) {
				if (a[i] > a[j]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
		}

		//iterate once and find out max value in lis array
		int max = 0;
		for (int i=0; i<lis.length; i++) {
			if (lis[i] > max) {
				max = lis[i];
			}
		}

		System.out.println(max);
	}
}
