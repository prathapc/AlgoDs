package com.practice.B_algo.A_sort_search_math.search;

public class A_BinarySearch {

	public static void main(String[] args) {
		int[] a = {2, -5, 6, 22, 67, 1};
		int key = 223;
		binarySearch(a, 0, 6, key);
	}

	private static void binarySearch(int[] a, int start, int end, int key) {
		if(start < end) {
			int mid = (start+end)/2;
			if(a[mid] == key) {
				System.out.println("key "+key+" found at index "+mid);
				return; 
			} else if(a[mid] < key) {
				binarySearch(a, mid+1, end, key);
			} else {
				binarySearch(a, start, mid-1, key);
			}			
		}  else {
			System.out.println("Key not found");
			return;
		}
	}
}
