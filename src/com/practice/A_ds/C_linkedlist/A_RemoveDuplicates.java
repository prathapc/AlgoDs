package com.practice.A_ds.C_linkedlist;

import com.practice.B_algo.A_sort_search_math.Utility;

/**
 * Created by prathapchowdary on 15/10/21.
 */
public class A_RemoveDuplicates {
    public static void main(String args[]) {
        ListNode head = Utility.buildLinkedList(new int[]{1,2,3,4,4,5,5,6});
        Utility.printLinkedList(head);
        Utility.printLinkedList(removeDuplicates(head));
    }

    private static ListNode removeDuplicates(ListNode node) {
        if(node == null) {
            return null;
        }
        ListNode curr = node, next = curr.next, nextNext = null;

        while(next != null) {
            if(curr.val == next.val) {
                nextNext = next.next;
                curr.next = nextNext;
                next = nextNext;
            } else {
                curr = next;
                next = next.next;
            }
        }
        return node;
    }
}
