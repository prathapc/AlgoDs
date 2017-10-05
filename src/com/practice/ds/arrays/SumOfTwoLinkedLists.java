package com.practice.ds.arrays;

/**
 * Created by prathap on 02/09/17.
 */

/**
 * i/p:
 * 1 -> 2 -> 3
 * 4 -> 5
 *
 * o/p: 1 -> 6 -> 8
 */
public class SumOfTwoLinkedLists {
  public static void main(String args[]) {
    Node node1 = new Node(1);
    node1.next = new Node(2);
    node1.next.next = new Node(3);

    Node node2 = new Node(4);
    node2.next = new Node(5);

    sumOfTwoLinkedLists(node1, node2);
  }

  private static void sumOfTwoLinkedLists(Node node1, Node node2) {
    int n1=0, n2=0;
    Node temp = node1;
    while(temp != null) {
      n1++;
      temp = temp.next;
    }
    temp = node2;
    while(temp != null) {
      n2++;
      temp = temp.next;
    }






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
