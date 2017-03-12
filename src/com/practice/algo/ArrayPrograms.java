package com.practice.algo;

import java.util.Scanner;

public class ArrayPrograms {

	public static void main(String[] args) throws Exception {
		// rainWaterStorageOnBuildings();
		AscDscTypeArray();

	}

	private static void rainWaterStorageOnBuildings() {
		int[] a = { 3, 2, 4, 1, 7 };
		int result = 0, temp = 0, start = 0;
		boolean isStorageFound = false;
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] >= a[i]) {
				if (isStorageFound) {
					temp += start;
				} else {
					temp += (a[i - 1] - a[i]);
					isStorageFound = true;
				}
			} else {
				if (isStorageFound)
					temp += (a[i] - a[i - 2]);
			}
		}

	}

	public static void AscDscTypeArray() throws Exception {
		Scanner scanner = new Scanner(System.in);
		int tc = scanner.nextInt();
		if (tc < 1 || tc > 100) {
			throw new Exception("No of test cases should be >=1 or <=100");
		}
		for (int i = 0; i < tc; i++) {
			int n = scanner.nextInt();
			if (n < 4 || n > 100) {
				throw new Exception("input array size should be >=4 or <=100");
			}
			int[] inputArray = new int[n];
			for (int k = 0; k < n; k++) {
				inputArray[k] = scanner.nextInt();
			}
			if (inputArray.length != n) {
				throw new Exception("input array size should be " + n);
			}
			int typeOfArray = -1;
			int largestNumber = inputArray[0];
			boolean isAscending=false, isDescending=false;
			for (int j = 0; j < n - 1; j++) {
				if (inputArray[j] < inputArray[j + 1]) {
					isAscending = true;
					if(isDescending) {
						typeOfArray = 3;
						largestNumber = inputArray[i+1];
						break;
					}
				} else {
					isDescending = true;
					if(isAscending) {
						typeOfArray = 4;
						largestNumber = inputArray[i];
						break;
					}
				}
			}
			if(typeOfArray == -1) {
				if(isAscending) {
					typeOfArray = 1;
					largestNumber = inputArray[n-1];
				} else {
					typeOfArray = 2;
					largestNumber = inputArray[0];
				}
			}
			
			System.out.println(largestNumber + " " + typeOfArray);
		}
	}

}
