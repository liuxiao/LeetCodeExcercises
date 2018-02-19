package com.cloudlewis.leetcode150;

import com.cloudlewis.leetcode.common.TreeNode;

/**
 * 
 * Given a binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path must contain at least one node and does not need to go through the root.
 * 
 * For example: Given the below binary tree,
 * 
 * @formatter:off 
 *
 *      1
 *     / \
 *    2   3
 * 
 * Return 6.
 * 
 * @formatter:on
 * @author xiao
 *
 */

// !! REVISIT

// does it need to be started and ended on leaf ?
// solution 1. traverse the tree, keep a local sum, find it from current node;
// then recursively call into left and right

/*
 * MOST IMPORTANT THING is to think in the right way; simply the problem to be a
 * maxPathDown; don't worry about going up case, recursive will take care of
 * reason first attempt is not working, because didn't nile down maxPathDown function
 */

public class BinaryTreeMaximumPathSum124 {
	public int maxPathSum(TreeNode root) {
		int[] maxValue = new int[1];
		maxValue[0] = Integer.MIN_VALUE;
		maxPathDown(root, maxValue);
		return maxValue[0];
	}

	private int maxPathDown(TreeNode node, int[] maxValue) {
		if (node == null)
			return 0;
		int left = Math.max(0, maxPathDown(node.left, maxValue));
		int right = Math.max(0, maxPathDown(node.right, maxValue));
		maxValue[0] = Math.max(maxValue[0], left + right + node.val);
		return Math.max(left, right) + node.val;
	}

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum124 t = new BinaryTreeMaximumPathSum124();
		TreeNode root = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		root.left = n1;
		root.right = n3;
		System.out.println(t.maxPathSum(root));
	}
}
