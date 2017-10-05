package com.practice.algo;

public class LargestIncreasingSubSequence {

	public static void main(String[] args) {
		int a[] = new int[]{10, 22, 9, 33, 21, 50, 41, 60};
		/*int[] temp = new int[a.length];
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
		System.out.println(a[printResult(length)]);*/
		System.out.println(findLIS(a));
	}

	static int findLIS(int[] s) {
		int[] t = new int[s.length];
		t[0] = s[0];
		int l = 1;
		int p = 0;
		for(int i=1; i<s.length; i++) {
			if(s[i] < t[0]) {
				t[0] = s[i];
			} else if(s[i] > t[l-1]) {
				t[l++] = s[i];
			} else {
				p = getTopIndex(t, -1, l-1, s[i]);
				t[p] = s[i];
			}
		}
		return l;
	}

	static int getTopIndex(int a[], int l, int r, int k) {
		while(r-1 > l) {
			int m = l+(r-l)/2;
			if(a[m] >= k) {
				r = m;
			} else {
				l=m;
			}
		}
		return r;
	}

	private static int printResult(int length) {
		if(length == 0) {
			return 0;
		} else {
			
		}
		return 0;
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
