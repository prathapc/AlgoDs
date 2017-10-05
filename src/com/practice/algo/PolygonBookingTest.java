package com.practice.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prathap on 14/07/17.
 */
public class PolygonBookingTest {
  public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int[] input = new int[args.length];
    for(int i=0;i<args.length;i++) {
      input[i] = Integer.parseInt(args[i]);
    }
    List<Integer> result = new ArrayList<>();
    result.add(input[0]);
    for(int i=0;i<input.length;i++){
      int temp=0;
      if(i<input.length-1) {
        temp = input[i + 1] - input[i];

        if (!(temp >= -127 && temp <= 127)) {
          result.add(-128);
          result.add(temp);
        } else
          result.add(temp);
      }

    }
    System.out.println(Arrays.toString(result.toArray()));
  }
}
