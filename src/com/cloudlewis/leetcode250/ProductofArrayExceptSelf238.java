package com.cloudlewis.leetcode250;

import com.cloudlewis.leetcode.common.Util;

/**
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up: Could you solve it with constant space complexity? (Note: The
 * output array does not count as extra space for the purpose of space
 * complexity analysis.)
 * 
 * @author xiao
 *
 */

/*
 * problem is the zero case
 */
public class ProductofArrayExceptSelf238 {
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int non_zero_prod = 1;
		int num_zero = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == 0)
				num_zero++;
			else
				non_zero_prod *= nums[i];
		}
		int[] prods = new int[len];
		for (int i = 0; i < len; i++) {
			if (nums[i] == 0 && num_zero == 1)
				prods[i] = non_zero_prod;
			else if (nums[i] == 0 && num_zero > 1) // always zero
				prods[i] = 0;
			else if (nums[i] != 0 && num_zero >= 1)
				prods[i] = 0;
			else
				prods[i] = non_zero_prod/nums[i];
		}
		return prods;
	}
	
	public static void main(String[] args) {
		ProductofArrayExceptSelf238 t = new ProductofArrayExceptSelf238();
		Util.printArray((t.productExceptSelf(new int[]{0,0}))); // 0,0 
		Util.printArray((t.productExceptSelf(new int[]{1,0}))); // 0,1
	}
}
