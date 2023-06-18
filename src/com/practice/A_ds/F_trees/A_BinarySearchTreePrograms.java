package com.practice.A_ds.F_trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.practice.B_algo_ps.K_sort_search_math.Utility;


public class A_BinarySearchTreePrograms {
	public static void main(String args[]) {
		Queue<Integer> q = new LinkedList<>();

		Node root = Utility.createBinarySearchTree();
		System.out.println(isBinarySearchTree(root, null, null));

		List<Integer> sortedListUsingInOrderTraversal = new ArrayList<>();
		inOrderTraversal(root, sortedListUsingInOrderTraversal);
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

	private static boolean isBinarySearchTree(Node root, Integer min, Integer max) {
		if (root != null) {
			if ((min != null && root.getData() <= min) || (max != null && root.getData() >= max)) {
				return false;
			}
			return isBinarySearchTree(root.getLeft(), min, root.getData()) && isBinarySearchTree(root.getRight(), root.getData(), max);
		}
		return true;
	}
}
