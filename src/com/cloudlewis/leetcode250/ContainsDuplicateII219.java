package com.cloudlewis.leetcode250;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 * 
 * @author xiao
 *
 */
public class ContainsDuplicateII219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums.length == 0)
			return false;
		Map<Integer, Integer> map = new HashMap<>();
		int index = 0;
		for (int i : nums) {
			if (!map.containsKey(i))
				map.put(i, index);
			else {
				if (index - map.get(i) <= k)
					return true;
				map.put(i, index);
			}	
			index++;
		}
		return false;
	}
}
