package com.practice.A_ds.F_trees;

import java.util.ArrayList;
import java.util.List;

public class M_BstsFromSortedArray {

  public static void main(String args[]) {
    int n = 3; //if n=5 then assume input array as [1,2,3,4,5]
    List<Node> bsts = bsts(1,n);
  }

  private static List<Node> bsts(int start, int end) {
    List<Node> result = new ArrayList<>();
    if (start > end) {
      return result;
    }

    for (int i=start; i<end; i++) {
      List<Node> leftTrees = bsts(start, i-1);
      List<Node> rightTrees = bsts(i+1, end);

      for (Node leftTree : leftTrees) {
        for (Node rightTree : rightTrees) {
          Node root = new Node(i);
          root.setLeft(leftTree);
          root.setRight(rightTree);
          result.add(root);
        }
      }
    }

    return result;
  }

  //Not efficient
  //try dp -> https://medium.com/@aashray/daily-code-1-dynamic-programming-157883622808

  /*
  int numTrees(int n){
     vector<int> res(n+1, 0);
     res[0] = res[1] = 1;
     int i, j;
     for(i = 2; i <= n; i++){
          int sum = 0;
          for(j = 1; j <= i; j++){
               sum += res[j - 1] * res[i - j];
          }
          res[i] = sum;
     }
     return res[n];
  }
  */
}
