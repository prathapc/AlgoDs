package com.practice.F_companyQA.Tekion;

//nth element from last of a singly-LL
public class TekionTest1 {
  public static void main(String[] args) {

    System.out.println(Long.parseLong("400000000000"));
    int n = 2;
    Node head = new Node(4);

    int len = getLength(head);

    Node temp = head;
    // 1->2->3->4->5->null
    while (temp != null) {
      if (len - n == 0) {
        System.out.println(temp.data);
        break;
      } else {
        n++;
        temp = temp.next;
      }
    }

  }

  private static int getLength(Node node) {
    Node temp = node;
    int l = 0;
    while (temp != null) {
      temp = temp.next;
      l++;
    }
    return l;
  }



  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
    }
  }

}
