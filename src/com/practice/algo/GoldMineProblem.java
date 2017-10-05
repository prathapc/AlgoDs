package com.practice.algo;

import java.util.Scanner;

import com.practive.util.Utility;

public class GoldMineProblem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int r = scanner.nextInt();
		int c = scanner.nextInt();
		int[][] a = Utility.readArray(r, c);
		
		for(int j=c-2; j>=0; j--) {
			for(int i=r-1; i>=0; i--) {
				int right = a[i][j+1];
				int rightUp = 0;
				if(i-1 >= 0) {
					rightUp = a[i-1][j+1];
				}
				int rightDown = 0;
				if(i+1 < r) {
					rightDown = a[i+1][j+1];					
				}
				a[i][j] = Utility.max(right+a[i][j], rightUp+a[i][j], rightDown+a[i][j]);
			}
		}
		
		int max = a[0][0];
		for(int p=1; p<r; p++) {
			if(a[p][0] > max) {
				max = a[p][0];
			}
		}
		
		System.out.println(max);
	}
}