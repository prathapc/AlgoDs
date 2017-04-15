package com.practice.algo;

public class LargestIncreasingSubSequence {

	public static void main(String[] args) {
		int a[] = new int[]{10, 22, 9, 33, 21, 50, 41, 60};
		int[] temp = new int[a.length];
		int[] result = new int[a.length];
		int length = 0;
		for(int i=1; i<a.length; i++) {
			if(a[temp[i]] > a[temp[i-1]]) {
				temp[i] = i;
				result[i] = temp[i-1];
				length++;
			} else {
				temp[binarySearchForCeil(a, temp, 0, i-1, a[i])] = i;
			}
		}
		System.out.println(a[printResult(length)]);
	}

	private static int printResult(int length) {
		if(length == 0) {
			return 0;
		} else {
			
		}
	}

	private static int binarySearchForCeil(int[] a, int[] temp, int start, int end, int key) {
		int mid = (start+end)/2;
		if(a[mid] == key) {
			return mid;
		} else if(a[mid] < key) {
			binarySearchForCeil(a, temp, mid+1, end, key);
		} else {
			binarySearchForCeil(a, temp, start, mid-1, key);
		}
		return 0;
	}

}
