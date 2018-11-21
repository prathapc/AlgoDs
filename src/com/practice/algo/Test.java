package com.practice.algo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Test {

	public static void main(String[] args) {

	}

	private static String factorial(int a) {
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= a; i++) {
			fact = fact.multiply(new BigInteger(i + ""));
		}
		return fact.toString();
	}
}
