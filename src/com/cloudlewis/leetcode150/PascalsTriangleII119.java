package com.cloudlewis.leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author xiao
 *
 */

// becomes a sort of dp problem, we can operate in the same array look like
// hack is leave out the 1, and add it at the back

public class PascalsTriangleII119 {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = i - 1; j >= 1; j--) {
				int tmp = ret.get(j - 1) + ret.get(j);
				ret.set(j, tmp);
			}
			ret.add(1);
		}
		return ret;
	}
	
	public static void main(String[] args) {
		PascalsTriangleII119 t = new PascalsTriangleII119();
		System.out.println(t.getRow(4));
	}
}
