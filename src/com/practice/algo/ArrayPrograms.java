package com.practice.algo;

import java.util.Scanner;

import com.practive.util.Utility;

public class ArrayPrograms {

	public static void main(String[] args) throws Exception {
		
		//largestNumberWithMaxKSwipes();
		find4ElementsWithSumEqualToK();
	}

	private static void find4ElementsWithSumEqualToK() {
		int a[] = new int[]{10, 2, 3, 4, 5, 9, 7, 8};
		int x = 23;
		
		find4ElementsWithSumEqualToKUtil(a, x);
	}

	private static void find4ElementsWithSumEqualToKUtil(int[] a, int x) {
		int n = a.length;
		int auxArraySize = n*(n-1)/2;
		
		PairSum aux[] = new PairSum[auxArraySize];
		for(int i=0; i<auxArraySize; i++) {
			PairSum ps = new PairSum();
			aux[i] = ps;
		}
		int k = 0;
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				aux[k].sum = a[i]+a[j];
				aux[k].i = a[i];
				aux[k].j = a[j];
				k++;
			}
		}
		quickSort(aux, 0, auxArraySize);
		int i=0;
		int j=auxArraySize-1;
		while(i<auxArraySize && j>=0) {
			if(aux[i].sum + aux[j].sum == x && noCommon(aux[i], aux[j])) {
				System.out.println(aux[i].i + " " + aux[i].j + " " + aux[j].i + " " + aux[j].j);
				i++;
				j--;
			} else if(aux[i].sum + aux[j].sum < x) {
				i++;
			} else {
				j--;
			}
		}
	}

	private static boolean noCommon(PairSum pairSum1, PairSum pairSum2) {
		if(pairSum1.i == pairSum2.i || pairSum1.i == pairSum2.j || pairSum1.j == pairSum2.j || pairSum1.j == pairSum2.i) {
			return false;
		}
		return true;
	}
	
	private static void quickSort(PairSum[] aux, int start, int end) {
		if(start < end) {
			int pIndex = quickSortPartition(aux, start, end);
			quickSort(aux, start, pIndex-1);
			quickSort(aux, pIndex+1, end);
		}
	}

	private static int quickSortPartition(PairSum[] aux, int start, int end) {
		int pIndex = start;
		int pivot = aux[end-1].sum;
		for(int i=start; i<end; i++) {
			if(aux[i].sum < pivot) {
				swap(aux, i, pIndex);
				pIndex++;
			}
		}
		swap(aux, pIndex, end-1);
		return pIndex;
	}
	
	private static void swap(PairSum[] aux, int i, int pIndex) {
		PairSum temp = aux[i];
		aux[i] = aux[pIndex];
		aux[pIndex] = temp;
	}

	static class PairSum {
		int i;
		int j;
		int sum;
		
	}

	private static void largestNumberWithMaxKSwipes() {
		//int a[] = {2,5,1,9,3,7,2,8,9,3};  //9 5 3 2 1 7 2 8 9 3 
		//int k = 6;
		
		int a[] = {9,9,9,9};
		int k = 4;
		largestNumberWithKSwipesUtil(a, 0, k);
		Utility.printArray(a);
		
	}

	private static void largestNumberWithKSwipesUtil(int[] a, int start, int k) {
		if(k > 0 && start < a.length-1) {
			int max = a[start];
			int maxIndex = start;
			for(int i=start; i<=k; i++) {
				if(i+1 < a.length) {
					if(a[start+i] > max) {
						max = a[start+i];
						maxIndex = start+i;
					}
				}
			}
			if(maxIndex > start) {
				swapUtil(a, start, maxIndex);	
			}
			k -= (maxIndex-start);
			largestNumberWithKSwipesUtil(a, ++start, k);
		}
	}

	private static void swapUtil(int[] a, int start, int maxIndex) {
		for(int i=maxIndex; i>start; i--) {
			Utility.swapElementsInArray(a, i, i-1);
		}
	}

	private static void maximumSumPathInTwoArrays() {
		int a[] = {2, 3, 7, 10, 12};
		int b[] = {1, 5, 7, 8};
		int result = 0, sum1 = 0, sum2 = 0;
		int m = a.length-1, n = b.length-1;
		int i=0, j=0;
		while(i<m && j<n) {
			if(a[i] < b[j]) {
				sum1 += a[i++];
			} else if(a[i] > b[j]) {
				sum2 += b[j++];
			} else {
				result += Utility.max(sum1, sum2);
				sum1 = 0;
				sum2 = 0;
				while(i<m && j<n && a[i] == b[j]) {
					result += a[i++];
					j++;
				}
			}
		}
		while(i<m) {
			sum1 += a[i++];
		}
		while(j<n) {
			sum2 += b[j++];
		}
		result += Utility.max(sum1, sum2);
		System.out.println(result);
	}

	private static void kColsestElementsToGivenValueInArray() {
		int a[] = new int[]{12, 16, 22, 30, 35, 39, 42, 
	               45, 48, 50, 53, 55, 56};
		int k=4, x=35;
		int indexOfX = binarySearchForX(x, a, 0, a.length-1);
		if(indexOfX != -1) {
			int left = indexOfX-1;
			int right = indexOfX+1;
			while(k > 0) {
				if(left < 0 && right > a.length-1) {
					break;
				}
				if(left < 0) {
					for(int i=right; i<a.length-1; i++) {
						System.out.print(a[i] + " ");
					}
					break;
				}
				if(right > a.length-1) {
					for(int i=left; i>=0; i--) {
						System.out.print(a[i] + " ");
					}
					break;
				}
				if(x-a[left] < a[right]-x) {
					System.out.print(a[left] + " ");
					left--;
				} else {
					System.out.print(a[right] + " ");
					right++;
				}
				k--;
			}
		}
	}

	private static int binarySearchForX(int x, int[] a, int start, int end) {
		if(start <= end) {
			int mid = (start+end)/2;
			if(x == a[mid]) {
				return mid;
			} else if(x > a[mid]) {
				return binarySearchForX(x, a, mid+1, end);
			} else {
				return binarySearchForX(x, a, start, mid);					
			}
		}
		return -1;
	}

	private static void mergeTwoSortedArraysWithoutExtraSpace() {
		int a[] = {1, 5, 9, 10, 15, 20};
		int b[] = {2, 3, 8, 13};
		int m = a.length-1;
		int n = b.length-1;
		for(int i=n; i>=0; i--) {
			if(a[m] > b[i]) {
				int temp = a[m];
				a[m] = b[i];
				b[i] = temp;
				sortFirstArrayAfterSwap(a);
			}
		}
		
		Utility.printArray(a);
		System.out.println(); 
		Utility.printArray(b);
	}

	private static void sortFirstArrayAfterSwap(int[] a) {
		for(int i=a.length-1; i>=0; i--) {
			if(a[i] < a[i-1]) {
				int temp = a[i];
				a[i] = a[i-1];
				a[i-1] = temp;
			} else {
				break;
			}
		}
	}

	private static void mergeArrayOfSizeNIntoAnotherArrayOfSizeMPlusN() {
		int m = 5, n = 3;
		int[] a1 = new int[m+n];
		int[] a2 = {1, 2, 3};
		a1[1] = 4; a1[3] = 5;
		
		//move elements in a1 to end
		for(int i=0; i<m+n; i++) {
			
		}
	}

	private static void pairsInArrayWhoseSumEqualToGivenNumber() {
		int[] a = {2, 6, 3, 9, 11};
		int givenSum = 9;
		System.out.println(countNoOfPairs(a, 5, 9));
	}

	private static int countNoOfPairs(int[] a, int n, int sum) {
		if(sum == 0)
			return 1;
		if(sum < 0)
			return 0;
		if(n <= 0 || sum > 0)
			return 0;
		return countNoOfPairs(a, n-1, sum) + countNoOfPairs(a, n, sum-a[n-1]);
	}

	private static void rainWaterStorageOnBuildings() {
		//int[] a = { 3, 2, 4, 1, 7 };
		Scanner scanner = new Scanner(System.in);
		int inputSize = scanner.nextInt();
		int a[] = new int[inputSize];
		for(int p=0; p<inputSize; p++) {
			a[p] = scanner.nextInt();
		}
		int[] leftTop = new int[a.length];
		int[] rightTop = new int[a.length];
		int leftHeighest = a[0];
		int rightHeighest = a[a.length-1];
		for(int i=1; i<a.length-1; i++) {
			//fill left top array
			if(a[i-1] > leftHeighest) {
				leftTop[i] = a[i-1];
				leftHeighest = a[i-1];
			} else {
				leftTop[i] = leftHeighest;
			}
			
			//fill right top array
			if(a[(a.length-1)-i+1] > rightHeighest) {
				rightTop[(a.length-1-i)] = a[(a.length-1)-i+1];
				rightHeighest = a[(a.length-1)-i+1];
			} else {
				rightTop[(a.length-1-i)] = rightHeighest;
			}
		}
		int result = 0;
		int temp;
		for(int i=1; i<a.length-1; i++) {
			temp = Utility.min(leftTop[i], rightTop[i]);
			if(temp > 0 && temp - a[i] > 0) {
				result += temp - a[i];
			}
		}
		System.out.println("water stored: "+result);
		scanner.close();
	}

	public static void AscDscTypeArray() throws Exception {
		Scanner scanner = new Scanner(System.in);
		int tc = scanner.nextInt();
		if (tc < 1 || tc > 100) {
			throw new Exception("No of test cases should be >=1 or <=100");
		}
		for (int p = 0; p < tc; p++) {
			int n = scanner.nextInt();
			if (n < 4 || n > 100) {
				throw new Exception("input array size should be >=4 or <=100");
			}
			int[] arr = new int[n];
			for (int k = 0; k < n; k++) {
				arr[k] = scanner.nextInt();
			}
			if (arr.length != n) {
				throw new Exception("input array size should be " + n);
			}
			int i = 0;
			 
		    // Check if the array is in ascending order
		    while (i < n-1 && arr[i] <= arr[i+1])
		        i++;
		 
		    // If i reaches to last index that means
		    // all elements are in increasing order
		    if (i == n-1)
		    {
		    	System.out.println("Ascending with maximum element = "+arr[n-1]);
		        return ;
		    }
		 
		    // If first element is greater than next one
		    if (i == 0)
		    {
		        while (i < n-1 && arr[i] >= arr[i+1])
		            i++;
		 
		        // If i reaches to last index
		        if (i == n - 1)
		        {
		        	System.out.println("Descending with maximum element = "+arr[0]);
		            return ;
		        }
		 
		        // If the whole array is not in decreasing order
		        // that means it is first decreasing then
		        // increasing, i.e., descending rotated, so
		        // its maximum element will be the point breaking
		        // the order i.e. i so, max will be i+1
		        if (arr[0] < arr[i+1])
		        {
		        	System.out.println("Descending rotated with maximum element = "+Utility.max(arr[0], arr[i+1]));
		            return ;
		        }
		        else
		        {
		        	System.out.println("Ascending rotated with maximum element = "+Utility.max(arr[0], arr[i+1]));
		            return ;
		        }
		    }
		 
		    // If whole array is not increasing that means at some
		    // point it is decreasing, which makes it ascending rotated
		    // with max element as the decreasing point
		    if (i < n -1 && arr[0] > arr[i+1])
		    {
		    	System.out.println("Ascending rotated with maximum element = "+ Utility.max(arr[i], arr[0]));
		        return;
		    }
		    System.out.println("Descending rotated with maximum element = "+Utility.max(arr[i],arr[0]));
		}
		scanner.close();
	}

}
