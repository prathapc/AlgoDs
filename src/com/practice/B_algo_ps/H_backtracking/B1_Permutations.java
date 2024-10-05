package com.practice.B_algo_ps.H_backtracking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by prathap on 06/01/18. Update: 01/12/21
 *
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * https://leetcode.com/problems/permutations/
 */
public class B1_Permutations {
  public static void main(String[] args) {
    int[] nums = {1,2,3};
    System.out.println(permute(nums));
    System.out.println(permute_bfs(nums));
  }

  //similar to previous subset problems using backtracking technique
  static List<List<Integer>> result;
  public static List<List<Integer>> permute(int[] nums) {
    result = new ArrayList<>();
    permute(nums, new ArrayList<>());
    return result;
  }
  private static void permute(int[] nums, List<Integer> temp) {
    if (temp.size() == nums.length) {
      result.add(new ArrayList<>(temp));
      return;
    }
    for (int i=0; i<nums.length; i++) { //always traverse from 0, no index passing
      //if (temp.contains(nums[i])) continue; //works but performance is bad beats 40% where as indexOf() beats 94%
      if (temp.indexOf(nums[i]) != -1) continue;
      temp.add(nums[i]);
      permute(nums, temp);
      temp.remove(temp.size()-1);
    }
  }


  //dfs + backtracking
  public static List<List<Integer>> permute1(int[] nums) {
    List<Integer> nums_lst = Arrays.stream(nums).boxed().collect(Collectors.toList());
    permute(nums_lst, 0);
    return result;
  }
  private static void permute(List<Integer> nums, int index) {
    if (index == nums.size()) {
      result.add(new ArrayList<>(nums));
      return;
    }
    for (int i=index; i<nums.size(); i++) {
      Collections.swap(nums, i, index);
      permute(nums, index+1);
      Collections.swap(nums, i, index);
    }
  }

  //bfs + backtracking
  private static List<List<Integer>> permute_bfs(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Queue<Set<Integer>> queue = new LinkedList<>();
    for (int num : nums) {
      Set<Integer> temp = new LinkedHashSet<>();
      temp.add(num);
      queue.add(temp);
    }
    while (!queue.isEmpty()) {
      Set<Integer> current = queue.poll();
      if (current.size() == nums.length) {
        result.add(new ArrayList<>(current));
      } else {
        for (int num : nums) {
          if (!current.contains(num)) {
            //Set<Integer> temp = new HashSet<>(current);
            current.add(num);
            queue.add(new LinkedHashSet<>(current));
            current.remove(num);
          }
        }
      }
    }
    return result;
  }
}
