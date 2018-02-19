package com.cloudlewis.leetcode150;

import com.cloudlewis.leetcode.common.ListNode;

/**
 * 
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Note: Do not modify the linked list.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @author xiao
 *
 */

// Solution 1. similar to #141, where use a Map can easy done
// Solution 2. also similar has a faster pointer, somewhere they will collide
// collide point is not the loop start point

public class LinkedListCycleII142 {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) // if no cycle, fast will reach null first
				break;
		}
		if (fast == null || fast.next == null) // check why loop break; //!!
												// MISSED fast.next null check
			return null;
		// now it must be equal, and has a loop
		// move fast back to head;
		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
}
