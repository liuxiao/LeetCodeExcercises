package com.cloudlewis.leetcode100;

import java.util.ArrayList;
import java.util.List;

import com.cloudlewis.leetcode.common.Interval;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * 
 * @author xiao
 *
 */
public class MergeIntervals56 {
	// asking if [0,0] a valid interval?

		// solution 1. merge every two intervals O(n^2)
		
		// solution 2. scanning, but we need to sort the interval based on their start location, quick sort O(nlogN)
		// then scan one time ideally, with O(n), total O(nlogn + n)
		
		public List<Interval> merge(List<Interval> intervals) {
			List<Interval> rs = new ArrayList<Interval>();
			int len = intervals.size();
			if (len == 0)
				return rs;
			sortInterval(intervals, 0, len - 1);
			// System.out.println(intervals.toString()); sorted
			int start = intervals.get(0).start, end = intervals.get(0).end;
			for (int i=1; i < len; i ++) {
				Interval in = intervals.get(i);
				if (in.start > end) { // a new interval found
					rs.add(new Interval(start, end));
					start = in.start;
					end = in.end;
				}
				else {
					end =Math.max(end, in.end); // !!!! TRICKY POINT. MISSED
				}
			}
			// add last one always
			rs.add(new Interval(start, end));
			return rs;
		}
		
		private int partition(List<Interval> interval, int start, int end) {
			int mid = start + (end -start) /2;
			int pivot = interval.get(mid).start;
			while(start <= end) {
				while(interval.get(start).start < pivot)
					start++;
				while(interval.get(end).start > pivot)
					end--;
				if (start <= end) { // we want to increase counter so have equal
					swapInterval(interval, start, end);
					start++;
					end--;
				}
			}
			return start;
		}
		
		private void swapInterval(List<Interval> intervals, int i, int j) {
			Interval one = intervals.get(i);
			Interval two = intervals.get(j);
			int tmp1 = one.start;
			int tmp2 = one.end;
			one.start = two.start;
			one.end = two.end;
			two.start= tmp1;
			two.end = tmp2;
		}
		
		private void sortInterval(List<Interval> interval, int start, int end) {
			if (start >= end)
				return;
			int partition =  partition(interval, start, end);
			if (start < partition -1)
				sortInterval(interval, start, partition -1); 
			// quick sort, most of the time, return partition,no need to include
			if (partition < end)
				sortInterval(interval, partition, end );
		}
		
		public void test() {
			List<Interval> s = new ArrayList<Interval>();
			s.add(new Interval(1,3));
			s.add(new Interval(2,6));
			s.add(new Interval(8,10));
			s.add(new Interval(15,18));
			System.out.println(merge(s).toString());
		}
		
		public void test1() {
			List<Interval> s = new ArrayList<Interval>();
			s.add(new Interval(1,3));
			System.out.println(merge(s).toString());
		}
		
		// !! FAILED TEST CASE
		public void test2() {
			List<Interval> s = new ArrayList<Interval>();
			s.add(new Interval(1,3));
			s.add(new Interval(1,4));
			System.out.println(merge(s).toString());
		}
		
		public static void main(String[] args) {
			MergeIntervals56 t = new MergeIntervals56();
			t.test();
			t.test1();
			t.test2();
		}
}
