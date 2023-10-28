package com.practice.A_ds.C_linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by prathapchowdary on 17/06/23.
 *
 * RecentCounter() Initializes the counter with zero recent requests.
 *
 * int ping(int t) Adds a new request at time t, where t represents some time in milliseconds,
 * and returns the number of requests that has happened in the past 3000 milliseconds (including the new request).
 * Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
 *
 * Input
 * ["RecentCounter", "ping", "ping", "ping", "ping"]
 * [[], [1], [100], [3001], [3002]]
 * Output
 * [null, 1, 2, 3, 3]
 *
 * https://leetcode.com/problems/number-of-recent-calls/
 */
public class A_NumberOfRecentCalls {

    //linear search - beats 10%
    /*List<Integer> data = null;
    int start,end;
    public A_NumberOfRecentCalls() {
        data = new LinkedList<>();
        start = 0;
        end = 0;
    }
    public int ping(int t) {
        data.add(t);
        end++;

        while (data.get(end-1) - data.get(start) > 3000) {
            start++;
        }
        return end-start;
    }*/

    //binary search - beats 98%
    List<Integer> list = new ArrayList<>();
    int lowerBound = 0;
    public A_NumberOfRecentCalls() {}
    public int ping(int t) {
        list.add(t);
        int r = list.size() - 1;
        int target = t - 3000;
        while (lowerBound < r) {
            int m = lowerBound + (r-lowerBound) / 2;
            if (list.get(m) >= target)
                r = m;
            else
                lowerBound = m + 1;
        }
        return list.size() - lowerBound;
    }
}
