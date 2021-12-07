package com.practice.C_ps;

public class NumbersPrograms {

	public static void main(String[] args) {
		//randomNumber();
		
		heighestNumberWithKSwipesWithGivenDigitsOfANumber(431520);//i/p --> 2345, k=2 o/p -> 4235
		
		nextHeighestNumberWithGivenDigitsInANumber(431520);  //i/p --> 234 o/p -> 243
		
	}

	private static void heighestNumberWithKSwipesWithGivenDigitsOfANumber(int num) {
		int input = 1234;
		int k = 2;
		
	}
	//recursion in a loop

	//small issue, debug and fix or use simper ds for this -> array to solve instead of string
	private static void nextHeighestNumberWithGivenDigitsInANumber(int num) {
		String numString = String.valueOf(num);
		int n = numString.length();
		int index = -1;
		int prev = Integer.parseInt(String.valueOf(numString.charAt(n-1)));
		for (int i=n-2; i>=0; i--) {
			int current = Integer.parseInt(String.valueOf(numString.charAt(i)));
			if (current < prev) {
				index = i;
				break;
			}
			prev = current;
		}
		if (index == -1) {
			System.out.println("Given number is the heighest with given digits");
		} else {
			//swap index with next heigher digit which is its right adjacent
			String result = numString.substring(0, n-index) + numString.charAt(n - index);
			if (index > 1) {
				result += numString.substring(n - index + 1);
			}
			System.out.println(result);
		}
	}

	//random number from 1 to 10
	private static void randomNumber() {
		double d = Math.random();
		System.out.println((int)(d*10+1));
	}
}