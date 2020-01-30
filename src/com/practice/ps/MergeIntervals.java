package com.practice.ps;

import java.util.ArrayList;
import java.util.Arrays;
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
public class MergeIntervals {

    public static void main(String args[]) {
        int intervals[][] = new int[][]{{2,6}, {1,9}, {8,10}, {15,18}};
        merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        int r = intervals.length;
        if (r == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (int[] i1, int[] i2) -> Integer.compare(i1[0], i2[0]));

        List<Integer> result = new ArrayList<>();
        int prev1 = intervals[0][0];
        int prev2 = intervals[0][1];
        for (int i=1; i<r; i++) {
            int p1 = intervals[i][0];
            int p2 = intervals[i][1];

            if (p1 > prev2) {
                result.add(prev1);
                result.add(prev2);
                prev1 = p1;
                prev2 = p2;
            } else {
                prev2 = p2 > prev2 ? p2 : prev2;
            }
        }

        result.add(prev1);
        result.add(prev2);

        int[][] res = new int[result.size()/2][2];
        int c = 0;
        for (int i=0; i<result.size(); i++) {
            res[c][0] = result.get(i);
            res[c][1] = result.get(++i);
            c++;
        }

        return res;
    }
}
