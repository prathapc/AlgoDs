package com.practice.A_ds.C_linkedlist;

import com.practice.C_ps.Utility;

/**
 * Created by prathapchowdary on 15/10/21.
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
