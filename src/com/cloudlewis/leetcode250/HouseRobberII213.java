package com.cloudlewis.leetcode250;

import com.cloudlewis.leetcode200.HouseRobber198;

/**
 * 
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This time,
 * all houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, the security system for these
 * houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * 
 * @author xiao
 *
 */
public class HouseRobberII213 {
	
	public int rob(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		HouseRobber198 t = new HouseRobber198();
		return Math.max(t.rob(nums, 0, nums.length - 2), t.rob(nums, 1, nums.length - 1));
	}
}
