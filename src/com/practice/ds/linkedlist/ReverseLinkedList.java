package com.practice.ds.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by prathap on 05/10/17.
 */
public class ReverseLinkedList {

  public static void main(String args[]) {

    Node head = new Node(1);
    head.next = new Node(1);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(4);
    head.next.next.next.next.next = new Node(4);
    head.next.next.next.next.next.next = new Node(7);
    head.next.next.next.next.next.next.next = new Node(8);
    printList(head);

    //printList(reverseLinkedList(head));
    //printList(pairwiseSwap(head));
    //printList(reverseLinkedListInGroups(head, 1));
    //printList(removeDuplicates(head));
    //int a[] = {5,5,5,7,7,3,4,7};
    int a[] = {5};
    //packNeighbouringNumbers(a);
  }

  private static Node removeDuplicates(Node node) {
    if(node == null) {
      return null;
    }
    Node curr = node, next = curr.next, nextNext = null;

    while(next != null) {
      if(curr.data == next.data) {
        nextNext = next.next;
        curr.next = nextNext;
        next = nextNext;
      } else {
        curr = next;
        next = next.next;
      }
    }
    return node;
  }

  private static Node pairwiseSwap(Node node) {
    Node curr = node;
    while(curr != null && curr.next != null) {
      int d = curr.data;
      curr.data = curr.next.data;
      curr.next.data = d;

      curr = curr.next.next;
    }
    return node;
  }

  private static Node reverseLinkedListInGroups(Node node, int k) {
    Node current = node, prev = null, next = null;
    int temp = 0;
    while(temp < k && current != null) {
      next = current.next;
      current.next = prev;

      prev = current;
      current = next;

      temp++;
    }
    if(next != null) {
      node.next = reverseLinkedListInGroups(next, k);
    }
    return prev;
  }

  private static Node reverseLinkedList(Node head) {
    Node prev = null, current = head, next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;

      prev = current;
      current = next;
    }
    return prev;
  }

  static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
    }
  }

  static void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " -> ");
      node = node.next;
    }
    System.out.print("null");
    System.out.println();
  }
}
