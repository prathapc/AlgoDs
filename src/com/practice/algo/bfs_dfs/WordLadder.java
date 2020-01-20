package com.practice.algo.bfs_dfs;

import java.util.*;

/**
 * Created by Prathap on 27 Nov, 2019
 *
 * https://leetcode.com/problems/word-ladder/submissions/
 *
 * find the length of shortest transformation sequence from beginWord to endWord
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * return its length 5.
 *
 */
public class WordLadder {

    //easy but beats only 5%;
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

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        List<String> list = new ArrayList<>();
        list.add("hot");list.add("dot");list.add("dog");list.add("lot");list.add("log");list.add("cog");
        System.out.println(ladderLength(start, end, list));
    }

    //Runtime: 72 ms, faster than 42.21% of Java online submissions for Word Ladder.
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Deque<String> q = new LinkedList<>();
        q.offer(beginWord);
        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        int count = 1; //counting the begin word
        Set<String> visited = new HashSet<>();
        while(!q.isEmpty()){
            int sizeOfLevel = q.size();
            for(int i = 0;i<sizeOfLevel;i++){
                String curr = q.poll();
                if(curr.equals(endWord)){
                    return count;
                }else{
                    if(!visited.contains(curr)) { //only then explore
                        visited.add(curr);

                        for(int k = 0;k<curr.length();k++){
                            char[] arr = curr.toCharArray();   //RESETS the chars and we pick next index
                            for(char c= 'a';c<='z';c++){
                                arr[k] = c;
                                String word = new String(arr);
                                if(dict.contains(word) && !visited.contains(word)){
                                    q.offer(word);
                                }
                            }
                        }
                    }
                }
            }
            count++; //next level
        }
        return 0;
    }

}