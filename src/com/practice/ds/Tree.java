package com.practice.ds;

public class Tree {

	private int d;
	private Tree left, right;
	
	public Tree(int d) {
		this.d = d;
	}
	
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	public Tree getLeft() {
		return left;
	}
	public void setLeft(Tree left) {
		this.left = left;
	}
	public Tree getRight() {
		return right;
	}
	public void setRight(Tree right) {
		this.right = right;
	}
	
}
