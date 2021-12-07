package com.practice.B_algo.A_sort_search_math.search;

import java.util.*;

/**
 * Created by prathapchowdary on 07/12/21.
 *
 * https://leetcode.com/problems/intersection-of-two-arrays-ii
 */
public class E_IntersectionOfTwoArraysWithDuplicates {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int i : nums2) {
            if(map.containsKey(i)){
                if (map.get(i) > 0) {
                    map.put(i, map.get(i) - 1);
                    result.add(i);
                } else {
                    map.remove(i);
                }
            }
        }

        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i]=result.get(i);
        }
        return ints;
    }

    //optimized for space and fewer lines of code
    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect1(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int k=0;
        for (int i : nums2) {
            int cnt = map.getOrDefault(i, 0);
            if (cnt > 0) {
                nums1[k++] = i;
                map.put(i, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
