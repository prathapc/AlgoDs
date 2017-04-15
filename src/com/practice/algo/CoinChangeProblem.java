package com.practice.algo;

public class CoinChangeProblem {
	
	//1,2,3 cent coins available; need change for "n" using these coins
	public static void main(String[] args) {
		int sum = 13;
		int coins[] = {7,3,2,6};
		int totalCoins = coins.length;
		
		//dynamicProgrammingMinNumberOfCoinsRequired(coins, totalCoins, sum);
		
		//NumberOfCombinationsOfCoins
		System.out.println(count(coins, totalCoins, sum));
	}

	private static void dynamicProgrammingMinNumberOfCoinsRequired(int[] coins, int totalCoins, int sum) {
		int[] sumArray = new int[sum];
		int[] usedCoinArray = new int[sum];
		
		for(int i=0; i<sum; i++) {
			if(i==0) {
				sumArray[i] = 0;
				usedCoinArray[i] = -1; 
			} else {
				sumArray[i] = Integer.MAX_VALUE;
				usedCoinArray[i] = -1;
			}
		}
		
		
		
		
		
	}

	private static int count(int[] s, int m, int n) {
		if(n == 0) {
			return 1; // do not include any coin is one solution
		}
		if(n < 0) {
			return 0;
		}
		if(m <= 0) {
			return 0;
		}
		return count(s, m-1, n) + count(s, m, n-s[m-1]);
	}

}
