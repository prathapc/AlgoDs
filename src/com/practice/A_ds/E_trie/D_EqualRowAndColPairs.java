package com.practice.A_ds.E_trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 11/06/23.
 *
 * Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
 * Output: 1
 * Explanation: There is 1 equal row and column pair:
 * - (Row 2, Column 1): [2,7,7]
 *
 * https://leetcode.com/problems/equal-row-and-column-pairs
 *
 */
public class D_EqualRowAndColPairs {
    public int equalPairs(int[][] grid) {
        Trie trie = new Trie();
        int count = 0, n = grid.length;
        for (int[] row : grid) {
            trie.insert(row);
        }
        for (int c=0; c<n; c++) {
            int[] col = new int[n];
            for (int r=0; r<n; r++) {
                col[r] = grid[r][c];
            }
            count += trie.search(col);
        }
        return count;
    }

    class TrieNode {
        int count;
        Map<Integer, TrieNode> children;

        public TrieNode() {
            this.count = 0;
            this.children = new HashMap<>();
        }
    }

    class Trie {
        TrieNode trie;

        public Trie() {
            this.trie = new TrieNode();
        }

        public void insert(int[] arr) {
            TrieNode trieNode = this.trie;
            for (int i : arr) {
                if (!trieNode.children.containsKey(i)) {
                    trieNode.children.put(i, new TrieNode());
                }
                trieNode = trieNode.children.get(i);
            }
            trieNode.count++;
        }

        public int search(int[] arr) {
            TrieNode trie = this.trie;
            for (int i : arr) {
                if (trie.children.containsKey(i)) {
                    trie = trie.children.get(i);
                } else {
                    return 0;
                }
            }
            return trie.count;
        }

    }
}
