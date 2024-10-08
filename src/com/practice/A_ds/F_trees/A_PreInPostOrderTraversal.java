package com.practice.A_ds.F_trees;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

/**
 * Created by prathapchowdary on 19/11/21.
 */
public class A_PreInPostOrderTraversal {
    public static void main(String args[]) {
        Node root = Utility.createSampleTreeBasic();
        inorderTree(root);
        System.out.println();
        preOrderTree(root);
        System.out.println();
        postOrderTree(root);
    }

    private static void inorderTree(Node root) {
        if (root != null) {
            inorderTree(root.getLeft());
            System.out.print(root.getVal() + " ");
            inorderTree(root.getRight());
        }
    }

    private static void preOrderTree(Node root) {
        if (root != null) {
            System.out.print(root.getVal() + " ");
            preOrderTree(root.getLeft());
            preOrderTree(root.getRight());
        }
    }

    private static void postOrderTree(Node root) {
        if (root != null) {
            postOrderTree(root.getLeft());
            postOrderTree(root.getRight());
            System.out.print(root.getVal() + " ");
        }
    }
}
