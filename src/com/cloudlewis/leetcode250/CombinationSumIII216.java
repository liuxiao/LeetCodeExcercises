package com.cloudlewis.leetcode250;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * 
 * Example 1:
 * 
 * Input: k = 3, n = 7
 * 
 * Output:
 * 
 * [[1,2,4]]
 * 
 * Example 2:
 * 
 * Input: k = 3, n = 9
 * 
 * Output:
 * 
 * [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * @author xiao
 *
 */
public class CombinationSumIII216 {
	List<List<Integer>> rs;

	public List<List<Integer>> combinationSum3(int k, int n) {
		rs = new ArrayList<>();
		if (k == 0 || n == 0)
			return rs;
		List<Integer> path = new ArrayList<>();
		combinationSum3(k, n, path);
		return rs;
	}

	private void combinationSum3(int k, int n, List<Integer> path) {
		if (k == 0 && n == 0)
			rs.add(new ArrayList<Integer>(path));
		else if (k < 0 || n < 0)
			return;
		int prev = 0;
		if (!path.isEmpty())
			prev = path.get(path.size() - 1); // get last number
		for (int i=prev + 1; i <= 9; i++) {
			path.add(i);
			combinationSum3(k - 1, n - i, path);
			path.remove(path.size() - 1);
		}
	}
	
	public static void main(String [] args) {
		CombinationSumIII216 t = new CombinationSumIII216();
		System.out.println(t.combinationSum3(3, 15));
		// [[1,5,9],[1,6,8],[2,4,9],[2,5,8],[2,6,7],[3,4,8],[3,5,7],[4,5,6]]
		System.out.println(t.combinationSum3(3, 7));
		// [[1, 2, 4]]
		System.out.println(t.combinationSum3(3, 9));
		// [[1, 2, 6], [1, 3, 5], [2, 3, 4]]

	}
}
