package com.cloudlewis.leetcode200;

/**
 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why? Suppose an array
 * sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * @author xiao
 *
 */

// !! REVISIT

public class FindMinimuminRotatedSortedArrayII154 {
	public int findMin(int[] nums) {
		int l = 0, r = nums.length - 1;
		while(l < r) {
			int m = l + (r - l) /2;
			if (nums[m] > nums[r]) // if same, they are all same
				l = m + 1;
			else if (nums[m] < nums[r])
				r = m;
			else
				r--;
		}
		return nums[l];
	}
	
	public static void main(String [] args) {
		FindMinimuminRotatedSortedArrayII154 t = new FindMinimuminRotatedSortedArrayII154();
		// -------------------------------------0 1 2 3 4 5 6 7 8 9
		System.out.println(t.findMin(new int[] {4,5,6,6,6,6,0,1,1,2}));
	}
}
