package com.cloudlewis.leetcode250;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

// !!!! https://briangordon.github.io/2014/08/the-skyline-problem.html
// !!!! REIVIST
public class TheSkylineProblem218 {

	/*
	 * this naive solution does not work, because critical point change reflect
	 * as a delay on the boundry
	 */
	public List<int[]> getSkylineHeighMap(int[][] buildings) {
		List<int[]> rs = new ArrayList<int[]>();
		int[] heightmap = new int[100];
		for (int i = 0; i < buildings.length; i++) {
			int[] bd = buildings[i];
			int height = bd[2];
			for (int j = bd[0]; j <= bd[1]; j++)
				heightmap[j] = Math.max(heightmap[j], height);
		}
		for (int i = 0; i < heightmap.length; i++) {
			if (heightmap[i] != heightmap[i - 1]) {
				if (heightmap[i] > heightmap[i - 1])
					rs.add(new int[] { i + 1, heightmap[i] });
				else
					rs.add(new int[] { i, heightmap[i] });

			}
		}
		return rs;
	}

	public List<int[]> getSkyline(int[][] buildings) {
		Map<Integer, List<int[]>> cps = new TreeMap<>(); // ordered by the
															// critical points
		for (int[] b : buildings) {
			cps.putIfAbsent(b[0], new LinkedList<>());
			cps.putIfAbsent(b[1], new LinkedList<>());
			cps.get(b[0]).add(b);
			cps.get(b[1]).add(b);
		}
		// heap for the currently active buildings, with heighest [2]
		PriorityQueue<int[]> heap = new PriorityQueue<>(new SkylineComparator());
		List<int[]> res = new ArrayList<>();

		// iterate from left to right over the critical points
		for (Map.Entry<Integer, List<int[]>> entry : cps.entrySet()) {
			int c = entry.getKey();
			List<int[]> bs = entry.getValue();

			for (int[] b : bs) {
				// this critical point is a left edge of building `b`
				if (c == b[0])
					heap.add(b);
				else // right edge
					heap.remove(b);
			}

			if (heap.isEmpty()) {
				// the heap is empty, so the skyline is 0
				res.add(new int[] { c, 0 });
			} else {
				int h = heap.peek()[2];
				if (res.isEmpty() || res.get(res.size() - 1)[1] != h) {
					// only add the highest rectangle if it different than
					// before
					res.add(new int[] { c, h });
				}
			}
		}

		return res;

	}

	class SkylineComparator implements Comparator<int[]> {
		// always assume there are 3, x1, x2 and y
		@Override
		public int compare(int[] o1, int[] o2) {
			return Integer.compare(o2[2], o1[2]);
		}
	}

	public static void main(String[] args) {
		TheSkylineProblem218 t = new TheSkylineProblem218();
		int[][] buildings = new int[][] { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
		List<int[]> s1 = t.getSkyline(buildings);
		for (int[] arr : s1) {
			System.out.print("[" + arr[0] + "," + arr[1] + "] ");
		}
	}
}
