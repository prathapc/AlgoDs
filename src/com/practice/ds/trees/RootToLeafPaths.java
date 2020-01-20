package com.practice.ds.trees;

import com.practice.ps.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathap on 07/10/17.
 */
public class RootToLeafPaths {
  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();
    List<Integer> data = new ArrayList<>();
    printAllRootToLeafPaths(root, data);
  }

  private static void printAllRootToLeafPaths(Node node, List<Integer> data) {
    if(node != null) {
      data.add(node.getData());
      if(node.getRight() == null && node.getLeft() == null) {
        for(Integer i : data) {
          System.out.print(i + " -> ");
        }
        System.out.print("null \n");
      } else {
        printAllRootToLeafPaths(node.getLeft(), data);
        printAllRootToLeafPaths(node.getRight(), data);
      }
      data.remove(data.size()-1);
    }
  }
}
