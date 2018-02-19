package com.cloudlewis.leetcode350;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a nested list of integers, return the sum of all integers in the list
 * weighted by their depth.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Example 1: Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2,
 * one 2 at depth 1)
 * 
 * @author xiao
 *
 */

// LinkedIn
public class NestedListWeightSum339 {
	
	//recurisve
	public int depthSumRecurisve(List<NestedInteger> nestedList) {
		int[] sum = new int[1];
		depthRecurisve(nestedList, sum, 1);
		return sum[0];
	}
	
	private void depthRecurisve(List<NestedInteger> list, int[] sum, int level) {
		for (NestedInteger i : list) {
			if (i.i != null)
				sum[0] += (level * i.i);
			else
				depthRecurisve(i.list, sum, level + 1);
		}
	}
	
	
	// interative
	public int depthSum(List<NestedInteger> nestedList) {
		if (nestedList == null || nestedList.size() == 0)
			return 0;
		int sum = 0, level = 2, count = 0, nextcount = 0;
		Queue<NestedInteger> q = new ArrayDeque<>();
		for (NestedInteger i : nestedList) {
			if (i.i != null)
				sum += i.i;
			else {
				q.addAll(i.list);
				count += i.list.size();
			}
		}
		while (!q.isEmpty()) {
			NestedInteger i = q.poll();
			if (i.i != null) {
				sum += i.i * level;
				count--;
			} else {
				q.addAll(i.list);
				nextcount += i.list.size();
			}
			if (count == 0) {
				count = nextcount;
				nextcount = 0;
				level++;
			}

		}
		return sum;
	}

	public int depthSumWithTwoQueue(List<NestedInteger> nestedList) {
		int sum = 0;

		LinkedList<NestedInteger> queue = new LinkedList<NestedInteger>();
		LinkedList<Integer> depth = new LinkedList<Integer>();

		for (NestedInteger ni : nestedList) {
			queue.offer(ni);
			depth.offer(1);
		}

		while (!queue.isEmpty()) {
			NestedInteger top = queue.poll();
			int dep = depth.poll();

			if (top.i != null) {
				sum += dep * top.i;
			} else {
				for (NestedInteger ni : top.list) {
					queue.offer(ni);
					depth.offer(dep + 1);
				}
			}
		}

		return sum;
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
		
		System.out.println(depthSum(g));
		System.out.println(depthSumRecurisve(g));
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

	public static void main(String[] args) {
		NestedListWeightSum339 t = new NestedListWeightSum339();
		t.test();
	}
}
