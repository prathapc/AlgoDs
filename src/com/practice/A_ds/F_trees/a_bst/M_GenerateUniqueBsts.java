package com.practice.A_ds.F_trees.a_bst;

import com.practice.A_ds.F_trees.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Prathap on 04 Oct, 2019
 *
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class M_GenerateUniqueBsts {

    //wrong solution, need to debug
    public static void main(String args[]) {
        int n = 3;
        int[] nodes = new int[n];

        if (n == 0) {
            System.out.println(0);
        }
        for (int i = 0; i < n; i++) {
            nodes[i] = i + 1;
        }
        Map<String, List<Node>> map = new HashMap<>();
        List<Node> result = dfs(0, n - 1, nodes, map);
        System.out.println(result.size() + " " + map.size());
    }

    static List<Node> dfs(int start, int end, int[] nodes, Map<String, List<Node>> map) {
        List<Node> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        if (start == end) {
            res.add(new Node(nodes[start]));
            return res;
        }
        String key = start + " " + end;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        for (int i = start; i <= end; i++) {
            List<Node> lefts = dfs(start, i - 1, nodes, map);
            List<Node> rights = dfs(i + 1, end, nodes, map);
            for (Node l : lefts) {
                for (Node r : rights) {
                    Node root = new Node(nodes[i]);
                    root.setLeft(l);
                    root.setRight(r);
                    res.add(root);
                }
            }
        }
        map.put(key, res);
        return res;
    }
}
