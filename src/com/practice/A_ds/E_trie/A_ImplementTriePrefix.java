package com.practice.A_ds.E_trie;

/**
 * Created by prathapchowdary on 29/06/23.
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class A_ImplementTriePrefix {
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
    public A_ImplementTriePrefix() {
        root = new Node(' ');
    }

    public void insert(String word) {
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
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            if (node.children[word.charAt(i)] != null) {
                node = node.children[word.charAt(i)];
            } else {
                return false;
            }
            if (i == word.length()-1) return node.isEnd;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i=0; i<prefix.length(); i++) {
            if (node.children[prefix.charAt(i)] != null) {
                node = node.children[prefix.charAt(i)];
            } else {
                return false;
            }
            if (i == prefix.length()-1) return true; //only difference from above as we dont need to check isEnd for prefix
        }
        return false;
    }
}
