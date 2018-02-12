package com.practice.ds.linkedlist;

/**
 * Created by prathap on 02/09/17.
 */

import com.practice.util.Utility;

/**
 * i/p:
 * 1 -> 2 -> 3
 * 4 -> 5
 *
 * o/p: 1 -> 6 -> 8
 */
public class SumOfTwoLinkedLists {
  public static void main(String args[]) {
    /*Node node1 = new Node(1);
    node1.next = new Node(2);
    node1.next.next = new Node(3);

    Node node2 = new Node(4);
    node2.next = new Node(5);*/

    Node node1 = new Node(2);
    node1.next = new Node(4);
    node1.next.next = new Node(3);

    Node node2 = new Node(5);
    node2.next = new Node(6);
    node2.next.next = new Node(4);

    printList(sumOfTwoLinkedLists(node1, node2));

  }

  private static Node sumOfTwoLinkedLists(Node node1, Node node2) {
    int sum = 0, carry = 0;
    Node curr = null, prev = null, res = null;
    while(node1 != null || node2 != null) {
      sum = carry + (node1 != null ? node1.data : 0) + (node2 != null ? node2.data : 0);

      carry = (sum >= 10 ? 1 : 0);

      sum %= 10;

      curr = new Node(sum);

      if(res == null) {
        res = curr;
      } else {
        prev.next = curr;
      }

      prev = curr;

      if(node1 != null) {
        node1 = node1.next;
      }
      if(node2 != null) {
        node2 = node2.next;
      }

    }
    if(carry > 0) {
      curr.next = new Node(carry);
    }

    return res;
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

class Node {
  public int data;
  public Node next;
  public Node random;

  public Node(int data) {
    super();
    this.data = data;
  }

}
