package com.practice.ds.trees;

import com.practice.util.Utility;

/**
 * Created by prathap on 06/04/18.
 */
public class SumTree {
  public static void main(String args[]) {
    Node node = Utility.createSampleSumTree();
    isSumTree(node, 0, 0);
    System.out.print(isSumTree);
  }

  private static boolean isSumTree = true;

  private static int isSumTree(Node node, int ls, int rs) {
    if (node == null) {
      return 0;
    }

    int tempLs = isSumTree(node.getLeft(), ls, rs);
    int tempRs = isSumTree(node.getRight(), ls, rs);

    ls += tempLs;
    rs += tempRs;
    if ((node.getLeft() != null || node.getRight() != null) && node.getData() != ls + rs) {
      isSumTree = false;
    }

    return ls + rs + node.getData();
  }
}
