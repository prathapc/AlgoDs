package com.practice.A_ds.E_trie;
import java.util.*;
/**
 * Created by prathapchowdary on 18/09/22.
 *
 * https://leetcode.com/problems/sum-of-prefix-scores-of-strings/
 *
 * We define the score of a string word as the number of strings words[i] such that
 * word is a prefix of words[i].
 *
 * For example, if words = ["a", "ab", "abc", "cab"], then the score of "ab" is 2,
 * since "ab" is a prefix of both "ab" and "abc".
 * Return an array answer of size n where answer[i] is the sum of scores of every non-empty prefix of words[i].
 *
 * Input: words = ["abc","ab","bc","b"]
 * Output: [5,4,3,2]
 * Explanation: The answer for each string is the following:
 * - "abc" has 3 prefixes: "a", "ab", and "abc".
 * - There are 2 strings with the prefix "a", 2 strings with the prefix "ab", and 1 string with the prefix "abc".
 * The total is answer[0] = 2 + 2 + 1 = 5.
 * - "ab" has 2 prefixes: "a" and "ab".
 * - There are 2 strings with the prefix "a", and 2 strings with the prefix "ab".
 * The total is answer[1] = 2 + 2 = 4.
 * - "bc" has 2 prefixes: "b" and "bc".
 * - There are 2 strings with the prefix "b", and 1 string with the prefix "bc".
 * The total is answer[2] = 2 + 1 = 3.
 * - "b" has 1 prefix: "b".
 * - There are 2 strings with the prefix "b".
 * The total is answer[3] = 2.
 *
 */
public class C_SumOfPrefixScoresOfStrings {

    //TLE - for prefix strings don't try using hashmaps
    public int[] sumPrefixScores(String[] words) {
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

    //beats 80%
    public int[] sumPrefixScores_trie(String[] words) {
        Trie trie = new Trie();
        int[] res = new int[words.length];
        for (String s : words)
            trie.insert(s);
        int c = 0;
        for (String s : words)
            res[c++] = trie.query(s);
        return res;
    }

    class TrieNode {
        TrieNode[] children;
        int count;
        public TrieNode() {
            this.count = 0;
            this.children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        void insert(String s) {
            TrieNode curr = root;
            for (int i=0; i<s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
                curr.count++;
            }
        }
        int query(String s) {
            TrieNode curr = root;
            int res = 0;
            for (int i=0; i<s.length(); i++) {
                int index = s.charAt(i) - 'a';
                curr = curr.children[index];
                res += curr.count;
            }
            return res;
        }
    }
}
