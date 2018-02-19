package com.cloudlewis.leetcode100;

import java.util.Stack;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * @formatter:off 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *    2
 *   / \
 *  1   3
 * Binary tree [2,1,3], return true.
 * Example 2:
 *    1
 *   / \
 *  2   3
 * Binary tree [1,2,3], return false.
 * 
 * @formatter:on
 * @author xiao
 *
 */

// easiet way is to use recursive, but when plugin the values of the max parent
// node
// there is a corner case on max_int, and min_int

// Solution 1
// If we use in-order traversal to serialize a binary search tree, we can
// get a list of values in ascending order. It can be proved with the
// definition of BST. And here I use the reference of TreeNode
// pointer prev as a global variable to mark the address of previous node in the
// list.

// !!! REVISIT

public class ValidateBinarySearchTree98 {

	// use iterative
	public boolean isValidBST(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode pre = null;
		while (root != null || !s.isEmpty()) {
			while (root != null) {
				s.push(root);
				root = root.left;
			}
			root = s.pop(); // last left
			if (pre != null && root.val <= pre.val)
				return false;
			pre = root;
			root = root.right;

		}
		return true;
	}

	public boolean isValidBSTRecursive(TreeNode root) {
		return isValid(root, null);
	}

	private boolean isValid(TreeNode node, TreeNode prev) { // boundray section
															// very trick!!!!
		if (node == null)
			return true;
		if (!isValid(node.left, node)) // here we passode, which denote
										// current!!!
			return false;
		if (prev != null && prev.val <= node.val) // this line of code seems
													// wrong
			return false;
		return isValid(node.right, prev); // here we use prev, because it is
											// from parent on right
	}

	public static void main(String[] args) {
		ValidateBinarySearchTree98 t = new ValidateBinarySearchTree98();
		System.out.println(t.isValidBST(Util.generateBST()));
		System.out.println(t.isValidBSTRecursive(Util.generateBST()));
		System.out.println(t.isValidBST(Util.generateWrongBST()));
		System.out.println(t.isValidBSTRecursive(Util.generateWrongBST()));
	}
}
