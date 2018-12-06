package com.practice.ds.trees;

import com.practice.algo.Utility;

public class MaxSumPathBetweenAnyTwoNodes {

  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();
    Res res = new Res();
    res.res = Integer.MIN_VALUE;

    maxSumPathUtil(root, res);

    System.out.println(res.res);
  }

  private static int maxSumPathUtil(Node root, Res res) {

    if (root == null) {
      return 0;
    }

    int l = maxSumPathUtil(root.getLeft(), res);
    int r = maxSumPathUtil(root.getRight(), res);

    //max considering root and either of left and right
    int max1 = Math.max(Math.max(l, r) + root.getData(), root.getData());
    //max considering complete path via root
    int max2 = Math.max(max1, l+r+root.getData());

    res.res = Math.max(max2, res.res);

    return max1;
  }


  static class Res {
    int res;
  }
}
