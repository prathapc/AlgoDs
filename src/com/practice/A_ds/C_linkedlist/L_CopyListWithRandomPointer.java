package com.practice.A_ds.C_linkedlist;

import java.util.HashMap;

/**
 * Created by prathapchowdary on 15/01/22.
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * #CloneList
 */
public class L_CopyListWithRandomPointer {
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        Node node = new Node(head.val);
        this.visitedHash.put(head, node);

        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
