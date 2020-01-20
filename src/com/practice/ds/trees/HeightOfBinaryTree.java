package com.practice.ds.trees;

import com.practice.ps.Utility;

/**
 * Created by prathap on 21/12/17.
 */
public class HeightOfBinaryTree {

  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();
    System.out.print("height of tree is " + heightOfTree1(root));
  }

  private static int heightOfTree(Node node) {
    if(node == null) {
      return 0;
    } else {
      return (1 + Utility.max(heightOfTree(node.getLeft()), heightOfTree(node.getRight())));
    }
  }

  private static int heightOfTree1(Node node) {
    if(node == null) {
      return 0;
    }
    int l = heightOfTree(node.getLeft());
    int r = heightOfTree(node.getRight());

    if (l > r) {
      return 1 + l;
    } else {
      return 1 + r;
    }
  }

}
