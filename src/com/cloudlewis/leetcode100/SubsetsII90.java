package com.cloudlewis.leetcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example, If nums = [1,2,2], a solution is:
 * 
 * @formatter:off
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 * 
 * @formatter:on
 * @author xiao
 *
 */

// !!! REVISIT

public class SubsetsII90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> rs = new ArrayList<>();
		rs.add(new ArrayList<>());
		int size = 0;
		for (int i = 0; i < nums.length; i++) {
			// if hit same elem, insert from last size, ie.elem added last round
			int insertLoc = (i >= 1 && nums[i] == nums[i-1]) ? size : 0;
			size = rs.size();
			for (int j = insertLoc; j< size; j ++){
				List<Integer> tmp = new ArrayList<>();
				tmp.addAll(rs.get(j));
				tmp.add(nums[i]);
				rs.add(tmp);
			}
		}
		return rs;
	}

	public static void main(String[] args) {
		SubsetsII90 t = new SubsetsII90();
		System.out.println(t.subsetsWithDup(new int[] { 1, 1 }));
		System.out.println(t.subsetsWithDup(new int[] { 1, 2, 2 }));
	}
}
