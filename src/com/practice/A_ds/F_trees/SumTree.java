package com.practice.A_ds.F_trees;

import com.practice.B_algo.A_sort_search_math.Utility;

/**
 * Created by prathap on 06/04/18.
 *
 * A SumTree is a Binary Tree where the value of a node is equal to
 * sum of the nodes present in its left subtree and right subtree.
 * An empty tree is SumTree and sum of an empty tree can be considered as 0.
 * A leaf node is also considered as SumTree
 */
public class SumTree {
  public static void main(String args[]) {
    Node node = Utility.createSampleSumTree();
    sumTreeUtil(node, 0, 0);
    System.out.print(isSumTree);
  }

  private static boolean isSumTree = true;

  private static int sumTreeUtil(Node node, int ls, int rs) {
    if (node == null) {
      return 0;
    }

    int tempLs = sumTreeUtil(node.getLeft(), ls, rs);
    int tempRs = sumTreeUtil(node.getRight(), ls, rs);

    ls += tempLs;
    rs += tempRs;
    if ((node.getLeft() != null || node.getRight() != null) && node.getData() != ls + rs) {
      isSumTree = false;
    }

    return ls + rs + node.getData();
  }
}
