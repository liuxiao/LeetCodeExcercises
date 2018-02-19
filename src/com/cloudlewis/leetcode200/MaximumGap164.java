package com.cloudlewis.leetcode200;

/**
 * 
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in
 * the 32-bit signed integer range.
 * 
 * @author xialiliu
 *
 */

// feel like didn't get the quesiton!!

// in linear time and space, two pointers, boolean to track up or down;
// if same order, move second points, till order break; compare max diff;
// move first pointer to the max, point before breaks, and 2nd pointer stay on
// the break pointer, and keep going; until 2nd pointer reaches end
public class MaximumGap164 {
	public int maximumGap(int[] nums) {
		int len = nums.length;
		if (len < 2)
			return 0;
		int r = 1, max = 0, local = 0;
		boolean up = nums[r] >= nums[r-1]; // we ignore dplicates
		while( r < len -1) {
			if (nums[r] > nums[r - 1] && up)
				local += nums[r] - nums[r-1];
			else if (nums[r] < nums[r-1] && !up)
				local += nums[r-1] - nums[r];
			else if (nums[r] > nums[r-1] && !up){ // break up trend
				if (local > max)
					max = local;
				up = false;
				local = nums[r] - nums[r-1];
			}
			else {
				if (local > max)
					max = local;
				up = true;
				local = nums[r-1] - nums[r];
			}
			r++;
		}
		return max;
	}
	
	public static void main(String [] args) {
		MaximumGap164 t = new MaximumGap164();
		System.out.println(t.maximumGap(new int[] {1,2,3,4,5,3,2,7,8,9,13,2,1}));
	}
}
