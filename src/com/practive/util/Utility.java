package com.practive.util;

import java.util.Scanner;

import com.practice.ds.Node;

public class Utility {

	public static void geeksforgeeksInputFormat() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for(int i=0; i<n; i++) {
		    //functionCall(scanner.nextInt());
		}
		scanner.close();	
	}
	
	public static int[][] readArray(int r, int c) {
		Scanner scanner = getScanner();
		int[][] a = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				a[i][j] = scanner.nextInt();
			}
		}
		scanner.close();
		return a;
	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static int max(int i, int j) {
		if (i > j) {
			return i;
		} else {
			return j;
		}
	}

	public static int min(int i, int j) {
		if (i < j) {
			return i;
		} else {
			return j;
		}
	}

	public static Scanner getScanner() {
		return new Scanner(System.in);
	}

	public static Node createBinarySearchTree() {
		Node root = new Node(9);
		Node left = new Node(5);
		Node right = new Node(18);
		root.setLeft(left);
		root.setRight(right);
		left.setLeft(new Node(1));
		Node leftRight = new Node(7);
		// leftRight.setRight(new Node(23));
		left.setRight(leftRight);
		right.setLeft(new Node(10));
		right.setRight(new Node(20));
		return root;
	}

	public static Node createMaxHeapTree() {
		Node root = new Node(100);
		Node left = new Node(19);
		Node right = new Node(36);

		root.setLeft(left);
		root.setRight(right);

		Node leftLeft = new Node(17);
		Node leftRight = new Node(3);

		Node rightLeft = new Node(25);
		Node rightRight = new Node(1);

		Node leftLeftLeft = new Node(2);
		Node leftLeftRight = new Node(7);

		leftLeft.setLeft(leftLeftLeft);
		leftLeft.setRight(leftLeftRight);

		left.setLeft(leftLeft);
		left.setRight(leftRight);

		right.setLeft(rightLeft);
		right.setRight(rightRight);

		return root;
	}

	public static Node createSampleTree() {
		Node root = new Node(8);
		Node left = new Node(5);
		Node right = new Node(18);
		root.setLeft(left);
		root.setRight(right);
		left.setLeft(new Node(1));
		Node leftRight = new Node(6);
		left.setRight(leftRight);
		leftRight.setLeft(new Node(4));
		right.setRight(new Node(20));
		return root;
	}

	public static Node createSampleTree1() {
		Node root = new Node(2);
		Node left = new Node(3);
		root.setLeft(left);
		Node leftLeft = new Node(4);
		left.setLeft(leftLeft);
		Node leftLeftLeft = new Node(5);
		leftLeft.setLeft(leftLeftLeft);
		return root;
	}

	public static Node createSampleTree2() {
		Node root = new Node(1);
		Node right = new Node(2);
		root.setRight(right);
		Node rightRight = new Node(3);
		right.setRight(rightRight);
		Node rightRightLeft = new Node(5);
		rightRight.setLeft(rightRightLeft);
		Node rightRightRight = new Node(4);
		rightRight.setRight(rightRightRight);
		Node rightRightRightLeft = new Node(7);
		rightRightRight.setLeft(rightRightRightLeft);
		Node rightRightRightRight = new Node(8);
		rightRightRight.setRight(rightRightRightRight);
		return root;
	}

	public static int max(int i, int j, int k) {
		if (i > j) {
			if (i > k) {
				return i;
			} else {
				return k;
			}
		} else {
			if (j > k) {
				return j;
			} else {
				return k;
			}
		}
	}

	public static void swapElementsInArray(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static int getMaxInArray(int[] a) {
		int maxElement = a[0];
		for (int i = 1; i < a.length; i++) {
			if(a[i] > maxElement) {
				maxElement = a[i];
			}
		}
		return maxElement;
	}
}
