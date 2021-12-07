package com.practice.C_ps;

import java.util.*;

/**
 * Created by Prathap on 18 Jan, 2020
 *
 * https://leetcode.com/problems/reorganize-string/
 *
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 *
 * Input: S = "aab"
 * Output: "aba"
 */
public class P767_ReorganizeString {

    public String reorganizeString(String S) {
        Map<Character, CharCounter> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            CharCounter cc = map.get(c);
            if (cc == null) {
                cc = new CharCounter(c, 1);
                map.put(c, cc);
            } else {
                cc.count ++;
            }
        }

        PriorityQueue<CharCounter> maxHeap = new PriorityQueue<>((c1, c2) -> c2.count - c1.count);
        maxHeap.addAll(map.values());

        char[] res = new char[S.length()];
        for (int i = 0; i < res.length; i++) {
            CharCounter mostFrequency = maxHeap.poll();
            if (i == 0 || mostFrequency.c != res[i-1]) {
                res[i] = mostFrequency.c;
                mostFrequency.count --;
            } else if (!maxHeap.isEmpty()) {
                CharCounter secondMostFrequency = maxHeap.poll();
                res[i] = secondMostFrequency.c;
                secondMostFrequency.count--;
                if (secondMostFrequency.count > 0) {
                    maxHeap.add(secondMostFrequency);
                }
            } else {
                return "";
            }
            if (mostFrequency.count > 0) {
                maxHeap.add(mostFrequency);
            }
        }
        return String.valueOf(res);
    }

    static class CharCounter {
        public char c;
        public int count;
        public CharCounter(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

}
