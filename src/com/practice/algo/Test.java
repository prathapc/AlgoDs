package com.practice.algo;

import java.net.UnknownHostException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws UnknownHostException {
		int[] charCount = new int[26];
		int offset = (int) 'a';
		Scanner scanner = new Scanner(System.in);
		int tc = scanner.nextInt();
		int a;
		for (int i = 0; i < tc; i++) {
			String input = scanner.next();
			for (int j = 0; j < input.length(); j++) {
				a = input.charAt(j) - offset;
				charCount[a] += 1;
			}

			for (int k = 0; k < charCount.length; k++) {
				if (charCount[k] != 0) {

				}
			}
		}
	}

}
