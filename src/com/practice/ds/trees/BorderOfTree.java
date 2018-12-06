package com.practice.ds.trees;

import com.practice.algo.Utility;

/**
 * One more way is to print left,right and bottom views by level order traersing with a queue.
 */
public class BorderOfTree {

  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();

    if (root != null) {
      System.out.print(root.getData() + " ");
      leftView(root.getLeft());
      printLeaves(root.getLeft());
      printLeaves(root.getRight());
      rightView(root.getRight());

    }
  }

  private static void printLeaves(Node node) {
    if (node != null) {
      printLeaves(node.getLeft());
      if (node.getLeft() == null && node.getRight() == null) {
        System.out.print(node.getData() + " ");
      }
      printLeaves(node.getRight());
    }

  }

  private static void rightView(Node node) {
    if (node == null) {
      return;
    }
    if (node.getRight() != null) {
      rightView(node.getRight());
      System.out.print(node.getData() + " ");
    } else if(node.getLeft() != null) {
      rightView(node.getLeft());
      System.out.print(node.getData() + " ");
    } else {
      //leaf node; do nothing
    }
  }

  private static void leftView(Node node) {
    if (node == null) {
      return;
    }
    if (node.getLeft() != null) {
      System.out.print(node.getData() + " ");
      leftView(node.getLeft());
    } else if (node.getRight() != null){
      System.out.print(node.getData() + " ");
      leftView(node.getRight());
    } else {
      //leaf node; do nothing
    }
  }
}