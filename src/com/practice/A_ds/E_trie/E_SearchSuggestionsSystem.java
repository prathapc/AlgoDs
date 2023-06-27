package com.practice.A_ds.E_trie;

import java.util.*;

/**
 * Created by prathapchowdary on 24/06/23.
 *
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
 * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
 * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"].
 *
 * https://leetcode.com/problems/search-suggestions-system/
 */
public class E_SearchSuggestionsSystem {
    class Trie {
        Trie[] children;
        LinkedList<String> suggestion;

        public Trie() {
            children = new Trie[26];
            suggestion = new LinkedList<>();
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        for (String p : products) {
            insert(p, root);
        }
        return search(searchWord, root);
    }
    private void insert(String p, Trie root) {
        Trie t = root;
        for (char c : p.toCharArray()) { // insert current product into Trie.
            if (t.children[c - 'a'] == null)
                t.children[c - 'a'] = new Trie();
            t = t.children[c - 'a'];
            t.suggestion.offer(p); // put products with same prefix into suggestion list.
            Collections.sort(t.suggestion);
            if (t.suggestion.size() > 3) // maintain 3 lexicographically minimum strings.
                t.suggestion.pollLast();
        }
    }
    private List<List<String>> search(String searchWord, Trie root) {
        List<List<String>> ans = new ArrayList<>();
        for (char c : searchWord.toCharArray()) { // search product.
            if (root != null) // if there exist products with current prefix.
                root = root.children[c - 'a'];
            ans.add(root == null ? Arrays.asList() : root.suggestion); // add it if there exist products with current prefix.
        }
        return ans;
    }
}
