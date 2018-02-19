package com.cloudlewis.leetcode100;

import java.util.Stack;

/**
 * 
 * https://leetcode.com/problems/largest-rectangle-in-histogram/#/description
 * 
 * For example, Given heights = [2,1,5,6,2,3], return 10.
 * 
 * @author xiao
 *
 */

// exact same question as 42
// tricky part is to keep last one to be zero, by adding a fake one
// so that algorithm can be generic, no need to handle the stack of non-pop elem

public class LargestRectangleinHistogram84 {
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> s = new Stack<>();
		int len = heights.length;
		int max = 0;
		for (int i = 0; i <= len; i++) {
			int h = (i == len) ? 0 : heights[i]; // push a last zero
			if (s.isEmpty() || h >= heights[s.peek()])
				s.push(i);
			else {
				int tp = s.pop(); // smallest
				max = Math.max(max, heights[tp] * (s.isEmpty()?i:i-s.peek() - 1));
				i--;
			}
				
		}
		return max;
	}
	
	public static void main(String[] args) {
		LargestRectangleinHistogram84 t = new LargestRectangleinHistogram84();
		System.out.println(t.largestRectangleArea(new int[] {2,1,5,6,2,3}));
	}
}
