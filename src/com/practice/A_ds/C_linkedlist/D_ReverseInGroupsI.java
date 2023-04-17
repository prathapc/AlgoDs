package com.practice.A_ds.C_linkedlist;

import com.practice.B_algo.A_sort_search_math.Utility;

/**
 * Created by prathapchowdary on 15/10/21.
 *
 * 1 -> 2 -> 3 -> 4 -> 5 -> NULL
 * 3 -> 2 -> 1 -> 5 -> 4 -> NULL
 */
public class D_ReverseInGroupsI {
    public static void main(String args[]) {
        ListNode head = Utility.createLinkedList();
        Utility.printLinkedList(head);
        head = reverseLinkedListInGroups(head, 3);
        Utility.printLinkedList(head);
    }

    private static ListNode reverseLinkedListInGroups(ListNode node, int k) {
        ListNode current = node, prev = null, next = null;
        int temp = 0;
        while(temp < k && current != null) {
            next = current.next;
            current.next = prev;

            prev = current;
            current = next;

            temp++;
        }
        if(next != null) {
            node.next = reverseLinkedListInGroups(next, k);
        }
        return prev;
    }
}
