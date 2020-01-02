package com.practice.ds.trie;

/**
 * Created by prathap on 13/07/17.
 */
import java.math.BigInteger;
import java.util.*;

/**
 * We perform the following sequence of operations:

 Add a contact named hack.
 Add a contact named hackerrank.
 Find and print the number of contact names beginning with hac. There are currently two contact names in the application and both of them start with hac, so we print  on a new line.
 Find and print the number of contact names beginning with hak. There are currently two contact names in the application but neither of them start with hak, so we print  on a new line.
 */
public class TriePgmPrefixWordCount {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    TrieNode1 root = new TrieNode1((char) 0);
    for(int a0 = 0; a0 < n; a0++){
      String op = in.next();
      String contact = in.next();
      switch(op) {
        case "add": {
          addNode(root, contact);
          break;
        }
        case "find": {
          findCountOfPrefixNodes(root, contact);
          break;
        }
      }
    }
  }

  private static void findCountOfPrefixNodes(TrieNode1 root, String word) {
    int n = word.length();
    TrieNode1 crawl = root;
    int result = 0;
    for(int i=0; i<n; i++) {
      Map<Character, TrieNode1> children = crawl.children;
      if(children.containsKey(word.charAt(i))) {
        crawl = children.get(word.charAt(i));
      } else {
        System.out.println(0);
        return;
      }
    }
    System.out.println(crawl.noOfWordsDown);
  }

  private static void addNode(TrieNode1 root, String word) {
    int n = word.length();
    TrieNode1 crawl = root;
    for(int i=0; i<n; i++) {
      Map<Character, TrieNode1> children = crawl.children;
      if(children.containsKey(word.charAt(i))) {
        crawl = children.get(word.charAt(i));
      } else {
        TrieNode1 temp = new TrieNode1(word.charAt(i));
        children.put(word.charAt(i), temp);
        crawl = temp;
      }
      crawl.noOfWordsDown += 1;
    }
    crawl.isEnd = true;
  }

  static class TrieNode1 {
    char ch;
    Map<Character, TrieNode1> children;
    boolean isEnd;
    int noOfWordsDown;

    public TrieNode1(char ch) {
      BigInteger max = BigInteger.valueOf(Integer.MAX_VALUE);
      this.ch = ch;
      this.children = new HashMap<>();
      isEnd = false;
    }
  }
}