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
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, temperatures[0]});
        for (int i=0; i<temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int[] prev = stack.pop();
                result[prev[0]] = i - prev[0];
            }
            stack.push(new int[]{i, temperatures[i]});
        }
        while (!stack.isEmpty()) {
            result[stack.pop()[0]] = 0;
        }
        return result;
    }

    public int[] dailyTemperatures_1(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int prev = stack.pop();
                result[prev] = i - prev;
            }
            stack.push(i);
        }
        //no need of below while loop as int array defaults are zero
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }
        return result;
    }
}
