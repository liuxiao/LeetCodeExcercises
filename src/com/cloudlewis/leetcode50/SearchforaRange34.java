package com.cloudlewis.leetcode50;

/**
 * Given an array of integers sorted in ascending order, find the starting and
 * ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author xiao
 *
 */

// *** REVISIT

public class SearchforaRange34 {
	public int[] searchRange(int[] nums, int target) {
		int len = nums.length;
		int [] rs = {-1, -1};
		if (len == 0)
			return rs;
		// search for left
		int left = 0, right = len -1;
		while(left < right) {
			int mid = left + (right - left)/2;
			if (target <= nums[mid])
				right = mid;
			else
				left = mid + 1;
		}
		if (nums[left] != target)
			return rs;
		else
			rs[0] = left;
		
		//search for right
		right = len -1;
		while(left < right) {
			int mid = left + (right - left)/2 + 1; // mid to right
			if (target < nums[mid])
				right = mid -1;
			else
				left = mid;
		}
		rs[1] = right;
		return rs;
		
	}
	
	public static void main(String[] args) {
		int [] s = {5, 7, 7, 8, 8, 10};
		SearchforaRange34 t = new SearchforaRange34();
		int [] rs = t.searchRange(s, 8);
		System.out.println(rs[0] + " " + rs[1]);
		
		int [] a = {1};
		rs = t.searchRange(a, 1);
		System.out.println(rs[0] + " " + rs[1]);
	}
}
