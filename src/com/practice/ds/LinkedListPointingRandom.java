package com.practice.ds;

public class LinkedListPointingRandom {

	public static void main(String[] args) {
		//create a linked list with next and random pointers
		// 1-> 2 -> 3 -> null
		// v   v 	v	
		// 3   1  	2  
		Node1 node1 = new Node1(1);
		Node1 node2 = new Node1(2);
		Node1 node3 = new Node1(3);
		node1.setNext(node2);
		node2.setNext(node3);
		node1.setRandom(node3);
		node2.setRandom(node1);
		node3.setRandom(node2);
		
		//returns clone of node1
		Node1 clone = cloneOfNode(node1);
		while(clone != null) {
			System.out.print(clone.getData() + " -> ");
			clone = clone.getNext();
		}
		
	}

	private static Node1 cloneOfNode(Node1 node1) {
		if(node1 == null)
			return node1;
		
		//construct duplicate linked list in the same linkedlist alternatively to acheive O(1) space
		// 1-> 4 -> 2 -> 5 -> 3 -> 6 -> null
		// v   		v 		  v	
		// 3   		1  		  2  
		Node1 nCurr = node1;
		while(nCurr != null) {
			Node1 temp = new Node1(nCurr.getData()+3);
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
		Node1 clone = node1.getNext();
		nCurr = node1;
		Node1 t = null;
		while(nCurr != null) {
			t = nCurr.getNext();
			if(nCurr.getNext() != null) {
				nCurr.setNext(nCurr.getNext().getNext());
			}
			nCurr = t;
		}
		return clone;
	}

}

class Node1 {
	private int data;
	private Node1 next;
	private Node1 random;
	
	public Node1(int data) {
		super();
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node1 getNext() {
		return next;
	}
	public void setNext(Node1 next) {
		this.next = next;
	}
	public Node1 getRandom() {
		return random;
	}
	public void setRandom(Node1 random) {
		this.random = random;
	}
}