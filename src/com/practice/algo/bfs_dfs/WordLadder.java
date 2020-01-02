package com.practice.algo.bfs_dfs;

import java.util.*;

/**
 * Created by Prathap on 27 Nov, 2019
 *
 * https://leetcode.com/problems/word-ladder/submissions/
 *
 */
public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> counterMap = new HashMap<>();
        counterMap.put(beginWord, 1);
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (String word : wordList) {
                if (canGo(cur, word)) {
                    if (counterMap.get(word) != null)
                        continue;
                    counterMap.put(word, counterMap.get(cur) + 1);
                    queue.offer(word);
                    if (word.equals(endWord)) {
                        return counterMap.get(word);
                    }
                }
            }
        }
        return 0;
    }

    private static boolean canGo(String org, String dest) {
        char[] orgChars = org.toCharArray();
        char[] destChars = dest.toCharArray();
        int counter = 0;
        for (int i = 0; i < orgChars.length; i++) {
            if (orgChars[i] == destChars[i]) {
                counter++;
            }
        }
        return counter == org.length() - 1;
    }

    /**
     * Input:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * Output: 5
     *
     * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     */
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        List<String> list = new ArrayList<>();
        list.add("hot");list.add("dot");list.add("dog");list.add("lot");list.add("log");list.add("cog");
        System.out.println(ladderLength(start, end, list));
    }

}