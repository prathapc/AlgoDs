package com.practice.F_companyQA.redmart;

import java.util.Stack;

public class Util {

	public static void main(String[] args) {
		// System.out.println(postFixCalc("6 ++ 7 + -- 9 ++ +"));
		StringBuilder sb = new StringBuilder();
		String word1 = "abc";
		String word2 = "pqr";
		int i = word1.length(), j = word2.length();
		while (i < word1.length() || j < word2.length()) {
			if (i < word1.length()) sb.append(word1.charAt(i++));
			if (j < word2.length()) sb.append(word2.charAt(j++));
		}
		System.out.println(sb.toString());
	}

	public static float postFixCalc(String[] exp) {
		Stack<Float> s = new Stack<Float>();

		for (int i = 0; i < exp.length; i++) {
			if (isNum(exp[i])) {
				s.push(Float.parseFloat(exp[i]));
			} else {
				float num2 = s.pop();
				String op = exp[i];
				if (op.equals("++")) {
					s.push(num2 + 1);
				} else if (op.equals("--")) {
					s.push(num2 - 1);
				} else {
					float num1 = s.pop();
					if (op.equals("+")) {
						s.push(num1 + num2);
					} else if (op.equals("-")) {
						s.push(num1 - num2);
					} else if (op.equals("*")) {
						s.push(num1 * num2);
					} else {
						s.push(num1 / num2);
					}
				}
			}
		}

		return s.pop();
	}

	public static int getRowIndexByChar(char ch) {
		return (int) ch - 65;
	}
	public static char getRowNameByNum(int index) {
		return (char) (index + 65);
	}

	public static boolean isNum(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

}
