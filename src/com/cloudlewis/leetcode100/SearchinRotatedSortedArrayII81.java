package com.cloudlewis.leetcode100;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why? Suppose an array
 * sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * The array may contain duplicates.
 * 
 * @author xiao
 *
 */

// take away is if there are duplicates in rotate, we have to go 1 by a time in
// worest case
// there is no way to workaround it

public class SearchinRotatedSortedArrayII81 {
	public boolean search(int[] nums, int target) {
		int len = nums.length;
		if (len == 0)
			return false;
		int l = 0, r = len -1;
		while( l <= r) {
			int mid = l + (r - l)/2;
			if (nums[mid] == target) 
				return true;
			if (nums[mid] > nums[r]) {
				if (nums[l] <= target && target < nums[mid])
					r = mid - 1;
				else
					l = mid + 1;
			}
			else if (nums[mid] < nums[r]) {
				if (nums[mid] < target && target <= nums[r])
					l = mid + 1; /// BOUNDARY!!!!
				else
					r = mid;
			}
			else {
				// if most right is same as mid, at least we verified mid is not target, we can remove right
				r--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SearchinRotatedSortedArrayII81 t = new SearchinRotatedSortedArrayII81();
		System.out.println(t.search(new int[] { 1,3 }, 3)); // true
		System.out.println(t.search(new int[] { 3, 1, 1 }, 3));  // true
		System.out.println(t.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 4));  // true
		System.out.println(t.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 6));   // true
		System.out.println(t.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));  // true

		System.out.println(t.search(new int[] { 4, 5, 5, 5, 6, 7, 0, 1, 2 }, 5));  // true
		System.out.println(t.search(new int[] { 4, 5, 6, 7, 0, 1, 2, 2, 2, 2 }, 2));  // true
		System.out.println(t.search(new int[] { 4, 5, 6, 7, 0, 1, 2, 2, 2, 2 }, 3));  // false
	}
}
