package com.cloudlewis.leetcode50;

/**
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author xiao
 *
 */
// kidding me solution 1. O(n) just scan

// solution 2. binary search
// https://discuss.leetcode.com/topic/3538/concise-o-log-n-binary-search-solution

// **** REIVIST
public class SearchinRotatedSortedArray33 {
	public int search(int[] nums, int target) {
		int len = nums.length;
		int l = 0, r = len - 1;
		// find pivot, the smallest
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] > nums[r])
				l = mid + 1;
			else
				r = mid;
		}
		// loop stops when it find the right range when l >= r
		int rot = l;
		l = 0;
		r = len - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			int rm = (m + rot) % len;
			if (nums[rm] == target)
				return rm;
			else if (nums[rm] < target)
				l = m + 1;
			else
				r = m - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchinRotatedSortedArray33 t = new SearchinRotatedSortedArray33();
		int[] a = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(t.search(a, 0));
	}
}
