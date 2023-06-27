package com.practice.B_algo_ps.J_bit_manipulation;

/**
 * Created by prathapchowdary on 24/06/23.
 *
 * Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
 * Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
 *
 * https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c
 */
public class D_MinFlipsToMakeaORbEqualToc {

    /**
     * Intuition
     * The XOR operation returns a bit with the value of 1 only if the corresponding bits of its operands are different.
     * In other words, if two bits are the same, the XOR operation returns 0, otherwise, it returns 1.
     * We can take advantage of this property to solve the problem without iterating over each bit.
     *
     * The problem is asking us to have a | b equal to c. If we do (a | b) ^ c,
     * then every bit that is different (and thus we need to flip) will have a value of 1.
     * Therefore we can just do (a | b) ^ c and count the bits that are set.
     *
     * However, there is one exception, which is when (c & 1) = 0 and both a & 1 and b & 1 equal 1.
     * In this case, we need an additional flip.
     *
     * To find all these cases, we need to identify all the bits where both a and b are equal to 1.
     *
     * To achieve this, we can use the bitwise & operator. The & operator only returns 1 when operands are both equal to 1.
     * As shown in the picture below, only the third least significant bit of a and b is 1 at the same time.
     * Therefore, we can find all the bits that "need an extra flip" from (a & b) & ((a | b) ^ c), where each bit with value 1 stands for an extra flip.
     */
    public int minFlips(int a, int b, int c) {
        return Integer.bitCount((a | b) ^ c) + Integer.bitCount(a & b & ((a | b) ^ c));
    }

}
