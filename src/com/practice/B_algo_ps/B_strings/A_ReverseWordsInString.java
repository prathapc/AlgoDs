package com.practice.B_algo_ps.B_strings;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by prathapchowdary on 16/04/22.
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/
 *
 */
public class A_ReverseWordsInString {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +"); //split by one or more spaces
        Collections.reverse(Arrays.asList(words)); // array to list and reverse
        return String.join(" ", words); // join words by space
    }
}
