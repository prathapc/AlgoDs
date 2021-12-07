package com.practice.A_ds.F_trees;

import java.util.*;

/**
 * Created by Prathap on 19 Jan, 2020
 *
 * https://www.geeksforgeeks.org/diameter-n-ary-tree/
 *
 */
public class Q_DiameterOfNaryTree {

    static class Node {
        char key;
        Vector<Node> child;
    }

    // Utility function to create a new tree node
    static Node newNode(int key) {
        Node temp = new Node();
        temp.key = (char) key;
        temp.child = new Vector<Node>();
        return temp;
    }

    // Utility function that will return the depth of the tree
    static int depthOfTree(Node ptr) {
        // Base case
        if (ptr == null)
            return 0;

        int maxdepth = 0;

        // Check for all children and find
        // the maximum depth
        for (Node it : ptr.child)

            maxdepth = Math.max(maxdepth,
                    depthOfTree(it));

        return maxdepth + 1;
    }

    // Function to calculate the diameter of the tree
    static int diameter(Node ptr) {
        // Base case
        if (ptr == null)
            return 0;

        // Find top two highest children
        int max1 = 0, max2 = 0;
        for (Node it : ptr.child)
        {
            int h = depthOfTree(it);
            if (h > max1)
            {
                max2 = max1;
                max1 = h;
            }
            else if (h > max2)
                max2 = h;
        }

        // Iterate over each child for diameter
        int maxChildDia = 0;
        for (Node it : ptr.child)
            maxChildDia = Math.max(maxChildDia,
                    diameter(it));

        return Math.max(maxChildDia, max1 + max2 + 1);
    }

    public static void main(String[] args) {
        Node root = newNode('A');
        (root.child).add(newNode('B'));
        (root.child).add(newNode('F'));
        (root.child).add(newNode('D'));
        (root.child).add(newNode('E'));
        (root.child.get(0).child).add(newNode('K'));
        (root.child.get(0).child).add(newNode('J'));
        (root.child.get(2).child).add(newNode('G'));
        (root.child.get(3).child).add(newNode('C'));
        (root.child.get(3).child).add(newNode('H'));
        (root.child.get(3).child).add(newNode('I'));
        (root.child.get(0).child.get(0).child).add(newNode('N'));
        (root.child.get(0).child.get(0).child).add(newNode('M'));
        (root.child.get(3).child.get(2).child).add(newNode('L'));

        System.out.print(diameter(root) + "\n");
    }
}
