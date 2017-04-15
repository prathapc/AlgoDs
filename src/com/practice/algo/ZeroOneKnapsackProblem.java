package com.practice.algo;

public class ZeroOneKnapsackProblem {

	public static void main(String[] args) {
		int[] values = {60, 100, 120};
		int[] weights = {10, 20, 30};
		int w = 50;
		System.out.println(knapsackWeight(values, weights, w));
		
	}

	private static int knapsackWeight(int[] values, int[] weights, int w) {
		int c = w/weights[0]+1;
		int r = weights.length+1;
		int[][] m = new int[r][c];
		int[] trailWeights = {0, 10, 20, 30, 40, 50};
		for(int i=1; i<r; i++) {
			for(int j=1; j<c; j++) {
				if(i==1) {
					m[i][j] = values[i-1]*j;
					continue;
				}
				if(trailWeights[j] < weights[i-1]) {
					m[i][j] = m[i-1][j];
					continue;
				}
				m[i][j] = min(m[i-1][j], (trailWeights[j]/weights[i-1])*values[i-1]+m[i][j-i]);
			}
		}
		return m[r-1][c-1];
	}

	private static int min(int i, int j) {
		return i>j?j:i;
	}
}
