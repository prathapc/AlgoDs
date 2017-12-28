package com.practice.algo;

import java.util.Scanner;

/**
 * Given a chess board of order NxM and source points (s1,s2) and destination points (d1,d2), 
 * Your task to find min number of moves required by the Knight to go to the destination cell. 
 *
 */
public class ShortestPathProblems {
	
	private static void findShortestPathForKnight(int r, int c, int sr, int sc, int dr, int dc) {
		boolean[][] visited = new boolean[r][c];
		if(r>0 && c>0 && sr<r && sc<c && dr<r && dc<c) {
			for(int i=0; i<=2; i++) {
				for(int j=0; j<=2; i++) {
					
				}
			}
		}
	}
	
	private static int findShortestPathForKnightUtil(int r, int c, int sr, int sc, int dr, int dc, boolean[][] visited) {
		return 0;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int r = scanner.nextInt();
		int c = scanner.nextInt();
		int sr = scanner.nextInt();
		int sc = scanner.nextInt();
		int dr = scanner.nextInt();
		int dc = scanner.nextInt();
		findShortestPathForKnight(r,c,sr,sc,dr,dc);
	}

}
