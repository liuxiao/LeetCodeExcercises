package com.cloudlewis.leetcode.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

public class TreeTraversal {

	public List<Integer> preOrderTraverseIterative(TreeNode node) {
		List<Integer> rs = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (node != null || !s.isEmpty()) {
			while (node != null) {
				rs.add(node.val);
				s.push(node);
				node = node.left;
			}
			node = s.pop();
			node = node.right;
		}
		return rs;
	}
	
	public List<Integer> postOrderTraverseRecursive(TreeNode node) {
		List<Integer> rs = new ArrayList<Integer>();
		postOrderTraverseRecursive(node, rs);
		return rs;
	}
	
	private void postOrderTraverseRecursive(TreeNode node, List<Integer> arr) {
		if (node == null)
			return;
		postOrderTraverseRecursive(node.left, arr);
		postOrderTraverseRecursive(node.right, arr);
		arr.add(node.val);
	}

	public List<Integer> inOrderTraveseRecursive(TreeNode node) {
		List<Integer> arr = new ArrayList<Integer>();
		inOrderTraveseRecursive(node, arr);
		return arr;
	}

	private void inOrderTraveseRecursive(TreeNode node, List<Integer> arr) {
		if (node == null)
			return;
		inOrderTraveseRecursive(node.left, arr);
		arr.add(node.val);
		inOrderTraveseRecursive(node.right, arr);
	}

	public List<Integer> inOrderTraverseIterative(TreeNode node) {
		List<Integer> arr = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<>();
		while (node != null || !s.isEmpty()) {
			while (node != null) {
				s.push(node);
				node = node.left;
			}
			node = s.pop();
			arr.add(node.val);
			node = node.right;
		}
		return arr;
	}

	public static void main(String[] agrs) {
		TreeTraversal t = new TreeTraversal();
		System.out.println(t.inOrderTraveseRecursive(Util.generateBST()));
		System.out.println(t.inOrderTraverseIterative(Util.generateBST()));
		System.out.println(t.preOrderTraverseIterative(Util.generateBST()));
	}
}
