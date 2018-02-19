package com.cloudlewis.leetcode150;

/**
 * 
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author xiao
 *
 */

// Solution 1. using a Map, integer to occurance O(n) space
// Solution 2. using bit? XOR it with the number, ideally, run two numbers will result in 0

public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int mask = 0;
        for (int i=0; i < nums.length; i++) 
        	mask ^= nums[i];
        return mask;
    }
    
    public static void main(String [] args) {
    	SingleNumber136 t = new SingleNumber136();
    	int[] nums = {1,3,2,5,4,6,8,1,3,4,5,8,6};
    	System.out.println(t.singleNumber(nums));
    }
}
