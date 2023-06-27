package com.practice.B_algo_ps.H_backtracking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by prathap on 06/01/18. Update: 01/12/21
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * https://leetcode.com/problems/permutations/
 */
public class B_Permutations {
  public static void main(String[] args) {
    int[] nums = {1,2,3};
    System.out.println(permute(nums));
    System.out.println(permute_bfs(nums));
  }

  private static List<List<Integer>> permute_bfs(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    //permute(nums, 0, result);
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

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> output = new LinkedList();
    List<Integer> nums_lst = Arrays.stream(nums).boxed().collect(Collectors.toList());
    backtrack(nums.length, nums_lst, output, 0);
    return output;
  }
  private static void backtrack(int n,
                        List<Integer> nums,
                        List<List<Integer>> output,
                        int first) {
    // if all integers are used up
    if (first == n)
      output.add(new ArrayList<Integer>(nums));
    for (int i = first; i < n; i++) {
      // place i-th integer first
      // in the current permutation
      Collections.swap(nums, first, i);
      // use next integers to complete the permutations
      backtrack(n, nums, output, first + 1);
      // backtrack
      Collections.swap(nums, first, i);
    }
  }
}
