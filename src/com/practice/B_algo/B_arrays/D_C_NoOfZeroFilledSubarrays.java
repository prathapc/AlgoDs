package com.practice.B_algo.B_arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 22/03/23.
 *
 * Input: nums = [1,3,0,0,2,0,0,4]
 * Output: 6
 * Explanation:
 * There are 4 occurrences of [0] as a subarray.
 * There are 2 occurrences of [0,0] as a subarray.
 * There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.
 *
 * https://leetcode.com/problems/number-of-zero-filled-subarrays
 */
public class D_C_NoOfZeroFilledSubarrays {

    Map<Long, Long> dp = null;
    public long zeroFilledSubarray(int[] nums) {
        dp = new HashMap<>();
        long result = 0, currWindow = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                currWindow++;
            } else {
                result += noOfSubArrays(currWindow);
                currWindow = 0;
            }
        }
        result += noOfSubArrays(currWindow);
        return result;
    }

    private long noOfSubArrays(long n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (dp.containsKey(n)) return dp.get(n);
        long result = n+noOfSubArrays(n-1);
        dp.put(n, result);
        return result;
    }
    //is it arithmetic progression? n(n+1)/2
}
