package com.practice.A_ds.D_heap;

import java.util.Scanner;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

//build/implement heap tree
//internal working of PriorityQueue<<>
//Application -> top k small or largest elements
public class A_HeapImplementation {

  public static void main(String[] args) {
    int a[] = createHeapTree();
    topNLargestElements(a, 2);
  }

  private static int[] createHeapTree() {
    Scanner scanner = Utility.getScanner();
    int n = scanner.nextInt();
    int[] a = new int[n + 1];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    scanner.close();
    for (int i = 1; i < a.length; i++) {
      buildHeap(a, i);
    }
    return a;
  }

  private static void buildHeap(int[] a, int i) {
    int parent;
    if (i == 0) {
      return;
    }
    parent = i / 2;
    if (a[i] > a[parent]) {
      swap(a, i, parent);
      buildHeap(a, parent);
    }
  }

  private static void swap(int[] a, int i, int parent) {
    int temp = a[parent];
    a[parent] = a[i];
    a[i] = temp;
  }

  private static void topNLargestElements(int[] a, int n) {
    for (int i = 0; i < n; i++) {
      System.out.println(a[0]);
      a[0] = a[a.length - 1];
      heapify(a, 0);
    }
  }

  private static void heapify(int[] a, int i) {
    if (2 * i + 1 <= a.length) { //both right and left child exit
      if (Utility.max(a[2 * i + 1], a[2 * i]) > a[i]) { //if either of them bigger than parent
        if (a[2 * i + 1] > a[2 * i]) { //if right is bigger than left
          swap(a, 2 * i + 1, i);  //swap right with parent
          heapify(a, 2 * i);
        } else {
          swap(a, 2 * i, i); //swap left with parent
          heapify(a, 2 * i);
        }
      }
    } else if (2 * i <= a.length) {//no right child, check left child
      if (a[2 * i] > a[i]) { //if left is bigger than parent
        swap(a, 2 * i, i); //swap left with parent
        heapify(a, 2 * i);
      }
    } else { //no children, just return
      return;
    }
  }
}
