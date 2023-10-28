package com.practice.A_ds.C_linkedlist;

/**
 * Created by prathapchowdary on 16/05/23.
 *
 * You are given the head of a linked list, and an integer k.
 * Return the head of the linked list after swapping the values of the kth node from the beginning
 * and the kth node from the end (the list is 1-indexed).
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 *
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 */
public class B_SwapNodes {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head, second = head;

        //find first
        for (int i=1; i<k; i++) { // 1 indexed
            first = first.next;
        }

        //find second by using slow and fast pointer concept
        ListNode temp = first;
        while (temp.next != null) {
            temp = temp.next;
            second = second.next;
        }

        //swap first and second
        int t = first.val;
        first.val = second.val;
        second.val = t;

        return head;
    }
}
