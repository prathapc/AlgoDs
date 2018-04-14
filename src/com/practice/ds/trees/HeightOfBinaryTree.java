package com.practice.ds.trees;

import com.practice.util.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathap on 21/12/17.
 */
public class HeightOfBinaryTree {

  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();
    System.out.print(heightOfTree(root));
  }

  private static int heightOfTree(Node node) {
    if(node == null) {
      return 0;
    } else {
      return (1 + Utility.max(heightOfTree(node.getLeft()), heightOfTree(node.getRight())));
    }
  }

}
