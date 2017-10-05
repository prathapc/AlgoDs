package com.practice.ds.trees;

public class BinaryTreeLinkedList {

	static Node2 root;
	static Node2 head;
	static Node2 prev = null;

	public static void main(String[] args) {
		// Let us create the tree as shown in above diagram
		BinaryTreeLinkedList tree = new BinaryTreeLinkedList();
		root = new Node2(10);
		root.left = new Node2(12);
		root.right = new Node2(15);
		root.left.left = new Node2(25);
		root.left.right = new Node2(30);
		root.right.left = new Node2(36);

		// convert to DLL
		BinaryTree2DoubleLinkedList(root);

		// Print the converted List
		printList(head);

	}

	private static void BinaryTree2DoubleLinkedList(Node2 root) {
		if(root == null)
			return;
		
		BinaryTree2DoubleLinkedList(root.left);
		if(prev == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		BinaryTree2DoubleLinkedList(root.right);	
	}

	private static void printList(Node2 node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}
}

class Node2 {
	int data;
	Node2 left, right;

	public Node2(int data) {
		this.data = data;
		left = right = null;
	}
}
