package com.practice.A_ds.A_stack;

import java.util.Stack;

/**
 * Created by prathapchowdary on 01/07/23.
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class L_LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int currHeight = 0, currIndex = 0, maxArea = 0;
        for (int i=0; i<heights.length; i++) {
            currHeight = heights[i];
            currIndex = i;
            // check if curr is less than stack elements , if so remove from stack and then
            //calcluate area from current i to the element being removed
            //in this way we will keep only elements which are of same or less than current
            //
            while (!stack.isEmpty() && stack.peek()[1] > currHeight) {
                int[] prev = stack.pop();
                maxArea = Math.max(maxArea, prev[1] * (i - prev[0]));
                currIndex = prev[0];
            }
            stack.push(new int[]{currIndex, currHeight});
        }
        while (!stack.isEmpty()) {
            int[] prev = stack.pop();
            maxArea = Math.max(maxArea, prev[1] * (heights.length-prev[0]));
        }

        return maxArea;
    }
}

