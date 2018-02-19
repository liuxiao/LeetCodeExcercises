package com.cloudlewis.leetcode.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

// general
// http://www.cs.princeton.edu/courses/archive/spring13/cos226/lectures/42DirectedGraphs.pdf

// Question:
// https://www.coursera.org/learn/algorithms-graphs-data-structures/exam/rOtFq/programming-assignment-1
public class KosarajuSCC {
	private Map<Integer, Set<Integer>> g_edges = new HashMap<>();

	private Set<Integer> g_vertices = new HashSet<>(); // not actually needed

	private Set<Integer> visited = new HashSet<>();

	private Stack<Integer> stack = new Stack<>();
	
	Map<Integer, Integer> comp_counts = new HashMap<>();
	
	private int component = 1;

	public Map<Integer, Set<Integer>> reverseExtraSpace(Map<Integer, Set<Integer>> edges) {
		Map<Integer, Set<Integer>> newedge = new HashMap<>();
		Set<Integer> keys = edges.keySet();
		for (Integer key : keys) {
			Set<Integer> outs = edges.get(key);
			for (Integer o : outs) {
				if (newedge.containsKey(o))
					newedge.get(o).add(key);
				else {
					Set<Integer> tmp = new HashSet<>();
					tmp.add(key);
					newedge.put(o, tmp);
				}
			}
		}
		return newedge;
	}

	private void fillOrder(Integer v, Map<Integer, Set<Integer>> edges) {
		// Mark the current node as visited and print it
		visited.add(v);
		if (edges.containsKey(v)) {
			// Recur for all the vertices adjacent to this vertex
			Iterator<Integer> iter = edges.get(v).iterator();
			while (iter.hasNext()) {
				int n = iter.next();
				if (!visited.contains(n))
					fillOrder(n, edges);
			}
		}
		// All vertices reachable from v are processed by now,
		// push v to Stack
		stack.push(new Integer(v));
	}

	private void dfs(Integer v, Map<Integer, Set<Integer>> edges) {
		// Mark the current node as visited and print it
		visited.add(v);
		// Recur for all the vertices adjacent to this vertex
		if (edges.containsKey(v)) {
			Iterator<Integer> iter = edges.get(v).iterator();
			while (iter.hasNext()) {
				int n = iter.next();
				if (!visited.contains(n))
					dfs(n, edges);
			}
		}
	}
	
	private void dfs2pass(Integer v, Map<Integer, Set<Integer>> edges) {
		// Mark the current node as visited and print it
		visited.add(v);
		// Recur for all the vertices adjacent to this vertex
		if (edges.containsKey(v)) {
			Iterator<Integer> iter = edges.get(v).iterator();
			while (iter.hasNext()) {
				int n = iter.next();
				if (!visited.contains(n)) {
					dfs2pass(n, edges);
					
				}
			}
		}
		if (comp_counts.containsKey(component))
			comp_counts.put(component, comp_counts.get(component) + 1);
		else
			comp_counts.put(component, 1);
	}

	public void computeSCC() {
		Iterator<Integer> iter = g_vertices.iterator();
		while (iter.hasNext()) {
			Integer v = iter.next();
			if (!visited.contains(v))
				fillOrder(v, g_edges);
		}
		Map<Integer, Set<Integer>> reverse = reverseExtraSpace(g_edges);
		visited.clear();

		while (stack.empty() == false) {
			// Pop a vertex from stack
			Integer v = stack.pop();

			// Print Strongly connected component of the popped vertex
			if (!visited.contains(v))
				dfs2pass(v, reverse);
			
			component++;
			System.out.println("checking component " + component);
		}
		
		Iterator<Integer> cnt_iter = comp_counts.keySet().iterator();
		List<Integer> list = new ArrayList<>();
		while(cnt_iter.hasNext())
			list.add(cnt_iter.next());
		
		Collections.sort(list);
		int len = list.size();
		System.out.println("completed file reading: " + g_vertices.size() + " vertices and " + g_edges.size() + " edges.");
		System.out.println("size of SCC " + list.size());
		for (int i= len -1;  i > len - 6; i--)
			System.out.println(list.get(i));
		
	}

	public void readFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("scc.txt").getFile());
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" ");
				Integer vert = new Integer(Integer.parseInt(parts[0]));
				g_vertices.add(vert);
				Set<Integer> set = new HashSet<>();
				for (int i = 1; i < parts.length; i++)
					set.add(new Integer(parts[i]));
				g_edges.put(vert, set);
			}
			System.out.println("completed file reading: " + g_vertices.size() + " vertices and " + g_edges.size() + " edges.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		KosarajuSCC t = new KosarajuSCC();
		t.readFile();
		t.computeSCC();
	}
}
