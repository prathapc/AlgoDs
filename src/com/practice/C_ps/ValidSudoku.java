package com.practice.C_ps;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Prathap on 06 Nov, 2019
 *
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> col = new HashSet<>();
            Set<Character> row = new HashSet<>();
            Set<Character> cubic = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.' && !col.add(board[j][i]))
                    return false;
                if (board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                /**
                 * 0 0
                 * 0 1
                 * 0 2
                 * 1 0
                 * 1 1
                 * 1 2
                 * 2 0
                 * 2 1
                 * 2 2
                 * ...
                 * ...
                 * ...
                 */
                if (board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3] != '.' && !cubic.add(board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3]))
                    return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        /*
        Input:-
        [["5","3",".",".","7",".",".",".","."],
        ["6",".",".","1","9","5",".",".","."],
        [".","9","8",".",".",".",".","6","."],
        ["8",".",".",".","6",".",".",".","3"],
        ["4",".",".","8",".","3",".",".","1"],
        ["7",".",".",".","2",".",".",".","6"],
        [".","6",".",".",".",".","2","8","."],
        [".",".",".","4","1","9",".",".","5"],
        [".",".",".",".","8",".",".","7","9"]]
         */
    }

}
