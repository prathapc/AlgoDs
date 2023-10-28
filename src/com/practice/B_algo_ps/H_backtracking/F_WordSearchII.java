package com.practice.B_algo_ps.H_backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by prathapchowdary on 10/06/22.
 *
 * https://leetcode.com/problems/word-search-ii/
 * Previous word-search-I problem timesout for a large board of length 10 with multiple string inputs
 */
class F_WordSearchII {

    //NOTE::
    //62 / 65 testcases passed with previous word-search solution
    //input word list for failed test case is too large; hence building
    //Trie for input word list and iterating in grid for matching words in Trie would be efficient by
    //discontinuing prefixes not found in Trie early.
    //***********************************************************

    private static int COLS;
    private static int ROWS;
    private Trie root;
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            root.addWord(word);
        }

        ROWS = board.length;
        COLS = board[0].length;
        Set<String> res = new HashSet<>();
        Set<String> visit = new HashSet<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(r, c, root, "", res, visit, board, root);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(
        int r,
        int c,
        Trie node,
        String word,
        Set<String> res,
        Set<String> visit,
        char[][] board,
        Trie root
    ) {
        if (r < 0 || c < 0 || r == ROWS || c == COLS || visit.contains(r + "-" + c) ||
            !node.children.containsKey(board[r][c]) ||
            node.children.get(board[r][c]).refs < 1) {
            return;
        }

        visit.add(r + "-" + c);
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if (node.isWord) {
            node.isWord = false;
            res.add(word);
            root.removeWord(word);
        }

        dfs(r + 1, c, node, word, res, visit, board, root);
        dfs(r - 1, c, node, word, res, visit, board, root);
        dfs(r, c + 1, node, word, res, visit, board, root);
        dfs(r, c - 1, node, word, res, visit, board, root);
        visit.remove(r + "-" + c);
    }

    class Trie {
        public HashMap<Character, Trie> children;
        public boolean isWord;
        public int refs = 0;

        public Trie() {
            children = new HashMap<>();
        }

        public void addWord(String word) {
            root = this;
            root.refs += 1;
            for (int i = 0; i < word.length(); i++) {
                char currentCharacter = word.charAt(i);
                if (!root.children.containsKey(currentCharacter)) {
                    root.children.put(currentCharacter, new Trie());
                }
                root = root.children.get(currentCharacter);
                root.refs += 1;
            }
            root.isWord = true;
        }

        public void removeWord(String word) {
            root = this;
            root.refs -= 1;
            for (int i = 0; i < word.length(); i++) {
                char currentCharacter = word.charAt(i);
                if (root.children.containsKey(currentCharacter)) {
                    root = root.children.get(currentCharacter);
                    root.refs -= 1;
                }
            }
        }
    }
}



