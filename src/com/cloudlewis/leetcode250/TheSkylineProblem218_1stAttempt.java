package com.cloudlewis.leetcode250;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/the-skyline-problem/#/description
 * 
 * The number of buildings in any input list is guaranteed to be in the range
 * [0, 10000].
 * 
 * The input list is already sorted in ascending order by the left x position
 * Li.
 * 
 * The output list must be sorted by the x position.
 * 
 * There must be no consecutive horizontal lines of equal height in the output
 * skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not
 * acceptable; the three lines of height 5 should be merged into one in the
 * final output as such: [...[2 3], [4 5], [12 7], ...]
 * 
 * @author xiao
 *
 */

/*
 * @formatter:off
 * failed google onsite interview question in 2015
 * 
 * 1) sort building by the first attribute, left edge; O(nlogn)
 * 2) two curosrs to move, if next collide with current, combine, and set combined to curr
 * 	  if no collide, print the curr and set next to curr O(n)
 * 
 * need to utility functions
 * checkCollide()
 * combineCollide()
 * 
 * @formatter:on
 */

public class TheSkylineProblem218_1stAttempt {
	public List<int[]> getSkyline(int[][] buildings) {
		int len = buildings.length;
		List<int[]> rs = new ArrayList<int[]>();
		if (len == 0)
			return rs;
		Arrays.sort(buildings, new SkylineComparator());
		List<int[]> curr = new ArrayList<int[]>();
		curr.addAll(buildingToCoornidate(buildings, 0));
		int i = 1;
		while (i < len) {
			if (isCollide(buildings, curr, i)) {
				curr = combineCollide(buildings, curr, i);
			} else { // no collide
				rs.addAll(curr);
				curr = buildingToCoornidate(buildings, i);
			}
			i++;
		}
		return rs;
	}

	// current might be a complicated one; given sorted in nature, we don't need
	// to check leftmost coornidate
	private boolean isCollide(int[][] buildings, List<int[]> curr, int next) {
		int[] mostright = curr.get(curr.size() - 1);
		if (buildings[next][0] > mostright[0]) // no overlapping
			return false;
		else
			return true; // if share same wall, need to regroup
	}

	private List<int[]> combineCollide(int[][] buildings, List<int[]> curr, int next) {
		int bleft = buildings[next][0], bright = buildings[next][1], bheight = buildings[next][2];
		List<int[]> rs = new ArrayList<>();
		int newheight = -1;
		for (int i = 0; i < curr.size(); i++) {
			if (newheight == -1) { // no collide yet
				if (curr.get(i)[0] == bleft) {
					rs.add(new int[] { bleft, Math.max(bheight, curr.get(i)[1]) });
					newheight = bheight;
				} else
					rs.add(curr.get(i));
				if (i + 1 < curr.size() && curr.get(i)[0] < bleft && bleft < curr.get(i + 1)[0]) {
					if (bheight > curr.get(i)[1])
						rs.add(new int[] {bleft, bheight});
					newheight = bheight;
				}
			} else {
				if (curr.get(i)[0] < bright && curr.get(i)[1] < newheight)
					continue;
				if (curr.get(i)[0] == bright) {
					rs.add(new int[] {bright, Math.max(bheight, curr.get(i)[1])});
					newheight = -1;
				}
			}
		}
		// remove duplicates with same height
		return rs;
	}

	private List<int[]> buildingToCoornidate(int[][] buildings, int i) {
		List<int[]> curr = new ArrayList<int[]>();
		curr.add(new int[] { buildings[i][0], 0 });
		curr.add(new int[] { buildings[i][0], buildings[i][2] });
		curr.add(new int[] { buildings[i][1], 0 });
		return curr;
	}

	class SkylineComparator implements Comparator<int[]> {
		// always assume there are 3, x1, x2 and y
		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] != o2[0])
				return Integer.compare(o1[0], o2[0]);
			else
				return Integer.compare(o1[1], o2[1]);
		}
	}

	public static void main(String[] args) {
		TheSkylineProblem218_1stAttempt t = new TheSkylineProblem218_1stAttempt();
	}
}
