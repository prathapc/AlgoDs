package com.practice.ds.trees;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by prathap on 04/10/17.
 */
public class ClosestLeafInTree {

  public static void main(String args[]) {
    Node root = new Node('A');
    Node rootLeft = new Node('B');
    root.left = rootLeft;

    Node rootRight = new Node('C');
    root.right = rootRight;
    Node rootRightLeft = new Node('E');
    rootRight.left = rootRightLeft;
    Node rootRightRight = new Node('F');
    rootRight.right = rootRightRight;
    Node rootRightLeftLeft = new Node('G');
    rootRightLeftLeft.left = rootRightLeftLeft;




  }

  static class Node {
    char data;
    Node left, right;
    Node(char data) {
      this.data = data;
    }
  }
}
