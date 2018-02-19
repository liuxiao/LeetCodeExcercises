package com.cloudlewis.leetcode300;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.cloudlewis.leetcode.common.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, find k values in the
 * BST that are closest to the target.
 * 
 * @author xiao
 *
 */

/* @formatter:off
 * Solution 1
 * stupid way is to do a in-order tree travese; which converted to a array problem
 * 
 * Solution 1.1
 * run in-order traverse to get predecessor, and reverse to get successor
 * then pick and compare from these two collection
 * 
 * Solution 2
 * use a maxheap, to store the diff with same of k.
 * use a map to store diff to a list of values
 * and there might be a case of tie
 * 
 * O(logN * N)
 * 
 * @formatter:on
 */
public class ClosestBinarySearchTreeValueII272 {

	// implementation of 1.1
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> rs = new ArrayList<>();
		Stack<Integer> s1 = new Stack<>(); // predecessor
		Stack<Integer> s2 = new Stack<>(); // sucecssor

		inorder(root, target, false, s1);
		inorder(root, target, true, s2);
		
		while(k-- > 0) {
			if (s1.isEmpty())
				rs.add(s2.pop());
			else if (s2.isEmpty())
				rs.add(s1.pop());
			else {
				if (Math.abs(target - s1.peek()) < Math.abs(target - s2.peek()))
					rs.add(s1.pop());
				else
					rs.add(s2.pop());
			}
		}
		return rs;
	}

	private void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
		if (root == null)
			return;

		inorder(reverse ? root.right : root.left, target, reverse, stack);
		// early terminate, no need to traverse the whole tree
		if ((reverse && root.val <= target) || (!reverse && root.val > target))
			return;
		// track the value of current node
		stack.push(root.val);
		inorder(reverse ? root.left : root.right, target, reverse, stack);
	}
}
