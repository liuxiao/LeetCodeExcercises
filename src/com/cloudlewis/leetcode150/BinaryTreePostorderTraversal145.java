package com.cloudlewis.leetcode150;

import java.util.ArrayList;
import java.util.List;

import com.cloudlewis.leetcode.common.TreeNode;

/**
 * @formatter:off
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example: 
 * 
 * Given binary tree {1,#,2,3},
 * 
 *  1
 *   \
 *    2
 *   /
 *  3
 * 
 * return [3,2,1].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @formatter:on
 * @author xiao
 *
 */

// practice morris one more time
// https://stackoverflow.com/questions/36384599/can-we-use-morris-traversal-for-postorder
// http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html


// below is not a complete solution
public class BinaryTreePostorderTraversal145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		//TODO:
		List<Integer> list = new ArrayList<>();
		TreeNode curr = root;
		while(curr != null) {
			if (curr.left == null) {
				list.add(curr.val);
				curr = curr.right;
			}
			else {
				TreeNode pre = curr.left;
				while(pre.right != null && pre.right != curr)
					pre = pre.right;
				if (pre.right == curr) {
					pre.right = null;
					curr = curr.right;
					
				}
				else {
					pre.right = curr;
					curr = curr.left;
				}
			}
		}
		return list;
	}
}
