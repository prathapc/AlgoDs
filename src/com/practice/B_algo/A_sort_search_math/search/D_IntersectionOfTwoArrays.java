package com.practice.B_algo.A_sort_search_math.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by prathapchowdary on 07/12/21.
 *
 * https://leetcode.com/problems/intersection-of-two-arrays
 *
 */
public class D_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        List<Integer> result = new ArrayList<>();
        for (int i : nums2) {
            if(set.contains(i)){
                result.add(i);
                set.remove(i);
            }
        }

        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i]=result.get(i);
        }
        return ints;
    }
    //Also can be solved with limited space by sorting input arrays. Think..
}
