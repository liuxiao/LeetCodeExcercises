package com.cloudlewis.leetcode200;

import java.util.Stack;

import com.cloudlewis.leetcode.common.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * @author xiao
 *
 */

/*
 * next smallest then should be inorder travese if we need O(1) retriveal, then
 * we need to know
 * 
 * it emphasis on average O(1), so first time
 */
public class BinarySearchTreeIterator173 {

	private Stack<TreeNode> s;

	/**
	 * @formatter:off
	 * Your BSTIterator will be called like this:
	 * BSTIterator i = new BSTIterator(root);
	 * while (i.hasNext()) v[f()] = i.next();
	 * @formatter:on
	 */
	public BinarySearchTreeIterator173(TreeNode root) {
		this.s = new Stack<>();
		pushAllLeftNode(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !s.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = s.pop();
		pushAllLeftNode(node.right);
		return node.val;
	}

	private void pushAllLeftNode(TreeNode node) {
		for (; node != null; s.push(node), node = node.left)
			;
	}
}
