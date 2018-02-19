package com.cloudlewis.leetcode200;

import com.cloudlewis.leetcode.common.Util;

/**
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * Note: Try to come up as many solutions as you can, there are at least 3
 * different ways to solve this problem.
 * 
 * 
 * Hint: Could you do it in-place with O(1) extra space?
 * 
 * @author xiao
 *
 */

// Solution 1. get a new array - put in from k till end, and then 0 to k

// Solution 2. rotate 4 times, for every 1 bit move

// Solution 3. [1,2,3,4,5,6,7]
// ----------- [7,6,5,4,3,2,1] reverse whole
// ----------- [5,6,7|1,2,3,4] reverse on split point
public class RotateArray189 {
	// this solution has time exceed error
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		k %= len;
		while (k > 0) {
			int tmp = nums[len - 1];
			for (int i = len - 1; i > 0; i--)
				nums[i] = nums[i - 1];
			nums[0] = tmp;
			k--;
		}
	}

	public void rotateWithTwoReverse(int[] nums, int k) {
		int len = nums.length;
		k %= len;
		reverse(nums, 0, len-1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, len -1);
	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}
	
	public static void main(String [] args) {
		RotateArray189 t= new RotateArray189();
		int[] nums = {1,2,3,4,5,6,7};
		t.rotateWithTwoReverse(nums, 3);
		Util.printArray(nums);
	}
}
