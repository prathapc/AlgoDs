package com.practice.ds.linkedlist;

public class LinkedListPointingRandom {

	public static void main(String[] args) {
		//create a linked list with next and random pointers
		// 1-> 2 -> 3 -> null
		// v   v 	v	
		// 3   1  	2  
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		node1.setNext(node2);
		node2.setNext(node3);
		node1.setRandom(node3);
		node2.setRandom(node1);
		node3.setRandom(node2);

		//returns clone of node1
		Node clone = cloneOfNode(node1);
		while(clone != null) {
			System.out.print(clone.getData() + " -> ");
			clone = clone.getNext();
		}

	}

	private static Node cloneOfNode(Node node1) {
		if(node1 == null)
			return node1;

		//construct duplicate linked list in the same linkedlist alternatively to acheive O(1) space
		// 1-> 4 -> 2 -> 5 -> 3 -> 6 -> null
		// v   		v 		  v
		// 3   		1  		  2
		Node nCurr = node1;
		while(nCurr != null) {
			Node temp = new Node(nCurr.getData()+3);
			temp.setNext(nCurr.getNext());
			nCurr.setNext(temp);
			nCurr = nCurr.getNext().getNext();
		}

		//now assign random pointers to duplicate list as well
		nCurr = node1;
		while(nCurr != null) {
			if(nCurr.getNext() != null && nCurr.getRandom() != null) {
				nCurr.getNext().setRandom(nCurr.getRandom().getNext());
			}
			nCurr = nCurr.getNext();
		}

		//now change next pointers and return node1 clone which is next node
		Node clone = node1.getNext();
		nCurr = node1;
		Node t = null;
		while(nCurr != null) {
			t = nCurr.getNext();
			if(nCurr.getNext() != null) {
				nCurr.setNext(nCurr.getNext().getNext());
			}
			nCurr = t;
		}
		return clone;
	}

	static class Node {
		private int data;
		private Node next;
		private Node random;

		public Node(int data) {
			super();
			this.data = data;
		}

		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getRandom() {
			return random;
		}
		public void setRandom(Node random) {
			this.random = random;
		}
	}

}