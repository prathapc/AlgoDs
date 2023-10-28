package com.practice.A_ds.D_heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by prathapchowdary on 24/06/23.
 *
 * Input: nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
 * Output: 12
 * Explanation:
 * The four possible subsequence scores are:
 * - We choose the indices 0, 1, and 2 with score = (1+3+3) * min(2,1,3) = 7.
 * - We choose the indices 0, 1, and 3 with score = (1+3+2) * min(2,1,4) = 6.
 * - We choose the indices 0, 2, and 3 with score = (1+3+2) * min(2,3,4) = 12.
 * - We choose the indices 1, 2, and 3 with score = (3+3+2) * min(1,3,4) = 8.
 * Therefore, we return the max score, which is 12.
 *
 * https://leetcode.com/problems/maximum-subsequence-score/
 * https://leetcode.com/problems/maximum-performance-of-a-team/
 */
public class I_MaxSubsequenceScore__ {
    /**
     Explanation:
     We iterate all pairs (A[i], B[i]) with B[i] from big to small,
     We keep the priority queue with maximum size of k.
     Each time when we introduce a new pair of (A[i], B[i]),
     the current minimum value on B is B[i]
     the current sum value on A is sum(priority queue)

     If the size of queue > k,
     we pop the minimum A[i].
     also update total sum -= A[i]

     If the size of queue == k,
     we update res = res = max(res, sum * B[i])


     Complexity
     Time O(nlogn)
     Space O(n)
     */
    public static long maxScore(int[] speed, int[] efficiency, int k) {
        int n = speed.length;
        int[][] ess = new int[n][2];
        for (int i = 0; i < n; ++i)
            ess[i] = new int[] {efficiency[i], speed[i]};
        Arrays.sort(ess, (a, b) -> b[0] - a[0]);
        Queue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long res = 0, sumS = 0;
        for (int[] es : ess) {
            pq.add(es[1]);
            sumS += es[1];
            if (pq.size() > k) sumS -= pq.poll();
            if (pq.size() == k) res = Math.max(res, (sumS * es[0]));
        }
        return res;
    }

    public static void main(String args[]) {
        maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3);
    }
}
