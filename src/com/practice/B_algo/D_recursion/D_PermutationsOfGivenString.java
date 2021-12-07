package com.practice.B_algo.D_recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathap on 06/01/18. UPdate: 01/12/21
 *
 * https://leetcode.com/problems/permutations/
 */
public class D_PermutationsOfGivenString {
  public static void main(String[] args) {
    int[] nums = {1,2,3};
    System.out.println(permute(nums));
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    permuteUtil(nums, 0, nums.length-1, result);
    return result;
  }

  private static void permuteUtil(int[] nums, int l, int r, List<List<Integer>> result) {
    //this condition is like checking
    if (l == r) {
      List<Integer> temp = new ArrayList<>();
      for (int num : nums) {
        temp.add(num);
      }
      result.add(temp);
    }

    for (int i=l; i<=r; i++) {
      swap(nums, i, l);
      permuteUtil(nums, l+1, r, result);
      swap(nums, i, l);
    }
  }

  private static void swap(int nums[], int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
