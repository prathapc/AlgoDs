package com.practice.algo.backtracking;

/**
 * Created by Prathap on 26 Nov, 2019
 */
public class SudokuSolver {

    private boolean solveSudoku(char[][] board) {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] == '.') {
                    for (char num='1'; num<='9'; num++) {
                        if (isValidBoard(board, i, j, num)) {
                            board[i][j] = num;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidBoard(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
            if (board[i][col] == num) return false;
            if (board[3*(row/3) + (i/3)][3*(col/3) + (i%3)] == num) return false;
        }
        return true;
    }
}
