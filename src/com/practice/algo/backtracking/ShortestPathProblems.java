package com.practice.algo.backtracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a chess board of order NxM and source points (s1,s2) and destination points (d1,d2), 
 * Your task to find min number of moves required by the Knight to go to the destination cell. 
 *
 */
public class ShortestPathProblems {

	private static int findShortestPathForKnight(int[] knightPostion, int[] targetPosition, int n) {
		int[] dx = {-2,-1,1,2,-2,-1,1,2};
		int[] dy = {-1,-2,-2,-1,1,2,2,1};

		Queue<Cell> queue = new LinkedList<>();
		queue.add(new Cell(knightPostion[0], knightPostion[1], 0));

		boolean[][] visited = new boolean[n+1][n+1];
		int x,y;
		while (!queue.isEmpty()) {
			Cell cell = queue.poll();

			if (cell.x == targetPosition[0] && cell.y == targetPosition[1]) {
				return cell.dist;
			}

			//loop for all reachable cells from knightPosition
			for (int i=0; i<8; i++) {
				x = cell.x + dx[i];
				y = cell.y + dy[i];

				if (isSafe(x, y, n) && !visited[x][y]) {
					visited[x][y] = true;
					queue.add(new Cell(x, y, cell.dist+1));
				}
			}
		}
		return -1;
	}

	private static boolean isSafe(int x, int y, int N) {
		if (x >= 1 && x <= N && y >= 1 && y <= N)
			return true;
		return false;
	}

	private static int findShortestPathForKnightUtil(int r, int c, int sr, int sc, int dr, int dc, boolean[][] visited) {
		return 0;
	}

	public static void main(String args[]) {
		int n = 30;
		int[] knightPoistion = {1, 1};
		int[] targetPosition = {30, 30};

		System.out.print(findShortestPathForKnight(knightPoistion, targetPosition, n));;
	}

	static class Cell {
		int x, y;
		int dist;
		Cell() {}
		Cell(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

}
