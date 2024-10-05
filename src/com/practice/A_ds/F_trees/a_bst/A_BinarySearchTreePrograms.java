package com.practice.A_ds.F_trees.a_bst;

import com.practice.A_ds.F_trees.Node;
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
		sortedListUsingInOrderTraversal.add(root.getVal());
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

	//instead of Integer null, if we take MAX_VALUE/MIN_VALUE, it fails for testcases having boundary max/min and overflow issues
	private static boolean isBinarySearchTree(Node root, Integer min, Integer max) {
		if (root != null) {
			if ((min != null && root.getVal() <= min) || (max != null && root.getVal() >= max)) {
				return false;
			}
			return isBinarySearchTree(root.getLeft(), min, root.getVal()) && isBinarySearchTree(root.getRight(), root.getVal(), max);
		}
		return true;
	}
}
