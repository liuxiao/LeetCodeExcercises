package com.cloudlewis.leetcode150;

import com.cloudlewis.leetcode.common.TreeLinkNode;

/**
 * 
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space. You may assume that it is a perfect
 * binary tree (ie, all leaves are at the same level, and every parent has two
 * children). For example, Given the following perfect binary tree,
 * 
 * @formatter:off
 * 
 *        1
 *       /  \
 *      2    3
 *     / \  / \
 *    4  5  6  7
 *
 * After calling your function, the tree should look like:
 *
 *       1 -> NULL
 *      /  \
 *     2 -> 3 -> NULL
 *    / \  / \
 *   4->5->6->7 -> NULL
 * 
 * @formatter:on
 * @author xiao
 *
 */

/*
 * Solution 1. using a stack, easy, work on each level, but require O(n) space;
 * asking for constance space solution need to find another way
 * 
 * Solution 2. we need to keep track of parents, if two nodes points to the same
 * parent, then left -> right; if two nodes points to different parents, need to
 * go parent's parent, and then left to the same level
 * 
 * given data structure does not have parent pointer, can ask if we could add
 * one
 * 
 * we don't have to set NULL explicitly, because they by default is null
 * 
 */

public class PopulatingNextRightPointersinEachNode116 {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode curr = null, prev = root;
		while (prev.left != null) { // level by level
			curr = prev;
			while (curr != null) {
				curr.left.next = curr.right;
				if (curr.next != null)
					curr.right.next = curr.next.left;
				curr = curr.next;
			}
			prev = prev.left;
		}
	}
	
	public static void main(String[] args) {
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n3 = new TreeLinkNode(3);
		n2.left = n1;
		n2.right = n3;
		
		PopulatingNextRightPointersinEachNode116 t = new PopulatingNextRightPointersinEachNode116();
		t.connect(n2);
		System.out.println(n2);
	}
}
