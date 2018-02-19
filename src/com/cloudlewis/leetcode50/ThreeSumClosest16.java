package com.cloudlewis.leetcode50;

import com.cloudlewis.leetcode.basic.QuickSort;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author xiao
 *
 */


// solution 1. worst case is not O(n^2), pick first element, two pointer scan
//  -7, -6, -2, -1, 3, 4, 5, 6 --- have to scan entire to know

public class ThreeSumClosest16 {
	public int threeSumClosest(int[] nums, int target) {
		QuickSort.sort(nums); 
		int sum = 0; // can be negative or positive
		int diff = Integer.MAX_VALUE; // absolute value
		int len = nums.length;
		for (int e=0; e < len -2; e ++) {
			int i = e + 1, j = len -1;
			int nt = target - nums[e];
			while (i < j) {
				int lsum = nums[e] + nums[i] + nums[j];
				if (Math.abs(lsum - target) < diff) {
					diff = Math.abs(lsum - target);
					sum = lsum;
				}
				if (nums[i] + nums[j] < nt )
					i++;
				else if (nums[i] + nums[j] == nt) // found exact match
					return target;
				else
					j--;			
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		ThreeSumClosest16 t = new ThreeSumClosest16();
		int [] s = {-1, 2, 1, -4, -2, 5, 0};
		System.out.println(t.threeSumClosest(s, 1));
	}
}
