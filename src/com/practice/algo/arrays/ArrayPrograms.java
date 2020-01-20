package com.practice.algo.arrays;

import com.practice.ps.Utility;

import java.util.*;
import java.util.Stack;

public class ArrayPrograms {

	public static void main(String[] args) throws Exception {
		
		find4ElementsWithSumEqualToK();
		arrayAfterNRotations();
		printMatrixInSpiralOrder();

		maximumSumPathInTwoArrays();

		System.out.print(nearestSmallerElement());

		maxProfitByBuySellStockAnyNoOfTimes();
		maxProfitByBuySellStockAtMost2Times();
		maxProfitByBuySellStockAtMostKTimes();

		rainWaterStorageOnBuildings();
	}

	private static void maxProfitByBuySellStockAnyNoOfTimes() {
		int prices[] = {100, 180, 260, 310, 40, 535, 695};
		int n = prices.length;
		List<Interval> transactions = new ArrayList<>();
		int i=0;
		while (i < n-1) {
			//find local minima
			while (i < n-1 && prices[i] >= prices[i+1]) {
				i++;
			}
			if (i == n-1) {
				break;
			}
			Interval e = new Interval();
			e.buy = i++;

			//find local maxima
			while (i < n && prices[i-1] <= prices[i]) {
				i++;
			}
			e.sell = i-1;
			transactions.add(e);
		}

		transactions.forEach(e -> System.out.println(e.buy + ":" + e.sell));
	}

	static class Interval {
		int buy;
		int sell;
	}

	//https://www.youtube.com/watch?v=oDhu5uGq_ic&t=293s
	private static void maxProfitByBuySellStockAtMostKTimes() {

		int k = 3;
		int price[] = {12, 14, 17, 10, 14, 13, 12, 15};

		int n = price.length;

		// table to store results of subproblems
		// profit[t][i] stores maximum profit
		// using atmost t transactions up to day
		// i (including day i)
		int profit[][] = new int[k + 1][ n + 1];

		// For day 0, you can't earn money
		// irrespective of how many times you trade
		for (int i = 0; i <= k; i++)
			profit[i][0] = 0;

		// profit is 0 if we don't do any
		// transation (i.e. k =0)
		for (int j = 0; j <= n; j++)
			profit[0][j] = 0;

		// fill the table in bottom-up fashion
		for (int i = 1; i <= k; i++)
		{
			int prevDiff = Integer.MIN_VALUE;
			for (int j = 1; j < n; j++)
			{
				prevDiff = Math.max(prevDiff, profit[i - 1][j - 1] - price[j - 1]);
				profit[i][j] = Math.max(profit[i][j - 1], price[j] + prevDiff);
			}
		}

		System.out.println(profit[k][n - 1]);
	}

	private static void maxProfitByBuySellStockAtMost2Times() {
		int price[] = {2, 30, 15, 10, 8, 25, 80};
		int n = price.length;

		// Create profit array and initialize it as 0
		int profit[] = new int[n];
		for (int i=0; i<n; i++)
			profit[i] = 0;

        /* Get the maximum profit with only one transaction
           allowed. After this loop, profit[i] contains maximum
           profit from price[i..n-1] using at most one trans. */
		int max_price = price[n-1];
		for (int i=n-2;i>=0;i--)
		{
			// max_price has maximum of price[i..n-1]
			if (price[i] > max_price)
				max_price = price[i];

			// we can get profit[i] by taking maximum of:
			// a) previous maximum, i.e., profit[i+1]
			// b) profit by buying at price[i] and selling at
			//    max_price
			profit[i] = Math.max(profit[i+1], max_price-price[i]);
		}

        /* Get the maximum profit with two transactions allowed
           After this loop, profit[n-1] contains the result */
		int min_price = price[0];
		for (int i=1; i<n; i++)
		{
			// min_price is minimum price in price[0..i]
			if (price[i] < min_price)
				min_price = price[i];

			// Maximum profit is maximum of:
			// a) previous maximum, i.e., profit[i-1]
			// b) (Buy, Sell) at (min_price, price[i]) and add
			//    profit of other trans. stored in profit[i]
			profit[i] = Math.max(profit[i-1], profit[i] +
					(price[i]-min_price) );
		}
		System.out.print(profit[n-1]);
	}

	/**
	 * find nearest smaller element for every element such that the smaller element is on left side.
	 * i/p:- {1,6,4,10,2,5}
	 * o/p:- {-,1,1,4,1,2}
	 */
	public static ArrayList<Integer> nearestSmallerElement() {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(34);arr.add(35);arr.add(27);arr.add(42);arr.add(5);arr.add(28);arr.add(39);arr.add(20);arr.add(28);

		ArrayList<Integer> result = new ArrayList<>();
		java.util.Stack<Integer> st = new Stack<>();

		for(int i=0; i<arr.size(); i++) {
			while(!st.empty()&&st.peek()>=arr.get(i)) {
				st.pop();
			}
			if(st.empty()) {
				result.add(-1);
			} else if(st.peek() < arr.get(i)) {
				result.add(st.peek());
			}
			st.push(arr.get(i));
		}
		return result;
	}

	private static void printMatrixInSpiralOrder() {
		List<ArrayList<Integer>> aList = new ArrayList<>();
		ArrayList<Integer> inner1 = new ArrayList<Integer>();
		inner1.add(1);inner1.add(2);inner1.add(3);
		aList.add(inner1);
		ArrayList<Integer> inner2 = new ArrayList<Integer>();
		inner2.add(4);inner2.add(5);inner2.add(6);
		aList.add(inner2);
		ArrayList<Integer> inner3 = new ArrayList<Integer>();
		inner3.add(7);inner3.add(8);inner3.add(9);
		aList.add(inner3);

		int r = aList.size();
		int c = aList.get(0).size();
		int[][] a = new int[r][c];

		for(int i=0; i<r; i++) {
			for(int j=0; j<r; j++) {
				a[i][j] = aList.get(i).get(j);
				//System.out.print(a[i][j] + " ");
			}
		}

		ArrayList<Integer> result = new ArrayList<Integer>();
		int i, k = 0, l = 0;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */
		int m=r, n=c;
		while (k < m && l < n)
		{
			// Print the first row from the remaining rows
			for (i = l; i < n; ++i)
			{
				result.add(a[k][i]);
			}
			k++;

			// Print the last column from the remaining columns
			for (i = k; i < m; ++i)
			{
				result.add(a[i][n-1]);
			}
			n--;

			// Print the last row from the remaining rows */
			if ( k < m)
			{
				for (i = n-1; i >= l; --i)
				{
					result.add(a[m-1][i]);
				}
				m--;
			}

			// Print the first column from the remaining columns */
			if (l < n)
			{
				for (i = m-1; i >= k; --i)
				{
					result.add(a[i][l]);
				}
				l++;
			}

			for(Integer kk : result) {
				System.out.print(kk + " ");
			}
		}
	}

	private static void arrayAfterNRotations() {
		int B = 18;
		Integer a[] = {44, 41, 12, 42, 71, 45, 28, 65, 75, 93, 66, 66, 37, 6, 24, 59 };
		ArrayList<Integer> A = new ArrayList<>();
		for(int i : a) {
			A.add(i);
		}
		ArrayList<Integer> ret = new ArrayList<>();
		if(B > A.size())
			B = B%A.size();
		for (int i = 0; i < A.size(); i++) {
			if(i+B >= A.size())
				break;
			ret.add(A.get(i + B));
		}
		for(int j=0; j<B; j++) {
			ret.add(A.get(j));
		}
		ret.forEach(System.out::println);
	}

	private static void find4ElementsWithSumEqualToK() {
		//int a[] = new int[]{10, 2, 3, 4, 5, 9, 7, 8};
		int a[] = new int[]{3,2,1,6,4,5};
		int x = 12;
		
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
		int[] arr = { 3, 2, 4, 1, 7 };
		int n= arr.length;

		int left[] = new int[n];
		int right[] = new int[n];

		int water = 0;

		left[0] = arr[0];
		for (int i = 1; i < n; i++)
			left[i] = Math.max(left[i-1], arr[i]);

		right[n-1] = arr[n-1];
		for (int i = n-2; i >= 0; i--)
			right[i] = Math.max(right[i+1], arr[i]);

		for (int i = 0; i < n; i++)
			water += Math.min(left[i],right[i]) - arr[i];

		System.out.println("water stored: "+water);
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
		    if (i == n-1) {
		    	System.out.println("Ascending with maximum element = "+arr[n-1]);
		        return ;
		    }
		 
		    // If first element is greater than next one
		    if (i == 0) {
		        while (i < n-1 && arr[i] >= arr[i+1])
		            i++;
		 
		        // If i reaches to last index
		        if (i == n - 1) {
		        	System.out.println("Descending with maximum element = "+arr[0]);
		            return ;
		        }
		 
		        // If the whole array is not in decreasing order
		        // that means it is first decreasing then
		        // increasing, i.e., descending rotated, so
		        // its maximum element will be the point breaking
		        // the order i.e. i so, max will be i+1
		        if (arr[0] < arr[i+1]) {
		        	System.out.println("Descending rotated with maximum element = "+Utility.max(arr[0], arr[i+1]));
		            return ;
		        }
		        else {
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
