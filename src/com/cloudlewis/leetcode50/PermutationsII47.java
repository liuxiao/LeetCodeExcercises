package com.cloudlewis.leetcode50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @formatter:off
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * For example,
 * [1,1,2] have the following unique permutations:
 *
 * [
 *  [1,1,2],
 *  [1,2,1],
 *  [2,1,1]
 * ]
 *
 * @author xiao
 *
 *@formatter:on
 */

// sort the array, so that duplicates are adjacent
// cannot use contains method

public class PermutationsII47 {

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> rs = new ArrayList<>();
		Arrays.sort(nums);// sort this array to avoid duplicate issue
		backtrace(nums, new ArrayList<Integer>(), rs, new boolean[nums.length]); // all
																					// false
		return rs;
	}

	private void backtrace(int[] nums, List<Integer> list, List<List<Integer>> rs, boolean[] bt) {
		if (nums.length == list.size())
			rs.add(new ArrayList<>(list));
		else {
			for (int i = 0; i < nums.length; i++) {
				// current is already used; or previous one = current one but
				// previous not used
				// under case previous = current: we only proceed if previous is
				// used, i.e. from the first one
				if (bt[i] || (i > 0 && nums[i] == nums[i - 1] && !bt[i - 1]))
					continue;
				bt[i] = true;
				list.add(nums[i]);
				backtrace(nums, list, rs, bt);
				list.remove(list.size() - 1);
				bt[i] = false;

			}
		}
	}

	public static void main(String[] args) {
		PermutationsII47 t = new PermutationsII47();
		int[] nums = { 1, 1, 2 };
		System.out.println(t.permuteUnique(nums));
	}
}
