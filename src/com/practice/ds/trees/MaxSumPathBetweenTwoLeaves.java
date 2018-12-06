package com.practice.ds.trees;

import com.practice.algo.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathap on 06/01/18.
 */
public class MaxSumPathBetweenTwoLeaves {

  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();
    MaxSumPathInBinaryTreeRes maxSumPathInBinaryTreeRes = new MaxSumPathInBinaryTreeRes();
    maxSumPathInBinaryTreeRes.res = Integer.MIN_VALUE;
    maxSumPathBwLeaves(root, maxSumPathInBinaryTreeRes);
    System.out.print(maxSumPathInBinaryTreeRes.res );
  }

  private static int maxSumPathBwLeaves(Node node, MaxSumPathInBinaryTreeRes maxSumPathInBinaryTreeRes) {
    if(node == null) {
      return 0;
    }
    if(node.getLeft() == null && node.getRight() == null) {
      return node.getData();
    }

    int ls = maxSumPathBwLeaves(node.getLeft(), maxSumPathInBinaryTreeRes);
    int rs = maxSumPathBwLeaves(node.getRight(), maxSumPathInBinaryTreeRes);

    if(node.getLeft() != null && node.getRight() != null) {
      maxSumPathInBinaryTreeRes.res = Math.max(maxSumPathInBinaryTreeRes.res, ls+rs+node.getData());

      return Math.max(ls, rs)+node.getData();
    }
    return node.getLeft() == null ? rs+node.getData() : ls+node.getData();
  }

  static class MaxSumPathInBinaryTreeRes {
    int res;
  }
}
