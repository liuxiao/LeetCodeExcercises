package com.cloudlewis.leetcode400;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list
 * weighted by their depth.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Similar to 339, but reversed level
 * 
 * Example 1: Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 2,
 * one 2 at depth 1)
 * 
 * @author xiao
 *
 */
public class NestedListWeightSumII364 {
	public int depthSumReverseLevel(List<NestedInteger> nestedList) {
		List<Integer> integers = new LinkedList<>();
		List<NestedInteger> tmp = new LinkedList<>();
		List<Integer> levels = new LinkedList<>();
		
		for (NestedInteger i : nestedList) {
			if (i.i != null) {
				integers.add(i.i);
				levels.add(1);
			}
			else
				tmp.addAll(i.list);
		}
		int level = 2, count = tmp.size();
		while(!tmp.isEmpty()) {
			NestedInteger i = tmp.remove(0);
			if (i.i != null) {
				integers.add(i.i);
				levels.add(level);
			}
			else {
				tmp.addAll(i.list);
			}
			count--;
			if (count == 0) {
				count = tmp.size();
				level++;
			}
		}
		// out loop
		int sum = 0;
		int maxlevel = levels.get(levels.size() - 1);
		for (int i=0; i < integers.size(); i++) {
			int newlevel = Math.abs(maxlevel + 1 - levels.get(i) );
			sum += newlevel * integers.get(i);
		}
		return sum;
	}
	
	class NestedInteger {
		public Integer i;
		public List<NestedInteger> list;

		public NestedInteger(int i) {
			this.i = i;
		}

		public NestedInteger(NestedInteger... n) {
			list = new ArrayList<NestedInteger>();
			for (NestedInteger in : n)
				list.add(in);
		}
	}
	
	public void test() {
		NestedInteger i1 = new NestedInteger(1);
		NestedInteger i11 = new NestedInteger(1);
		NestedInteger i1g = new NestedInteger(i1, i11);
		NestedInteger i2 = new NestedInteger(2);
		NestedInteger i111 = new NestedInteger(1);
		NestedInteger i1111 = new NestedInteger(1);
		NestedInteger i1g1 = new NestedInteger(i111, i1111);
		List<NestedInteger> g = new ArrayList<>();
		g.add(i1g);
		g.add(i2);
		g.add(i1g1);
		
		System.out.println(depthSumReverseLevel(g));
	}

	public static void main(String[] args) {
		NestedListWeightSumII364 t = new NestedListWeightSumII364();
		t.test();
	}
}
