package com.cloudlewis.leetcode150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * 
 * @formatter:off 
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * return its zigzag level order traversal as:
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
 *
 * @formatter:on
 * @author xiao
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> lvl = new ArrayList<>();
		if (root == null)
			return lvl;
		LinkedList<TreeNode> q = new LinkedList<>();
		q.add(root);
		int level = 0;
		while (!q.isEmpty()) {
			int num = q.size();
			List<Integer> arr = new ArrayList<>();
			for (int i = 0; i < num; i++) {
				TreeNode node;
				node = q.poll();
				if (level % 2 == 0)
					arr.add(node.val);
				else
					arr.add(0, node.val);
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			level ++;
			lvl.add(arr);
		}
		return lvl;
	}
	
	public static void main(String [] args) {
		BinaryTreeZigzagLevelOrderTraversal103 t = new BinaryTreeZigzagLevelOrderTraversal103();
		System.out.println(t.zigzagLevelOrder(Util.generateBST()));
	}
}
