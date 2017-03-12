package com.practice.ds;

import java.util.LinkedList;
import java.util.Queue;

public class TreePrograms {

	public static void main(String args[]) {
		Tree root = createSampleTree();
		//printTree(root);
		levelOrder(root);
		//System.out.println("************");
		//rightView(root);
	}

	private static void rightView(Tree root) {
		Queue<Tree> queue = new LinkedList<Tree>();
		if(root != null) {
			queue.add(root);
		}
		int level = 0, count = 0;
		while(! queue.isEmpty()) {
			Tree node = queue.poll();
			if(node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if(node.getRight() != null) {
				queue.add(node.getRight());
			}
			if(count == 0) {
				count = ++level;
				System.out.print(node.getD() + " ");
			} else {
				count--;
			}
			if(queue.isEmpty()) {
				System.out.print(node.getD() + " ");
			}
		}
	}

	private static void levelOrder(Tree root) {
		Queue<Tree> queue = new LinkedList<Tree>();
		
		if(root != null) {
			queue.add(root);
		}
		int level = 0, count = 1;
		while(! queue.isEmpty()) {
			Tree node = queue.poll();
			if((int) Math.pow(2, level) == count) {
				count = 0;
				level++;
				System.out.println(node.getD());
			} else {
				System.out.print(node.getD() + " ");
			}
			if(node.getLeft() != null) {
				queue.add(node.getLeft()); count++;
			}
			if(node.getRight() != null) {
				queue.add(node.getRight()); count++;
			}
		}
	}

	private static void printTree(Tree root) {
		if(root != null) {
			System.out.println(root.getD() + " ");
		}
		//for(int )
	}

	private static Tree createSampleTree() {
		Tree root = new Tree(8);
		Tree left = new Tree(5);
		Tree right = new Tree(18);
		root.setLeft(left);
		root.setRight(right);
		left.setLeft(new Tree(1));
		Tree leftRight = new Tree(6);
		left.setRight(leftRight);
		leftRight.setLeft(new Tree(4));
		right.setRight(new Tree(20));
		return root;
	}
	private static Tree createSampleTree1() {
		Tree root = new Tree(2);
		Tree left = new Tree(3);
		root.setLeft(left);
		Tree leftLeft = new Tree(4);
		left.setLeft(leftLeft);
		Tree leftLeftLeft = new Tree(5);
		leftLeft.setLeft(leftLeftLeft);
		return root;
	}
	private static Tree createSampleTree2() {
		Tree root = new Tree(1);
		Tree right = new Tree(2);
		root.setRight(right);
		Tree rightRight = new Tree(3);
		right.setRight(rightRight);
		Tree rightRightLeft = new Tree(5);
		rightRight.setLeft(rightRightLeft);
		Tree rightRightRight = new Tree(4);
		rightRight.setRight(rightRightRight);
		Tree rightRightRightLeft = new Tree(7);
		rightRightRight.setLeft(rightRightRightLeft);
		Tree rightRightRightRight = new Tree(8);
		rightRightRight.setRight(rightRightRightRight);
		return root;
	}
	
}
