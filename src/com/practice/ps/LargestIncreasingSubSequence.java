package com.practice.ps;

import java.util.*;

public class LargestIncreasingSubSequence {

	public static void main(String[] args) {
		int a[] = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80};
		longestIncreasingSubSequence(a);

		longestIncreasingSubSequence2(a);
	}

	//not efficient
	private static void longestIncreasingSubSequence(int[] a) {
		int[] lis = new int[a.length];
		Arrays.fill(lis, 1);

		for (int i=1; i<lis.length; i++) {
			for (int j=0; j<i; j++) {
				if (a[i] > a[j]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
		}

		int max = 0;
		for (int i=0; i<lis.length; i++) {
			if (lis[i] > max) {
				max = lis[i];
			}
		}
		System.out.println(max);
	}

	/*
	The idea is to squeeze current sequence as hard as possible on each iteration. At every step there are 3 options:

	If there is no ceiling element in the set that means it's a new part of the sequence. (set size + 1)
	If there is a ceiling element which is equal to current digit we will simply remove-add same element. (set size doesnt change)
	If there is a ceiling element which is bigger than current element we will remove it and put smaller element into set, so we will squeeze current sequence. (set size doesnt change)
	Example: input [2, 4, 8, 5, 6, 1]

	Add 2 then 4 and 8. Set becomes 2 - 4 - 8.
	Current element is 5, that means our ceiling element is 8, let's squeeze the sequence. Remove 8 and put 5 instead, so the sequence becomes 2 - 4 - 5.
	2 - 4 - 5 - 6
	Current element is 1, that means we remove 2 and put 1, which looks like we ruined the sequence, but here is the trick. That does not increase size of the set!
	 */
	private static int longestIncreasingSubSequence2 (int[] nums) {
		TreeSet<Integer> set = new TreeSet<>();
		for(int i : nums) {
			Integer ceiling = set.ceiling(i);
			if(null != ceiling) set.remove(ceiling);
			set.add(i);
		}
		return set.size();
	}

}
