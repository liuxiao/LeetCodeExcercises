package com.cloudlewis.leetcode150;

import com.cloudlewis.leetcode.common.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * @formatter:off
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *     3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 
 * @formatter:on
 * @author xiao
 *
 */

// solution 1. use layer print out, and then compare from both ends

// solution 2. use recursive

// solution 3. using two stack, need one for left, one for right, then compare on each level

public class SymmetricTree101 {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null || right == null)
			return left == right; // true only when both null
		if (left.val != right.val)
			return false;
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
}
