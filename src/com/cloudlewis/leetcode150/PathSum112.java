package com.cloudlewis.leetcode150;

import java.util.Stack;

import com.cloudlewis.leetcode.common.TreeNode;

/**
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * For example: Given the below binary tree and sum = 22,
 * 
 * @formatter:off
 * 
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \      \
 *       7    2      1
 *       
 * @formatter:on
 *       
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * @author xiao
 *
 */

// this is a DFS, we need to check all of them, because not BST, value can be
// negative

public class PathSum112 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		Stack<TreeNode> s = new Stack<>();
		while (root != null || !s.isEmpty()) {
			while (root != null) {
				s.push(root);
				sum -= root.val;
				root = root.left;
			}
			TreeNode node = s.pop();
			if (node.left == null && node.right == null && sum == 0) // !!! TRICKY, MAKE SURE IT IS LEAF!
				return true;
			sum += node.val;
			node = node.right;
		}
		return false;
	}

	public boolean hasPathSumRecursive(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && sum - root.val == 0)
			return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
