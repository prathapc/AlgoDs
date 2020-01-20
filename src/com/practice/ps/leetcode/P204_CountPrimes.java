package com.practice.ps.leetcode;

/**
 * Created by Prathap on 09 Nov, 2019
 */
public class P204_CountPrimes {

    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        for (int i=0; i<n; i++) {
            primes[i] = true;
        }

        for (int i=2; i*i<n; i++) {
            if (primes[i]) {
                for (int j=i; i*j<n; j++) {
                    primes[i*j] = false;
                }
            }
        }

        int result = 0;
        for (int i=2; i<primes.length; i++) {
            if (primes[i]) {
                result++;
            }
        }

        return result;
    }

    //Regular solution but not efficient
    /*public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        if (n <= 2) {
            return 0;
        }
        primes[1] = true;
        int result = 1;
        for (int i=3; i<n; i++) {
            boolean isPrime = true;
            for (int j=2; j<=Math.sqrt(i); j++) {
                if (primes[j-1]  && i%j == 0) {
                   isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes[i-1] = true;
                result++;
            }
        }
        return result;
    }*/
}
