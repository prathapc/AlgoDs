package com.practice.B_algo_ps.A_arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 13/01/22.
 *
 * Given an integer array nums and an integer k,
 * return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.
 *
 * https://leetcode.com/problems/continuous-subarray-sum/
 */
public class D_SubArraySumEqualToKMultiplier {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // key: rolling sum% k, val: array index
        map.put(0, -1);
        int sum =0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            int mod = (k==0 ? sum : sum%k);
            //when map contains mod, it means that there exist an subarray from 0~j (j=map.get(mod)) where its sum%k==mod.
            //which means that subarray sum( j~i) %k==0.
            if(map.containsKey(mod) && i-map.get(mod)>1) return true;
            map.putIfAbsent(mod,i);
        }
        return false;
    }
}
