package com.cloudlewis.leetcode250;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * 
 * @formatter:off
 * Invert a binary tree.
 * 
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 
 * to
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 
 * @formatter:on
 * @author xiao
 *
 */

// we will do swap node instead of the value itself

public class InvertBinaryTree226 {
	public TreeNode invertTree(TreeNode root) {
		invertTreeRecursive(root); // root does not change
		return root;
	}

	private void invertTreeRecursive(TreeNode root) {
		if (root != null) {
			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;
			invertTreeRecursive(root.left);
			invertTreeRecursive(root.right);
		}
	}
	
	public static void main(String [] args) {
		InvertBinaryTree226 t = new InvertBinaryTree226();
		TreeNode node = Util.generateBST();
		Util.printTreeNodePreOrder(node);
		TreeNode newnode = t.invertTree(node);
		Util.printTreeNodePreOrder(newnode);
	}
}
