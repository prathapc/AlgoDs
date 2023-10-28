package com.practice.B_algo_ps.E_greedy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by prathapchowdary on 19/08/23.
 *
 * Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
 * Output: 4
 * Explanation: Since your initial capital is 0, you can only start the project indexed 0.
 * After finishing it you will obtain profit 1 and your capital becomes 1.
 * With capital 1, you can either start the project indexed 1 or the project indexed 2.
 * Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
 * Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
 *
 * https://leetcode.com/problems/ipo
 */
public class F_IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<int[]> capitalPq = new PriorityQueue<>((a, b) -> a[0] - b[0]); //minHeap
        Queue<int[]> profitPq = new PriorityQueue<>((a, b) -> b[1] - a[1]); //maxHeap
        for (int i=0; i<profits.length; i++) {
            capitalPq.add(new int[]{capital[i], profits[i]});
        }
        for (int i=0; i<k; i++) {
            while (!capitalPq.isEmpty() && capitalPq.peek()[0] <= w) {
                profitPq.add(capitalPq.poll());
            }
            if (profitPq.isEmpty()) break;
            w += profitPq.poll()[1];
        }
        return w;
    }
}
