package com.practice.B_algo_ps.B_strings;

/**
 * Created by prathapchowdary on 30/05/23.
 *
 * Input: s = "hello"
 * Output: "holle"
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string
 */
public class A_ReverseVowelsOfString {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = s.length()-1;
        while (start < end) {
            while (!isVowel(chars[start]) && start < end) start++;
            while (!isVowel(chars[end]) && end > start) end--;
            if (start >= end) break;
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }

    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') return true;
        return false;
    }
}
