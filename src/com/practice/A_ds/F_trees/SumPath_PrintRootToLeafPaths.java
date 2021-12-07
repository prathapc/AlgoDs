package com.practice.A_ds.F_trees;

import com.practice.C_ps.Utility;

import java.util.ArrayList;
import java.util.List;

public class SumPath_PrintRootToLeafPaths {

  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();
    List<Integer> path = new ArrayList<>();

    pathSum(root, 32);

  }

  private static void pathSum(Node root, int sum) {
    List<Integer> temp = new ArrayList<>();
    pathSumUtil(root, sum, temp);
  }

  private static void pathSumUtil(Node root, int sum, List<Integer> temp) {
    if (root == null) {
      return;
    }

    temp.add(root.getData());

    if (root.getData() - sum == 0) {
      temp.forEach(e -> System.out.print(e + " "));
      System.out.println();
    }

    pathSumUtil(root.getLeft(), sum-root.getData(), temp);
    pathSumUtil(root.getRight(), sum-root.getData(), temp);

    temp.remove(temp.size() - 1);
  }
}
