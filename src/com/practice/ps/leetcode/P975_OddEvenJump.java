package com.practice.ps.leetcode;

import java.util.*;

/**
 * Created by Prathap on 30 Jan, 2020
 *
 * https://leetcode.com/problems/odd-even-jump/
 *
 * Input: [10,13,12,14,15]
 * Output: 2
 * Explanation:
 * From starting index i = 0, we can jump to i = 2 (since A[2] is the smallest among A[1], A[2], A[3], A[4] that is greater or equal to A[0]), then we can't jump any more.
 * From starting index i = 1 and i = 2, we can jump to i = 3, then we can't jump any more.
 * From starting index i = 3, we can jump to i = 4, so we've reached the end.
 * From starting index i = 4, we've reached the end already.
 * In total, there are 2 different starting indexes (i = 3, i = 4) where we can reach the end with some number of jumps.
 */
public class P975_OddEvenJump {

    public int oddEvenJumps(int[] A) {
        // Each boolean array has the same length as A.
        // The value stored at odd[i] tells us whether we can
        // reach the end of the array from A[i] if we are doing and odd jump at A[i].
        // The idea is the same for the even boolean array.
        boolean[] odd = new boolean[A.length];
        boolean[] even = new boolean[A.length];

        // The last element is always a good jump because
        // if we start from the last element, we are already at the end of the array
        // regatdless whether the jump is odd or not.
        even[A.length - 1] = true;
        odd[A.length - 1] = true;

        // We use a tree map to store a number from A as a key and its index as a value:
        // A[i] : i
        // If there are duplicate values in A, at any point in time the tree map
        // will have the last seen one.
        // We will be going through the array backwards so if there are duplicates in A,
        // the tree map will always have the one with smallest index as it would have been
        // the one we visited most recently.
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[A.length-1], A.length-1);

        // Store the number of good jumps we have seen.
        int goodJumps = 0;

        // We start going over the array backwards and we start from the last but one
        // because we have already set the last element's odd and even boolean to true
        for(int i = A.length - 2; i >= 0; i--) {
            // First we check of the tree map has the current A[i] as a key.
            // If it does, this means we have already computed it's even and odd booleans
            if(map.containsKey(A[i])) {
                // even[map.getValue(A[i])] will give us the even[] boolean for the duplicate of
                // our current element that is already in the tree.
                // We want this because if we are looking for the greatest smaller or equal item
                // to a number n, such number is always n. I.e. n is always the greatest number which
                // is smaller or equal to a given number is that same number (because we allow an equal number).
                // Same applies for smallest greater or equal number to a given number.
                // So in our case we know we have a number which is equal to our current number and that
                // is what we want, so we get it from the map.
                odd[i] = even[map.get(A[i])];
                even[i] = odd[map.get(A[i])];
            } else {
                // if current A[i] is not in the tree we have to compute even[i] and odd[i]

                // ceilingEntry(i) gives the smallest greater element than i, if such is present in the map
                // if it is present, it means we could make an odd jump from A[i] and we need to see if we can
                // make an even jump from the value we can jump to

                Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(A[i]);
                if(ceilingEntry != null)
                    odd[i] = even[ceilingEntry.getValue()];

                // The same logic as the previous if, only floorEntry gives us the greatest smaller item than
                // the one we pass, which would be the item we would land on if we make an even jump from
                // the current item
                Map.Entry<Integer, Integer> floorEntry = map.floorEntry(A[i]);
                if(floorEntry != null)
                    even[i] = odd[floorEntry.getValue()];

            }

            // we always put the current A[i] and its index i to the tree so that
            // if such element exists already we override it with the most recent index
            map.put(A[i], i);
        }

        // Finally, since we always start with an odd jump (1), we want to see how many
        // good jumps we have in the odd[] boolean array and this is our answer

        for(boolean b : odd)
            goodJumps += b ? 1 : 0;

        return goodJumps;
    }
}
