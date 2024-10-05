package com.practice.B_algo_ps.K_sort_search_math.math_geometry;

import java.util.Arrays;

/**
 * Created by prathapchowdary on 15/02/24.
 *
 * You are given an array of positive integers nums of length n.
 * A polygon is a closed plane figure that has at least 3 sides. The longest side of a polygon
 * is smaller than the sum of its other sides.
 *
 * Input: nums = [1,12,1,2,5,50,3]
 * Output: 12
 * Explanation: The polygon with the largest perimeter which can be made from nums has 5 sides: 1, 1, 2, 3, and 5. The perimeter is 1 + 1 + 2 + 3 + 5 = 12.
 * We cannot have a polygon with either 12 or 50 as the longest side because it is not possible to include 2 or more smaller sides that have a greater sum than either of them.
 * It can be shown that the largest possible perimeter is 12.
 *
 * https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/
 */
public class PolygonWithLargestPerimeter {
    public long largestPerimeter(int[] nums) {
        long sum = 0;
        for (int n : nums) sum += n;
        Arrays.sort(nums);
        long perimeter = 0;
        for (int i=nums.length-1; i>=0; i--) {
            int currNum = nums[i];
            long remainingSum = sum - currNum;
            if (currNum >= remainingSum) {
                sum -= currNum;
            } else {
                perimeter += currNum;
            }
        }
        return perimeter == 0 ? -1 : perimeter;
    }
}
