package com.cloudlewis.leetcode150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * @formatter:off
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * return its bottom-up level order traversal as:
 * [
 *  [15,7],
 *  [9,20],
 *  [3]
 * ]
 * 
 * @formatter:on
 * @author xiao
 *
 */
public class BinaryTreeLevelOrderTraversalII107 {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> lvl = new ArrayList<>();
		if (root == null)
			return lvl;
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()) {
			int num = q.size();
			List<Integer> list = new ArrayList<>();
			for (int i=0; i < num; i++) {
				TreeNode node = q.poll();
				list.add(node.val);
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			lvl.add(0, list);
		}
		return lvl;
	}

	// just reverse list of quetion #102
	public List<List<Integer>> levelOrderBottomWithHack(TreeNode root) {
		BinaryTreeLevelOrderTraversal102 t = new BinaryTreeLevelOrderTraversal102();
		List<List<Integer>> list = t.levelOrder(root);
		List<List<Integer>> reverse = new ArrayList<>();
		for (int i= list.size() - 1; i>=0; i--)
			reverse.add(list.get(i));
		return reverse;
	}
	
	public static void main(String [] args) {
		BinaryTreeLevelOrderTraversalII107  t = new BinaryTreeLevelOrderTraversalII107();
		System.out.println(t.levelOrderBottom(Util.generateBST()));
	}
}
