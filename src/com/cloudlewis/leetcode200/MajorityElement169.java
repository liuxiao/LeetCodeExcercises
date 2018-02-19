package com.cloudlewis.leetcode200;

/**
 * 
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 */

/* @formatter:off
 * looks like it is more than n/2 times, stupid is keep track of occurance
 * Solution 1. Hashmap? - number to times O(n) space + time complexity
 * Solution 2. pick max from first half - O(n/2) - a slightly improved #1
 * Solution 3. sort - O(nlogn) time, O(1) space
 * Solution 4 - Moore Voting Algorithm
 * 
 * more : https://discuss.leetcode.com/topic/17446/6-suggested-solutions-in-c-with-explanations/2
 * @formatter:on
 * 
 */
public class MajorityElement169 {
	public int majorityElement(int[] nums) {
		int major = nums[0], counts = 0, n = nums.length;
		for (int i = 0; i < n; i++) {
			if (counts == 0) {
				major = nums[i];
				counts = 1;
			} else
				counts += (nums[i] == major) ? 1 : -1;
		}
		return major;
	}
	
	
}
