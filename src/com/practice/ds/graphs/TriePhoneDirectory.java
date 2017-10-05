package com.practice.ds.graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by prathap on 02/10/17.
 */
public class TriePhoneDirectory {

  public static void main(String args[]) {
    TrieUtil trieUtil = new TrieUtil();
    trieUtil.add(9999803989L, "prathap");
    trieUtil.add(9989803645L, "pradeep");
    trieUtil.add(9846403123L, "ajay");
    Map<Long, String> result = trieUtil.search(99L);
    for(Map.Entry<Long, String> entry : result.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
  }
}

class TrieUtil {

  TrieNode root;

  TrieUtil() {
    root = new TrieNode(-1);
  }

  public void add(Long number, String name) {
    Stack<Integer> digits = getDigitsFromNumber(number);
    TrieNode temp;
    TrieNode crawl = root;
    while (!digits.isEmpty()) {
      int digit = digits.pop();
      temp = new TrieNode(digit);
      if(crawl.children.containsKey(digit)) {
        crawl = crawl.children.get(digit);
      } else {
        if(digits.isEmpty()) {
          temp.isEnd = true;
          temp.name = name;
        }
        crawl.children.put(digit, temp);
        crawl = temp;
      }
    }
  }

  public Map<Long, String> search(Long number) {
    Map<Long, String> searchResult = new HashMap<>();
    TrieNode crawl = root;
    Stack<Integer> digits = getDigitsFromNumber(number);
    while (!digits.isEmpty()) {
      int digit = digits.pop();
      if(crawl.children.containsKey(digit)) {
        crawl = crawl.children.get(digit);
      }
    }
    String resultNumber = number.toString();
    getAllChildNumbers(crawl, searchResult, resultNumber);
    return searchResult;
  }

  private void getAllChildNumbers(TrieNode crawl, Map<Long, String> searchResult, String resultNumber) {
    Map<Integer, TrieNode> children = crawl.children;
    for(Map.Entry<Integer, TrieNode> entry : children.entrySet()) {
      resultNumber += entry.getKey();
      if(entry.getValue().isEnd) {
        searchResult.put(Long.valueOf(resultNumber.toString()), entry.getValue().name);
        resultNumber = "";
      } else {
        getAllChildNumbers(entry.getValue(), searchResult, resultNumber);
      }
    }
  }

  private Stack<Integer> getDigitsFromNumber(Long number) {
    Stack<Integer> result = new Stack<>();
    while(number > 0) {
      result.add((int) (number%10));
      number /= 10;
    }
    return result;
  }

  class TrieNode {
    int digit;
    Map<Integer, TrieNode> children;
    boolean isEnd;
    String name;

    TrieNode(int digit) {
      this.digit = digit;
      children = new HashMap<>();
    }

  }
}
