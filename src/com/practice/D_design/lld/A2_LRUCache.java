package com.practice.D_design.lld;

import java.util.LinkedHashMap;

/**
 * Created by prathapchowdary on 08/06/22.
 *
 * https://leetcode.com/problems/lru-cache/
 */
public class A2_LRUCache {

    private LinkedHashMap<Integer, Integer> map;
    private int SIZE;
    public A2_LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        SIZE = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            int value = map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.remove(key);
        }else if(map.size() + 1 > SIZE) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }

    //solution without using LinkedHashMap
    /*
    final Node head = new Node(0, 0);
    final Node tail = new Node(0, 0);
    final Map<Integer, Node> map;
    final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
      int res = -1;
      if(map.containsKey(key)){
        Node n = map.get(key);
        remove(n);
        insertToHead(n);
        res = n.value;
      }
      return res;
    }

    public void put(int key, int value) {
      if(map.containsKey(key)){
        Node n = map.get(key);
        remove(n);
        n.value = value;
        insertToHead(n);
      } else {

        if(map.size() == capacity){
           map.remove(tail.prev.key);
           remove(tail.prev);
        }

        Node n = new Node(key, value);
        insertToHead(n);
        map.put(key, n);
      }
    }

    private void remove(Node n){
      n.prev.next = n.next;
      n.next.prev = n.prev;
    }

    private void insertToHead(Node n){
      Node headNext = head.next;
      head.next = n;
      headNext.prev = n;
      n.prev = head;
      n.next = headNext;
    }

    class Node{
      Node prev, next;
      int key, value;
      Node(int k, int v){
        key = k;
        value = v;
      }
    }
    */

}
