package com.practice.ds.linkedlist;

/**
 * Created by prathap on 27/12/17.
 */
public class RemoveNthNodeFromEnd {

  public static void main(String args[]) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    printList(head);
    Node node = removeNthFromEnd(head, 5);
    printList(node);
  }

  //single pass alogrithm
  public static Node removeNthFromEnd1(Node A, int n) {
    Node dummy = new Node(0);
    dummy.next = A;
    Node first = dummy, second = dummy;
    for (int i=0; i<=n; i++) {
      first = first.next;
    }

    while (first != null) {
      first = first.next;
      second = second.next;
    }

    second.next = second.next.next;
    return dummy.next;
  }


  //two pass algorithm
  public static Node removeNthFromEnd(Node A, int B) {
    int len = lengthOfLinkedList(A);
    int n = len-B;
    if(n <= 0) {
      A = A.next;
      return A;
    }

    Node temp = A;
    while(--n > 0) {
      temp = temp.next;
    }
    Node del = temp.next;
    if(del != null) {
      if(del.next == null) {
        temp.next = null;
      } else {
        temp.next = del.next;
      }
    }
    return A;
  }

  private static int lengthOfLinkedList(Node a) {
    int len = 0;
    while(a != null) {
      len++;
      a = a.next;
    }
    return len;
  }

  static class Node {
    int val;
    Node next;

    public Node(int val) {
      this.val = val;
    }
  }

  static void printList(Node node) {
    while (node != null) {
      System.out.print(node.val + " -> ");
      node = node.next;
    }
    System.out.print("null");
    System.out.println();
  }
}
