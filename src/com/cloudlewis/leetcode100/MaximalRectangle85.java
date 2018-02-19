package com.cloudlewis.leetcode100;

import java.util.Stack;

/**
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing only 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * @formatter:off
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * @formatter:on
 * Return 6.
 * 
 * @author xiao
 *
 */

// build another mask with the same size, places calculated place, then we don't
// have to calculate again

// !!! REVISIT

// Solution 1. use another array to store height, and calculate based on
// histogram question #84
// search for each location O(n^2)
// height[] records the current height of columns during the loop of rows, where
// the height is defined as:
// for row of index `row`, the consecutive number of 1's from `row` to `0`
// As it is mentioned, the height for column i H[i] is reset to 0 where
// matrix[row][i] is 0 while looping through row.
// https://discuss.leetcode.com/topic/1634/a-o-n-2-solution-based-on-largest-rectangle-in-histogram

// @formatter:off
// Solution 2. use DP
// https://discuss.leetcode.com/topic/6650/share-my-dp-solution
// left(i,j) = max(left(i-1,j), cur_left), cur_left can be determined from the current row
// right(i,j) = min(right(i-1,j), cur_right), cur_right can be determined from the current row
// height(i,j) = height(i-1,j) + 1, if matrix[i][j]=='1';
// height(i,j) = 0, if matrix[i][j]=='0'
// @formatter:on
// scan row by row, keep n

public class MaximalRectangle85 {
	public int maximalRectangle(char[][] matrix) {
		int max = 0;
		int m = matrix.length, n = matrix[0].length;
		int[] left = new int[n], right = new int[n], height = new int[n];
		for (int row = 0; row < m; row++) {
			int cur_left=0, cur_right=n; 
			for (int i = 0; i < n; i++) {
				if (matrix[row][i] == '1') {
					height[i]++;
					left[i] = Math.max(left[i], cur_left);
					right[i] = Math.min(right[i], cur_right);
				}
				else {
					height[i] = 0;
					left[i] = 0;
					cur_left = i + 1; // current not 1
					right[i] = 0;
					cur_right = i - 1;
				}
			}
			for ( int j=0; j<n;j++)
				max = Math.max(max, height[j] * (right[j] - left[j] + 1));
		}
		return max;
	}

	public int maximalRectangleHistogram(char[][] matrix) {
		int max = 0;
		int m = matrix.length, n = matrix[0].length;
		int[] heights = new int[n + 1];
		heights[n] = 0; // stored a cumulative value
		for (int i = 0; i < m; i++) {
			Stack<Integer> s = new Stack<>(); // each row, we get a new stack
			for (int j = 0; j < n + 1; j++) { // same logic, keep one more for 0
				if (j < n) {
					if (matrix[i][j] == '1')
						heights[j]++;
					else
						heights[j] = 0;
				}
				if (s.isEmpty() || heights[j] >= heights[s.peek()])
					s.push(j);
				else {
					while (!s.isEmpty() && heights[j] < heights[s.peek()]) {
						int top = s.pop();
						int area = heights[top] * (s.isEmpty() ? j : (j - s.peek() - 1));
						if (area > max)
							max = area;
					}
					s.push(j);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		MaximalRectangle85 t = new MaximalRectangle85();
		char[][] nums = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' } };
		System.out.println(t.maximalRectangleHistogram(nums));
	}
}
