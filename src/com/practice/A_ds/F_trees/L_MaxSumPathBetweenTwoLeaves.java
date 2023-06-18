package com.practice.A_ds.F_trees;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

/**p
 * Created by prathap on 06/01/18.
 *
 * https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
 *
 */
public class L_MaxSumPathBetweenTwoLeaves {

  static int result = Integer.MIN_VALUE;
  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();
    maxSumPathBwLeaves(root);
    System.out.print(result);
  }

  private static int maxSumPathBwLeaves(Node node) {
    if(node == null) {
      return 0;
    }
    if(node.getLeft() == null && node.getRight() == null) {
      return node.getData();
    }

    int ls = maxSumPathBwLeaves(node.getLeft());
    int rs = maxSumPathBwLeaves(node.getRight());

    if(node.getLeft() != null && node.getRight() != null) {
      result = Math.max(result, ls+rs+node.getData());

      return Math.max(ls, rs)+node.getData();
    }
    return node.getLeft() == null ? rs+node.getData() : ls+node.getData();
  }
}
