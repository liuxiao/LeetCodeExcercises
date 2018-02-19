package com.cloudlewis.leetcode250;

import com.cloudlewis.leetcode.common.TreeNode;

/**
 * 
 * @formatter:off
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of
 * two given nodes in the BST.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes v and w as the lowest node in T that has both v
 * and w as descendants (where we allow a node to be a descendant of itself).”
 * 
 *         _______6______
 *       /              \
 *   ___2__          ___8__
 *  /      \        /      \
 *  0      _4       7       9
 *        /  \
 *        3   5
 * 
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another
 * example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of
 * itself according to the LCA definition.
 * 
 * @formatter:on
 * @author xiao
 *
 */

/*
 * check should just stop where they are on the same of t he subtree
 */
public class LowestCommonAncestorofaBinarySearchTree235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while ((root.val - p.val) * (root.val - q.val) > 0)
			root = p.val < root.val ? root.left : root.right;
		return root;
	}

	public void test() {
		TreeNode n5 = new TreeNode(5);
		TreeNode n3 = new TreeNode(3);
		TreeNode n0 = new TreeNode(0);
		TreeNode n4 = new TreeNode(4);
		n4.left = n3;
		n4.right = n5;
		TreeNode n2 = new TreeNode(2);
		n2.left = n0;
		n2.right = n4;
		TreeNode n7 = new TreeNode(7);
		TreeNode n9 = new TreeNode(9);
		TreeNode n8 = new TreeNode(8);
		n8.left = n7;
		n8.right = n9;
		TreeNode n6 = new TreeNode(6);
		n6.left = n2;
		n6.right = n8;

		System.out.println(lowestCommonAncestor(n6, n2, n8).val);
		System.out.println(lowestCommonAncestor(n6, n2, n4).val);
		System.out.println(lowestCommonAncestor(n6, n3, n5).val);

	}

	public static void main(String[] args) {
		LowestCommonAncestorofaBinarySearchTree235 t = new LowestCommonAncestorofaBinarySearchTree235();
		t.test();
	}
}
