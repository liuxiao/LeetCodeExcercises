package com.cloudlewis.leetcode250;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.cloudlewis.leetcode.common.Util;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If
 * it is impossible to finish all courses, return an empty array.
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So the correct course order is [0,1]
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]] There are a total of 4 courses to take. To take
 * course 3 you should have finished both courses 1 and 2. Both courses 1 and 2
 * should be taken after you finished course 0. So one correct course order is
 * [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * 
 * Note: The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented. You may
 * assume that there are no duplicate edges in the input prerequisites. click to
 * show more hints.
 * 
 * Hints: This problem is equivalent to finding the topological order in a
 * directed graph. If a cycle exists, no topological ordering exists and
 * therefore it will be impossible to take all courses. Topological Sort via DFS
 * - A great video tutorial (21 minutes) on Coursera explaining the basic
 * concepts of Topological Sort. Topological sort could also be done via BFS.
 * 
 * @author xiao
 *
 */

/*
 * this is the exact same question as 207; only to record the order
 */
public class CourseScheduleII210 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer>[] adj = new ArrayList[numCourses];
		int[] inedges = new int[numCourses];
		for (int i=0; i < numCourses; i++)
			adj[i] = new ArrayList<>();
		for (int i=0; i < prerequisites.length; i++) {
			int course = prerequisites[i][0];
			int req = prerequisites[i][1];
			adj[req].add(course);
			inedges[course]++;
		}
		int[] rs = new int[numCourses];
		int index = 0;
		Queue<Integer> q = new ArrayDeque<>();
		for (int i=0; i<numCourses; i++)
			if (inedges[i] == 0)
				q.add(i);
		
		while(!q.isEmpty()){
			int from = q.poll();
			rs[index++] = from;
			List<Integer> outs = adj[from];
			for (Integer i : outs) {
				inedges[i]--;
				if (inedges[i] == 0)
					q.offer(i);
			}
		}
		return (index == numCourses) ? rs : new int[0];
	}
	
	public static void main(String[] args) {
		CourseScheduleII210 t = new CourseScheduleII210();
		Util.printArray(t.findOrder(4, new int[][] {{1,0},{2,0},{3,1},{3,2}}));
		Util.printArray(t.findOrder(2, new int[][] {{1,0}}));
	}
}
