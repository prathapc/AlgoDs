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
    static Queue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2-i1);
    static Queue<Integer> minHeap = new PriorityQueue<>();
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return findMedianSortedArrays1(nums2, nums1);
        }

        addToHeap(nums1);
        addToHeap(nums2);

        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            return 0d;
        } else if (maxHeap.isEmpty()) {
            return (double) minHeap.peek();
        } else if (minHeap.isEmpty()) {
            return (double) maxHeap.peek();
        } else {
            if (minHeap.size() > maxHeap.size()) return minHeap.peek();
            else if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
            else return (minHeap.peek() + maxHeap.peek())/2.0d;
        }
    }
    private static void addToHeap(int[] nums) {
        for (int i : nums) {
            if (maxHeap.isEmpty()) { //starting element (min element) should go to maxheap; order is important
                maxHeap.offer(i);
            } else if (minHeap.isEmpty()) {
                minHeap.offer(i);
            } else {
                if (i >= minHeap.peek()) {
                    if (minHeap.size() > maxHeap.size()) {
                        minHeap.offer(i);
                        maxHeap.offer(minHeap.poll());
                    } else {
                        minHeap.offer(i);
                    }
                } else {
                    if (maxHeap.size() > minHeap.size()) {
                        maxHeap.offer(i);
                        minHeap.offer(maxHeap.poll());
                    } else {
                        maxHeap.offer(i);
                    }
                }
            }
        }
    }
}
