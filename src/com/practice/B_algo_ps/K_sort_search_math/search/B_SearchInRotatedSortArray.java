package com.practice.B_algo_ps.K_sort_search_math.search;

/**
 * Created by prathapchowdary on 04/12/21.
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 */
public class B_SearchInRotatedSortArray {

    public int search(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            //int mid = low + (high - low) / 2
            int mid = (lo + hi) >>> 1; // same as mid = (lo + hi) / 2 and avoids overflow

            if (a[mid] == key)
                return mid;

            // the bottom half is sorted
            if (a[lo] <= a[mid]) {
                if (a[lo] <= key && key < a[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            // the upper half is sorted
            else {
                if (a[mid] < key && key <= a[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
