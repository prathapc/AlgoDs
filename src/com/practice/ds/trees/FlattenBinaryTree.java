package com.practice.ds.trees;

import com.practice.util.Utility;

/**
 * Created by prathap on 07/01/18.
 *
 * Given


     1
    / \
   2   5
  / \   \
 3   4   6
 The flattened tree should look like:

 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6

 */
public class FlattenBinaryTree {

  public static void main(String args[]) {
    Node root = Utility.createSampleTree3();
    flatten(root);
  }


  private static Node flatten(Node a) {
    if(a ==null){
      return null;
    }
    Node left = a.getLeft();
    Node right = a.getRight();

    a.setLeft(null);
    flatten(left);
    flatten(right);

    a.setRight(left);
    Node current = a;
    while(current.getRight() !=null) {
      current = current.getRight();
    }
    current.setRight(right);
    return a;
  }
}
