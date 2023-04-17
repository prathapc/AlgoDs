package com.practice.B_algo.A_sort_search_math.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Prathap on 11 Jan, 2020
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * https://leetcode.com/problems/merge-intervals/
 *
 */
public class A_MergeIntervals {

    public static void main(String args[]) {
        int intervals[][] = new int[][]{{1,3}, {2,6}, {8,10}, {15,18}};
        merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] i1, int[] i2) -> i1[0] - i2[0]);
        int[][] result = new int[intervals.length][2];
        int[] prev = intervals[0];
        int c = 0;
        for (int i=1; i<intervals.length; i++) {
            int[] curr = intervals[i];
            //(a,b) (c,d) => if (b>=c) then prev = (a, {b,d})
            if (prev[1] >= curr[0]) {
                prev = new int[]{prev[0], curr[1]>prev[1]?curr[1]:prev[1]};
            } else {
                result[c++] = new int[]{prev[0], prev[1]};
                prev = curr;
            }
        }
        result[c] = new int[]{prev[0], prev[1]};
        return Arrays.copyOfRange(result, 0, c+1);
    }
}
