package com.practice.algo;

public class StackImplementations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,-2,4,-3,-8,5};
		java.util.Stack<Integer> s = new java.util.Stack<Integer>();
		for(int i=0; i<a.length; i++) {
			if(s.isEmpty()) {
				s.push(a[i]);
			} else {
				for(int j=0; j<s.size(); j++) {
					if(s.peek() < a[i]) {
						System.out.println(s.pop() + "," + a[i]);
						j--;
					}
				}
				s.push(a[i]);				
			}
		}
		System.out.println(s.pop() + "," + null);
	}

}

class Stack {
	int top;
	
}
