package com.practice.B_algo.H_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prathap on 24 Nov, 2019
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2804/
 */
public class NQueenII {
    int results = 0;
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }

        List<Integer> queenPos = new ArrayList<>();
        search(queenPos, n);
        return results;
    }

    /*
     * results store all of the chessboards
     * queenPos store the column indices or the position of queens for each row
     */
    private void search(List<Integer> queenPos,
                        int n) {

        // there are already n queens in the list,
        // which means every row has been assigned a queen
        if (queenPos.size() == n) {
            results++;
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (isValid(queenPos, colIndex)) {
                queenPos.add(colIndex);
                search(queenPos, n);
                // backtracking, and explore if the queen can be placed into the next column
                queenPos.remove(queenPos.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> queenPos, int column) {
        int row = queenPos.size();
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            int preQueenPos = queenPos.get(rowIndex);
            // same column, fail
            if (preQueenPos == column) {
                return false;
            }
            // left diagonal or right diagonal, fail
            if (rowIndex + preQueenPos == row + column
                    || rowIndex - preQueenPos == row - column) {
                return false;
            }
        }
        return true;
    }
}
