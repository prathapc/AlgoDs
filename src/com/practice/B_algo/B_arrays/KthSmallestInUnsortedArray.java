package com.practice.B_algo.B_arrays;

import java.util.ArrayList;

/**
 * Created by prathap on 14/12/17.
 */
public class KthSmallestInUnsortedArray {
  public static void main(String[] args) throws Exception {
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(7);arr.add(10);arr.add(4);arr.add(3);arr.add(20);arr.add(15);arr.add(2);
    int k=4;
    maxHeapKElements(arr, 4);
    System.out.print(arr.get(0));
  }

  private static void maxHeapKElements(ArrayList<Integer> arr, int k) {
    //max-heapify k elements
    for(int i=0; i<k-2; i++) {
      addToHeap(arr, i, k);
    }

    //check remaining n-k elements
    for(int i=k; i<arr.size(); i++) {
      if(arr.get(i) < arr.get(0)) {
        arr.set(0, arr.get(i));
        heapify(arr, 0, k);
      }
    }
  }

  private static void addToHeap(ArrayList<Integer> arr, int rootIndex, int k) {
    int root = arr.get(rootIndex);
    int leftChild = arr.get(2*rootIndex+1);
    int rightChild = arr.get(2*rootIndex+2);
    if(2*rootIndex+1 < k && leftChild > root) {
      swap(arr, rootIndex, 2*rootIndex+1);
      root = leftChild;
    }
    if(2*rootIndex+2 < k && rightChild > root) {
      swap(arr, rootIndex, 2*rootIndex+2);
    }
  }

  private static void heapify(ArrayList<Integer> arr, int rootIndex, int k) {
    int root = arr.get(rootIndex);
    int leftChild = arr.get(2*rootIndex+1);
    int rightChild = arr.get(2*rootIndex+2);
    if(2*rootIndex+1 < k  && leftChild > rightChild) {
      if(leftChild > root) {
        swap(arr, rootIndex, 2*rootIndex+1);
        heapify(arr, 2*rootIndex+1, k);
      }
    } else {
      if(2*rootIndex+2 < k && rightChild > root) {
        swap(arr, rootIndex, 2*rootIndex+2);
        heapify(arr, 2*rootIndex+2, k);
      }
    }
  }

  private static void swap(ArrayList<Integer> arr, int n1, int n2) {
    int temp = arr.get(n1);
    arr.set(n1, arr.get(n2));
    arr.set(n2, temp);
  }
}
