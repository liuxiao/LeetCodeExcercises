package com.cloudlewis.leetcode200;

/**
 * @formatter:off
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * 
 * Note:
 * Your solution should be in logarithmic complexity. 
 * 
 * @formatter:on
 * @author xiao
 *
 */

/*
 * @formatter:off
 * Solution 1. This problem is similar to Local Minimum. And according to the given condition, num[i] != num[i+1], there must exist a O(logN) solution. So we use binary search for this problem.
 *
 * If num[i-1] < num[i] > num[i+1], then num[i] is peak
 * If num[i-1] < num[i] < num[i+1], then num[i+1...n-1] must contains a peak -- don't agree!
 * If num[i-1] > num[i] > num[i+1], then num[0...i-1] must contains a peak
 * If num[i-1] > num[i] < num[i+1], then both sides have peak
 *
 * above solution would work only based on assumption that  num[-1] = num[n] = -∞.
 * otherwise sequence of [1,3,2,3,4,5,6,7,8], and when look at 4, there is no peak on the right of 4
 * @formatter:on
 */
public class FindPeakElement162 {
	public int findPeakElement(int[] nums) {
		int len = nums.length;
		int l = 0, r = len - 1;
		while (l < r) {
			// boundry section
			if (l + 1 == r) {
				if (nums[l] > nums[r])
					return l;
				else
					return r;
			}
			int m = l + (r - l) / 2;
			if (nums[m - 1] < nums[m] && nums[m] > nums[m + 1])
				return m;
			else if (nums[m - 1] < nums[m] && nums[m] < nums[m + 1])
				l = m + 1;
			else if (nums[m - 1] > nums[m] && nums[m] > nums[m + 1])
				r = m - 1;
			else
				l = l + 1;
		}
		return l;
	}
	
	public static void main(String[] args) {
		FindPeakElement162 t = new FindPeakElement162();
		System.out.println(t.findPeakElement(new int[] { 2, 1 }));
	}
}
