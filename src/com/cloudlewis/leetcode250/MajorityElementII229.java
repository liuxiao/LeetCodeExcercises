package com.cloudlewis.leetcode250;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than [
 * n/3 ]times. The algorithm should run in linear time and in O(1) space.
 * 
 * @author xiao
 *
 */

// question asks for more than n/3, meaning at most two results
// https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm

public class MajorityElementII229 {
	public List<Integer> majorityElement(int[] nums) {
		int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
		for (int i : nums) {
			if (count1 != 0 && i == candidate1)
				count1++;
			else if (count2 != 0 && candidate2 == i)
				count2++;
			else if (count1 == 0) {
				candidate1 = i;
				count1++;
			}
			else if (count2 == 0) {
				candidate2 = i;
				count2++;
			}
			else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int i : nums) {
			if (i == candidate1)
				count1++;
			else if (i == candidate2)
				count2++;
		}
		List<Integer> rs = new ArrayList<>();
		if (count1 > nums.length / 3)
			rs.add(candidate1);
		if (count2 > nums.length / 3)
			rs.add(candidate2);
		return rs;
	}

	public static void main(String[] args) {
		MajorityElementII229 t = new MajorityElementII229();
		System.out.println(t.majorityElement(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
		System.out.println(t.majorityElement(new int[] { 1, 1, 1, 4, 5, 6, 7 }));
		System.out.println(t.majorityElement(new int[] { 1, 1, 1, 2, 6, 2, 2 }));
	}
}
