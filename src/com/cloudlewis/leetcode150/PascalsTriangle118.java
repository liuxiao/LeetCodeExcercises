package com.cloudlewis.leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * @formatter:off
 * 
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * 
 * @formatter:on
 * @author xiao
 *
 */

// solution 1, can use dp?, just have to handle the corner cases

public class PascalsTriangle118 {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> rs = new ArrayList<>();
		if (numRows == 0)
			return rs;
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		rs.add(arr);
		if (numRows == 1)
			return rs;
		for (int row = 2; row <= numRows; row++) { //offset by 1
			List<Integer> list = rs.get(row -2);
			List<Integer> thisrow = new ArrayList<Integer>();
			for (int i = 0; i < row; i++) { // will be #numRows elem
				if (i == 0)
					thisrow.add(1);
				else if (i < row -1) {
					int sum = list.get(i -1) + list.get(i);
					thisrow.add(sum);
				}
				else
					thisrow.add(1);
			}	
			rs.add(thisrow);
		}
		return rs;
	}
	
	public static void main(String[] args) {
		PascalsTriangle118 t = new PascalsTriangle118();
		System.out.println(t.generate(5));
	}
}
