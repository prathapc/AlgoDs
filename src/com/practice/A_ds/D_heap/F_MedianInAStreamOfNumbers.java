package com.practice.A_ds.D_heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by prathapchowdary on 17/05/22.
 *
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 *
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class F_MedianInAStreamOfNumbers {

	/**
	 * We use maxHeap to store a half of low numbers, top of the maxHeap is the highest number among low numbers.
	 * We use minHeap to store a half of high numbers, top of the minHeap is the lowest number among high numbers.
	 * We need to balance the size between maxHeap and minHeap while processing. Hence after adding k elements,
	 * If k = 2 * i then maxHeap.size = minHeap.size = i
	 * If k = 2 * i + 1, let maxHeap store 1 element more than minHeap, then maxHeap.size = minHeap.size + 1.
	 *
	 * When adding a new number num into our MedianFinder:
	 * Firstly, add num to the maxHeap, now maxHeap may contain the big element (which should belong to minHeap). So we need to balance, by removing the highest element from maxHeap, and offer it to minHeap.
	 * Now, the minHeap might hold more elements than maxHeap, in that case, we need to balance the size, by removing the lowest element from minHeap and offer it back to maxHeap.
	 */
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();;
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());;

	public void addNum(int num) {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		if (minHeap.size() > maxHeap.size())
			maxHeap.offer(minHeap.poll());
	}

	public double findMedian() {
		if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
		return (minHeap.peek() + maxHeap.peek()) / 2.0d;
	}

	/**
	 * Your MedianFinder object will be instantiated and called as such:
	 * MedianFinder obj = new MedianFinder();
	 * obj.addNum(num);
	 * double param_2 = obj.findMedian();
	 */

}
