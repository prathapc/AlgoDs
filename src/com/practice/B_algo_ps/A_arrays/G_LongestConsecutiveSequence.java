package com.practice.B_algo_ps.A_arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by prathapchowdary on 07/04/22.
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class G_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> data = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int result = 0;
        for (int i : data) {
            if (!data.contains(i-1)) {
                int temp = 0;
                while (data.contains(i++)) {
                    temp++;
                }
                result = Math.max(result, temp);
            }
        }
        return result;
    }

    /**
     * Time complexity : O(n).
     *
     * Although the time complexity appears to be quadratic due to the while loop nested within the for loop,
     * closer inspection reveals it to be linear. Because the while loop is reached only when currentNum marks
     * the beginning of a sequence (i.e. currentNum-1 is not present in nums), the while loop can only run for
     * n iterations throughout the entire runtime of the algorithm. This means that despite looking like O(n.n)
     * complexity, the nested loops actually run in O(n+n)=O(n) time. All other computations occur in constant time,
     * so the overall runtime is linear.
     *
     * Space complexity : O(n).
     *
     * In order to set up O(1) containment lookups, we allocate linear space for a hash table
     * to store the O(n) numbers in nums.
     */



    //nlogn => 40/74 passed
    public int longestConsecutive_2(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int prev = nums[0], result = 1, temp = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == prev+1) {
                temp++;
            } else {
                result = Math.max(result, temp);
                temp = 1;
            }
            prev = nums[i];
        }
        result = Math.max(result, temp);
        return result;
    }

    //time limit exceeded
    public int longestConsecutive_1(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> data = new HashSet<>();
        int min = nums[0], max = nums[0];
        for (int i : nums) {
            data.add(i);
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int result = 1;
        for (int i=min; i<=max; i++) {
            if (data.contains(i)) {
                int temp = 1;
                while (data.contains(++i)) temp++;
                result = Math.max(result, temp);
            }
        }
        return result;
    }
}
