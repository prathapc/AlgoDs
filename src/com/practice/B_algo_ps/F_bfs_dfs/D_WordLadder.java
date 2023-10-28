package com.practice.B_algo_ps.F_bfs_dfs;

import java.util.*;

/**
 * Created by Prathap on 27 Nov, 2019
 *
 * https://leetcode.com/problems/word-ladder/
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
public class D_WordLadder {
    //Note: for finding the shortest path we have to use BFS, as DFS will find route but not optimal/shortest
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        List<String> list = new ArrayList<>();
        list.add("hot");list.add("dot");list.add("dog");list.add("lot");list.add("log");list.add("cog");
        System.out.println(ladderLength1(start, end, list));
    }

    //Runtime: beats 58.2%
    //Time Complexity :- BigO(M^2 * N), where M is size of dequeued word & N is size of our word list
    //Space Complexity :- BigO(M * N) where M is no. of character that we had in our string & N is the size of our wordList.
    public static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visited = new HashSet<>();
        queue.add(beginWord);

        int changes = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord))
                    return changes;

                for (int j = 0; j < word.length(); j++) {
                    for (int k = 'a'; k <= 'z'; k++) {
                        char arr[] = word.toCharArray();
                        arr[j] = (char) k;

                        String str = new String(arr);
                        if (set.contains(str) && !visited.contains(str)) {
                            queue.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            ++changes;
        }
        return 0;
    }
}