package com.practice.A_ds.E_trie;

/**
 * Created by prathapchowdary on 31/08/23.
 *
 * Input:-
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation:-
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */
public class B_DesignAddAndSearchWords {

    class Node {
        char ch;
        Node[] children;
        boolean isEnd;
        public Node(char ch) {
            this.ch = ch;
            children = new Node[128];
            isEnd = false;
        }
    }

    Node root;
    public B_DesignAddAndSearchWords() {
        root = new Node(' ');
    }

    public void addWord(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch] != null) {
                node = node.children[ch];
            } else {
                Node curr = new Node(ch);
                node.children[ch] = curr;
                node = curr;
            }
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int i, Node node) {
        if (i == word.length()) return node.isEnd;
        if (word.charAt(i) == '.') {
            for (int j=0; j<node.children.length; j++) {
                if (node.children[j] == null) continue;
                if (search(word, i+1, node.children[j])) return true;
            }
        } else if (node.children[word.charAt(i)] != null) {
            node = node.children[word.charAt(i)];
            return search(word, i+1, node);
        }
        return false;
    }
}
