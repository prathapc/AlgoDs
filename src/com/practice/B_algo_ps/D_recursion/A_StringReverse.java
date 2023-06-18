package com.practice.B_algo_ps.D_recursion;

/**
 * Created by prathapchowdary on 14/10/21.
 *
 * Reverse string in O(1) space
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 */
public class A_StringReverse {

    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }

    //Recursive solution - O(n) time and space
    public void helper(char[] s, int left, int right) {
        if (left >= right) return;

        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;

        helper(s, left, right);
    }

    //Iterative solution
    public void reverseString_Iteration(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}
