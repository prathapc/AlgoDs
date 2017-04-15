package com.practice.algo;

import java.util.Scanner;

public class Fibonacii {

	static int[] a;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//recursiveSolution(scanner.nextInt());
		//memorizationSolution(scanner.nextInt());
		tabularSolution(scanner.nextInt());
	}

	private static void tabularSolution(int n) {
		int[] f = new int[n+1];
		f[0] = 0;
		f[1] = 1;
		for(int i=2; i<=n; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		System.out.println(f[n]);
	}

	private static void memorizationSolution(int n) {
		a = new int[n];
		Long startTime = System.currentTimeMillis();
		int result = 0;
		result += memFib(n);
		Long endTime = System.currentTimeMillis();
		System.out.println(n + "th Fibanocci number is:"+result+" and time taken for calculation is:"+(endTime-startTime));
	}
	
	private static int memFib(int n) {
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else {
			if(a[n-1] != 0) {
				return a[n-1];
			} else {
				a[n-1] = memFib(n-1) + memFib(n-2);
				return a[n-1];
			}
		}
	}
	
	private static void recursiveSolution(int n) {
		Long startTime = System.currentTimeMillis();
		int result = 0;
		result += recFib(n);
		Long endTime = System.currentTimeMillis();
		System.out.println(n + "th Fibanocci number is:"+result+" and time taken for calculation is:"+(endTime-startTime));
	}
	
	private static int recFib(int n) {
		if(n == 0) 
			return 0;
		else if(n == 1)
			return 1;
		else {
			int n1 = recFib(n-1);
			int n2 = recFib(n-2);
			return n1+n2;
		}
	}
}
