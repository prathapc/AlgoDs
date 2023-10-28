package com.practice.A_ds.F_trees.bst;

import com.practice.A_ds.F_trees.Node;

/**
 * Created by prathap on 05/04/18.
 * Updated on Nov 28' 2021
 *
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 */
public class F_BstToDll {
  private Node head;
  private Node tail;
  public Node treeToDoublyList(Node root) {
    if (root == null) return null;
    treeToDoublyListUtil(root);

    tail.right = head;
    head.left = tail;

    return head;
  }

  private void treeToDoublyListUtil(Node node) {
    if (node == null) return;

    treeToDoublyListUtil(node.left);

    if (head == null) {
      head = node;
    }
    if (tail != null) {
      tail.right = node;
      node.left = tail;
    }
    tail = node;

    treeToDoublyListUtil(node.right);
  }
}

