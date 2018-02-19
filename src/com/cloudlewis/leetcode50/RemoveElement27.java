package com.cloudlewis.leetcode50;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * Example: Given input array nums = [3,2,2,3], val = 3
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 2.
 * 
 * @author xiao
 *
 */

// using left and right curosr, keep things at left
// ********* VERY TRICKY boundry condition

public class RemoveElement27 {
	public int removeElement(int[] nums, int val) {
		int left = 0, right = nums.length - 1;
		while (left <= right) { // HAVE EQUAL
			while (left <= right && nums[left] != val) // HAVE EQUAL
				left++;

			while (right >= left && nums[right] == val) // HAVE EQUAL
				right--;
			if (left < right) {
				nums[left] = nums[right];
				left++;
				right--;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		RemoveElement27 t = new RemoveElement27();
		int[] nums = { 3, 2, 2, 3 };
		int l = t.removeElement(nums, 3);
		for (int i = 0; i < l; i++) {
			System.out.print(nums[i]);
		}
		System.out.println();

		nums = new int[] { 1, 2, 3, 2, 2, 3 };
		l = t.removeElement(nums, 2);
		for (int i = 0; i < l; i++) {
			System.out.print(nums[i]);
		}
		System.out.println();
	}
}
