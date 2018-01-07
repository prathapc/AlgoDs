package com.practice.ds.trees;

/**
 * Created by prathap on 07/01/18.
 */
public class In_Pre_Post_OrdersToBinaryTree {

  /**
   * From In-Order:-
   * -------------
   * Inorder sequence: D B E A F C
   *                  A
                    /   \
                  /       \
                D B E     F C

   *  recursivley build above tree
   *
   *
   *  From Pre-Order:-
   *  ---------------
   *  The trick is to set a range {min .. max} for every node. Initialize the range as {INT_MIN .. INT_MAX}.
   *  The first node will definitely be in range, so create root node.
   *  To construct the left subtree, set the range as {INT_MIN …root->data}.
   *  If a values is in the range {INT_MIN .. root->data}, the values is part part of left subtree.
   *  To construct the right subtree, set the range as {root->data..max .. INT_MAX}.
   *
   *  From Post-Order:-
   *  ----------------
   *  (https://www.geeksforgeeks.org/construct-a-binary-search-tree-from-given-postorder/)
   *  The trick is to set a range {min .. max} for every node. Initialize the range as {INT_MIN .. INT_MAX}.
   *  The last node will definitely be in range, so create root node.
   *  To construct the left subtree, set the range as {INT_MIN …root->data}.
   *  If a values is in the range {INT_MIN .. root->data}, the values is part part of left subtree.
   *  To construct the right subtree, set the range as {root->data .. INT_MAX}.
   *
   *
   */
}
