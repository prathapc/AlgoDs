package com.practice.B_algo.A_sort_search_math.math;

/**
 * Created by prathapchowdary on 16/10/21.
 *
 * https://leetcode.com/problems/powx-n
 */
public class H_Pow {

    //O(N)
    public double myPow1(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++)
            ans = ans * x;
        return ans;
    }

    //O(longN)
    //Assuming we have got the result of x ^ n, how can we get x ^ {2 * n}
    //Obviously we do not need to multiply x for another n times. Using the formula (x ^ n) ^ 2 = x ^ {2 * n}
    //we can get x ^ {2 * n} at the cost of only one computation. Using this optimization, we can reduce the time complexity of our algorithm.
    public double myPow(double x, int n) {
        //to cover upper bounds of int
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }
}
