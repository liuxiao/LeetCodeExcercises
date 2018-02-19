package com.cloudlewis.leetcode150;

import com.cloudlewis.leetcode.common.ListNode;

/**
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @author xiao
 *
 */

// Solution 1. quick idea is easy to use a Map to store the data
// Solution 2. if there is a cycle, let one node run faster, and it will
// eventually catch

public class LinkedListCycle141 {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			head = head.next;
			fast = fast.next.next;
			if (head == fast)
				return true;
		}
		return false;
	}
}
