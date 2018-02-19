package com.cloudlewis.leetcode50;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * 
 * @author xiao
 *
 */

// constant space -> hint -> must store data in place
// try to save in the array, but what if [1,100,2] ? is this valid?
// when say first positive, then, start from 1, to handle above, we could just abandon it

public class FirstMissingPositive41 {
	public int firstMissingPositive(int[] nums) {
		int len = nums.length;
		int i =0;
		while (i < len) {
			//       index < len &&  need swap   && index >0
			// !!! CAREFUL deadloop + source != dest
			while( nums[i] <= len && nums[i] -1 != i && nums[i] > 0 && nums[nums[i] -1] != nums[i])  
				swap(nums, i, nums[i] -1);
			i++;
		}
		for (i =0; i<len; i ++)
			if (nums[i] != i +1)
				return i + 1;
		return len + 1;
	}
	
	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public static void main(String[] args) {
		FirstMissingPositive41 t = new FirstMissingPositive41();
		System.out.println(t.firstMissingPositive(new int[] {0}));
		System.out.println(t.firstMissingPositive(new int[] {1}));
		System.out.println(t.firstMissingPositive(new int[] {1, 1}));
		System.out.println(t.firstMissingPositive(new int[] {1,2,0}));
		System.out.println(t.firstMissingPositive(new int[] {3,4,-1, 1}));
	}
}
