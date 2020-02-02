package com.practice.algo.knapsack;

public class CoinChangeProblem {
	
	//1,2,3 cent coins available; need change for "n" using these coins
	public static void main(String[] args) {
		int sum = 10;
		int coins[] = {2,5,3,6};
		int totalCoins = coins.length;

		//System.out.println(count(coins, totalCoins, sum));
		System.out.println(dynamicProgrammingNumberOfWaysToMakeChange(coins, totalCoins, sum));
	}

	private static int dynamicProgrammingNumberOfWaysToMakeChange(int[] coins, int totalCoins, int sum) {
		int a[][] = new int[totalCoins][sum+1];
		for(int i=0; i<totalCoins; i++) {
			for(int j=0; j<=sum;j++) {
				if(j==0) {
					a[i][j] = 1;
					continue;
				}
				if(i==0) {
					a[i][j] = (j%coins[i] == 0) ? 1: 0;
					continue;
				}
				if(j<coins[i]) {
					a[i][j] = a[i-1][j];
					continue;
				}
				a[i][j] = a[i-1][j] + a[i][j-coins[i]];
			}
		}
		return a[totalCoins-1][sum];
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
