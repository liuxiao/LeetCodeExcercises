package com.cloudlewis.leetcode300;

import com.cloudlewis.leetcode.common.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, find the value in
 * the BST that is closest to the target.
 * 
 * @author xiao
 *
 */

public class ClosestBinarySearchTreeValue270 {
	//brute force, scan entire tree O(n)
	public int closestValue(TreeNode root, double target) {
		int[] candidate = new int[1];
		candidate[0] = root.val;
		closehelper(root, target, candidate);
		return candidate[0];
	}
	
	private void closehelper(TreeNode node, double target, int[] candidate) {
		if (node != null) {
			if (Math.abs(node.val - target) < Math.abs(node.val - candidate[0]))
				candidate[0] = node.val;
			if (target > node.val)
				closehelper(node.right, target, candidate);
			else if (target < node.val)
				closehelper(node.left, target, candidate);
			// equal case will exit, cannot be smaller
		}
	}
}
