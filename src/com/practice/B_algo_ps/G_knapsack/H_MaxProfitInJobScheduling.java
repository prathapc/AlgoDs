package com.practice.B_algo_ps.G_knapsack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 06/01/24.
 */
public class H_MaxProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        Map<Integer, Integer> dp = new HashMap<>();
        return dfs(jobs, 0, dp);
    }

    private int dfs(int[][] jobs, int curr, Map<Integer, Integer> dp) {
        if (curr == jobs.length) return 0;
        if (dp.containsKey(curr)) return dp.get(curr);

        int next = findNext(jobs, curr);
        int inclProf = jobs[curr][2] + (next == -1 ? 0 : dfs(jobs, next, dp));
        int exclProf = dfs(jobs, curr + 1, dp);

        dp.put(curr, Math.max(inclProf, exclProf));
        return Math.max(inclProf, exclProf);
    }

    //TLE - use binary search instead
    int findNextLinear(int cur, int[][] jobs) {
        for (int next = cur + 1; next < jobs.length; next++) {
            if (jobs[next][0] >= jobs[cur][1]) {
                return next;
            }
        }
        return -1;
    }
    //binary search for next job which is starting after curr job
    private int findNext(int[][] jobs, int idx) {
        int lo = idx + 1;
        int hi = jobs.length -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(jobs[mid][0] >= jobs[idx][1]) {
                if(jobs[mid-1][0] >= jobs[idx][1])
                    hi = mid - 1;
                else
                    return mid;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
