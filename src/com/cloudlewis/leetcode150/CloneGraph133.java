package com.cloudlewis.leetcode150;

import java.util.HashMap;
import java.util.Map;

import com.cloudlewis.leetcode.common.UndirectedGraphNode;

/**
 * 
 * @formatter:off
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * 
 * OJ's undirected graph serialization: Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label
 * and each neighbor of the node. As an example, consider the serialized graph
 * {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as
 * separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. 
 * Second node is labeled as 1. Connect node 1 to node 2. 
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle. 
 * 
 * Visually, the graph looks like the following:
 * 
 * 
 *      1
 *     / \
 *    /   \
 *   0 --- 2
 *        / \
 *        \_/
 * 
 * @formatter:on
 * @author xiao
 *
 */

// !!! TRICKY part is cannot use Set, because that will return the same old object
// idea seems simple to using recursive call to clone, and return
// key is to make sure do not get into loop
// use a HashSet to keep track


public class CloneGraph133 {
	// maintain a map from original to new cloned node
	private Map<UndirectedGraphNode, UndirectedGraphNode> cloned = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
	
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node == null)
    		return null;
        if (cloned.containsKey(node))
        	return cloned.get(node); // ?? good enough
        UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
        cloned.put(node, newnode);
        for (UndirectedGraphNode cnode : node.neighbors)
        	newnode.neighbors.add(cloneGraph(cnode));
        return newnode;
    }
    
    public static void main(String [] args ) {
    	CloneGraph133 t = new CloneGraph133();
    	UndirectedGraphNode n0 = new UndirectedGraphNode(0);
    	UndirectedGraphNode n1 = new UndirectedGraphNode(1);
    	UndirectedGraphNode n2 = new UndirectedGraphNode(2);
    	n0.neighbors.add(n1);
    	n0.neighbors.add(n2);
    	n1.neighbors.add(n0);
    	n1.neighbors.add(n2);
    	n2.neighbors.add(n2);
    	UndirectedGraphNode graph = t.cloneGraph(n0);
    	System.out.println(graph);
    	System.out.println(graph.neighbors);
    	System.out.println(graph.neighbors.get(1).neighbors);
    }
}
