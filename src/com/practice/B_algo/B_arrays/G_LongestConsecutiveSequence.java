package com.practice.B_algo.B_arrays;

import java.util.HashSet;
import java.util.Set;

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
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;
        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
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
}
