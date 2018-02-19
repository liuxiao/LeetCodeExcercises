package com.cloudlewis.leetcode50;

import java.util.Stack;

/**
 * https://leetcode.com/problems/trapping-rain-water/#/description
 * 
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @author xiao
 *
 */

// !!!!! REVISIT

// each bar with a width of 1
// 0,1,2,3,4,5,6,7,8,9,10,11
// [0,1,0,2,1,0,1,3,2,1,2,1]
//

// solution 2
// The idea is:I calculated the stored water at each index a and b in my code.At
// the start of every loop,I update the current maximum height from left
// side(that is from A[0,1...a])and the maximum height from right side(from
// A[b,b+1...n-1]).if(leftmax<rightmax)then,at least(leftmax-A[a])water can
// definitely be stored no matter what happens between[a,b]since we know there
// is a barrier at the rightside(rightmax>leftmax).On the other side,we cannot
// store more water than(leftmax-A[a])at index a since the barrier at left is of
// height leftmax.So,we know the water that can be stored at index a is
// exactly(leftmax-A[a]).The same logic applies to the case
// when(leftmax>rightmax).At each loop we can make a and b one step closer.Thus
// we can finish it in linear time.

public class TrappingRainWater42 {

	// Solution 1 - stack algorithm.
	public int trap(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int len = height.length;
		int cur = 0, sum = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while (cur < len) {
			if (stack.isEmpty() || height[cur] <= height[stack.peek()]) // smaller
																		// than
																		// previous
				stack.push(cur++);
			else { // if
				int low = stack.pop(); // lowest, can ignore, water on top
				if (!stack.isEmpty()) {
					int local = (cur - stack.peek() - 1) * (Math.min(height[cur], height[stack.peek()]) - height[low]);
					sum += local;
				} // if stack is empty, no high bar
			}
			// cur++; // no general increase, if bar is high, we will pop them
			// from stack
		}
		return sum;
	}

	// solution 2 - one pass scan
	public int trapScan(int[] height) {
		if (height == null || height.length == 0) return 0;
		int len = height.length;
		int l = 0, r = len -1;
		int maxleft =0, maxright = 0, sum =0;
		while(l <= r) { // we need equal, because need to calculate water stored on that point
			if (height[l] > maxleft)
				maxleft = height[l];
			if (height[r] > maxright)
				maxright = height[r];
			
			if (maxleft > maxright) {
				sum += (maxright - height[r]);
				r--;
			}
			else {
				sum += (maxleft - height[l]);
				l++;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		TrappingRainWater42 t = new TrappingRainWater42();
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(t.trap(height));
	}
}
