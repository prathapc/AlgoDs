package com.practice.ds.trees;

import com.practice.ps.Utility;

/**
 * Created by prathap on 22/08/17.
 */
public class SiblingsInTree {

  public static void main(String args[]) {
    Node root = Utility.createSampleTree();
    printNoSiblingNode(root);
  }

  private static void printNoSiblingNode(Node root) {
    if(root == null) {
      return;
    }

    if(root.getLeft() != null && root.getRight() != null) {
      printNoSiblingNode(root.getLeft());
      printNoSiblingNode(root.getRight());
    } else if(root.getLeft() != null) {
      System.out.print(root.getData() + " ");
      printNoSiblingNode(root.getLeft());
    } else if(root.getRight() != null) {
      System.out.print(root.getData() + " ");
      printNoSiblingNode(root.getRight());
    }
  }

}
