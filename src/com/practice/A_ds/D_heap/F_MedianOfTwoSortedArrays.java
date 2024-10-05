package com.practice.A_ds.D_heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by prathapchowdary on 06/06/22.
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class F_MedianOfTwoSortedArrays {
    //beats 13% - good for one calculation after all nums are given
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i : nums1) minHeap.add(i);
        for (int i : nums2) minHeap.add(i);
        int half = nums1.length + nums2.length;
        if (half % 2 == 0) {
            half /= 2;
            half--;
            while (half > 0) {
                minHeap.poll();
                half--;
            }
            int a = minHeap.poll();
            int b = minHeap.poll();
            return (a + b) * 1.0 / 2;
        } else {
            half /= 2;
            while (half > 0) {
                minHeap.poll();
                half--;
            }
            return minHeap.poll() * 1.0;
        }
    }

    //another solution - beats 11% - good for stream input numbers
    Queue<Integer> maxHeap = null;
    Queue<Integer> minHeap = null;
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        maxHeap = new PriorityQueue<>((a, b) -> b-a);
        minHeap = new PriorityQueue<>();
        if (nums1.length > 0) addToHeap(nums1);
        if (nums2.length > 0) addToHeap(nums2);
        if (maxHeap.isEmpty() || minHeap.isEmpty()) {
            return maxHeap.isEmpty() ? 1.0*minHeap.poll() : 1.0*maxHeap.poll();
        } else {
            if (maxHeap.size() == minHeap.size()) return (maxHeap.poll() + minHeap.poll()) / 2.0;
            else if (maxHeap.size() > minHeap.size()) return 1.0*maxHeap.poll();
            else return 1.0*minHeap.poll();
        }
    }

    private void addToHeap(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            if (maxHeap.isEmpty()) {
                maxHeap.offer(nums[i]);
                continue;
            }
            if (maxHeap.peek() < nums[i]) {
                minHeap.offer(nums[i]);
                if (minHeap.size()-maxHeap.size() > 1) maxHeap.offer(minHeap.poll());
            } else {
                maxHeap.offer(nums[i]);
                if (maxHeap.size()-minHeap.size() > 1) minHeap.offer(maxHeap.poll());
            }

        }
    }
}
