package com.practice.algo;

public class StringManipulation {

	public static void main(String[] args) {
		String str = " Reverse sentense of words  ";
		str = trim(str);
		System.out.println("after trimming:"+str);
		for(int i=str.length()-1; i>0; i--) {
			if(str.charAt(i) == ' ') {
				
			}
		}
		
	}

	private static String trim(String str) {
		int start = 0;
		int end = str.length()-1;
		while(str.charAt(start) == ' ') {
			start++;
		}
		while(str.charAt(end) == ' ') {
			end--;
		}
		return new String(str.toCharArray(), start, end);
	}
}
