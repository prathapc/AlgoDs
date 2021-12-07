package com.practice.A_ds.B_queue;

import java.util.PriorityQueue;

//binary heap
public class C_PriorityQueueDemo {

  public static void main(String args[]) {
    minHeap();
    System.out.println("--------------");
    maxHeap();
    System.out.println("--------------");

    PriorityQueue<String> pq = new PriorityQueue<String>();
    pq.add("2");
    pq.add("4");
    System.out.println(pq); //prints [2, 4]
    System.out.println(pq.peek()); //peek 2
    pq.offer("1");
    System.out.println(pq); // prints [1, 4, 2]
    System.out.println(pq.peek()); //peek 1
    pq.offer("3");
    System.out.println(pq); // prints [1, 3, 2, 4]
    System.out.println(pq.peek()); //peek 1
  }

  private static void minHeap() {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(2);
    pq.add(4);
    pq.add(1);
    pq.add(7);
    pq.add(5);

    while (!pq.isEmpty()) {
      System.out.println(pq.remove() + " ");
    }
  }

  private static void maxHeap() {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    pq.add(2);
    pq.add(4);
    pq.add(1);
    pq.add(7);
    pq.add(5);

    while (!pq.isEmpty()) {
      System.out.println(pq.remove() + " ");
    }
  }
}
