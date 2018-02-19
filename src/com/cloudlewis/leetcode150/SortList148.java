package com.cloudlewis.leetcode150;

import com.cloudlewis.leetcode.common.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * @author xiao
 *
 */

public class SortList148 {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode fast = head, prev = null, slow = head;
		// cut list in half
		while (fast != null && fast.next != null) {
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}
		prev.next = null;

		ListNode left = sortList(head);
		ListNode right = sortList(slow);

		return merge(left, right);
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0), curr = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		if (l1 != null)
			curr.next = l1;

		if (l2 != null)
			curr.next = l2;
		return dummy.next;

	}

}
