package com.practice.ds.trees;

import com.practice.ps.Utility;

import java.util.ArrayList;
import java.util.List;

//TODO Bug:- one path getting printed two times
public class SumPath_AnyNodeToDownwards {

  private static int res = 0;
  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();
    List<Integer> path = new ArrayList<>();

    pathSum(root, 22);

    System.out.println(res);
  }

  private static void pathSum(Node root, int sum) {
    List<Integer> list = new ArrayList<>();
    pathSumUtil(root, sum, list, sum);
  }

  private static void pathSumUtil(Node root, int sum, List<Integer> list, int inputSum) {
    if (root != null) {
      list.add(root.getData());

      if (root.getData() - sum == 0) {
        list.forEach(e->System.out.print(e + " "));
        System.out.println("sum:" + sum);
        res++;
      }

      pathSumUtil(root.getLeft(), sum-root.getData(), list, inputSum);
      pathSumUtil(root.getLeft(), inputSum, new ArrayList<>(), inputSum);

      pathSumUtil(root.getRight(), inputSum, new ArrayList<>(), inputSum);
      pathSumUtil(root.getRight(), sum-root.getData(), list, inputSum);

      list.remove(list.size() - 1);
    }
  }
}
