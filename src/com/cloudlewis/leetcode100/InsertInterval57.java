package com.cloudlewis.leetcode100;

import java.util.ArrayList;
import java.util.List;

import com.cloudlewis.leetcode.common.Interval;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @author xiao
 *
 */
public class InsertInterval57 {
	// @formatter:off
		// !!! NAH. not working...too complicated
		// intervals are sorted on first, but no mentioning of the end, however,
		// given non-overlapping condition, this is not a case we need to worry.
		// idea is : 
		// for each interval, there will be three cases 
		// 1) newInterval.start > curr.end -- move to next
		// 2) newInterval.start >= curr.start && newInterval.end <=curr.end -- include, break
		// 3) newInterval.end < curr.start -- insert at location curr - 1
		// 4) newInterval.start <= curr.start && newInterval.end
		// 3) newInterval.start >= curr.start && newInterval.start <=curr.end && newInterval.end >curr.end -- merge case,
	    //                      loop next :
		//								if newInterval.end < next.start -- combine inbetween, not include next
		//							    if newInterval.end >= next.start && newInterval.end <= next.end -- combine inbetween, include next
		 // 4) leave insert at back,i.e. first element as special case; 
		// @formatter:on
		public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
			int len = intervals.size();
			List<Interval> rs = new ArrayList<Interval>();
			int i = 0;
			while (i < len && newInterval.start > intervals.get(i).end) {
				rs.add(intervals.get(i));
				i++;
			}

			// hit here, when newInterval.start hit within a range
			// we only need to care about the merge case, if no merge, outside loop will handle
			while (i < len && newInterval.end >= intervals.get(i).start) {
				newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start),
						Math.max(newInterval.end, intervals.get(i).end));
				i++;
			}
			// two scenarios hit here, newInterval.end < next.start (no overlapping) 
			// or above while loop create a new newInterval, which is a merge
			rs.add(newInterval);

			while (i < len) {
				rs.add(intervals.get(i));
				i++;
			}
			return rs;
		}
		
		 
		public void test() {
			List<Interval> s = new ArrayList<Interval>();
			s.add(new Interval(1,3));
			s.add(new Interval(6,9));
			System.out.println(insert(s, new Interval(2, 5)).toString());
		}
		 
		 public void test1() {
				List<Interval> s = new ArrayList<Interval>();
				s.add(new Interval(1,2));
				s.add(new Interval(3,5));
				s.add(new Interval(6,7));
				s.add(new Interval(8,10));
				s.add(new Interval(12,16));
				System.out.println(insert(s, new Interval(4,9)).toString());
			}
		
		public static void main(String[] args) {
			InsertInterval57 t = new InsertInterval57();
			t.test();
			t.test1();
		}
}
