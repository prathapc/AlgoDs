package com.practice.design;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by prathap on 16/12/17.
 *
 * https://www.interviewbit.com/problems/design-cache/
 *
 */
public class LRUCacheImplementation {

  static Deque<KeyValueNode> deque;
  static Map<Integer, KeyValueNode> map;
  static int capacity;

  public LRUCacheImplementation(int capacity) {
    deque = new LinkedList<>();
    map = new HashMap<>();
    this.capacity = capacity;

  }

  public static void main(String args[]) {
    LRUCacheImplementation lruCacheImplementation = new LRUCacheImplementation(2);
    System.out.print(get(2));
    set(2,6);
    System.out.print(get(1));
    set(1,5);
    set(1,2);
    System.out.print(get(1));
    System.out.print(get(2));
  }

  private static int get(int key) {
    if(map.containsKey(key)) {
      KeyValueNode keyValueNode = map.get(key);
      deque.remove(keyValueNode);
      deque.addFirst(keyValueNode);
      return keyValueNode.value;
    } else {
      return -1;
    }
  }

  private static void set(int key, int value) {
    KeyValueNode keyValueNode;
    if(map.containsKey(key)) {
      keyValueNode = map.get(key);
      map.put(key, keyValueNode);
      deque.remove(keyValueNode);
      keyValueNode.value = value;
      deque.addFirst(keyValueNode);
    } else {
      if(capacity == deque.size()) {
        keyValueNode = deque.peekLast();
        map.remove(keyValueNode.key);
        deque.pollLast();
      }
      keyValueNode = new KeyValueNode();
      keyValueNode.key = key;
      keyValueNode.value = value;
      deque.addFirst(keyValueNode);
      map.put(key, keyValueNode);
    }
  }

  static class KeyValueNode {
    int key;
    int value;
  }
}


