package com.practice.A_ds.B_queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by prathapchowdary on 03/07/23.
 *
 * You are given an array of integers nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * Return the max sliding window.
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 *
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class D_SlidingWindowMaximum {

  //solved in 20mins
  //usually max/min problems in streams solved with heap, why not approach in same way
  public int[] maxSlidingWindow1(int[] nums, int k) {
    Queue<int[]> maxHeap = new PriorityQueue<>((int[] i1, int[] i2) -> i2[1] - i1[1]);
    //initialise first window
    int i = 0;
    for (;i<k-1; i++) {
      maxHeap.add(new int[]{i, nums[i]});
    }
    int[] result = new int[nums.length-k+1];

    //add and find max from heap; remove expired window indexes
    int p = 0;
    for (; i<nums.length; i++) {
      maxHeap.add(new int[]{i, nums[i]});
      result[p++] = maxHeap.peek()[1];
      while (!maxHeap.isEmpty() && maxHeap.peek()[0] <= i-k+1) {
        maxHeap.poll();
      }
    }
    return result;
  }

  /**
   * //we can use deque to removeLast, addLast etc
   * //(usually in LinkedList/Queue firstNode gets removed on poll() and
   * //offer() adds to last of queue.
   * //In deque we can specify last or first to remove or add)
   */
  public static int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> q = new ArrayDeque<>();  // stores *indices*
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      //make sure to have big element to stay on queue
      while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
        q.removeLast();
      }
      q.addLast(i);

      // remove first element if it's outside the window
      if (i - q.peekFirst() >= k) {
        q.removeFirst();
      }

      // if window has k elements add to results; for initial window condition
      if (i >= k - 1) {
        res.add(nums[q.getFirst()]);
      }
    }
    return res.stream().mapToInt(i->i).toArray();
  }

  public static void main(String args[]) {
    maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
  }
}
