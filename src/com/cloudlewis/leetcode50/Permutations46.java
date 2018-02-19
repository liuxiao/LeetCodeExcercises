package com.cloudlewis.leetcode50;

import java.util.ArrayList;
import java.util.List;

/**
 * @formatter:off
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [
 *  [1,2,3],
 *  [1,3,2],
 *  [2,1,3],
 *  [2,3,1],
 *  [3,1,2],
 *  [3,2,1]
 * ]
 * 
 * @formatter:on
 * @author xiao
 *
 */

// !!!! READ
// !!!!
// https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/4

public class Permutations46 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> rs = new ArrayList<>();
		backtrace(nums, new ArrayList<Integer>(), rs);
		return rs;
	}

	private void backtrace(int[] nums, List<Integer> list, List<List<Integer>> rs) {
		if (nums.length == list.size())
			rs.add(new ArrayList<>(list));
		else {
			for (int i = 0; i < nums.length; i++) {
				if (!list.contains(nums[i])) {
					list.add(nums[i]);
					backtrace(nums, list, rs);
					list.remove(list.size() - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		Permutations46 t = new Permutations46();
		int[] a = {1,2,3};
		System.out.println(t.permute(a));
	}
}
