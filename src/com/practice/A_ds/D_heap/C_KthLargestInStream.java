package com.practice.A_ds.D_heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by prathapchowdary on 10/04/22.
 *
 * Input
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * Output
 * [null, 4, 5, 5, 8, 8]
 *
 * Explanation
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 */
public class C_KthLargestInStream {
    Queue<Integer> pq = null;
    int k;
    public C_KthLargestInStream(int k, int[] nums) {
        pq = new PriorityQueue<>();
        for (int i: nums) pq.add(i);
        this.k = k;

        while (pq.size() > k) {
            pq.poll();
        }
    }

    public int add(int val) {
        pq.add(val);
        while (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
