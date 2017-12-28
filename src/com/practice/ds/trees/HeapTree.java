package com.practice.ds.trees;

import java.util.Scanner;

import com.practice.util.Utility;

public class HeapTree {

	public static void main(String[] args) {
		int a[] = createHeapTree();
		topNLargestElements(a, 2);
	}

	private static int[] createHeapTree() {
		Scanner scanner = Utility.getScanner();
		int n = scanner.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = scanner.nextInt();
		}
		scanner.close();
		for(int i=1; i<a.length; i++) {
			buildHeap(a, i);
		}
		/*for(int j=0; j<a.length; j++) {
			System.out.print(a[j] + " ");
		}*/
		return a;
	}

	private static void buildHeap(int[] a, int i) {
		int parent;
		if(i == 0)
			return;
		if(i%2 == 0) {
			parent = (i-2)/2;
		} else {
			parent = (i-1)/2;
		}
		if(a[i] > a[parent]) {
			swap(a, i, parent);
			buildHeap(a, parent);
		}
	}
	private static void swap(int[] a, int i, int parent) {
		int temp = a[parent];
		a[parent] = a[i];
		a[i] = temp;
	}

	private static void topNLargestElements(int[] a, int n) {
		for(int i=0; i<n; i++) {
			System.out.println(a[0]);
			a[0] = a[a.length-1];
			heapify(a, 0);
		}
	}
	
	private static void heapify(int[] a, int i) {
		if(2*i+2 <= a.length) {
			if(Utility.max(a[2*i+2], a[2*i+1]) > a[i]) {
				if(a[2*i+2] > a[2*i+1]) {
					swap(a, 2*i+2, i);
					heapify(a, 2*i+2);
				} else {
					swap(a, 2*i+1, i);
					heapify(a, 2*i+1);
				}
			}
		} else if(2*i+1 <= a.length) {
			if(a[2*i+1] > a[i]) {
				swap(a, 2*i+1, i);
				heapify(a, 2*i+1);
			}
		} else {
			return;
		}
	}
}
