package com.practice.B_algo_ps.A_arrays;

import java.util.*;

/**
 * Created by prathapchowdary on 20/05/22.
 */
public class N_IntersionOfTwoArrays {

    /**
     *
     * https://leetcode.com/problems/intersection-of-two-arrays/
     *
     * Given two integer arrays nums1 and nums2, return an array of their intersection.
     * Each element in the result must be unique and you may return the result in any order.
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [9,4]
     * Explanation: [4,9] is also accepted.
     */
    //note input arrays have unique elements
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int i : nums2) {
            if(set.contains(i)){
                result.add(i);
                set.remove(i);
            }
        }

        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i]=result.get(i);
        }
        return ints;
    }

    /**
     * https://leetcode.com/problems/intersection-of-two-arrays-ii/
     *
     * Given two integer arrays nums1 and nums2, return an array of their intersection.
     * Each element in the result must appear as many times as it shows in both arrays and
     * you may return the result in any order.
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [4,9]
     * Explanation: [9,4] is also accepted.
     */
    //note input arrays have duplicate elements
    public int[] intersect_approach1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect_approach1(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
    public int[] intersect_approach2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                nums1[k++] = nums1[i++];
                ++j;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
    /**
     * Follow-up Questions for problem having input with duplicate elements
     * What if the given array is already sorted? How would you optimize your algorithm?
     *
     * We can use either Approach 2 or Approach 3, dropping the sort of course. It will give us linear time and constant memory complexity.
     * What if nums1's size is small compared to nums2's size? Which algorithm is better?
     *
     * Approach 1 is a good choice here as we use a hash map for the smaller array.
     * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
     *
     * If nums1 fits into the memory, we can use Approach 1 to collect counts for nums1 into a hash map. Then, we can sequentially load and process nums2.
     *
     * If neither of the arrays fit into the memory, we can apply some partial processing strategies:
     *
     * Split the numeric range into subranges that fits into the memory. Modify Approach 1 to collect counts only within a given subrange, and call the method multiple times (for each subrange).
     *
     * Use an external sort for both arrays. Modify Approach 2 to load and process arrays sequentially.
     */
}
