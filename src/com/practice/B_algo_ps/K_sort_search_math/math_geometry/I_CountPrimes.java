package com.practice.B_algo_ps.K_sort_search_math.math_geometry;

/**
 * Created by Prathap on 09 Nov, 2019
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * https://leetcode.com/problems/count-primes/
 */
public class I_CountPrimes {

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
