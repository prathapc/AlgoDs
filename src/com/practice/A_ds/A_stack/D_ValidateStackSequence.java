package com.practice.A_ds.A_stack;

import java.util.Stack;

/**
 * Created by Prathap on 22 Dec, 2019
 *
 * https://leetcode.com/problems/validate-stack-sequences/
 *
 */
public class D_ValidateStackSequence {

    public static void main(String args[]) {
        int[] pushed = {2,1,0};
        int[] popped = {1,2,0};
        System.out.println(validateStackSequences(pushed, popped));
    }

    private static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 || popped.length == 0) {
            if (pushed.length == 0 && popped.length == 0) {
                return true;
            }
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i=0; i<pushed.length; i++) {
            stack.push(pushed[i]);
            if (pushed[i] == popped[popIndex]) {
                while (!stack.isEmpty()) {
                    if (stack.peek() == popped[popIndex]) {
                        stack.pop();
                        ++popIndex;
                    } else {
                        break;
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != popped[popIndex++]) {
                return false;
            }
        }
        return true;
    }

}
