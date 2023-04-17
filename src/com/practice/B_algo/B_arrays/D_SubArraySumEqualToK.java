package com.practice.B_algo.B_arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by prathapchowdary on 03/01/22.
 *
 * Given an array of integers nums and an integer k,
 * return the total number of continuous subarrays whose sum equals to k.
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class D_SubArraySumEqualToK {

    //The idea behind this approach is as follows:
    //If the cumulative sum(represented by sum[i] for sum up to ith index) up to two indices is the same,
    //then sum of the elements lying in between those indices is zero.
    //Extending the same thought further, if the cumulative sum up to two indices,
    //say i and j is at a difference of k i.e. if sum[i] - sum[j] = k, the sum of elements lying between indices i and j is k.

    //In another way, the key to solve this problem is SUM[i, j].
    //So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j].
    //To achieve this, we just need to go through the array, calculate the current sum and save number of all seen PreSum to a HashMap
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //you can remove this if you put "if (sum == k) count++;" inside loop
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            //if (sum == k) count++;  //handled already using "map.put(0, 1);"
            if (map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    //bruteforce - TLE
    public int subarraySum1(int[] nums, int k) {
        int result = 0;
        for (int i=0; i<nums.length; i++) {
            int sum = 0;
            for (int j=i; j<nums.length; j++) {
                sum += nums[j]; //can not break if sum > k as there could be -ve values in array
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }



    // Function to print all subarrays with a zero-sum in a given array
    // same as sub array sum equal to k
    public static void printSubArraysWithZeroSum() {
        int[] nums = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        // create an empty multimap to store the ending index of all
        // subarrays having the same sum
        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        // insert (0, -1) pair into the map to handle the case when
        // subarray with zero-sum starts from index 0
        insert(hashMap, 0, -1);

        int sum = 0;

        // traverse the given array
        for (int i = 0; i < nums.length; i++) {
            // sum of elements so far
            sum += nums[i];

            // if the sum is seen before, there exists at least one
            // subarray with zero-sum
            if (hashMap.containsKey(sum)) {
                List<Integer> list = hashMap.get(sum);

                // find all subarrays with the same sum
                for (Integer value: list) {
                    System.out.println("Subarray [" + (value + 1) + "…" + i + "]");
                }
            }

            // insert (sum so far, current index) pair into the multimap
            insert(hashMap, sum, i);
        }
    }
    private static<K, V> void insert(Map<K, List<V>> hashMap, K key, V value) {
        // if the key is seen for the first time, initialize the list
        hashMap.putIfAbsent(key, new ArrayList<>());
        hashMap.get(key).add(value);
    }



    //for indexes of result sub array - old progream
    /**
     * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
     Ouptut: Sum found between indexes 2 and 4

     Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
     Ouptut: Sum found between indexes 1 and 4

     Input: arr[] = {1, 4}, sum = 0
     Output: No sub array found
     */
    private static void subArraysWithGivenSum() {
        int a[] = {1, 4, 20, 3, 10, 5};
        int sum = 33;
        int tempSum = a[0];
        int start = 0, end = 0;
        if(tempSum == sum) {
            System.out.print("sub array from " + start + " to " + end + " has given sum");
        }
        for(int i=1; i<a.length; i++) {
            tempSum += a[i];
            end++;
            if (tempSum == sum) {
                System.out.print("sub array from " + start + " to " + end + " has given sum");
                break;
            } else if (tempSum > sum) {
                while(start < end) {
                    tempSum -= a[start];
                    start++;
                    if (tempSum == sum) {
                        System.out.print("sub array from " + start + " to " + end + " has given sum");
                        break;
                    }
                }
            }
        }
    }
}
