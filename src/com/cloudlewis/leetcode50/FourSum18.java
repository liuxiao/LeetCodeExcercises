package com.cloudlewis.leetcode50;

import java.util.ArrayList;
import java.util.List;

import com.cloudlewis.leetcode.basic.QuickSort;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * 
 * @formatter:off
 * [ 
 *   [-1, 0, 0, 1], 
 *   [-2, -1, 1, 2], 
 *   [-2, 0, 0, 2] 
 * ]
 * @formatter:on
 * 
 * @author xiao
 *
 */

// solution 1. reuse ThreeSum function O(n^2) complexity

public class FourSum18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		int len = nums.length;
		List<List<Integer>> list = new ArrayList<>();
		if (len < 4)
			return list;
		QuickSort.sort(nums);
		int max = nums[len - 1];
		for (int i = 0; i < len; i++) {
			if (nums[i] + 3 * max < target) // i is too small
				continue;
			if (nums[i] * 4 > target) // too big
				break;
			if (i - 1 > 0 && nums[i] == nums[i - 1])
				continue;
			int t = target - nums[i];
			findThreeSum(nums, list, t, i + 1, nums[i]);
		}
		return list;
	}

	private void findThreeSum(int[] nums, List<List<Integer>> list, int target, int left, int first) {
		int newlen = nums.length - left;
		int[] newnum = new int[newlen];
		for (int i = 0; i < newlen; i++) {
			newnum[i] = nums[i + left];
		}
		ThreeSum15 t = new ThreeSum15();
		List<List<Integer>> l = t.threeSum(newnum, target);
		for (List<Integer> ll : l) {
			List<Integer> rs = new ArrayList<Integer>();
			rs.add(first);
			rs.addAll(ll);
			list.add(rs);
		}
	}

	public void test() {
		int[] s = { 1, 0, -1, 0, -2, 2 };
		List<List<Integer>> sum = fourSum(s, 0);
		for (List<Integer> arr : sum)
			System.out.println(arr.toString());

		System.out.println();

	}

	public static void main(String[] args) {
		FourSum18 t = new FourSum18();
		t.test();
	}
}
