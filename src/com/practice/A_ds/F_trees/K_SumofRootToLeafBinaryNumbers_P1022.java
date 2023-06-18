package com.practice.A_ds.F_trees;

/**
 * Created by Prathap on 03 Feb, 2020
 *
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 *
 */
public class K_SumofRootToLeafBinaryNumbers_P1022 {

    int result = 0;
    public int sumRootToLeaf(Node root) {
        sumRootToLeafUtil(root, 0);
        return result;
    }

    private void sumRootToLeafUtil(Node node, int sum){
        if(node == null) return;

        sum = sum*2+node.getData();
        if(node.getLeft() == null && node.getRight() == null){
            result += sum;
            return;
        }
        sumRootToLeafUtil(node.getLeft(), sum);
        sumRootToLeafUtil(node.getRight(), sum);
    }
}
