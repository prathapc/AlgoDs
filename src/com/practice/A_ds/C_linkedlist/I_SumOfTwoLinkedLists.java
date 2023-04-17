package com.practice.A_ds.C_linkedlist;

/**
 * Created by prathap on 02/09/17.
 */
public class I_SumOfTwoLinkedLists {

  /**
   * https://leetcode.com/problems/add-two-numbers-ii/description/
   *
   * i/p:
   * 1 -> 2 -> 3
   *      4 -> 5
   *
   * o/p: 1 -> 6 -> 8
   *
   * Input: l1 = [2,4,3], l2 = [5,6,4]
   * Output: [8,0,7]
   */
  Node th = null;
  Node tt = null;
  public Node addTwoNumbersReverse(Node l1, Node l2) {
    int carry = 0;
    Node r1 = reverseList(l1);
    Node r2 = reverseList(l2);
    while(r1 != null || r2 != null){
      int v1 = (r1 != null) ? r1.data : 0;
      int v2 = (r2 != null) ? r2.data : 0;
      int total = v1 + v2 + carry;
      int sum = total % 10;
      addFirst(new Node(sum));
      carry = total / 10;
      r1 = (r1 != null) ? r1.next : null;
      r2 = (r2 != null) ? r2.next : null;
    }

    if(carry > 0){
      addFirst(new Node(carry));
    }

    return th;
  }

  void addFirst(Node node){
    if(th == null){
      th = node;
      tt = node;
    }else{
      node.next = th;
      th = node;
    }
  }

  public Node reverseList(Node head) {

    if(head == null || head.next == null){
      return head;
    }

    Node prev = null;
    Node fwd = null;
    Node curr = head;
    while(curr != null) {
      fwd = curr.next;
      curr.next = prev;
      prev = curr;
      curr = fwd;
    }
    return prev;
  }

  /**
   * https://leetcode.com/problems/add-two-numbers/
   *
   * Input: l1 = [2,4,3], l2 = [5,6,4]
   * Output: [7,0,8]
   * Explanation: 342 + 465 = 807.
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      int num1 = l1 != null ? l1.val : 0;
      int num2 = l2 != null ? l2.val : 0;

      int sum = num1 + num2 + carry;
      int newNum = sum % 10;
      carry = sum / 10;
      curr.next = new ListNode(newNum);
      curr = curr.next;

      l1 = l1 != null ? l1.next : null;
      l2 = l2 != null ? l2.next : null;
    }
    return dummy.next;
  }

  static void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " -> ");
      node = node.next;
    }
    System.out.print("null");
    System.out.println();
  }

  static class Node {
    public int data;
    public Node next;

    public Node(int data) {
      super();
      this.data = data;
    }
  }
}

