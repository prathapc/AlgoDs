package com.practice.B_algo.J_bfs_dfs;

import java.util.Scanner;

public class LongestRegionInMatrix {

	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		int tc = scanner.nextInt();
		if (tc < 1 || tc > 100) {
			throw new Exception("No of test cases should be >=1 or <=100");
		}
		for (int i = 0; i < tc; i++) {
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			if (r < 1 || r > 50 || c < 1 || c > 50) {
				throw new Exception("input array row and cols should be >=1 or <=50");
			}
			int[][] inputArray = new int[r][c];
			for (int j = 0; j < r; j++) {
				for(int k=0; k<c; k++) {
					inputArray[j][k] = scanner.nextInt();
				}
			}
			longestRegionInMatrixUsingDFS(inputArray, r, c);
		}
	}

	private static void longestRegionInMatrixUsingDFS(int[][] input, int r, int c) {
		int[][] visited = new int[r][c];
		int maxReg = 0;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				int maxRegion = visit(input, visited, i, j, r, c);
				if(maxRegion > maxReg) {
					maxReg = maxRegion;
				}
			}
		}
		System.out.println(maxReg);
	}

	private static int visit(int[][] input, int[][] visited, int i, int j, int r, int c) {
		if(i < 0 || j < 0 || i > r-1 || j > c-1 || input[i][j] == 0 || visited[i][j] == 1) {
			return 0;
		} else {
			int maxRegion = 0;
			visited[i][j] = 1;
			maxRegion++;
			for(int p=-1; p<=1; p++) {
				for(int q=-1; q<=1; q++) {
					maxRegion += visit(input, visited, i+p, j+q, r, c);
				}
			}
			return maxRegion;			
		}
	}

}
