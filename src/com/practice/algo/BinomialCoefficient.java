package com.practice.algo;

import java.util.Scanner;

public class BinomialCoefficient {

	static int[][] m;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		if(n >= k) {
		    //System.out.println(recursiveSolution(n, k));
			m = new int[n][k];
			//System.out.println(dpSolution(n, k));
			System.out.println(dpSolutionWithMinSpace(n, k));
		}
		scanner.close();
	}

	private static int recursiveSolution(int n, int k) {
		if(k == 0 || k == n) {
			return 1;
		}
		return recursiveSolution(n-1, k-1)+recursiveSolution(n-1, k);
	}
	
	
	private static int dpSolution(int n, int k) {
		if(k == 0 || k == n) {
			return 1;
		}
		if(m[n-1][k-1] != 0) {
			return m[n-1][k-1];
		}
		m[n-1][k-1] = dpSolution(n-1, k-1) + dpSolution(n-1, k);
		return m[n-1][k-1];
	}

	private static int dpSolutionWithMinSpace(int n, int k) {
		int[] m = new int[k+1];
		m[0] = 1;
		for(int i=1; i<=n; i++) {
			for(int j=(i>k?i:k); j>0; j--) {
				m[j] = m[j] + m[j-1];
			}
		}
		return m[k];
	}
}
