package com.practice.A_ds.C_linkedlist;

/**
 * Created by prathapchowdary on 12/09/21.
 *
 * https://leetcode.com/problems/rotate-list/
 *
 */
public class J_RotateListRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode t = head;
        int l = 0;
        while (t != null) {
            t = t.next;
            l++;
        }

        if (k > l) {
            k = k % l;
        }
        if (l == 1 || k < 1) {
            return head;
        }

        ListNode node = head, newHead = head;
        int move = l - k;
        while (node != null) {
            if (--move == 0) {
                newHead = node.next;
                node.next = null;

                t = newHead;
                while (t.next != null) {
                    t = t.next;
                }
                t.next = head;
                break;
            }
            node = node.next;
        }
        return newHead;
    }

    //clean solution
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            // base cases
            if (head == null) return null;
            if (head.next == null) return head;

            // close the linked list into the ring
            ListNode old_tail = head;
            int n;
            for(n = 1; old_tail.next != null; n++)
                old_tail = old_tail.next;
            old_tail.next = head;

            // find new tail : (n - k % n - 1)th node
            // and new head : (n - k % n)th node
            ListNode new_tail = head;
            for (int i = 0; i < n - k % n - 1; i++)
                new_tail = new_tail.next;
            ListNode new_head = new_tail.next;

            // break the ring
            new_tail.next = null;

            return new_head;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
