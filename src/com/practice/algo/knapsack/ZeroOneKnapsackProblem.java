package com.practice.algo.knapsack;

import com.practice.algo.Utility;

public class ZeroOneKnapsackProblem {

	public static void main(String[] args) {
		int[] values = {60, 100, 120};
		int[] weights = {10, 20, 30};
		int w = 10;
		int n = 3;
		//System.out.println(recursiveSolution_KnapsackWeight(w, weights, values, n));
		System.out.println(knapsackWeight(values, weights, n, w));
		
	}

	private static int recursiveSolution_KnapsackWeight(int weight, int[] weights, int[] values, int n) {
		if(weight == 0 || n == 0) {
			return 0;
		}
		if(weights[n-1] > weight) {
			//dont include n-1th weight
			return recursiveSolution_KnapsackWeight(weight, weights, values, n-1);
		} else {
			//max of including nth and not including nth weight
			return Utility.max(values[n-1] + recursiveSolution_KnapsackWeight(weight-weights[n-1], weights, values, n-1),
					recursiveSolution_KnapsackWeight(weight, weights, values, n-1));
		}
	}

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
		return K[n][W];
	}

}
