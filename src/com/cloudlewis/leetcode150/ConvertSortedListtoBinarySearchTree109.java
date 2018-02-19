package com.cloudlewis.leetcode150;

import com.cloudlewis.leetcode.common.ListNode;
import com.cloudlewis.leetcode.common.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * @author xiao
 *
 */

// Solution 1.
// Stupid solution is to convert it into an arrylist and then use #108

// Solution 2.
// trick is always find the middle one and let recursive handle
public class ConvertSortedListtoBinarySearchTree109 {
	public TreeNode sortedListToBST(ListNode head) {
		return toTree(head, null);
	}
	
	private TreeNode toTree(ListNode head, ListNode tail) {
		if (head == tail)
			return null;
		ListNode fast = head, slow = head;
		while(fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		// fast is running twice faster, so left slow in the middle
		TreeNode node = new TreeNode(slow.val);
		node.left = toTree(head, slow);
		node.right = toTree(slow.next, tail);
		return node;
	}
}
