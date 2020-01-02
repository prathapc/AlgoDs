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
   *  To construct the right subtree, set the range as {root->data..max .. INT_MAX}.
   *
   *  From Post-Order:-
   *  ----------------
   *  (https://www.geeksforgeeks.org/construct-a-binary-search-tree-from-given-postorder/)
   *  The trick is to set a range {min .. max} for every node. Initialize the range as {INT_MIN .. INT_MAX}.
   *  The last node will definitely be in range, so create root node.
   *  To construct the right subtree, set the range as {root->data .. INT_MAX}.
   *  To construct the left subtree, set the range as {INT_MIN …root->data}.
   *
   *
   *
   * From In and Pre order:-
   * ---------------------
   * take first ele from pre and build node and recursively call for left building left and right subtrees by finding
   * new root ele position in in-order array (0 to poistion for left and position to end for right tree recursive calls)
   *
   * https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
   *
   * Solution:-
   * https://github.com/fishercoder1534/Leetcode/blob/master/src/main/java/com/fishercoder/solutions/_105.java
   *
   */
}
