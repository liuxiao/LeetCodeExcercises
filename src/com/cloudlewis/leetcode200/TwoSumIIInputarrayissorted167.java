package com.cloudlewis.leetcode200;

/**
 * 
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution and you may
 * not use the same element twice.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * 
 * @author xialiliu
 *
 */

// easy O(n) logic, looking for somethign else?
public class TwoSumIIInputarrayissorted167 {
	public int[] twoSum(int[] numbers, int target) {
		if (numbers.length < 2)
			return new int[] { 0, 0 };
		int l = 0, r = numbers.length - 1;
		while (l < r) {
			if (numbers[l] + numbers[r] == target)
				return new int[] { l + 1, r + 1 };
			else if (numbers[l] + numbers[r] < target)
				l++;
			else
				r--;
		}
		return new int[] { 0, 0 }; // should not reach, because there is
									// gurantee a solution
	}

	public static void main(String[] args) {
		TwoSumIIInputarrayissorted167 t = new TwoSumIIInputarrayissorted167();
		int[] rs = t.twoSum(new int[] { 2, 7, 11, 15 }, 9);
		System.out.println(rs[0] + " " + rs[1]);

	}
}
