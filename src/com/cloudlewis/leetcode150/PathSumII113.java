package com.cloudlewis.leetcode150;

import java.util.ArrayList;
import java.util.List;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 * 
 * @formatter:off
 * 
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \    / \
 *       7    2  5   1
 *
 * return
 * [
 *  [5,4,11,2],
 *  [5,8,4,5]
 * ]
 *
 * @formatter:on
 * @author xiao
 *
 */
public class PathSumII113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		path(root, sum, list, new ArrayList<Integer>());

		return list;
	}

	private void path(TreeNode node, int sum, List<List<Integer>> rs, List<Integer> path) {
		if (node == null)
			return;
		path.add(new Integer(node.val));
		if (node.left == null && node.right == null && sum == node.val) {
			rs.add(new ArrayList<>(path));
			path.remove(path.size() - 1); ///!!! TRICKY, we need to remove it when found!
			return;
		}
		path(node.left, sum - node.val, rs, path);
		path(node.right, sum - node.val, rs, path);
		path.remove(path.size() - 1); ///!!!
	}

	public void test() {
		TreeNode root = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		TreeNode n8 = new TreeNode(8);
		root.left = n4;
		root.right = n8;
		TreeNode n11 = new TreeNode(11);
		TreeNode n13 = new TreeNode(13);
		TreeNode n4s = new TreeNode(4);
		n4.left = n11;
		n8.left = n13;
		n8.right = n4s;
		TreeNode n7 = new TreeNode(7);
		TreeNode n2 = new TreeNode(2);
		TreeNode n5 = new TreeNode(5);
		TreeNode n1 = new TreeNode(1);
		n11.left = n7;
		n11.right = n2;
		n4s.left = n5;
		n4s.right = n1;

		Util.printTreeNodePreOrder(root);
		System.out.println(pathSum(root, 22));
	}

	public static void main(String[] args) {
		PathSumII113 t = new PathSumII113();
		t.test();
	}
}
