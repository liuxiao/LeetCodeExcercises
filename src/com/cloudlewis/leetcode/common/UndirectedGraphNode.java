package com.cloudlewis.leetcode.common;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {
	public int label;
	public List<UndirectedGraphNode> neighbors;

	public UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}

	@Override
	public String toString() {
		return "UndirectedGraphNode [label=" + label + "]";
	}
	
	
}
