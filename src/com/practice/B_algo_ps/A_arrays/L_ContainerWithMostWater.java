package com.practice.B_algo_ps.A_arrays;

/**
 * Created by prathapchowdary on 25/05/22.
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 * https://leetcode.com/problems/container-with-most-water/
 */
public class L_ContainerWithMostWater {

    /**
     * We take two pointers, one at the beginning and one at the end of the array constituting
     * the length of the lines. Futher, we maintain a variable maxarea to store the maximum area obtained till now.
     * At every step, we find out the area formed between them, update maxarea and move the pointer
     * pointing to the shorter line towards the other end by one step.
     *
     */
    public int maxArea2(int[] height) {
        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }
}
