package com.practice.A_ds.F_trees;

import com.practice.A_ds.F_trees.TreeNode;

import java.util.*;

/**
 * Created by Prathap on 28 Jan, 2020
 *
 * https://leetcode.com/problems/binary-search-tree-iterator/
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 *          7
 *       3     15
 *           9    20
 *
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 */

/**
 * simple solution (O(n) space:
 class BSTIterator {
    List<Integer> list;
    int index;
    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        inorder(root);
        this.index = -1;
        System.out.println(list);
    }

    public int next() {
        index++;
        return list.get(index);
    }
    public boolean hasNext() {
        if(index>=list.size()-1) return false;
        else return true;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
 }
 */

class O_BinarySearchTreeIterator_P173 {
    Stack<TreeNode> stack;

    public O_BinarySearchTreeIterator_P173(TreeNode root) {

        // Stack for the recursion simulation
        this.stack = new Stack<TreeNode>();

        // Remember that the algorithm starts with a call to the helper function
        // with the root node as the input
        this._leftmostInorder(root);
    }

    private void _leftmostInorder(TreeNode root) {
        // For a given node, add all the elements in the leftmost branch of the tree
        // under it to the stack.
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        // Node at the top of the stack is the next smallest element
        TreeNode topmostNode = this.stack.pop();
        // Need to maintain the invariant. If the node has a right child, call the
        // helper function for the right child
        if (topmostNode.right != null) {
            this._leftmostInorder(topmostNode.right);
        }
        return topmostNode.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}