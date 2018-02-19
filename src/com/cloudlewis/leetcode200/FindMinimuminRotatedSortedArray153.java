package com.cloudlewis.leetcode200;

/**
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author xiao
 *
 */

// Solution 1. O(n)

// Solution 2. O(logN)

public class FindMinimuminRotatedSortedArray153 {
	public int findMin(int[] nums) {
		if (nums.length == 0)
			return 0;
		int l = 0, r = nums.length - 1;
		while (l < r) {
			if (nums[l] < nums[r])
				return nums[l];
			int m = l + (r - l) / 2;
			if (nums[m] >= nums[l]) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return nums[l];
	}
}
