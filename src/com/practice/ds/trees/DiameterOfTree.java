package com.practice.ds.trees;

import com.practice.algo.Utility;

public class DiameterOfTree {

  static class Ans {
    int ans;
    Ans(int ans) {
      this.ans = ans;
    }
  }

  public static void main(String args[]) {
    //diameterOfTree(Utility.createSampleTree(), new Ans(Integer.MIN_VALUE));
    System.out.println(diameterOfTree(Utility.createSampleTree())[1]);
    System.out.println(diameterOfTree1(Utility.createSampleTree()));
  }

  //time complexity O(n^2)
  private static int diameterOfTree1(Node node) {
    if (node == null) {
      return 0;
    }
    int lHeight = height(node.getLeft());
    int rHeight = height(node.getRight());

    int lDiameter = diameterOfTree1(node.getLeft());
    int rDiameter = diameterOfTree1(node.getRight());

    return Utility.max(1 + lHeight + rHeight, Utility.max(lDiameter, rDiameter));
  }

  private static int height(Node node) {
    if (node == null) {
      return 0;
    }
    int l = height(node.getLeft());
    int r = height(node.getRight());
    if (l > r) {
      return 1 + l;
    } else {
      return 1 + r;
    }
  }

  //time complexity O(n)
  private static int[] diameterOfTree(Node root) {
    int[] heightAndDiameterArray = {0, 0};

    if (root != null) {

      int[] lHeightAndDiameter = diameterOfTree(root.getLeft());
      int[] rHeightAndDiameter = diameterOfTree(root.getRight());
      heightAndDiameterArray[0] = Utility.max(lHeightAndDiameter[0], rHeightAndDiameter[0]) + 1;

      int leftDiameter = lHeightAndDiameter[1];
      int rightDiameter = rHeightAndDiameter[1];
      int rootDiameter = lHeightAndDiameter[0] + rHeightAndDiameter[0] + 1;
      heightAndDiameterArray[1] = Utility.max(rootDiameter, leftDiameter, rightDiameter);
    }
    return heightAndDiameterArray;
  }
}
