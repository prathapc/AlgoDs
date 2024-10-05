package com.practice.B_algo_ps.J_bit_manipulation;

/**
 * Created by prathapchowdary on 29/11/23.
 */
public class C3_LongestConsecutive1s {

    /**
     * The idea is based on the concept that the AND of bit sequence with a left shifted by 1 version
     * of itself effectively removes the trailing 1 from every sequence of consecutive 1s.
     *
     * So the operation N = (N & (N << 1)) reduces length of every sequence of 1s by one in binary
     * representation of N. If we keep doing this operation in a loop, we end up with N = 0.
     * The no of iterations required to reach 0 is actually length of the longest consecutive sequence of 1s.
     */
    private static int maxConsecutiveOnes(int x)
    {
        // Initialize result
        int count = 0;

        // Count the number of iterations to
        // reach x = 0.
        while (x!=0) {
            // This operation reduces length
            // of every sequence of 1s by one.
            x = (x & (x << 1));
            count++;
        }
        return count;
    }
}
