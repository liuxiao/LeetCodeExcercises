package com.cloudlewis.leetcode50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. The solution
 * set must not contain duplicate combinations. For example, given candidate set
 * [10, 1, 2, 7, 6, 1, 5] and target 8, A solution set is: [ [1, 7], [1, 2, 5],
 * [2, 6], [1, 1, 6] ]
 * 
 * @author xiao
 *
 */

// different from 39, where candidates can contains duplicates;
// therefore, cannot use same way to rule out duplicate by comparing last
// element
// need to keep track which element is used, which is not, so use recursive

public class CombinationSumII40 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		int len = candidates.length;
		Arrays.sort(candidates);
		List<List<Integer>> rs = new ArrayList<>();
		if (len == 0)
			return rs;

		// depth first search
		combinationSum2(rs, new ArrayList<>(), candidates, 0 , target);
		return rs;
	}

	private void combinationSum2(List<List<Integer>> rs, List<Integer> path,
			int[] candidates, int curcan, int target) {
		if (target == 0) // find sotluioon
			rs.add(path);
		if (target < 0) //
			return;
		else {
			for (int i = curcan; i < candidates.length; i++) {
				// if previous is the same, then it has been counted already
				if (i -1 >= curcan && candidates[i] == candidates[i-1]) // !!!!! TRICKY BOUNDRY  i - 1> cur
					continue;
				List<Integer> newpath = new ArrayList<Integer>(path);
				newpath.add(candidates[i]);
				combinationSum2(rs, newpath, candidates, i + 1, target - candidates[i]);
			}
		}
	}

	public static void main(String[] args) {
		CombinationSumII40 t = new CombinationSumII40();
		int[] s = { 2, 3, 6, 7 };
		System.out.println(t.combinationSum2(s, 7));

		int[] ss = { 10, 1, 2, 7, 6, 1, 5 }; // 1, 1, 2, 5, 6, 7, 10
		System.out.println(t.combinationSum2(ss, 8));
		// [ [1, 7], [1, 2, 5],[2, 6], [1, 1, 6] ]

	}
}
