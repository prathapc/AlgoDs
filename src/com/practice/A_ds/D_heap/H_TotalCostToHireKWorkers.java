package com.practice.A_ds.D_heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by prathapchowdary on 24/06/23.
 *
 * Input: costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
 * Output: 11
 * Explanation: We hire 3 workers in total. The total cost is initially 0.
 * - In the first hiring round we choose the worker from [17,12,10,2,7,2,11,20,8].
 *   The lowest cost is 2, and we break the tie by the smallest index, which is 3. The total cost = 0 + 2 = 2.
 * - In the second hiring round we choose the worker from [17,12,10,7,2,11,20,8].
 *   The lowest cost is 2 (index 4). The total cost = 2 + 2 = 4.
 * - In the third hiring round we choose the worker from [17,12,10,7,11,20,8].
 *   The lowest cost is 7 (index 3). The total cost = 4 + 7 = 11. Notice that the worker with index 3 was common in the first and last four workers.
 * The total hiring cost is 11.
 *
 * https://leetcode.com/problems/total-cost-to-hire-k-workers/
 */
public class H_TotalCostToHireKWorkers {

    class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            int i = 0;
            int j = costs.length - 1;
            PriorityQueue<Integer> pq1 = new PriorityQueue<>();
            PriorityQueue<Integer> pq2 = new PriorityQueue<>();

            long ans = 0;
            while (k-- > 0) {
                while (pq1.size() < candidates && i <= j) {
                    pq1.offer(costs[i++]);
                }
                while (pq2.size() < candidates && i <= j) {
                    pq2.offer(costs[j--]);
                }

                int t1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
                int t2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;

                if (t1 <= t2) {
                    ans += t1;
                    pq1.poll();
                } else {
                    ans += t2;
                    pq2.poll();
                }
            }
            return ans;
        }
    }
}
