package com.practice.A_ds.F_trees;

import com.practice.B_algo.A_sort_search_math.Utility;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by prathap on 29/12/17.
 */
public class C_LevelOrder {

  public static void main(String args[]) {
    levelOrder(Utility.createMaxHeapTree());
    levelOrderWithAlternateReverse(Utility.createSampleTree2());
  }

  public static void levelOrder(Node root) {
    Queue<Node> queue = new LinkedList<Node>();

    if (root != null) {
      queue.add(root);
    }
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      System.out.print(node.getData() + " ");
      if (node.getLeft() != null) {
        queue.add(node.getLeft());
      }
      if (node.getRight() != null) {
        queue.add(node.getRight());
      }
    }
  }

  private static void levelOrderWithAlternateReverse(Node root) {
    Stack<Node> stack1 = new Stack<>();
    Stack<Node> stack2 = new Stack<>();
    stack1.push(root);
    while (!stack1.isEmpty() || !stack2.isEmpty()) {

      while(!stack1.isEmpty()) {
        Node node = stack1.pop();
        System.out.println(node.getData());
        if (node.getLeft() != null) {
          stack2.add(node.getLeft());
        }
        if (node.getRight() != null) {
          stack2.add(node.getRight());
        }
      }

      while(!stack2.isEmpty()) {
        Node node = stack2.pop();
        System.out.println(node.getData());
        if (node.getLeft() != null) {
          stack1.add(node.getLeft());
        }
        if (node.getRight() != null) {
          stack1.add(node.getRight());
        }
      }
    }
  }
}
