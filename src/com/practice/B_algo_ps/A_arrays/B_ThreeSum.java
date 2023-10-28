package com.practice.B_algo_ps.A_arrays;

import java.util.*;

/**
 * Created by Prathap on 01 Feb, 2020
 *
 * https://leetcode.com/problems/3sum/
 *
 * Note:
 * The solution set must not contain duplicate triplets.
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class B_ThreeSum {

    public static void main(String args[]) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    //solved in 15mins
    public List<List<Integer>> threeSum_1(int[] nums) {
        Map<String, int[]> resultData = new HashMap<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            int first = nums[i];
            int reqSum = -1 * first;
            int start = i+1, end = nums.length-1;
            while (start < end) {
                int currSum = nums[start] + nums[end];
                if (currSum == reqSum) {
                    resultData.put(first + "" + nums[start] + "" + nums[end], new int[]{first, nums[start], nums[end]});
                    start++; end--;
                } else if (currSum < reqSum) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        resultData.forEach((k, v) -> {
            List<Integer> temp = new ArrayList<>();
            for (int i=0; i<3; i++) {
                temp.add(v[i]);
            }
            result.add(temp);
        });
        return result;
    }

    //above solution can be simplified with Set<List<Integer>> as below
    public List<List<Integer>> threeSum_2(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
            int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0) res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if (sum >0) k--;
                else if (sum<0) j++;
            }

        }
        return new ArrayList<>(res);
    }

    //Time Complexity: O(n^2)
    //twoSum is O(n), and we call it n times
    //Sorting the array takes O(nlogn), so overall complexity is O(nlogn+n^2)
    //This is asymptotically equivalent to O(n^2)
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) { //fix first element and try finding two sum
            if (i>0 && nums[i] == nums[i-1]) continue; //maks sure unique
            int reqSum = -1 * nums[i];
            int start = i+1, end = nums.length-1;
            while (start < end) {
                if (nums[start] + nums[end] == reqSum) {
                    result.add(Arrays.asList(nums[i], nums[start++], nums[end--]));
                    while (start < end && nums[start-1] == nums[start]) { //maks sure unique
                        start++;
                    }
                } else if(nums[start] + nums[end] < reqSum) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}
