package com.practice.A_ds.C_linkedlist;

/**
 * Created by prathap on 04/10/17.
 */
public class G_IntersectionNode {

  public static void main(String[] args) {
    Node node11 = new Node(3);
    Node node12 = new Node(6);
    Node node13 = new Node(9);
    Node node14 = new Node(15);
    Node node15 = new Node(30);
    node11.next = node12;
    node12.next = node13;
    node13.next = node14;
    node14.next = node15;

    Node node21 = new Node(6);
    node21.next = node14;

    findIntersectionNode(node11, node21);
  }

  private static void findIntersectionNode(Node node11, Node node21) {
    int node11Length = findLinkedListLength(node11);
    int node21Length = findLinkedListLength(node21);
    int diff = Math.abs(node11Length - node21Length);
    if(node11Length > node21Length) {
      node11 = moveDifferenceNodes(node11, diff);
    } else {
      node21 = moveDifferenceNodes(node21, diff);
    }
    findIntersectionInEqualLengthNodes(node11, node21);
  }

  private static void findIntersectionInEqualLengthNodes(Node node11, Node node21) {
    Node temp1 = node11, temp2 = node21;
    while (temp1 != null && temp2 != null) {
      if(temp1.data == temp2.data) {
        System.out.print("diff node is "+ temp1.data);
        break;
      }
      temp1 = temp1.next;
      temp2 = temp2.next;
    }
  }

  private static Node moveDifferenceNodes(Node node11, int diff) {
    Node temp = node11;
    while(diff-- > 0) {
      temp = temp.next;
    }
    return temp;
  }

  private static int findLinkedListLength(Node node) {
    int length = 0;
    Node current = node;
    while(current != null) {
      ++length;
      current = current.next;
    }
    return length;
  }

  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
    }

  }
}
