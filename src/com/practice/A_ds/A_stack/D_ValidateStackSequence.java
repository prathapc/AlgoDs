package com.practice.A_ds.A_stack;

import java.util.Stack;

/**
 * Created by Prathap on 22 Dec, 2019
 *
 * https://leetcode.com/problems/validate-stack-sequences/
 */
public class D_ValidateStackSequence {

    public static void main(String args[]) {
        int[] pushed = {2,1,0};
        int[] popped = {1,2,0};
        System.out.println(validateStackSequences(pushed, popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
