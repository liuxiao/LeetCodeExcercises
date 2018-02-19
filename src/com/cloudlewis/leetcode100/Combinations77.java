package com.cloudlewis.leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 *
 * @formatter:off
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 *
 * @formatter:on
 * @author xiao
 *
 */

// here n is inclusive !!

public class Combinations77 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> rs = new ArrayList<>();
		if (k > n) // can equal, which is the full
			return rs;
		List<Integer> path = new ArrayList<>();
		docombine(n, k, 1, path, rs);
		return rs;
	}
	
	private void docombine(int n, int k, int step, List<Integer> path, List<List<Integer>> rs) {
		if (k == 0) {
			rs.add(path);
		}
		else {
			for (int i = step; i <= n; i ++) {
				List<Integer> newpath = new ArrayList<Integer>();
				newpath.addAll(path);
				newpath.add(i);
				docombine(n, k-1, i + 1, newpath, rs);
			}
		}
	}
	
	public static void main(String[] args) {
		Combinations77 t = new Combinations77();
		System.out.println(t.combine(4, 2));
	}
}
