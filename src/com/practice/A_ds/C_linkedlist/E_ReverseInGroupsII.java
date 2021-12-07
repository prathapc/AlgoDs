package com.practice.A_ds.C_linkedlist;

import com.practice.C_ps.Utility;

/**
 * Created by prathapchowdary on 11/09/21.
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 * Similar to prev problem, but count total nodes first and exit the last batch if no of nodes < k
 */
public class E_ReverseInGroupsII {
    public static void main(String args[]) {
        ListNode head = Utility.createLinkedList();
        Utility.printLinkedList(head);
        head = reverseKGroup(head, 3);
        Utility.printLinkedList(head);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        ListNode ktail = null;
        // Head of the final, modified linked list
        ListNode new_head = null;

        // Keep going until there are nodes in the list
        while (ptr != null) {
            int count = 0;
            // Start counting nodes from the head
            ptr = head;
            // Find the head of the next k nodes
            while (count < k && ptr != null) {
                ptr = ptr.next;
                count += 1;
            }

            // If we counted k nodes, reverse them
            if (count == k) {

                // Reverse k nodes and get the new head
                ListNode revHead = reverseLinkedList(head, k);

                // new_head is the head of the final linked list
                if (new_head == null)
                    new_head = revHead;

                // ktail is the tail of the previous block of
                // reversed k nodes
                if (ktail != null)
                    ktail.next = revHead;

                ktail = head;
                head = ptr;
            }
        }

        // attach the final, possibly un-reversed portion
        if (ktail != null)
            ktail.next = head;

        return new_head == null ? head : new_head;
    }

    public static ListNode reverseLinkedList(ListNode head, int k) {
        ListNode new_head = null;
        ListNode ptr = head;

        while (k > 0) {
            ListNode next_node = ptr.next;

            ptr.next = new_head;
            new_head = ptr;

            ptr = next_node;
            k--;
        }
        return new_head;
    }
}
