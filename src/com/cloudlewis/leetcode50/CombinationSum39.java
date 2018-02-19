package com.cloudlewis.leetcode50;

import java.util.ArrayList;
import java.util.List;

import com.cloudlewis.leetcode.basic.QuickSort;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number
 * (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. The solution
 * set must not contain duplicate combinations. For example, given candidate set
 * [2, 3, 6, 7] and target 7, A solution set is: [ [7], [2, 2, 3] ]
 * 
 * @author xiao
 *
 */

// like a backtracing problem
// choose to select all from given set, if combination sum larger than target,
// terminate;

// or use recursive

// !!!! TRICKY part is to deal with duplicate sets; need to sort the candidate
// O(nlogn) and then pick ones that is greater or equal to the last element in
// the list

public class CombinationSum39 {

	// iterative
	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		int len = candidates.length;			
		List<List<Integer>> rs = new ArrayList<>();
		if (len == 0) return rs;
		QuickSort.sort(candidates);
		List<List<Integer>> temp = new ArrayList<>();
		List<List<Integer>> next = new ArrayList<>();
		temp.add(new ArrayList<>());

		while (!temp.isEmpty()) {
			for (List<Integer> list : temp) {
				int currsum = 0;
				for (Integer i : list)
					currsum += i;
				for (int n : candidates) {
					if (!list.isEmpty() && list.get(list.size() - 1) > n)
						continue;
					if (currsum + n == target) { // found
						list.add(n);
						rs.add(new ArrayList<Integer>(list));
						list.remove(list.size() - 1); // keep it the same for
														// others
					} else if (currsum + n < target) {
						list.add(n);
						next.add(new ArrayList<Integer>(list));
						list.remove(list.size() - 1);
					} // else is too big, no need to maintain anymore
				}
			}
			temp.clear();
			temp.addAll(next);
			next.clear();
		}
		return rs;
	}

	public static void main(String[] args) {
		CombinationSum39 t = new CombinationSum39();
		int[] s = { 2, 3, 6, 7 };
		List<List<Integer>> combinationSum = t.combinationSum(s, 7);
		System.out.println(combinationSum.toString());
		
	}
}
