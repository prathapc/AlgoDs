package com.practice.B_algo_ps.K_sort_search_math.intervals;

import java.util.*;

/**
 * Created by Prathap on 26 Jan, 2020
 *
 * Given an array of intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 * https://leetcode.com/problems/non-overlapping-intervals/
 */
public class B_NonOverlappingIntervals {

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
            //(a,b) (c,d) => if (b>c) then overlap found and if (b<d) don't update prev
            if (prev[1] > current[0]) {
                ++toBeDeleted;
                if (prev[1] < current[1]) {
                    continue;
                }
            }
            prev = current;
        }
        return toBeDeleted;
    }


    //another greedy approach
    //hint: if two intervals are overlapping, we want to remove the interval that has the longer end point --
    //the longer interval will always overlap with more or the same number of future intervals compared to the shorter one
    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (int[] i1, int[] i2) -> i1[1]-i2[1]);
        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
