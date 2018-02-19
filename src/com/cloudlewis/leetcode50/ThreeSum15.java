package com.cloudlewis.leetcode50;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.cloudlewis.leetcode.basic.QuickSort;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * @formatter:off
 * A solution set is: 
 * [ 
 *   [-1, 0, 1], 
 *   [-1, -1, 2] 
 * ]
 * 
 * 
 * @author xiao
 *
 */

// solution 1. use Hsahmap store value + location with first pass O(n) ? what about duplicates in array itself
//             use two for loop O(n^2) to sum the value and find the corresponding in map, cannot be same object 

// solution 2. sort the array, two loopO(n^2), start from small, if 2sum greater than 0, stop
//		       search on the other end with another cursor, not a O(n^3), because the other cursor will never collide

//@formatter:on
public class ThreeSum15 {
	public List<List<Integer>> threeSum(int[] nums) {
		return threeSum(nums, 0);
	}

	public List<List<Integer>> threeSum(int[] nums, int t) {
		int len = nums.length;
		List<List<Integer>> list = new LinkedList<>();
		if (len < 3) // asking for 3 elements triplet
			return list;
		QuickSort.sort(nums);
		for (int e = 0; e < len - 2; e++) { // picked first element; then scan
			if (e - 1 > 0 && nums[e] == nums[e - 1])
				continue;
			int target = t - nums[e];
			int i = e + 1, j = len - 1; // last element
			while (i < j) { // cannot equal, otherwise 2 elements
				while (i < j && i - 1 > e && nums[i] == nums[i - 1])
					// !VERY IMPORTANT
					i++;
				while (j > i && j + 1 < len && nums[j] == nums[j + 1]) 
					j--;
				if (i < j) {
					if (nums[i] + nums[j] < target)
						i++;
					else if (nums[i] + nums[j] > target)
						j--;
					else { // found one, how to avoid duplicates?
						list.add(Arrays.asList(nums[e], nums[i], nums[j]));
						i++;
						j--;
					}
				}
			}
		}
		return list;
	}

	public void test() {
		// int[] s = { -1, 0, 1, 2, -1, -4 };
		// List<List<Integer>> sum = threeSum(s);
		// for (List<Integer> arr : sum)
		// System.out.println(arr.toString());

		// System.out.println();

		int[] s1 = { -1, 0, 1, 0, 0, 0, 0, 2, -1, -4, 4 };
		List<List<Integer>> sum = threeSum(s1);
		for (List<Integer> arr : sum)
			System.out.println(arr.toString());

	}

	public static void main(String[] args) {
		ThreeSum15 t = new ThreeSum15();
		t.test();
	}
}
