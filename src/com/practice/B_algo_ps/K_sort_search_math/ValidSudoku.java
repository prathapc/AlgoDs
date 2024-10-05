package com.practice.B_algo_ps.K_sort_search_math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Prathap on 06 Nov, 2019
 *
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int r = board.length, c = board[0].length;
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        Map<String, Set<Integer>> gridMap = new HashMap<>();
        for (int i=0; i<r; i++){
            for (int j=0;j<c; j++) {
                if (board[i][j] == '.') continue;
                int curr = board[i][j] - '0';

                //validate row
                rowMap.putIfAbsent(i, new HashSet<>());
                if (!rowMap.get(i).add(curr)) return false;

                //validate col
                colMap.putIfAbsent(j, new HashSet<>());
                if (!colMap.get(j).add(curr)) return false;

                //validate box
                int ri = (i / 3) * 3;
                int cj = (j / 3) * 3;
                String gridKey = ri + "_" + cj;
                gridMap.putIfAbsent(gridKey, new HashSet<>());
                if (!gridMap.get(gridKey).add(curr)) return false;
            }
        }
        return true;
    }
}
