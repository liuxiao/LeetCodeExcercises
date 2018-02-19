package com.cloudlewis.leetcode150;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * 
 * @formatter:off
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 *    1
 *   / \
 *  2   3
 * 
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 * @formatter:on
 * @author xiao
 *
 */

/*
 * asking what if root == null?
 * 
 * this looks like to be a pre-order traverse problem; passing in a global sum
 * variable and path of node values
 * 
 */
public class SumRoottoLeafNumbers129 {
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		int sum[] = new int[1];
		getSum(root, new StringBuilder(), sum);
		return sum[0];
	}

	private void getSum(TreeNode root, StringBuilder path, int[] sum) {
		if (root.left == null && root.right == null) { // find a value
			path.append(root.val);
			sum[0] += Integer.parseInt(path.toString());
		} else {
			if (root.left != null) {
				StringBuilder ns = new StringBuilder(path);
				ns.append(root.val);
				getSum(root.left, ns, sum);
			}
			if (root.right != null) {
				StringBuilder ns = new StringBuilder(path);
				ns.append(root.val);
				getSum(root.right, ns, sum);
			}
		}
	}
	
	public static void main(String []args) {
		SumRoottoLeafNumbers129 t = new SumRoottoLeafNumbers129();
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n5 = new TreeNode(5);
		n1.right = n5;
		System.out.println(t.sumNumbers(n1));
		
		
		System.out.println(t.sumNumbers(Util.generateBST()));
		

	}

}
