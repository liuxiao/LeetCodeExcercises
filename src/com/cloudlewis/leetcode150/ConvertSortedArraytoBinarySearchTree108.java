package com.cloudlewis.leetcode150;

import com.cloudlewis.leetcode.common.TreeNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * 
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * @author xiao
 *
 */
public class ConvertSortedArraytoBinarySearchTree108 {
	public TreeNode sortedArrayToBST(int[] nums) {
		if ( nums.length == 0)
			return null;
		TreeNode  head = sortedArrayToBST(nums, 0, nums.length - 1);
		return head;
	}
	
	private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
		if (left > right)
			return null;
		int mid = left + (right - left) /2;
		TreeNode m = new TreeNode(nums[mid]);
		m.left = sortedArrayToBST(nums, left, mid - 1);
		m.right = sortedArrayToBST(nums, mid + 1, right);
		return m;
	}
	
	public static void main(String [] args) {
		int [] arr = new int[] {1,2,3,4,5,6,7,8};
		ConvertSortedArraytoBinarySearchTree108 t = new ConvertSortedArraytoBinarySearchTree108();
		Util.printTreeNodePreOrder(t.sortedArrayToBST(arr));
	}
}
