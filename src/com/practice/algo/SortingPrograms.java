package com.practice.algo;

import com.practice.util.Utility;

public class SortingPrograms {

	static int temp[];
	static int a[] = { 34, 56, 23, 55, 12, 60 };

	public static void main(String[] args) {
		//mergeSort(a);
		quickSort(a, 0, a.length-1);
		
		Utility.printArray(a);
	}

	public static void quickSort(int[] a, int start, int end) {
		if(start < end) {
			int pIndex = quicksortPartition(a, start, end);
			quickSort(a, start, pIndex-1);
			quickSort(a, pIndex+1, end);			
		}
	}

	private static int quicksortPartition(int[] a, int start, int end) {
		int pivot = a[end];
		int pIndex = start;
		for(int i=start; i<end; i++) {
			if(a[i] <= pivot) {
				Utility.swapElementsInArray(a, i, pIndex);
				pIndex++;
			}
		}
		Utility.swapElementsInArray(a, pIndex, end);
		return pIndex;
	}

	private static void mergeSort(int[] a) {
		temp = new int[a.length];
		partition(a, 0, a.length - 1);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static void partition(int[] a, int start, int end) {
		if (start < end) {
			int middle = (start + (end - start) / 2);
			partition(a, start, middle);
			partition(a, middle + 1, end);
			merge(start, middle, end);
		}
	}

	private static void merge(int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			temp[i] = a[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;

		while (i <= middle && j <= high) {
			if (temp[i] <= temp[j]) {
				a[k] = temp[i];
				i++;
			} else {
				a[k] = temp[j];
				j++;
			}
			k++;
		}
		
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			a[k] = temp[i];
			k++;
			i++;
		}
	}

}
