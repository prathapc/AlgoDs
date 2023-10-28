package com.practice.A_ds.C_linkedlist;

/**
 * Created by prathapchowdary on 07/09/23.
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class A_RemoveDuplicatesII {

    public ListNode deleteDuplicates(ListNode head) {
        //use two pointers, slow - track the node before the dup nodes,
        // fast - to find the last node of dups.
        ListNode dummy = new ListNode(0), curr = head, prev = dummy;
        prev.next = curr;
        while(curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;    //while loop to find the last node of the dups.
            }
            if (prev.next != curr) { //duplicates detected.
                prev.next = curr.next; //remove the dups.
            } else { //no dup, move down both pointer.
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    /**
     * if current node is not unique, return deleteDuplicates with head.next.
     * If current node is unique, link it to the result of next list made by recursive call.
     */
    public ListNode deleteDuplicates_recursion(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }

}
