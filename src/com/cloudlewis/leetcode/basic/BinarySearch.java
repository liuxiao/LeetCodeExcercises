package com.cloudlewis.leetcode.basic;

public class BinarySearch {
	public static int binarySearchInSortedArray(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int m = l + (r - l) /2;
			if (nums[m] == target)
				return m;
			else if (nums[m] > target)
				r = m -1;
			else
				l = m;
				
		}
		return l;
	}

	public static void main(String[] args) {
		System.out.println(BinarySearch.binarySearchInSortedArray(new int[] { 1, 3, 4, 5, 7, 8, 9 }, 5));
	}
}
