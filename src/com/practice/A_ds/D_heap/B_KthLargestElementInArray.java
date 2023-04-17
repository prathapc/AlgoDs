package com.practice.A_ds.D_heap;

import java.util.*;

/**
 * Created by prathapchowdary on 04/01/22.
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 */
public class B_KthLargestElementInArray {

    //The time complexity of adding an element in a heap of size k is O(logk),
    //and we do it N times that means O(Nlogk) time complexity for the algorithm.
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b-a); //maxHeap
        for (int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
        }
        while (!pq.isEmpty()) {
            int i = pq.poll();
            if (--k == 0) {
                return i;
            }
        }
        return -1;
    }
}
