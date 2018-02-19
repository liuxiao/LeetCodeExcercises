package com.cloudlewis.leetcode50;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively. It doesn't matter what you leave beyond the new
 * length.
 * 
 * @author xiao
 *
 */

// keep a count for insertion location
// REVISIT - logic

public class RemoveDuplicatesfromSortedArray26 {
	public int removeDuplicates(int[] nums) {
		int len = nums.length;
		if (len < 2)
			return len;
		int insert = 1;
		for (int i = 1; i < len; i++) {
			if (nums[i] != nums[i-1]) {
				nums[insert++] = nums[i];	
			}
		}
		return insert;
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArray26 t = new RemoveDuplicatesfromSortedArray26();
		int[] nums = new int[] { 1, 1, 2, 3 };
		int l = t.removeDuplicates(nums);
		for (int i = 0; i < l; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		nums = new int[] { 1, 2, 3, 3, 4, 4, 5 };
		l = t.removeDuplicates(nums);
		for (int i = 0; i < l; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		nums = new int[] { 1, 1 };
		l = t.removeDuplicates(nums);
		for (int i = 0; i < l; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		nums = new int[] { 1, 1, 1 };
		l = t.removeDuplicates(nums);
		for (int i = 0; i < l; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
}
