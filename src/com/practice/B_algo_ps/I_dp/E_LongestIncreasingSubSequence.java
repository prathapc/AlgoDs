package com.practice.B_algo_ps.I_dp;

import java.util.*;

public class E_LongestIncreasingSubSequence {

	public static void main(String[] args) {
		int a[] = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80};
		//lengthOfLIS_dp(a); //O(n^2)
		//lengthOfLIS_linearSearch(a); //O(n^2)
		lengthOfLIS_binarySearch(a); //O(n*log(n)) same as above approach but with binary search
	}

	public static int lengthOfLIS_dp(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int longest = 0;
		for (int c: dp) {
			longest = Math.max(longest, c);
		}

		return longest;
	}

	//Approach:It appears the best way to build an increasing subsequence is:
	//for each element num, if num is greater than the largest element in our subsequence,
	//then add it to the subsequence. Otherwise, perform a linear scan through the subsequence
	//starting from the smallest element and replace the first element that is greater than or equal to num with num.
	//This opens the door for elements that are greater than num but less than the element replaced to be included in the sequence.

	//Note: with the input [3, 4, 5, 1], at the end we will have sub = [1, 4, 5],
	//which isn't a subsequence, but the length is still correct.
	//The length remains correct because the length only changes when a new element is larger than any element in the subsequence.
	//In that case, the element is appended to the subsequence instead of replacing an existing element.
	public static int lengthOfLIS_linearSearch(int[] nums) {
		ArrayList<Integer> sub = new ArrayList<>();
		sub.add(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			if (num > sub.get(sub.size() - 1)) {
				sub.add(num);
			} else {
				// Find the first element in sub that is greater than or equal to num
				int j = 0;
				while (num > sub.get(j)) {
					j += 1;
				}

				sub.set(j, num);
			}
		}

		return sub.size();
	}

	public static int lengthOfLIS_binarySearch(int[] nums) {
		ArrayList<Integer> sub = new ArrayList<>();
		sub.add(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			if (num > sub.get(sub.size() - 1)) {
				sub.add(num);
			} else {
				int j = binarySearch(sub, num);
				sub.set(j, num);
			}
		}
		return sub.size();
	}

	private static int binarySearch(ArrayList<Integer> sub, int num) {
		int left = 0;
		int right = sub.size() - 1;
		int mid = (left + right) / 2;

		while (left < right) {
			mid = (left + right) / 2;
			if (sub.get(mid) == num) {
				return mid;
			}

			if (sub.get(mid) < num) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		System.out.println(left);
		return left;
	}
}
