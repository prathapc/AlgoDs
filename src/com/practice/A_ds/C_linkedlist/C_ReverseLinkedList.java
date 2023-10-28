package com.practice.A_ds.C_linkedlist;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

/**
 * Created by prathap on 05/10/17.
 *
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class C_ReverseLinkedList {

  public static void main(String args[]) {
    ListNode head = Utility.createLinkedList();
    Utility.printLinkedList(head);
    head = reverseLinkedList_recursion(head);
    Utility.printLinkedList(head);
  }

  private static ListNode reverseLinkedList(ListNode head) {
    ListNode prev = null, current = head, next = null;
    while (current != null) {
      next = current.next; //preserve next

      current.next = prev; //change pointers / reverse

      prev = current;
      current = next; //update prev and curr
    }
    return prev;
  }

  //build recursion stack to understand better
  //maintain level containing head and newHead along with values/data
  //so that you will know what to change pointer to and what to return
  private static ListNode reverseLinkedList_recursion(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = reverseLinkedList_recursion(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}
