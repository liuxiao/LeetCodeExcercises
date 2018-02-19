package com.cloudlewis.leetcode250;

import com.cloudlewis.leetcode.common.TreeNode;

/**
 * 
 * @formatter:off
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes v and w as the lowest node in T that has both v
 * and w as descendants (where we allow a node to be a descendant of itself).”
 * 
 * 
 *       _______3______
 *      /              \
 *   ___5__          ___1__
 *  /      \        /      \
 *  6      _2       0       8
 *        /  \
 *        7   4
 * 
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another
 * example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of
 * itself according to the LCA definition.
 * 
 * @formatter:on
 * @author xiao
 *
 */

// !!! REVISIT

public class LowestCommonAncestorofaBinaryTree236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}

	public void test() {
		TreeNode n7 = new TreeNode(7);
		TreeNode n4 = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		n2.left = n7;
		n2.right = n4;
		TreeNode n6 = new TreeNode(6);
		TreeNode n5 = new TreeNode(5);
		n5.left = n6;
		n5.right = n2;
		TreeNode n0 = new TreeNode(0);
		TreeNode n8 = new TreeNode(8);
		TreeNode n1 = new TreeNode(1);
		n1.left = n0;
		n1.right = n8;
		TreeNode n3 = new TreeNode(3);
		n3.left = n5;
		n3.right = n1;

		System.out.println(lowestCommonAncestor(n3, n5, n3).val);
		System.out.println(lowestCommonAncestor(n3, n5, n4).val);
		System.out.println(lowestCommonAncestor(n3, n7, n4).val);

	}

	private boolean treeContains(TreeNode node, TreeNode p) {
		if (node == null)
			return false;
		if (node.val == p.val)
			return true;
		return treeContains(node.left, p) || treeContains(node.right, p);
	}

	public static void main(String[] args) {
		LowestCommonAncestorofaBinaryTree236 t = new LowestCommonAncestorofaBinaryTree236();
		t.test();
	}

}
