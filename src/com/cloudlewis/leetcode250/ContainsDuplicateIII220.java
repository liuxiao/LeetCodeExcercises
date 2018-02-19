package com.cloudlewis.leetcode250;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the absolute difference between nums[i] and
 * nums[j] is at most t and the absolute difference between i and j is at most
 * k.
 * 
 * @author xiao
 *
 */

/*
 * Naive implementation will not work because it would fail/time for big number
 * Have to use bucket concept; use a bucket size of t + 1
 * 
 */

// !!! REVISIT

public class ContainsDuplicateIII220 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0)
			return false;
		Map<Long, Long> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			long remapnum = (long) nums[i] - Integer.MIN_VALUE;
			long bucket = remapnum / ((long) t + 1);
			if (map.containsKey(bucket) || (map.containsKey(bucket - 1) && remapnum - map.get(bucket - 1) <= t)
					|| (map.containsKey(bucket + 1) && map.get(bucket + 1) - remapnum <= t))
				return true;
			if (i >= k) { // only need to maintain k number of bucket
				// !!! need equal, otherwise, third test case fail, we will remove, because next one will put
				long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
				map.remove(lastBucket);
			}
			map.put(bucket, remapnum);
		}
		return false;
	}

	public boolean containsNearbyAlmostDuplicateNaive(int[] nums, int k, int t) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int chk = nums[i] - t;
			while (chk <= nums[i] + t) {
				if (map.containsKey(chk)) {
					int loc = map.get(chk);
					if (i - loc <= k)
						return true;
				}
				chk++;
			}
			map.put(nums[i], i);
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicateIII220 t = new ContainsDuplicateIII220();
		System.out.println(t.containsNearbyAlmostDuplicate(new int[] { -1, -1 }, 1, 0));
		System.out.println(t.containsNearbyAlmostDuplicate(new int[] { -1, 2147483647 }, 1, 2147483647)); // false
		System.out.println(t.containsNearbyAlmostDuplicate(new int[] { 1, 3, 1 }, 1, 1)); // false
	}
}
