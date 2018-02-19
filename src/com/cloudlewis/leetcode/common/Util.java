package com.cloudlewis.leetcode.common;

import java.util.List;

import com.cloudlewis.leetcode.basic.TreeTraversal;

public class Util {
	public static void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");
		System.out.println();
	}

	public static void printArrayArray(int[][] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++)
				System.out.print(nums[j][i]);
			System.out.println();
		}
	}

	public static void printListList(List<List<String>> list) {
		for (List<String> l : list)
			System.out.println(l);
		System.out.println();
	}

	public static void printListNode(ListNode head) {
		while (head != null) {
			System.out.print(head.val);
			if (head.jump != null)
				System.out.print("(" + head.jump.val +")");
			System.out.print(" ");
			head = head.next;
		}
		System.out.println();
	}

	public static void printTreeNodePreOrder(TreeNode node) {
		System.out.println((new TreeTraversal()).preOrderTraverseIterative(node));
	}

	public static void printListTreeNodePreOrder(List<TreeNode> nodes) {
		for (TreeNode node : nodes)
			System.out.println((new TreeTraversal()).preOrderTraverseIterative(node));
	}

	public static void printTreeNodeInOrder(TreeNode node) {
		System.out.println((new TreeTraversal()).inOrderTraverseIterative(node));
	}
	
	public static void printTreeNodePostOrder(TreeNode node) {
		System.out.println((new TreeTraversal()).postOrderTraverseRecursive(node));
	}

	public static void printListTreeNodeInOrder(List<TreeNode> nodes) {
		for (TreeNode node : nodes)
			System.out.println((new TreeTraversal()).inOrderTraverseIterative(node));
	}

	public static TreeNode generateWrongBST() {
		TreeNode root = new TreeNode(5);
		TreeNode n3 = new TreeNode(2);
		TreeNode n1 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n8 = new TreeNode(8);
		TreeNode n7 = new TreeNode(7);
		TreeNode n9 = new TreeNode(9);
		root.left = n3;
		root.right = n8;
		n3.left = n1;
		n3.right = n4;
		n8.left = n7;
		n8.right = n9;
		return root;
	}

	public static TreeNode generateBST() {
		TreeNode root = new TreeNode(5);
		TreeNode n3 = new TreeNode(3);
		TreeNode n1 = new TreeNode(1);
		TreeNode n4 = new TreeNode(4);
		TreeNode n8 = new TreeNode(8);
		TreeNode n7 = new TreeNode(7);
		TreeNode n9 = new TreeNode(9);
		root.left = n3;
		root.right = n8;
		n3.left = n1;
		n3.right = n4;
		n8.left = n7;
		n8.right = n9;
		return root;
	}
}
