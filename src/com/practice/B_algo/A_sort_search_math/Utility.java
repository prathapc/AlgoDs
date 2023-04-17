package com.practice.B_algo.A_sort_search_math;

import java.util.Arrays;
import java.util.Scanner;

import com.practice.A_ds.C_linkedlist.ListNode;
import com.practice.A_ds.F_trees.Node;
import com.practice.A_ds.F_trees.TreeNode;
import com.sun.source.tree.Tree;

public class Utility {

	public static void main(String args[]) {
		//System.out.print(solution(0,8,3,2,6,4));
		System.out.print(solution(0,0,0,7,8,9));
	}

	public static String solution(int A, int B, int C, int D, int E, int F) {
		int[] input = new int[]{A,B,C,D,E,F};
		Arrays.sort(input);
		String hh = getHour(input);
		if(!hh.equals("NOT POSSIBLE")) {
			String mm = getMini(input);
			if(!mm.equals("NOT POSSIBLE")) {
				String ss = getSec(input);
				if(!ss.equals("NOT POSSIBLE")) {
					return hh+":"+mm+":"+ss;
				}
			}
		}
		return "NOT POSSIBLE";
	}

	public static String getHour(int[] input){

		String hour;
		if(input[0]>3){
			return "NOT POSSIBLE";
		}
		hour=input[0]+"";
		if(input[0]==2 && input[1]>4){
			return "NOT POSSIBLE";
		}
		hour =hour+input[1];
		return hour;
	}


	public static String getMini(int[] input){

		String min;

		if(input[2]>5){
			return "NOT POSSIBLE";
		}
		min=input[2]+"";

		if(input[4]<6 ){
			min=min+input[3];
		}
		else if( input [3]<6 ){
			min=min+input[4];
		}
		else {
			return "NOT POSSIBLE";
		}
		return min;

	}

	public static String getSec(int[] input){

		String sec;

		if(input[4]<6 ){
			sec=input[4]+""+input[5]+"";
			return sec;
		}
		else if( input [3]<6 ){
			sec=input[3]+""+input[5]+"";
		}
		else {
			return "NOT POSSIBLE";
		}
		return sec;
	}

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

	public static void printArray(int[][] a, int r, int c) {
		for (int i = 0; i < r; i++) {
			for(int j=0; j<c; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
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

	public static int min(int i, int j, int k) {
		if (i <= j) {
			if(i <= k) {
				return i;
			}
			return k;
		}
		return j;
	}

	public static Scanner getScanner() {
		return new Scanner(System.in);
	}

	/**
	 * 			 9
	 * 		 5		  18
	 * 	  1    7   10 	  20
	 *
	 */
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

	/**
	 * 			  8
	 * 		5		  18
	 * 	1		6  			20
	 * 		4
	 */
	public static TreeNode createSampleTree() {
		TreeNode root = new TreeNode(8);
		TreeNode left = new TreeNode(5);
		TreeNode right = new TreeNode(18);
		root.left = left;
		root.right = right;
		left.left = new TreeNode(1);
		TreeNode leftRight = new TreeNode(6);
		left.right = leftRight;
		leftRight.left = new TreeNode(4);
		right.right = new TreeNode(20);
		return root;
	}

	public static TreeNode createSampleTree(String[] vals) {
		if (vals.length == 0) return null;
		String rootVal = vals[0];
		if (rootVal == null) return null;

		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		TreeNode temp = root;
		for (int i=1; i<vals.length; i++) {
			String val = vals[i];
			if (val == null) continue;
			if (i % 2 != 0) {
				TreeNode left = new TreeNode(Integer.parseInt(val));
				temp.left = left;
			} else {
				TreeNode right = new TreeNode(Integer.parseInt(val));
				temp.right = right;
			}
		}
		return root;
	}

	/**
	 * 			  1
	 * 		2	     	5
	 * 	3		4	  		6
	 * @return
	 */
	public static Node createSampleTreeBasic() {
		Node root = new Node(1);
		Node left = new Node(2);
		Node right = new Node(5);
		root.setLeft(left);
		root.setRight(right);
		left.setLeft(new Node(3));
		left.setRight(new Node(4));

		right.setRight(new Node(6));
		return root;
	}

	public static Node createSampleSumTree() {
		Node root = new Node(28);
		Node left = new Node(11);
		Node right = new Node(3);
		root.setLeft(left);
		root.setRight(right);
		left.setLeft(new Node(5));
		Node leftRight = new Node(6);
		left.setRight(leftRight);
		right.setRight(new Node(3));
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

	/**
	 * 			1
	 * 				2
	 * 					3
	 * 				5		4
	 * 					  7	   8
	 */
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

	/**
	 * 					10
	 * 			8			  12
	 * 		4		12				23
	 *
	 * 			10		14
	 */
	public static Node createSampleTree3() {
		Node root = new Node(10);
		Node left = new Node(8);
		Node right = new Node(12);
		root.setLeft(left);
		root.setRight(right);
		left.setLeft(new Node(4));
		Node leftRight = new Node(12);
		left.setRight(leftRight);
		leftRight.setLeft(new Node(10));
		leftRight.setRight(new Node(14));
		right.setRight(new Node(23));
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

	public static ListNode createLinkedList() {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		head.next = node1;
		ListNode node2 = new ListNode(3);
		node1.next = node2;
		ListNode node3 = new ListNode(4);
		node2.next = node3;
		ListNode node4 = new ListNode(5);
		node3.next = node4;
		//ListNode node5 = new ListNode(6);
		//node4.next = node5;
		//node5.next = null;
		return head;
	}

	public static ListNode buildLinkedList(int a[]) {
		ListNode head = null, node = null, prev = null;
		for (int i=0; i<a.length; i++) {
			if (head == null) {
				head = new ListNode(a[i]);
				prev = head;
			} else {
				node = new ListNode(a[i]);
				prev.next = node;
				prev = node;
			}
		}
		return head;
	}

	public static void printLinkedList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("NULL");
	}

}

