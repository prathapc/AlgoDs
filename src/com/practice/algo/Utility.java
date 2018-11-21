package com.practice.algo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.practice.ds.trees.Node;

/**
 * Separate the integer into 4 digits.
 If you don't have a 0, 1, or 2 then there is no answer.
 Put the largest number that is <= 2 in the first spot in the time.
 If the first digit was a 2, then put the largest remaining number that is <=3 in the second place. (If there isn't one, then there is no answer.) If the first digit was 1 or 0, then place the largest remaining number in the second place.
 Put the largest remaining number that is <= 5 in the third place.
 Put the only remaining number in the fourth place.
 */
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
	 * 					20
	 * 			8				20
	 * 		4		12				23
	 *
	 * 			10		14
	 */
	public static Node createSampleTree3() {
		Node root = new Node(20);
		Node left = new Node(8);
		Node right = new Node(20);
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
}

