package com.practice.B_algo.B_arrays;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Created by prathapchowdary on 22/03/22.
 *
 * Input: nums = [3,2,1]
 * Output: 1
 *
 * Input: [1,2,-2147483648]
 * output: -2147483648
 *
 * https://leetcode.com/problems/third-maximum-number/
 */
public class F_ThirdMaxNumber {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int largest = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            largest = Math.max(largest, num);
        }
        Queue<Integer> minheap = new PriorityQueue<>();
        for (int num : set) {
            if (minheap.size() < 3) {
                minheap.offer(num);
            } else if (num > minheap.peek()) {
                minheap.poll();
                minheap.offer(num);
            }
        }
        return minheap.size() == 3 ? minheap.peek() : largest;
    }
}
