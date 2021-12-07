package com.practice.C_ps;

/**
 * There is a bug in the program with given input; need to debug and fix
 *
 * https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
 *
 * @author Prathap
 *
 */
public class MedianInAStreamOfNumbers {

	static int minIndex = -1;
	static int maxIndex = 0;
	public static void main(String[] args) {
		int a[] = {3,56,7,89,31,44,2,22, 58};
		int minHeap[] = new int[(a.length/2)+1];
		int maxHeap[] = new int[(a.length/2)+1];
		
		
		maxHeap[maxIndex] = a[0];
		for(int i=1; i<a.length; i++) {
			addElementToMinOrMaxHeap(a[i], maxHeap, minHeap);
			System.out.println(getMedian(maxHeap, minHeap));
		}
	}

	private static int getMedian(int[] maxHeap, int[] minHeap) {
		if(maxIndex == minIndex) {
			return (maxHeap[0] + minHeap[0])/2;
		} else if(maxIndex > minIndex) {
			return maxHeap[0];
		} else {
			return minHeap[0];
		}
	}

	private static void addElementToMinOrMaxHeap(int i, int[] maxHeap, int[] minHeap) {
		if(minIndex == -1) {
			if(maxHeap[maxIndex] < i) {
				minHeap[++minIndex] = i;
			} else {
				minHeap[++minIndex] = maxHeap[maxIndex];
				maxHeap[maxIndex] = i;
			}
		} else if (maxHeap[0] < i){
			minHeap[++minIndex] = i;
			minHeapify(minHeap, minIndex);
		} else {
			maxHeap[++maxIndex] = i;
			maxHeapify(maxHeap, maxIndex);
		}
		balance(maxHeap, minHeap);
	}

	private static void balance(int[] maxHeap, int[] minHeap) {
		if(maxIndex > minIndex) {
			if(maxIndex - minIndex > 1) {
				minHeap[++minIndex] = maxHeap[0];
				minHeapifyAfterRemove(minHeap, minIndex, minIndex);
				maxHeap[0] = maxHeap[maxIndex];
				maxHeap[maxIndex] = 0;
				maxIndex--;
				maxHeapifyAfterRemove(maxHeap, maxIndex, maxIndex);
			}
		} else {
			if(minIndex - maxIndex > 1) {
				maxHeap[++maxIndex] = minHeap[0];
				maxHeapifyAfterRemove(maxHeap, maxIndex, maxIndex);
				minHeap[0] = minHeap[minIndex];
				minHeap[minIndex] = 0;
				minIndex--;
				minHeapifyAfterRemove(minHeap, minIndex, minIndex);
			}
		}
	}

	private static void maxHeapify(int[] a, int i) {
		if(i == 0)
			return;
		int parent;
		if(i % 2 == 0) {
			parent = (i-2)/2;
		} else {
			parent = (i-1)/2;
		}
		if(a[i] > a[parent]) {
			Utility.swapElementsInArray(a, i, parent);
			maxHeapify(a, parent);
		}
	}
	
	private static void minHeapify(int[] a, int i) {
		if(i == 0)
			return;
		int parent;
		if(i % 2 == 0) {
			parent = (i-2)/2;
		} else {
			parent = (i-1)/2;
		}
		if(a[i] < a[parent]) {
			Utility.swapElementsInArray(a, i, parent);
			minHeapify(a, parent);
		}
	}
	
	private static void maxHeapifyAfterRemove(int[] a, int i, int maxIndex) {
		if(2*i+2 <= maxIndex+1) {
			if(Utility.max(a[2*i+2], a[2*i+1]) > a[i]) {
				if(a[2*i+2] > a[2*i+1]) {
					Utility.swapElementsInArray(a, 2*i+2, i);
					maxHeapifyAfterRemove(a, 2*i+2, maxIndex);
				} else {
					Utility.swapElementsInArray(a, 2*i+1, i);
					maxHeapifyAfterRemove(a, 2*i+1, maxIndex);
				}
			}
		} else if(2*i+1 <= maxIndex+1) {
			if(a[2*i+1] > a[i]) {
				Utility.swapElementsInArray(a, 2*i+1, i);
				maxHeapifyAfterRemove(a, 2*i+1, maxIndex);
			}
		} else {
			return;
		}
	}
	
	private static void minHeapifyAfterRemove(int[] a, int i, int minIndex) {
		if(2*i+2 <= minIndex+1) {
			if(Utility.max(a[2*i+2], a[2*i+1]) < a[i]) {
				if(a[2*i+2] < a[2*i+1]) {
					Utility.swapElementsInArray(a, 2*i+2, i);
					minHeapifyAfterRemove(a, 2*i+2, minIndex);
				} else {
					Utility.swapElementsInArray(a, 2*i+1, i);
					minHeapifyAfterRemove(a, 2*i+1, minIndex);
				}
			}
		} else if(2*i+1 <= minIndex+1) {
			if(a[2*i+1] < a[i]) {
				Utility.swapElementsInArray(a, 2*i+1, i);
				minHeapifyAfterRemove(a, 2*i+1, minIndex);
			}
		} else {
			return;
		}
	}

}
