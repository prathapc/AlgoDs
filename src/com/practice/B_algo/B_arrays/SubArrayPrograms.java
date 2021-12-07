package com.practice.B_algo.B_arrays;

/**
 * Created by prathap on 02/09/17.
 */

import com.practice.C_ps.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Kadane's algorithm
 */
public class SubArrayPrograms {
  public static void main(String args[]) {
    largestSumContinousSubArray();
    largestProductContrinousSubArray();

    subArrayWithGivenSum();
    noOfSubArraysWithGivenSum();
    largestSubArrayWithZeroSum();
    printSubArraysWithZeroSum();

    subarraysDivByK();
    sortSubArray();
  }

  /**
   * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
   Ouptut: Sum found between indexes 2 and 4

   Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
   Ouptut: Sum found between indexes 1 and 4

   Input: arr[] = {1, 4}, sum = 0
   Output: No sub array found
   */
  private static void subArrayWithGivenSum() {
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

  /**
   * we know the key to solve this problem is SUM[i, j].
   * So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j].
   * To achieve this, we just need to go through the array,
   * calculate the current sum and save number of all seen PreSum to a HashMap
   */
  private static void noOfSubArraysWithGivenSum() {
    int nums[] = {10, 3, 2, 4, 1};
    int k = 5;
    int sum = 0, result = 0;
    HashMap<Integer, Integer> preSum = new HashMap<>();
    preSum.put(0, 1);
    for (int i=0; i<nums.length; i++) {
      sum += nums[i];
      if (preSum.containsKey(sum - k)) {
        result += preSum.get(sum - k);
      }
      preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
    }
    System.out.print(result);
  }

  private static int subarraysDivByK() {
    int A[] = {4,5,0,-2,-3,1};
    int K = 5;
    Map<Integer, Integer> preSum = new HashMap();
    int sum = 0;
    int result = 0;
    preSum.put(0, 1);
    for (int i = 0; i < A.length; i++) {
      sum += A[i];
      int remainder = sum % K;

      //handling -ve numbers
      if (remainder < 0) {
        remainder += K;
      }

      result += preSum.getOrDefault(remainder, 0);

      preSum.put(remainder, preSum.getOrDefault(remainder, 0) + 1);
    }
    return result;
  }

  private static void largestSubArrayWithZeroSum() {
    int a[] = {15, -2, 2, -8, 1, 7, 10, 23};

    Map<Integer, Integer> sumSeenAndEndingIndexMap = new HashMap<>();
    sumSeenAndEndingIndexMap.put(a[0], 0);
    int maxLen = 0;
    int sumSoFar = a[0];
    for (int i=1; i<a.length; i++) {
      sumSoFar += a[i];

      if (a[i] == 0 && maxLen == 0) {
        maxLen = 1;
      }

      if (sumSoFar == 0) {
        maxLen = i+1;
      }

      if (sumSeenAndEndingIndexMap.containsKey(sumSoFar)) {
        maxLen = Math.max(maxLen, i - sumSeenAndEndingIndexMap.get(sumSoFar));
      } else {
        sumSeenAndEndingIndexMap.put(sumSoFar, i);
      }
    }
    System.out.println(maxLen);

  }

  private static void largestProductContrinousSubArray() {
    int a[] = {6, -3, -10, 0, 2};
    int maxEndingHere = a[0], minEndingHere = a[0];
    int maxSoFar = a[0];
    for (int i=1; i<a.length; i++) {
      if (a[i] < 0) {
        int temp = maxEndingHere;
        maxEndingHere = minEndingHere;
        minEndingHere = temp;
      }

      maxEndingHere = Utility.max(a[i], maxEndingHere*a[i]);
      minEndingHere = Utility.min(a[i], minEndingHere*a[i]);

      maxSoFar = Utility.max(maxSoFar, maxEndingHere);
    }
    System.out.println(maxSoFar);
  }

  private static void largestSumContinousSubArray() {
    //int a[] = {100, -1, -100, 200};
    int a[] = {-2, -3, 4, -1, -2, 1, 5, -3, -21, 22};

    int sum=a[0], tempSum=a[0];
    for(int i=1; i<a.length; i++) {
      tempSum += a[i];

      if(a[i] > tempSum) {
        tempSum = a[i];
      }

      if(tempSum > sum) {
        sum = tempSum;
      }
    }
    System.out.println(sum);
  }

  //sort sub array that entire array gets sorted
  private static void sortSubArray() {
    ArrayList<Integer> input = new ArrayList<>();
    input.add(1);input.add(1);input.add(10);
    input.add(10);input.add(15);input.add(10);
    input.add(15);input.add(10);input.add(10);
    input.add(15);input.add(10);input.add(15);
    System.out.print(subUnsort(input));
  }
  //1,1,10,10,15,10,15,10,10,15,10,15
  private static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
    ArrayList<Integer> result = new ArrayList<>();
    int i=0, j=1;
    for(i=0; i<A.size(); i++) {
      while(j < A.size()) {
        if(A.get(j) < A.get(i)) {
          break;
        }
        i++;
        j++;
      }
      int start=0;
      while(++j < A.size()) {
        if(start > 0) {
          if(A.get(j) < A.get(j-1)) {
            start = j;
          }
        }
        if(A.get(j) > A.get(i)) {
          start = i;
        }
        if((start>0 && (j==A.size()-1))) {
          result.add(i);
          result.add(j-1);
          return result;
        }
      }
    }
    result.add(-1);
    return result;
  }

  // Function to print all subarrays with a zero-sum in a given array
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

}
