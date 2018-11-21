package com.practice.ds.trees;

import com.practice.algo.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathap on 29/12/17.
 *
 * Two problems:
 * -------------
 * 1. Print path from root to leaf with given sum
 * 2. Find if path exist from root to leaf with given sum
 *
 */
public class RootLeafSumIsK {
  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();
    List<Integer> path = new ArrayList<>();

    rootToLeafSum(root, 50, path);

    System.out.println(isRootToLeafSumExist(root, 50));

  }

  private static boolean isRootToLeafSumExist(Node root, int sum) {
    if (root == null) {
      return sum == 0;
    } else {
      boolean ans = false;

      if (root.getLeft() == null && root.getRight() == null && root.getData() == sum) {
        return true;
      }

      if (root.getLeft() != null) {
        ans = ans || isRootToLeafSumExist(root.getLeft(), sum - root.getData());
      }
      if (root.getRight() != null) {
        ans = ans || isRootToLeafSumExist(root.getRight(), sum - root.getData());
      }

      return ans;
    }
  }

  private static void rootToLeafSum(Node node, int k, List<Integer> path) {
    if(node == null)
      return;
    path.add(node.getData());
    if(node.getData() == k) {
      path.forEach(System.out:: println);
    }

    rootToLeafSum(node.getLeft(), k-node.getData(), path);
    rootToLeafSum(node.getRight(), k-node.getData(), path);
    path.remove(path.size()-1);
  }
}
