package com.practice.algo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Test {

	public static void main(String[] args) {

		//trailingZeroes(9247);
	}


	public static int trailingZeroes(int a) {
		String f = factorial(a);
		int result = 0;
		for(int i=f.length()-1; i>=0; i--) {
			if(f.charAt(i) == '0') {
				result++;
			} else {
				break;
			}
		}
		return result;

	}

	private static String factorial(int a) {
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= a; i++) {
			fact = fact.multiply(new BigInteger(i + ""));
		}
		return fact.toString();
	}
}
