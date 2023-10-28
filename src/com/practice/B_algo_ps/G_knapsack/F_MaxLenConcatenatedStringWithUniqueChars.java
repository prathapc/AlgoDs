package com.practice.B_algo_ps.G_knapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathapchowdary on 04/11/21.
 *
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All the valid concatenations are:
 * - ""
 * - "un"
 * - "iq"
 * - "ue"
 * - "uniq" ("un" + "iq")
 * - "ique" ("iq" + "ue")
 * Maximum length is 4.
 */
public class F_MaxLenConcatenatedStringWithUniqueChars {

    static int maxLength = 0;
    public static void main(String args[]) {
        List<String> arr = new ArrayList<>();
        arr.add("un");arr.add("iq");arr.add("ue");
        maxLengthUtil(arr, 0, "");
        System.out.println(maxLength);
    }

    private static void maxLengthUtil(List<String> arr, int index, String current) {
        if (index == arr.size() && uniqueCharsCount(current) > maxLength) {
            maxLength = current.length();
            return;
        }
        if (index == arr.size()) {
            return;
        }

        //don't include current
        maxLengthUtil(arr, index+1, current);
        //include current
        maxLengthUtil(arr, index+1, current+arr.get(index));
    }

    private static int uniqueCharsCount(String current) {
        int[] chars = new int[26];
        for (int i=0; i<current.length(); i++) {
            if (chars[current.charAt(i) - 'a']++ > 0) {
                return -1;
            }
        }
        return current.length();
    }

}
