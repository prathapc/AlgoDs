package com.practice.algo;

import java.util.Scanner;

public class TicTacToeGame {

	/**
	 * Player places 1 and AI places 2 when their turn comes. whoever forms row/column/diagonal with
	 * their placements - wins
	 * 
	 */
	public static void main(String[] args) {
		int[][] board = new int[3][3];
		printBoard(board, 3, 3);
		while (true) {
			playerMove(board);
			if (winning(board, 1)) {
				System.out.println("Congratulations. You won!!");
				break;
			}
			AIMove(board, 3, 3);
			if (winning(board, 2)) {
				System.out.println("Sorry. You have lost!!");
				break;
			}
		}
	}

	private static void AIMove(int[][] board, int r, int c) {
		int aiRowPlacement = -1, aiColPlacement = -1;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(board[i][j] == 0) {
					board[i][j] = 2;
					if(winning(board, 2)) {
						aiRowPlacement = i;
						aiColPlacement = j;
						break;
					}
					board[i][j] = 1;
					if(winning(board, 1)) {
						aiRowPlacement = i;
						aiColPlacement = j;
					}
					if(aiRowPlacement == -1 && aiColPlacement == -1) {
						aiRowPlacement = i;
						aiColPlacement = j;
					}
					board[i][j] = 0;
				}
			}
		}
		if(aiRowPlacement != -1 && aiColPlacement != -1) {
			board[aiRowPlacement][aiColPlacement] = 2;
			System.out.println("AI move is; "+aiRowPlacement+" "+aiColPlacement);
			printBoard(board, 3, 3);
		} else {
			System.out.println("oh ho! Thats a Tie. Game Over!!");
			System.exit(0);
		}
	}

	private static boolean winning(int[][] board, int player) {
		if ((board[0][0] == player && board[0][1] == player && board[0][2] == player)
				|| (board[1][0] == player && board[1][1] == player && board[1][2] == player)
				|| (board[2][0] == player && board[2][1] == player && board[2][2] == player)
				|| (board[0][0] == player && board[1][0] == player && board[2][0] == player)
				|| (board[0][1] == player && board[1][1] == player && board[2][1] == player)
				|| (board[0][2] == player && board[1][2] == player && board[2][2] == player)
				|| (board[0][0] == player && board[1][1] == player && board[2][2] == player)
				|| (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
			return true;
		} else {
			return false;
		}
	}

	private static void playerMove(int[][] board) {
		System.out.println("Your move; enter coordinates of your placement");
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		if(x < 0 || y < 0 || x > 2 || y > 2 || board[x][y] != 0) {
			System.out.println("Thats invalid move. Please try again.");
			playerMove(board);
		} else {
			board[x][y] = 1;
			printBoard(board, 3, 3);
		}
	}

	private static void printBoard(int[][] board, int r, int c) {
		System.out.println("***board***");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}