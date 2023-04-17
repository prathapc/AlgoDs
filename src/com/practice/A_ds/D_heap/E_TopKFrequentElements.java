package com.practice.A_ds.D_heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by prathapchowdary on 14/01/22.
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * https://leetcode.com/problems/top-k-frequent-elements
 */
public class E_TopKFrequentElements {

    //overal O(NlogK) complexity - check individual section time complexities below
    public int[] topKFrequent(int[] nums, int k) {

        //O(N)
        Map<Integer, Integer> data = new HashMap<>();
        for (int i : nums) {
            data.put(i, data.getOrDefault(i, 0) + 1);
        }

        //O(NlogK)
        Queue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            return b[1] - a[1];
        });
        for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        //O(KlogK)
        int result[] = new int[k];
        for(int i=0; i<k; i++) {
            result[i] = pq.poll()[0];
        }
        return result;
    }
}
