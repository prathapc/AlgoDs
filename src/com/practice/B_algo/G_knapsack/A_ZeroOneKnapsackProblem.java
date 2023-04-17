package com.practice.B_algo.G_knapsack;

import com.practice.B_algo.A_sort_search_math.Utility;

/**
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 *
 * Given weights and values of n items,
 * put these items in a knapsack of capacity W to get the maximum total value in the knapsack
 */
public class A_ZeroOneKnapsackProblem {

	public static void main(String[] args) {
		int[] values = {60, 100, 120};
		int[] weights = {10, 20, 30};
		int w = 50;
		int n = 3;
		//System.out.println(recursiveSolution_KnapsackWeight(w, weights, values, n));
		System.out.println(knapsackWeight(values, weights, n, w));
		
	}

	//recursion O(2^n)
	private static int recursiveSolution_KnapsackWeight(int weight, int[] weights, int[] values, int n) {
		if(weight == 0 || n == 0) {
			return 0;
		}
		if(weights[n-1] > weight) {
			//don't include n-1th weight
			return recursiveSolution_KnapsackWeight(weight, weights, values, n-1);
		} else {
			//max of including nth and not including nth weight
			return Utility.max(values[n-1] + recursiveSolution_KnapsackWeight(weight-weights[n-1], weights, values, n-1),
					recursiveSolution_KnapsackWeight(weight, weights, values, n-1));
		}
	}

	//dp
	private static int knapsackWeight(int[] values, int[] weights, int n, int W) {
		int i, w;
		int K[][] = new int[n+1][W+1];
		for(i=0; i<=n; i++) {
			for(w=0; w<=W; w++) {
				if(i==0 || w==0) {
					K[i][w] = 0;
				} else if(weights[i-1] > w) {
					K[i][w] = K[i-1][w];
				} else {
					K[i][w] = Utility.max(values[i-1] + K[i-1][w-weights[i-1]], K[i-1][w]);
				}
			}
		}
		//Utility.printArray(K, n+1, W+1);
		return K[n][W];
	}

}
