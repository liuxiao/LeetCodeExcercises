package com.cloudlewis.leetcode.facebook;

import com.cloudlewis.leetcode.common.Interval;

/**
 * Choose from a list of intervals, to make full coverage of target interval
 * with minimum selection. If cannot cover, return -1. for example:
 * [[3,6],[4,5],[7,10],[6,9],[7,12],[12,17],[10,13],[18,22],[16,18]]; target is
 * [7, 22]; should return 3;
 * 
 * solution with O(n) time and O(n) space.
 * 
 * @author xiao
 *
 */

/*
 * This is a very similar problem like 45.JumpGameII key point is how to
 * transform this to 45
 */
public class MinimumCoverInterval {
	public int minimumCoverInterval(Interval[] intervals, Interval target) {
		if (target == null || target.start == target.end || intervals.length == 0)
			return 0;
		// map it to a jump game
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (Interval i : intervals) {
			min = Math.min(min, i.start);
			max = Math.max(max, i.end);
		}
		int[] count = new int[max - min + 1];
		for (Interval i : intervals)
			count[i.start - min] = Math.max(count[i.start - min], i.end - i.start);
		// need max for above to avoid duplicates and overlapping
		int target_start = target.start - min;
		int target_end = target.end - min;
		int i = 0, reach = 0;
		// we start from 0, and we need to find the interval that covers target
		// start, with max of covering; more cover over target.start, better;
		// that would be the first section, and we will count after this
		while (i <= target_start) {
			if (count[i] + i >= target_start)
				reach = Math.max(reach, count[i] + i);
			i++;
		}
		int num = 1; // already matched one above
		int maxreach = 0; // remember how far we could go beyond reach
		while (i < target_end) { // we don't need equal here, a failed case
			if (reach >= target_end)
				break; // can terminate early
			maxreach = Math.max(maxreach, count[i] + i);
			if (reach < i) { // this cannot have an equal, because we move out
				reach = maxreach; // we assign the max we could reach
				num++;
			}
			i++;
		}
		return reach >= target_end ? num : -1;
	}

	public static void main(String[] args) {
		MinimumCoverInterval t = new MinimumCoverInterval();
		Interval[] intervals = new Interval[] { new Interval(3, 6), new Interval(4, 5), new Interval(7, 10),
				new Interval(6, 9), new Interval(7, 12), new Interval(12, 17), new Interval(10, 13),
				new Interval(18, 22), new Interval(16, 18) };
		System.out.println(t.minimumCoverInterval(intervals, new Interval(7, 22)));
	}
}
