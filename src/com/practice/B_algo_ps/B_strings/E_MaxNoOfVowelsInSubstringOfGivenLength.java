package com.practice.B_algo_ps.B_strings;

import java.util.Set;

/**
 * Created by prathapchowdary on 18/05/23.
 *
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
 */
public class E_MaxNoOfVowelsInSubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int ans = 0;
        var vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for (int i = 0, winCnt = 0; i < s.length(); ++i) {
            if (vowels.contains(s.charAt(i))) {
                ++winCnt;
            }
            if (i >= k && vowels.contains(s.charAt(i - k))) {
                --winCnt;
            }
            ans = Math.max(winCnt, ans);
        }
        return ans;
    }
}
