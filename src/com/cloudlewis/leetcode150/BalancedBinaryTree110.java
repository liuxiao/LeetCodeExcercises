package com.cloudlewis.leetcode150;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author xiao
 *
 */
public class BalancedBinaryTree110 {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		int left = depth(root.left);
		int right = depth(root.right);
		return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	private int depth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}

	public static void main(String[] args) {
		BalancedBinaryTree110 t = new BalancedBinaryTree110();
		System.out.println(t.isBalanced(Util.generateBST()));
	}

}
