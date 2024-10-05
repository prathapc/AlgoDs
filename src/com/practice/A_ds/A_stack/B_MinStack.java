package com.practice.A_ds.A_stack;

import java.util.Stack;

/**
 * Created by prathapchowdary on 13/03/22.
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * https://leetcode.com/problems/min-stack/
 */
public class B_MinStack {

    Stack<int[]> stack = null;
    public B_MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (!stack.isEmpty() && stack.peek()[1] < val) {
            stack.push(new int[]{val, stack.peek()[1]});
        } else {
            stack.push(new int[]{val, val});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
