package com.practice.B_algo.A_sort_search_math.math;

/**
 * Created by prathapchowdary on 16/10/21.
 *
 * https://leetcode.com/problems/powx-n/solution/
 */
public class Pow {

    public double myPow(double x, int n) {
        //to cover upper bounds of int
        long lonN = n;
        if (lonN < 0) {
            x = 1 / x;
            lonN = -lonN;
        }

        double result = 1;
        double current_product = x;
        for (long i = lonN; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                result = result * current_product;
            }
            current_product = current_product * current_product;
        }
        return result;
    }
}
