package com.cloudlewis.leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a set of distinct integers, nums, return all possible subsets.
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * For example,
 * If nums = [1,2,3], a solution is:
 *
 * @formatter:off
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 * @formatter:on
 * @author xiao
 *
 */
public class Subsets78 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> rs = new ArrayList<>();
		int len = nums.length;
		if (len ==0)
			return rs;
		List<Integer> path = new ArrayList<>(); // empty
		getsubset(nums, rs, path,  0, len);
		return rs;
	}
	
	private void getsubset(int[] nums, List<List<Integer>> rs, List<Integer>path,  int step, int len) {
		rs.add(path);
		for (int i=step; i< len; i++) {
			List<Integer> newarr = new ArrayList<Integer>();
			newarr.addAll(path);
			newarr.add(nums[i]);
			getsubset(nums, rs, newarr, i +1, len );
		}
	}
	
	public static void main(String[] args) {
		Subsets78 t = new Subsets78();
		System.out.println(t.subsets(new int[] {1,2,3}));
	}
}
