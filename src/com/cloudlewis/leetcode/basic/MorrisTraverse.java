package com.cloudlewis.leetcode.basic;

import java.util.ArrayList;
import java.util.List;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * 
 * https://en.wikipedia.org/wiki/Threaded_binary_tree
 * 
 * http://www.geeksforgeeks.org/morris-traversal-for-preorder/
 * 
 * @author xiao
 *
 */
public class MorrisTraverse {
	/**
	 * @formatter:off
	 * 1. Initialize current as root 
	 * 2. While current is not NULL 
	 *    If current does not have left child 
	 *       a) Print current’s data 
	 *       b) Go to the right, i.e., current = current->right 
	 *    Else 
	 *       a) Make current as right child of the rightmost node in current's left subtree 
	 *       b) Go to this left child, i.e.current = current->left
	 * 
	 * @param node
	 * 
	 * @formatter:on
	 */
	public static List<TreeNode> inOrderTraverse(TreeNode node) {
		List<TreeNode> list = new ArrayList<>();
		TreeNode curr = node;
		if (curr == null)
			return list;
		while (curr != null) {
			if (curr.left == null) {
				list.add(curr);
				curr = curr.right;
			} else {
				// inorder predecessor of current
				TreeNode pre = curr.left;
				while (pre.right != null && pre.right != curr)
					pre = pre.right;
				// Make current as right child of its inorder predecessor
				if (pre.right == null) {
					pre.right = curr;
					curr = curr.left;
				} else { // revert back the change
					pre.right = null;
					list.add(curr);
					curr = curr.right;
				}
			}
		}
		return list;
	}

	/**
	 * @formatter:off
	 * 1. If left child is null
	 *       print the current node data. 
	 *       Move to right child.
	 *    Else
	 *       Make the right child of the inorder predecessor point to the current node. 
	 *       Two cases arise: 
     *           a) The right child of the inorder predecessor already points to the current node. 
     *              Set right child to NULL.
	 *              Move to right child of current node
	 *           b) The right child is NULL. 
	 *              Set it to current node. 
	 *              Print current node’s data and move to left child of current node. 
	 * 2. Iterate until current node is not NULL.
	 * 
	 * 
	 * @formatter:on
	 * @param node
	 * @return
	 */
	public static List<TreeNode> preOrderTraverse(TreeNode node) {
		List<TreeNode> list = new ArrayList<>();
		TreeNode curr = node;
		if (curr == null)
			return list;
		while( curr != null) {
			if (curr.left == null) {
				list.add(curr);
				curr = curr.right;
			}
			else {
				TreeNode pre = curr.left;
				while(pre.right != null && pre.right != curr)
					pre = pre.right;
				if (pre.right == null) {
					list.add(curr);
					pre.right = curr;
					curr = curr.left;
				}
				else {
					pre.right = null;
					curr = curr.right;
				}
					
			}
		}
		return list;
	}

	public static void main(String[] args) {
		List<TreeNode> nodes = MorrisTraverse.inOrderTraverse(Util.generateBST());
		for (TreeNode n : nodes)
			System.out.print(n.val + " ");
		System.out.println();
		Util.printTreeNodeInOrder(Util.generateBST());
		
		nodes = MorrisTraverse.preOrderTraverse(Util.generateBST());
		for (TreeNode n : nodes)
			System.out.print(n.val + " ");
		System.out.println();
		Util.printTreeNodePreOrder(Util.generateBST());
	}
}
