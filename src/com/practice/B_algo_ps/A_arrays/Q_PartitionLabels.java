package com.practice.B_algo_ps.A_arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathapchowdary on 02/07/23.
 *
 * You are given a string s. We want to partition the string into as many parts as possible
 * so that each letter appears in at most one part.
 * Note that the partition is done so that after concatenating all the parts in order,
 * the resultant string should be s.
 * Return a list of integers representing the size of these parts.
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 *
 * https://leetcode.com/problems/partition-labels/
 */
public class Q_PartitionLabels {

  public List<Integer> partitionLabels(String s) {
    List<Integer> result = new ArrayList<>();
    int start = 0, end = 0;
    for (int i=0; i<s.length(); i++) {
      char curr = s.charAt(i);
      int lastIndexOfCurr = s.lastIndexOf(curr);
      if (end < lastIndexOfCurr) {
        end = lastIndexOfCurr;
      }
      if (i == end) {
        result.add(end-start+1);
        start = i+1;
      }
    }
    return result;
  }
}
