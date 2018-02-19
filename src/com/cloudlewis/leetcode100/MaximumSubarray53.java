package com.cloudlewis.leetcode100;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray
 * [4,-1,2,1] has the largest sum = 6.
 * 
 * click to show more practice.
 * 
 * More practice: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 * 
 * @author xiao
 *
 */

// what if it is all negative? it would be like finding the biggest element

public class MaximumSubarray53 {
	public int maxSubArray(int[] nums) {
		int len = nums.length;
		int sum = 0, max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			sum += nums[i];
			if (sum > max)
				max = sum;
			if (sum < 0)
				sum = 0;
		}
		return max;
	}
	
	public static void main(String[] args) {
		MaximumSubarray53 t= new MaximumSubarray53();
		System.out.println(t.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(t.maxSubArray(new int[] {-2,-11,-3,-4,-1,-2,-5}));
	}
}
