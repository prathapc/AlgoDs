package com.practice.ps.leetcode;

import java.util.*;

/**
 * Created by Prathap on 24 Jan, 2020
 *
 * https://leetcode.com/problems/longest-string-chain/
 *
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it
 * equal to word2.  For example, "abc" is a predecessor of "abac"
 *
 * Input: ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: one of the longest word chain is "a","ba","bda","bdca".
 */
public class P1048_LongestStringChain {

    public static void main(String args[]) {
        String[] input = {"a","b","ba","bca","bda","bdca"};
        longestStrChain(input);
    }

    public static int longestStrChain(String[] words) {
        if(words.length == 0)
            return 0;

        int max = 1;
        TreeMap<Integer, List<String>> wordsByLength = new TreeMap<>();
        Map<String, Integer> chains = new HashMap<>();

        //build map with key as length of word and value as list of words of that length
        for(String word: words) {
            wordsByLength.computeIfAbsent(word.length(), x->new ArrayList<String>());
            wordsByLength.get(word.length()).add(word);
        }

        for(Integer wordLength: wordsByLength.keySet()) {
            if(wordsByLength.higherKey(wordLength)!=null) {
                for(String w1: wordsByLength.get(wordLength)) {
                    for(String w2: wordsByLength.get(wordLength+1)) {
                        if(isChain(w1, w2)) {
                            Integer chainLength = chains.get(w1)==null?2:chains.get(w1)+1;
                            chains.put(w2, chainLength);
                            max = Math.max(max, chainLength);
                        }
                    }
                }
            }
        }
        return max;
    }

    private static boolean isChain(String w1, String w2) {
        if(w1.length() != w2.length()-1)
            return false;
        int i=0, j=0, diff = 0;
        while(i<w1.length() && j<w2.length()) {
            if(w1.charAt(i)!=w2.charAt(j)) {
                if(diff==0) {
                    diff++;
                    j++;
                    continue;
                } else {
                    return false;
                }
            }
            j++;
            i++;
        }
        return true;
    }

}
