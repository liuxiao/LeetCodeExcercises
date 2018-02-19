package com.cloudlewis.leetcode150;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * 
 * @author xiao
 *
 */

// @formatter:off
// can use a bit mask to achieve, but the bit mask need to be large? with size of Integer.MAX_VALUE?
// what about the value is negative, bit mask might not be used, or use another one for negative
// trick is to handle boundary 
// Solution 1. use above alg but two mask
//
//
// @formatter:on

public class LongestConsecutiveSequence128 {
	public int longestConsecutive(int[] nums) {
		Set<Integer> s = new HashSet<>();
		for (int n : nums)
			s.add(n);
		int max = 0;
		for (Integer i : s) {
			if (!s.contains(i - 1)) { // make sure, we only check one direction
				int j = i + 1;
				while (s.contains(j))
					j++;
				max = Math.max(max, j - i);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestConsecutiveSequence128 t = new LongestConsecutiveSequence128();
		System.out.println(t.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
	}
}
