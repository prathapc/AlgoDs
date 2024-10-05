package com.practice.B_algo_ps.H_backtracking;

import com.practice.A_ds.F_trees.TreeNode;

/**
 * Created by prathapchowdary on 24/01/24.
 *
 * Given a binary tree where node values are digits from 1 to 9.
 * A path in the binary tree is said to be pseudo-palindromic if at least one permutation
 * of the node values in the path is a palindrome.
 * Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
 *
 * Input: root = [2,3,1,3,1,null,1]
 * Output: 2
 * Explanation: The figure above represents the given binary tree.
 * There are three paths going from the root node to leaf nodes: the red path [2,3,3],
 * the green path [2,1,1], and the path [2,3,1].
 * Among these paths only red path and green path are pseudo-palindromic paths
 * since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome)
 * and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).
 *
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 */
public class B3_PermutationPalindromTreePath {
    int result = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] map = new int[10];
        findPesudoPalindromUtil(root,map);
        return result;
    }

    void findPesudoPalindromUtil(TreeNode root,int[] map){
        if(root == null) return;
        map[root.val] = map[root.val]+1;
        if(root.left == null && root.right == null){
            if(isPalindrome(map))
                result++;
        }

        findPesudoPalindromUtil(root.left,map);
        findPesudoPalindromUtil(root.right,map);
        //backtrack
        map[root.val] = map[root.val]-1;
    }
    boolean isPalindrome(int[] map){
        int miss = 0;
        for(int i=0;i<=9;i++){
            if(map[i] % 2 != 0)
                miss++;
            if(miss > 1)
                return false;
        }
        return true;
    }
}
