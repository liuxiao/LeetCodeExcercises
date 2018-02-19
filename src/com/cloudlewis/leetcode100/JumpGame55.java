package com.cloudlewis.leetcode100;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * @author xiao
 *
 */
public class JumpGame55 {
	public boolean canJump(int[] nums) {
		int maxLocation = 0;
	    for(int i=0; i<nums.length; i++) {
	        if(maxLocation<i) return false; // if previous maxLocation smaller than i, meaning we cannot reach location i, thus return false.
	        maxLocation = (i+nums[i]) > maxLocation ? i+nums[i] : maxLocation; // greedy:
	    }
	    return true;
	}
}
