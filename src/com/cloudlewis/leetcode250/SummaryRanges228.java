package com.cloudlewis.leetcode250;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 
 * @author xiao
 *
 */
public class SummaryRanges228 {
	public List<String> summaryRanges(int[] nums) {
		List<String> rs = new ArrayList<>();
		int len = nums.length;
		int i = 0;
		while (i < len) {
			int j = i + 1;
			while(j < len && nums[j] - nums[j-1] == 1)
				j++;
			// j-1 is a valid
			if (i == j-1) {
				rs.add("" + nums[i]);
				i++;
			}
			else {
				rs.add(nums[i] + "->" + nums[j -1]);
				i = j;
			}
		}
		return rs;
	}
	
	public static void main(String[] args) {
		SummaryRanges228 t = new SummaryRanges228();
		System.out.println(t.summaryRanges(new int[] {0,1}));
		System.out.println(t.summaryRanges(new int[] {0,1,2,4,5,7}));
	}
	
}
