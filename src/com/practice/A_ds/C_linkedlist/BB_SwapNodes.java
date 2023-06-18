package com.practice.A_ds.C_linkedlist;

/**
 * Created by prathapchowdary on 16/05/23.
 *
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 *
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/
 */
public class BB_SwapNodes {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        int cnt = 0;
        // find the k-th node
        while (left != null) {
            if (++cnt == k) {
                break;
            }
            left = left.next;
        }

        // find the k-th last element
        ListNode pNode = left;
        while (pNode.next != null) {
            pNode = pNode.next;
            right = right.next;
        }

        // swap their values.
        int temp = left.val;
        left.val = right.val;
        right.val = temp;

        return head;
    }
}
