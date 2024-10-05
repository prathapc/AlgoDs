package com.practice.A_ds.F_trees;

import com.sun.source.tree.Tree;

/**
 * Created by prathapchowdary on 29/11/23.
 */
public class J_UnivaluedTreeCount {

    //TODO verify testcases
    static int result = 0;
    public static int countUnivalTrees(TreeNode root) {
        if (root == null) return 0;
        countUnivalTrees(root, root.val);
        return result;
    }
    private static boolean countUnivalTrees(TreeNode root, int val) {
        if (root == null) return true;
        if (!countUnivalTrees(root.left, root.val) || !countUnivalTrees(root.right, root.val)) return false;
        result++;
        return root.val == val;
    }
}
