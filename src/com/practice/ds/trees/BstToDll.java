package com.practice.ds.trees;

import com.practice.ps.Utility;

/**
 * Created by prathap on 05/04/18.
 */
public class BstToDll {

  static Node head;

  public static void main(String args[]) {
    Node root = Utility.createBinarySearchTree();
    convertToDllUtil(root);
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.getData() + " ");
      temp = temp.getRight();
    }

  }

  static Node prev = null;
  //inorder traversal and then build ll
  private static void convertToDllUtil(Node node) {

    if (node == null)
      return;

    convertToDllUtil(node.getLeft());

    if (prev != null) {
      node.setLeft(prev);
      prev.setRight(node);
    } else {
      head = node;
    }
    prev = node;

    convertToDllUtil(node.getRight());

  }
}

