package com.cloudlewis.leetcode100;

import java.util.List;

import com.cloudlewis.leetcode.basic.TreeTraversal;
import com.cloudlewis.leetcode.common.TreeNode;

/**
 * @formatter:off
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree [1,null,2,3],
 *   1
 *    \
 *     2
 *    /
 *   3
 * return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 * @formatter:on
 * @author xiao
 *
 */
public class BinaryTreeInorderTraversal94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		return (new TreeTraversal().inOrderTraverseIterative(root));
	}
}
