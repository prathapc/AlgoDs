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
public class L_LargestRectangleInHistogram_ {

    public static int largestRectangleArea(int[] heights) {
        int area = 0, n = heights.length;
        int start;
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            int curHt =heights[i];
            start = i;
            while(!stack.isEmpty() && stack.peek()[1] > curHt){
                int[] pair = stack.pop();
                int index = pair[0];
                int h = pair[1];
                area = Math.max(area, h * (i - index));
                start = index;
            }
            stack.push(new int[]{start,curHt});
        }

        while(!stack.isEmpty()){
            int[] pair = stack.pop();
            int index = pair[0];
            int h = pair[1];
            area = Math.max(area, h * (n - index));
        }
        return area;
    }


    //TODO
    public static int largestRectangleArea1(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int currHeight = 0, currIndex = 0, maxArea = 0;
        for (int i=0; i<heights.length; i++) {
            currHeight = heights[i];
            currIndex = i;
            // check if curr is less than stack elements , if so remove from stack and then
            //calculate area from current i to the element being removed
            //in this way we will keep only elements which are of same or less than current


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

    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack();
        int maxArea = 0;
        for(int i = 0; i <= n; i++) {
            int h = (i==n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]){
                int curHeight = heights[stack.pop()];
                int prevIndex = stack.isEmpty() ? -1 : stack.peek();
                int area = curHeight * (i - prevIndex - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }


    //using two arrays
    public static int largestRectangleArea3(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
}

