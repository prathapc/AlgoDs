package com.practice.ds.linkedlist;

/**
 * Created by prathap on 19/07/17.
 */
public class LinkedListDetectCycle {
  public void main(String args[]) {
    hasCycle();
  }

  private void hasCycle() {
    Node head = new Node(1);
    if(head != null) {

    }
  }

  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
    }
  }
}


