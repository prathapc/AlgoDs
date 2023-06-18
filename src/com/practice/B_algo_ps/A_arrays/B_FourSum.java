package com.practice.B_algo_ps.A_arrays;

import java.util.*;

/**
 * Created by Prathap on 22 Jan, 2020
 * https://www.geeksforgeeks.org/find-four-numbers-with-sum-equal-to-given-sum/
 * https://leetcode.com/problems/4sum/ -> below solution can be generalized for any sum, not just zero
 */
public class B_FourSum {

    public static void main(String[] args) throws Exception {
        int nums[] = {1,0,-1,0,-2,2};
        //int A[] = {1, 4, 45, 6, 10, 12};
        int n = nums.length;
        int x = 0;
        fourSum(nums, n, x);
    }

    private static void fourSum(int A[], int n, int X) {
        int l, r;

        // Sort the array in increasing order, using library
        // function for quick sort
        Arrays.sort(A);

        /* Now fix the first 2 elements one by one and find
           the other two elements */
        for (int i = 0; i < n - 3; i++)
        {
            for (int j = i + 1; j < n - 2; j++)
            {
                // Initialize two variables as indexes of the first and last
                // elements in the remaining elements
                l = j + 1;
                r = n - 1;

                // To find the remaining two elements, move the index
                // variables (l & r) toward each other.
                while (l < r)
                {
                    if (A[i] + A[j] + A[l] + A[r] == X)
                    {
                        System.out.println(A[i]+" "+A[j]+" "+A[l]+" "+A[r]);
                        l++;
                        r--;
                    }
                    else if (A[i] + A[j] + A[l] + A[r] < X)
                        l++;
                    else // A[i] + A[j] + A[l] + A[r] > X
                        r--;
                } // end of while
            } // end of inner for loop
        } // end of outer for loop
    }
}
