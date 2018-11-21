package com.practice.ds.trees;

public class MirrorTree {

  public static void main(String args[]) {
    mirrorTrees();
  }

  private static void mirrorTrees() {
    Node root1 = new Node(1);
    root1.setLeft(new Node(2));
    root1.setRight(new Node(3));
    Node root2 = new Node(1);
    root2.setLeft(new Node(3));
    root2.setRight(new Node(2));
    System.out.println(isMirrorTree(root1, root2));
  }

  private static boolean isMirrorTree(Node root1, Node root2) {
    if (root1 == null && root2 == null) {
      return true;
    }
    if (root1 == null || root2 == null) {
      return false;
    }
    if (((root1.getData() == root2.getData()) && isMirrorTree(root1.getLeft(), root2.getRight())
        && isMirrorTree(root1.getRight(), root2.getLeft()))) {
      return true;
    }
    return false;
  }
}
