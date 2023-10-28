package com.practice.B_algo_ps.B_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prathapchowdary on 21/10/23.
 *
 * Design an algorithm to encode a list of strings to a string.
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 *
 * Input: [“hello”,”world”]
 * Output: “5#hello5#world”
 *
 * https://leetcode.com/problems/encode-and-decode-strings/ [locked]
 */
public class B_EncodeAndDecodeStrings {
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('/').append(str);
        }
        return sb.toString();
    }
    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            res.add(s.substring(slash + 1, slash + size + 1));
            i = slash + size + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList(new String[]{"hello", "world"});
        String encodedStr = encode(input);
        System.out.println(encodedStr);
        System.out.println(decode(encodedStr));
    }
}
