package com.practice.A_ds.D_heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by prathapchowdary on 06/06/22.
 */
public class F_MedianOfTwoSortedArrays {
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
}
