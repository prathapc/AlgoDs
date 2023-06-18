package com.practice.B_algo_ps.B_strings;

/**
 * Created by prathapchowdary on 30/05/23.
 *
 * Input: chars = ["a","a","b","b","c","c","c"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 *
 * https://leetcode.com/problems/string-compression
 * #leetcode75
 */
public class B_StringCompression {
    public static int compress(char[] chars) {
        if (chars.length == 1) return 1;
        int index = -1, c = 1;
        char prevChar = chars[0];
        for (int i=1; i<chars.length; i++) {
            if (chars[i] == prevChar) {
                c++;
            } else {
                chars[++index] = prevChar;
                if (c > 1) {
                    String temp = String.valueOf(c);
                    for (int t=0; t<temp.length(); t++) {
                        chars[++index] = temp.charAt(t);
                    }
                }
                c = 1;
            }
            prevChar = chars[i];
        }
        chars[++index] = prevChar;
        if (c > 1) {
            String temp = String.valueOf(c);
            for (int t=0; t<temp.length(); t++) {
                chars[++index] = temp.charAt(t);
            }
        }
        return index+1;
    }

    public static void main(String args[]) {
        compress(new char[]{'a','a','b','b','c','c','c'});
    }
}
