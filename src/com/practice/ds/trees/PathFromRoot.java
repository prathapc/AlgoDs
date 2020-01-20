package com.practice.ds.trees;

import com.practice.ps.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathap on 21/12/17.
 */
public class PathFromRoot {
  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();
    List<Integer> data = new ArrayList<>();
    printPathFromRoot(root, data, 23);
  }

  private static void printPathFromRoot(Node node, List<Integer> data, int k) {
    if(node != null) {

      data.add(node.getData());

      if(node.getData() == k) {
        data.forEach(System.out::println);
      }

      printPathFromRoot(node.getLeft(), data, k);
      printPathFromRoot(node.getRight(), data, k);

      data.remove(data.size()-1);
    }
  }

  private static boolean printPathFromRoot1(Node node, List<Integer> data, int k) {
    if(node == null)
      return false;
    /*data.add(node.getData());
    if(node.getData() == k) {
      data.forEach(System.out::println);
    }*/
    if(node.getData() == k) {
      System.out.println(node.getData());
      return true;
    }

    boolean leftFound = printPathFromRoot1(node.getLeft(), data, k);
    boolean rightFound = printPathFromRoot1(node.getRight(), data, k);

    if(leftFound||rightFound) {
      System.out.println(node.getData());
    }

    return leftFound||rightFound;

    //data.remove(data.size()-1);
  }
}
