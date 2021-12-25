package com.practice.B_algo.A_sort_search_math.sort;

import java.util.PriorityQueue;

/**
 * Created by Prathap on 11 Jan, 2020
 *
 * https://leetcode.com/problems/largest-number/
 */
public class LargestNumber {

    public static void main(String args[]) {
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
    }

    private static String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return "";

        PriorityQueue<String> heap = new PriorityQueue<String>((a, b) -> (b + a).compareTo(a + b));
        for(int num : nums)
            heap.offer(String.valueOf(num));

        StringBuilder sb = new StringBuilder();
        while(!heap.isEmpty())
            sb.append(heap.poll());

        return allZeroCheck(sb.toString());
    }

    //for handling "00" or "00.." case where we have to return "0"
    private static String allZeroCheck(String s){
        for(char c : s.toCharArray())
            if(c != '0')
                return s;

        return "0";
    }
}
