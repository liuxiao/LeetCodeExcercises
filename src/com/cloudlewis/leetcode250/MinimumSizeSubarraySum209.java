package com.cloudlewis.leetcode250;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length under the problem constraint.
 * 
 * click to show more practice.
 * 
 * More practice: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log n).
 * 
 * @author xiao
 *
 */
public class MinimumSizeSubarraySum209 {
	public int minSubArrayLen(int s, int[] nums) {
		int len = nums.length;
		if ( len == 0)
			return 0;
		int i = 0, j = 0, count = len, sum = 0;
		while (i < len && j < len) {
			while (i < len && sum < s) {
				sum += nums[i];
				i++;
			}
			while (j <= i && sum >= s) {
				if (i - j < count)
					count = i - j;
				sum -= nums[j];
				j++;
			}
		}
		if (j == 0 && sum < s)
			return 0;
		return count;
	}
	
	public static void main(String[] args) {
		MinimumSizeSubarraySum209 t = new MinimumSizeSubarraySum209();
		System.out.println(t.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
		System.out.println(t.minSubArrayLen(20, new int[] {2,3,1,2,4,3}));
		System.out.println(t.minSubArrayLen(7, new int[] {2,3,1,2,4,7}));
	}
}
