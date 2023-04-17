package com.practice.A_ds.E_trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathap on 26/09/17.
 */
public class A_TriePrograms {
  public static void main(String args[]) {
    Trie rootTrie = new Trie(-1);
    addNumber(rootTrie, "1234564434");
    addNumber(rootTrie, "5345656554");
  }

  private static void addNumber(Trie rootTrie, String number) {
    Trie crawl = rootTrie;
    for(int i=0; i<number.length(); i++) {
      int n = Character.getNumericValue(number.charAt(i));
      if(crawl.children.containsKey(n)) {
        crawl = crawl.children.get(n);
      } else {
        Trie trie = new Trie(n);
        crawl.children.put(n, trie);
        crawl = trie;
      }
    }
    crawl.isEnd = true;
  }

  static class Trie {
    int data;
    boolean isEnd;
    Map<Integer, Trie> children; //can take simple array as well

    public Trie(int data) {
      this.data = data;
      children = new HashMap<>();
    }
  }
}
