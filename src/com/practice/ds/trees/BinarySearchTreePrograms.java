package com.practice.ds.trees;

import java.util.ArrayList;
import java.util.List;

import com.practice.algo.Utility;


public class BinarySearchTreePrograms {
	public static void main(String args[]) {
		Node root = Utility.createBinarySearchTree();
		//System.out.println(isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

		//Scanner scanner = Utility.getScanner();
		System.out.println(pathInTree(root, 5, 20));
		
		//List<Integer> sortedListUsingInOrderTraversal = new ArrayList<Integer>();
		//inOrderTraversal(root, sortedListUsingInOrderTraversal);
		//checkSumOfTwoNumbersInBSTMatchesInputNumber(sortedListUsingInOrderTraversal, 19);
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


	/*
	Not a clean way, there is another way using recursion.
	 */
	private static List<Integer> pathInTree(Node root, int src, int dest) {
		List<Integer> result = new ArrayList<Integer>();
		if(src == root.getData()) {
			List<Integer> pathOfElements = findPathToANode(root, dest);
			return pathOfElements;
		} else if(dest == root.getData()) {
			List<Integer> pathOfElements = findPathToANode(root, src);
			for(int i=pathOfElements.size()-1; i>0; i--) {
				result.add(pathOfElements.get(i));
			}
			return result;
		} else if((src < root.getData() && dest > root.getData()) || (src > root.getData() && dest < root.getData())) {
			List<Integer> pathOfElemetsToSrc = findPathToANode(root, src);
			List<Integer> pathOfElemetsToDest = findPathToANode(root, dest);
			for(int i=pathOfElemetsToSrc.size()-1; i>0; i--) {
				result.add(pathOfElemetsToSrc.get(i));
			}
			result.addAll(pathOfElemetsToDest);
			return result;
		} else {
			List<Integer> pathOfElemetsToSrc = findPathToANode(root, src);
			List<Integer> pathOfElemetsToDest = findPathToANode(root, dest);
			for(int i=pathOfElemetsToSrc.size()-1; i>0; i--) {
				result.add(pathOfElemetsToSrc.get(i));
				if(pathOfElemetsToDest.contains(pathOfElemetsToSrc.get(i))) {
					int p = pathOfElemetsToDest.indexOf(pathOfElemetsToSrc.get(i));
					for(int k=p+1; k<pathOfElemetsToDest.size(); k++) {
						result.add(pathOfElemetsToDest.get(k));
					}
					break;
				}
			}
			return result;
		}
	}

	private static List<Integer> findPathToANode(Node root, int dest) {
		List<Integer> pathOfElements;
		pathOfElements = new ArrayList<Integer>();
		while(true) {
			pathOfElements.add(root.getData());
			if(root == null || root.getData() == dest) {
				break;
			}else if(root.getData() > dest) {
				root = root.getLeft();
			} else {
				root = root.getRight();
			}
		}
		return pathOfElements;
	}

	private static boolean isBinarySearchTree(Node root, int min, int max) {
		if(root == null) 
			return true;
		if(root.getData() < min || root.getData() > max)
			return false;
		return isBinarySearchTree(root.getLeft(), min, root.getData()-1) && isBinarySearchTree(root.getRight(), root.getData()+1, max);	
	}

	
}
