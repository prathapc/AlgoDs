package com.practice.B_algo.J_bfs_dfs;

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
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        List<String> list = new ArrayList<>();
        list.add("hot");list.add("dot");list.add("dog");list.add("lot");list.add("log");list.add("cog");
        System.out.println(ladderLength1(start, end, list));
    }

    //Runtime: 72 ms, faster than 42.21% of Java online submissions for Word Ladder.
    public static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
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