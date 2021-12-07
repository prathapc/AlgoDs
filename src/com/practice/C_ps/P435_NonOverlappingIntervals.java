package com.practice.C_ps;

import java.util.*;

/**
 * Created by Prathap on 26 Jan, 2020
 *
 * https://leetcode.com/problems/non-overlapping-intervals/
 *
 */
public class P435_NonOverlappingIntervals {

    //solved by me in <10mins beating 100%
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (int[] i1, int[] i2) -> i1[0]-i2[0]);
        int[] prev = intervals[0];
        int toBeDeleted = 0;
        for (int i=1; i<intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] < prev[1]) {
                ++toBeDeleted;
                if (current[1] > prev[1]) {
                    continue;
                }
            }
            prev = current;
        }
        return toBeDeleted;
    }

}
