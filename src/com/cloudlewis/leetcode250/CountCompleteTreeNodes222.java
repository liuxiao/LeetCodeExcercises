package com.cloudlewis.leetcode250;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * Given a complete binary tree, count the number of nodes.
 * 
 * In a complete binary tree every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as
 * possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * 
 * @author xiao
 *
 */

// !!! REIVIST

/*
 * Solution 1. O(n) Use the characteristic of complete tree? otherwise, just use
 * recursion to traverse the tree
 * 
 * Solution 2. O(logN)
 * https://discuss.leetcode.com/topic/15533/concise-java-solutions-o-log-n-2/2
 */
public class CountCompleteTreeNodes222 {

	public int countNodes(TreeNode root) {
		int count = 0, h = height(root);
		while (root != null) {
			if (height(root.right) == h - 1) {
				count += 1 << h;
				root = root.right;
			} else { 
				count += 1 << h - 1;
				root = root.left;
			}
			h--;
		}
		return count;
	}

	// complete tree guranteed the left is full height
	private int height(TreeNode node) {
		return (node == null) ? -1 : 1 + height(node.left);
	}

	public int countNodesON(TreeNode root) {
		return countNodesRecursive(root);
	}

	private int countNodesRecursive(TreeNode node) {
		if (node == null)
			return 0;
		return countNodes(node.left) + countNodes(node.right) + 1;
	}

	public static void main(String[] args) {
		TreeNode node = Util.generateBST();
		Util.printTreeNodeInOrder(node);
		CountCompleteTreeNodes222 t = new CountCompleteTreeNodes222();
		System.out.println(t.countNodes(node));
	}
}
