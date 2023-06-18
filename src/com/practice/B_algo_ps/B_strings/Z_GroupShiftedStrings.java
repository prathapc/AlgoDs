package com.practice.B_algo_ps.B_strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by prathapchowdary on 10/01/22.
 * https://leetcode.com/problems/group-shifted-strings/
 *
 * We can shift a string by shifting each of its letters to its successive letter.
 * For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd" -> ... -> "xyz"
 *
 * Input:- ["abc","bcde","acef","xyz"]
 * Output:- [["acef"],["bcde"],["abc","xyz"]]
 */
public class Z_GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings) {
            String key = getHashKey(s);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    private String getHashKey(String s) {
        String key = "";
        for (int i=1; i<s.length(); i++) {
            int diff = s.charAt(i) - s.charAt(i-1);
            key += diff < 0 ? diff + 26 : diff;
            key += ":";
        }
        return key;
    }
}
