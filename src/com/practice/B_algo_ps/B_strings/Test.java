package com.practice.B_algo_ps.B_strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by prathapchowdary on 18/09/22.
 */
public class Test {
    public static void main(String args[]) {
        //longestContinuousSubstring("abcde");
        String[] input = {"abc","ab","bc","b"};
        sumPrefixScores(input);

    }

    public static int[] sumPrefixScores(String[] words) {
        Map<Integer, List<String>> prefixes = new HashMap<>();
        Map<String, Integer> prefixCount = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            int l=0, r=0;
            String word = words[i];
            List<String> temp = new ArrayList<>();
            while (r<word.length()) {
                String subStr = word.substring(l,++r);
                temp.add(subStr);
                prefixCount.put(subStr, prefixCount.getOrDefault(subStr, 0) + 1);
            }
            prefixes.put(i, temp);
        }

        int[] result = new int[words.length];
        int k = 0;
        for (var prefixEntry : prefixes.entrySet()) {
            List<String> ps = prefixEntry.getValue();
            int c = 0;
            for (String prefix : ps) {
                if (prefixCount.containsKey(prefix)) {
                    result[k] += prefixCount.get(prefix);
                }
            }
            k++;
        }
        return result;
    }

    public static int longestContinuousSubstring(String s) {
        int l=0, r=1, ans=0;
        while (l<r && r<s.length()) {
            if (s.charAt(r) == s.charAt(r-1) + 1) {
                ans = Math.max(ans, r-l+1);
            } else {
                l = r;
            }
            r++;
        }
        return ans;
    }
}
