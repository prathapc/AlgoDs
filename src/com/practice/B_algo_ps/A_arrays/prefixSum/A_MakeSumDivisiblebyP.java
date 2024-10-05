package com.practice.B_algo_ps.A_arrays.prefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 04/10/24.
 *
 * Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that
 * the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.
 *
 * Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.
 *
 * Input: nums = [3,1,4,2], p = 6
 * Output: 1
 * Explanation: The sum of the elements in nums is 10, which is not divisible by 6.
 * We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.
 *
 * https://leetcode.com/problems/make-sum-divisible-by-p/
 */
public class A_MakeSumDivisiblebyP {

    /**
     * Approach 1: Brute Force (Time Limit Exceeded)
     * ---------------------------------------------
     * Our goal is to remove the smallest subarray so that the sum of the remaining elements is divisible by p.
     *
     * If the total sum of the array is already divisible by p, there's no need to remove any subarray.
     * However, if the total sum isn't divisible by p, we need to find a subarray to remove.
     * The remainder of the total sum divided by p is the part we want to "eliminate"
     * by removing a subarray whose sum's remainder matches this remainder.
     *
     * To do this, we can check every possible subarray by starting at each index and calculating
     * the sum of all sub arrays that begin at this index. For each subarray, we compute the remaining
     * sum of the elements after removing it. If the remaining sum becomes divisible by p, we record
     * the length of the subarray. We keep track of the smallest such subarray length as we proceed
     * through all possibilities.
     *
     * This is inefficient because we compute the sum for every subarray, leading to quadratic time complexity.
     * So, this will work for small arrays but will struggle with larger inputs, leading to TLE.
     *
     * Approach 2: Prefix Sum Modulo
     * -----------------------------
     * We want to reduce the number of subarray checks while still solving the problem correctly.
     * Usually, when we have a problem that involves the summation of a subarray, we resort to prefix sums.
     * This lowers the time complexity of computing subarray summations to O(1),
     * as sum(i, j) = sum(0, j) - sum(0, i-1).
     *
     * Instead of trying all sub arrays, we keep track of the prefix sum as we iterate through the array.
     * For each index, we compute the current prefix sum modulo p. The remainder of the total sum modulo p
     * gives us a "target" remainder we want to eliminate. This is where modular arithmetic becomes useful:
     * if, at some point in our prefix sum, we find that removing a certain portion of the array will
     * leave a sum divisible by p, we have our solution.
     *
     * To speed this up, we use a hash map to store the earliest occurrence of each remainder (prefix sum modulo p).
     * By doing so, when we encounter the same remainder later on, we know that the subarray between
     * these two occurrences can be removed to make the sum divisible by p. This allows us to find
     * the smallest subarray length in linear time, drastically improving the efficiency of the algorithm.
     *
     * check A_MakeSumDivisiblebyP-img.png for formulae
     */

    class Solution {
        public int minSubarray(int[] nums, int p) {
            int n = nums.length;
            int totalSum = 0;

            // Step 1: Calculate total sum and target remainder
            for (int num : nums) {
                totalSum = (totalSum + num) % p; //fails for input = [1000000000,1000000000,1000000000] if no % p for finding totalSum
            }

            int target = totalSum % p;
            if (target == 0) {
                return 0; // The array is already divisible by p
            }

            // Step 2: Use a hash map to track prefix sum mod p
            Map<Integer, Integer> modMap = new HashMap<>();
            modMap.put(0, -1); // To handle the case where the whole prefix is the answer
            int currentSum = 0;
            int minLen = n;

            // Step 3: Iterate over the array
            for (int i = 0; i < n; ++i) {
                currentSum = (currentSum + nums[i]) % p;

                // Calculate what we need to remove
                int needed = (currentSum - target + p) % p;

                // If we have seen the needed remainder, we can consider this subarray
                if (modMap.containsKey(needed)) {
                    minLen = Math.min(minLen, i - modMap.get(needed));
                }

                // Store the current remainder and index
                modMap.put(currentSum, i);
            }

            // Step 4: Return result
            return minLen == n ? -1 : minLen;
        }
    }
}
