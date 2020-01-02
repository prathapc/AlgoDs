package com.practice.ds.trees;

import java.util.*;

/**
 * Created by Prathap on 04 Oct, 2019
 *
 * All Nodes Distance K in Binary Tree - LeetCode: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 *   This code passes all Leetcode test cases as of Feb. 12th 2019
 *   Runtime: 3 ms, faster than 64.42% of Java online submissions for All Nodes Distance K in Binary Tree.
 *   (can't get much faster than that. Asymptotically this is identical to anything even remotely faster)
 *   The video to explain this code is here: https://www.youtube.com/watch?v=nPtARJ2cYrg
 */
public class NodeInKDistanceFromTarget_easy { //Takes extra space though

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    public List<Integer> distanceK(TreeNode treeRoot, TreeNode startNode, int targetDistance) {

        Map<TreeNode, TreeNode> nodeToParentMap = new HashMap<>();
        populateNodeToParentMap(nodeToParentMap, treeRoot, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(startNode);

        Set<TreeNode> seen = new HashSet();
        seen.add(startNode);

        int currentLayer = 0;

        while (!queue.isEmpty()) {
            if (currentLayer == targetDistance) {
                return extractLayerFromQueue(queue);
            }

            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {

                TreeNode currentNode = queue.poll();

                if (currentNode.left != null && !seen.contains(currentNode.left)) {
                    seen.add(currentNode.left);
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null && !seen.contains(currentNode.right)) {
                    seen.add(currentNode.right);
                    queue.offer(currentNode.right);
                }

                TreeNode parentOfCurrentNode = nodeToParentMap.get(currentNode);
                if (parentOfCurrentNode != null && !seen.contains(parentOfCurrentNode)) {
                    seen.add(parentOfCurrentNode);
                    queue.offer(parentOfCurrentNode);
                }
            }
            currentLayer++;
        }

        return new ArrayList<Integer>();
    }

    private void populateNodeToParentMap(Map<TreeNode, TreeNode> nodeToParentMap,
                                         TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }

        nodeToParentMap.put(root, parent);

        populateNodeToParentMap(nodeToParentMap, root.left, root);
        populateNodeToParentMap(nodeToParentMap, root.right, root);
    }

    private List<Integer> extractLayerFromQueue(Queue<TreeNode> queue) {
        List<Integer> extractedList = new ArrayList();
        for (TreeNode node: queue) {
            extractedList.add(node.val);
        }
        return extractedList;
    }
}


