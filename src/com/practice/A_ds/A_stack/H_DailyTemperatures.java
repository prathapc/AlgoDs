package com.practice.A_ds.A_stack;

import java.util.Stack;

/**
 * Created by prathapchowdary on 15/03/22.
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 * https://leetcode.com/problems/daily-temperatures/
 */
public class H_DailyTemperatures {

    // first came up with this then realised no need of int[] instead can simply store index (sol below)
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i=1; i<temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                result[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
