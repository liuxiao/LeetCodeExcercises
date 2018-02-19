package com.cloudlewis.leetcode.tests;

import java.io.InputStreamReader;
import java.util.Scanner;

// http://www.markhneedham.com/blog/2012/12/15/prims-algorithm-in-ruby/

public class MinimumSpanningTree {

	int[][] graph;
	int numNodes;
	int[] tree;// it has just edges tree[i] contains j if (i,j) is in
				// tree. This array is NOT symmetric. init to -1
	/*
	 * implements slow O(mn) algo default one
	 */

	public void primsSlow() {
		loadData();
		int weight = 0;
		boolean[] status = new boolean[numNodes];
		for (int i=0; i<status.length; i++)
			status[i] = false;
		status[0] = true;

		int minw = Integer.MAX_VALUE;
		int mini = 0;
		int minj = 0;
		while (!isComplete(status)) {
			for (int i = 0; i < numNodes; i++) {
				if (status[i])
					continue;
				// find in graph an edge with (i,j) where j=true and trace
				// minimum
				for (int j = 0; j < numNodes; j++) {
					if (!status[j])
						continue;
					if (minw > graph[i][j]) {
						minw = graph[i][j];
						mini = i;// new node
						minj = j;// old node
					}
				}
			}
			status[mini] = true;
			tree[minj] = mini;
			weight += graph[mini][minj];
			minw = Integer.MAX_VALUE;
		}
		System.out.println("weight " + weight);

	}

	public boolean isComplete(boolean[] status) {
		for (boolean b : status) {
			if (!b)
				return false;
		}
		return true;
	}

	private void loadData() {
		Scanner scanner = new Scanner(
				new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("mst.txt")));
		String[] line = scanner.nextLine().split(" ");
		numNodes = Integer.parseInt(line[0]);
		graph = new int[numNodes][numNodes];
		for (int i = 0; i < numNodes; i++)
			for (int j = 0; j < numNodes; j++)
				graph[i][j] = Integer.MAX_VALUE;
		String str;
		while (scanner.hasNextLine()) {
			str = scanner.nextLine();
			int i = Integer.parseInt(str.split(" ")[0]) - 1;
			int j = Integer.parseInt(str.split(" ")[1]) - 1;
			graph[i][j] = Integer.parseInt(str.split(" ")[2]);
			graph[j][i] = Integer.parseInt(str.split(" ")[2]);
		}
		tree = new int[numNodes];
		for (int i= 0; i< tree.length; i++)
			tree[i] = -1;
		scanner.close();
	}

	public static void main(String[] args) {
		MinimumSpanningTree t = new MinimumSpanningTree();
		t.primsSlow();
	}
}
