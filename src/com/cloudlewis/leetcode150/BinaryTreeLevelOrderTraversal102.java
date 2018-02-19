package com.cloudlewis.leetcode150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * @formatter:off
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * return its level order traversal as:
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 * @formatter:on
 * @author xiao
 *
 */
public class BinaryTreeLevelOrderTraversal102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> lvl = new ArrayList<>();
		if (root == null)
			return lvl;
		Queue<TreeNode> s = new ArrayDeque<>();
		Queue<TreeNode> tmp = new ArrayDeque<>();
		s.add(root);
		while (!s.isEmpty()) {
			List<Integer> arr = new ArrayList<>();
			while (!s.isEmpty()) {
				TreeNode node = s.poll();
				arr.add(node.val);
				if (node.left != null)
					tmp.add(node.left);
				if (node.right != null)
					tmp.add(node.right);
			}
			lvl.add(arr);
			s.clear();
			s.addAll(tmp);
			tmp.clear();
		}
		return lvl;
	}
	
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal102  t= new BinaryTreeLevelOrderTraversal102();
		System.out.println(t.levelOrder(Util.generateBST()));
	}
}
