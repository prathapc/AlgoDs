package com.practice.algo.strings;

/**
 * Created by Prathap on 07 Nov, 2019
 *
 * https://leetcode.com/problems/count-and-say/
 *
 */
public class CountAndSay {

    public static void main(String args[]) {
        int n = 4;
        if (n == 1) {
            System.out.println("1");
        }
        String num = "1";
        for (int i=1; i<n; i++) {
            num = countAndSayUtil(num);
        }
        System.out.println(num);
    }

    private static String countAndSayUtil(String input) {
        String result = "";
        //String input = String.valueOf(n);
        if (input.length() == 1) {
            return "1" + input.charAt(0);
        }
        char prev = input.charAt(0);
        int prevCount = 1;
        for (int i=1; i<input.length(); i++) {
            if (input.charAt(i) == prev) {
                prevCount++;
                continue;
            }
            result = result + prevCount + "" + prev;
            prev = input.charAt(i);
            prevCount = 1;
        }
        result = result + "" + prevCount + "" + prev;
        return result;
    }

}
