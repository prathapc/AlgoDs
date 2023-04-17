package com.practice.A_ds.D_heap;

import java.util.PriorityQueue;

//binary heap
//min heap => PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//max heap => PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

//insert and delete long(N); get is O(1)
public class A_PriorityQueueDemo {

  public static void main(String args[]) {
    minHeap();
    System.out.println("--------------");
    maxHeap();
    System.out.println("--------------");

    PriorityQueue<String> pq = new PriorityQueue<String>();
    pq.add("2");
    pq.add("4");
    pq.add("4");
    System.out.println(pq); //prints [2, 4, 4]
    System.out.println(pq.peek()); //peek 2
    pq.offer("1");
    System.out.println(pq); // prints [1, 2, 4, 4]
    System.out.println(pq.peek()); //peek 1
    pq.offer("3");
    System.out.println(pq); // prints [1, 2, 4, 4, 3]
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
    //PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //another way
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
