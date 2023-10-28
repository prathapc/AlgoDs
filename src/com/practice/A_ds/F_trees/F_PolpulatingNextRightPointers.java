package com.practice.A_ds.F_trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by prathapchowdary on 08/07/23.
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class F_PolpulatingNextRightPointers {

  public Node connect(Node root) {
    if(root == null) return root;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
      Node prev = null;
      int size = queue.size();
      for(int i = 0; i < size; i++){
        Node cur = queue.poll();
        if(cur.left != null){
          queue.offer(cur.left);
        }
        if(cur.right != null){
          queue.offer(cur.right);
        }
        if(prev == null){
          prev = cur;
        }else{
          prev.next = cur;
          prev = cur;
        }
      }
    }
    return root;
  }

  class Node {
    int val;
    Node next, left, right;
  }

}
