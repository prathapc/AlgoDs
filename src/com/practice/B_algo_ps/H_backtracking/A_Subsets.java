package com.practice.B_algo_ps.H_backtracking;

import java.util.*;

/**
 * Created by prathap on 09/12/17.
 *
 * https://leetcode.com/problems/subsets/
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Explanation at the bottom :)
 */
public class A_Subsets {
  public static void main(String args[]) {
    int[] nums = {1,2,3};
    System.out.println(subsets(nums));
  }

  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null) return result;
    generateSubsets(nums, 0, new ArrayList<>(), result);
    return result;
  }

  private static void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
    result.add(new ArrayList<>(current));
    for (int i=index; i<nums.length; i++) {
      current.add(nums[i]);
      generateSubsets(nums, i+1, current, result);
      current.remove(current.size()-1);
    }
  }
}

/**
 * Let's take an example -> nums = [1,2,3]
 *
 * first of all, we created current = [ ]
 * Now, we are going to create a copy of current and add it to our subsets Arraylist.
 * So far, we have subsets = [[ ]]
 *
 * Now, we insert the nums[i] i.e., nums[0] in current. Current become -> [1]
 * Now, we make a recursion call with index = 1 and current = [1].
 *
 * Now, we  add current in subsets. Subsets = [[ ], [1]] (created a copy of current and added it to subset)
 * Add nums[i] to current where index = 1. Current = [1,2]
 * Recursion call -> index = 2, current = [1, 2].
 *
 * Add current to subsets. Subsets = [[ ], [1], [1,2]]
 * Add nums[i] to current where index = 2.
 * Recursion call -> index = 3, current = [1,2,3]
 *
 * Add current to subset. Subsets = [[ ], [1],[1,2],[1,2,3]]
 * Now, for loop won't execute because index > nums.length().
 * So, it will return now.
 *
 * Now, we come to statement current.remove(current.size() - 1).
 * We now get, current = [1,2]. i = 2 here. Now, we come to next iteration of for loop, i becomes 3 but 3 < nums.length().
 * So, it will again return.
 *
 * Now, we come to statement current.remove(current.size() - 1) again.
 * We now get, current = [1], i = 1 here. Now, in next loop iteration, i = 2.
 * We add nums[i] to current. i = 2. Current = [1,3]
 * Recursion Call -> current = [1,3], index = 3
 *
 * Insert current to subset. Subset = [[ ], [1], [1,2], [1,2,3], [1,3]]
 * We now try to run the loop but i = 3 and it is not less than nums.length().
 * So, we return.
 *
 * Now, we come back to statement current.remove(current.size() - 1).
 *
 *
 * And in the same fashion, [1] is also removed. After 1 is removed, we get [ ] and we insert 2 in it. then we insert [2] in subsets. Then we insert [2,3]. Then we remove 3 and 2. Then we insert [3]. And we are done.
 *
 * We finally get subset = [[ ], [1], [1,2], [1,2,3], [1,3], [2], [2,3], [3]] ------> ANSWER. Return it.
 */
