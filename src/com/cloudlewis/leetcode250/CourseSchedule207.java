package com.cloudlewis.leetcode250;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0, and to take course 0 you should also have
 * finished course 1. So it is impossible.
 * 
 * Note: The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented. You may
 * assume that there are no duplicate edges in the input prerequisites. click to
 * show more hints.
 * 
 * Hints: This problem is equivalent to finding if a cycle exists in a directed
 * graph. If a cycle exists, no topological ordering exists and therefore it
 * will be impossible to take all courses. Topological Sort via DFS - A great
 * video tutorial (21 minutes) on Coursera explaining the basic concepts of
 * Topological Sort. Topological sort could also be done via BFS.
 * 
 * @author xiao
 *
 */

// https://www.coursera.org/learn/algorithms-graphs-data-structures/lecture/yeKm7/topological-sort

public class CourseSchedule207 {

	/*
	 * For DFS, it will first visit a node, then one neighbor of it, then one
	 * neighbor of this neighbor... and so on. If it meets a node which was
	 * visited in the current process of DFS visit, a cycle is detected and we
	 * will return false. Otherwise it will start from another unvisited node
	 * and repeat this process till all the nodes have been visited. Note that
	 * you should make two records: one is to record all the visited nodes and
	 * the other is to record the visited nodes in the current DFS visit.
	 * 
	 * The code is as follows. We use a boolean[] visited to record all the
	 * visited nodes and another boolean[] onpath to record the visited nodes
	 * of the current DFS visit. Once the current visit is finished, we reset
	 * the onpath value of the starting node to false.
	 */
	public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
		// every time we will need to start from a particular point, until we
		// run through the entire graph without a node pointing back
		int[] indegree = new int[numCourses]; // not needed here
		// E part
		List<Integer>[] adj = createGraph(numCourses, prerequisites, indegree);
		boolean[] visited = new boolean[numCourses];
		boolean[] onpath = new boolean[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			if (!visited[i] && checkCycle(adj, visited, onpath, i))
				return false; // if visited and has a cycle
		}
		return true;
	}

	private boolean checkCycle(List<Integer>[] adj, boolean[] visited, boolean[] onpath, int n) {
		if (visited[n])
			return false;
		onpath[n] = visited[n] = true;
		List<Integer> indegree = adj[n]; // who has a dependency on i
		for (Integer i : indegree) {
			if (onpath[i] || checkCycle(adj, visited, onpath, i))
				return true;
		}
		return onpath[n] = false; // ? always return true
	}

	private List<Integer>[] createGraph(int numCourses, int[][] prerequisites, int[] indegree) {
		List<Integer>[] adj = new List[numCourses + 1]; // what? because they don't use 0
		for (int i=0; i<adj.length; i++)
			adj[i] = new LinkedList<>();
		for (int[] pre : prerequisites) {
			int preCourse = pre[1];
			int readyCourse = pre[0];
			List<Integer> list = adj[preCourse];
			list.add(readyCourse);
			indegree[readyCourse]++;
		}
		return adj;
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// O(V + E)
		int[] indegree = new int[numCourses];
		// E part
		List<Integer>[] matrix = createGraph(numCourses, prerequisites, indegree);

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}
		int count = 0;
		// V part
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			count++;
			List<Integer> adjacent = matrix[vertex];
			if (adjacent == null)
				continue;
			for (int neighbor : adjacent) {
				indegree[neighbor]--;
				if (indegree[neighbor] == 0)
					queue.offer(neighbor);
			}
		}
		return count == numCourses;
	}

	public boolean canFinishWithMatix(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses]; // i -> j
		int[] indegree = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			int course = prerequisites[i][0];
			int pre = prerequisites[i][1];
			if (matrix[pre][course] == 0)
				indegree[course]++; // duplicate case
			matrix[pre][course] = 1;
		}

		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int course = queue.poll();
			count++;
			for (int i = 0; i < numCourses; i++) {
				if (matrix[course][i] != 0) {
					if (--indegree[i] == 0)
						queue.offer(i);
				}
			}
		}
		return count == numCourses;

	}

	public void test1() {
		int[][] p = new int[2][2];
		p[0][0] = 1;
		p[0][1] = 0;
		p[1][0] = 0;
		p[1][1] = 1;

		System.out.println(canFinish(2, p));

	}

	public void test2() {
		int[][] p = new int[1][2];
		p[0][0] = 1;
		p[0][1] = 0;

		System.out.println(canFinish(2, p));

	}

	public static void main(String[] args) {
		CourseSchedule207 t = new CourseSchedule207();
		t.test1();
		t.test2();
	}
}
