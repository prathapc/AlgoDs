package com.practice.ds.trees;

import java.util.ArrayList;
import java.util.List;

import com.practice.algo.Utility;


public class BinarySearchTreePrograms {
	public static void main(String args[]) {
		Node root = Utility.createBinarySearchTree();
		System.out.println(isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

		//List<Integer> sortedListUsingInOrderTraversal = new ArrayList<Integer>();
		//inOrderTraversal(root, sortedListUsingInOrderTraversal);
	}

	private static void inOrderTraversal(Node root, List<Integer> sortedListUsingInOrderTraversal) {
		if(root == null)
			return;
		inOrderTraversal(root.getLeft(), sortedListUsingInOrderTraversal);
		sortedListUsingInOrderTraversal.add(root.getData());
		inOrderTraversal(root.getRight(), sortedListUsingInOrderTraversal);
	}
	
	private static void checkSumOfTwoNumbersInBSTMatchesInputNumber(List<Integer> sortedListUsingInOrderTraversal, int sum) {
		int n = sortedListUsingInOrderTraversal.size();
		for(int i=0; i<n; i++) {
			int sumOfTwoNumInArray = sortedListUsingInOrderTraversal.get(i) + sortedListUsingInOrderTraversal.get(n-1 - i);
			if(sumOfTwoNumInArray == sum) {
				System.out.println(true); return;
			} else if(sumOfTwoNumInArray < sum) {
				continue;
			} else {
				n--;
				i--;
			}
		}
		System.out.println(false);
	}

	private static boolean isBinarySearchTree(Node root, int min, int max) {
		if(root == null) 
			return true;
		if(root.getData() < min || root.getData() > max)
			return false;
		return isBinarySearchTree(root.getLeft(), min, root.getData()-1) && isBinarySearchTree(root.getRight(), root.getData()+1, max);	
	}
}
