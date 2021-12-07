package com.practice.C_ps;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathap on 10/12/17.
 */
public class RainWaterTrappedOnBuildings {

  public static void main(String args[]) {
    List<Integer> input = new ArrayList<>();
    input.add(0);
    input.add(1);
    input.add(0);
    input.add(2);
    input.add(1);
    input.add(0);
    input.add(1);
    input.add(3);
    System.out.print(trap(input));
  }

  private static int trap(final List<Integer> a) {
    int[] left = new int[a.size()];
    int[] right = new int[a.size()];

    int n = a.size();
    left[0] = a.get(0);
    right[n-1] = a.get(n-1);
    for(int i=1; i<a.size(); i++) {
      if(a.get(i) < left[i-1]) {
        left[i] = left[i-1];
      } else {
        left[i] = a.get(i);
      }

      if(a.get(a.size()-1-i) > right[a.size()-i]) {
        right[a.size()-1-i] = a.get(a.size()-1-i);
      } else {
        right[a.size()-1-i] = right[a.size()-i];
      }
    }
    int result = 0;
    for(int i=1; i<a.size(); i++) {
      if(left[i] < right[i]) {
        result += left[i] - a.get(i);
      } else {
        result += right[i] - a.get(i);
      }

    }
    return result;
  }
}
