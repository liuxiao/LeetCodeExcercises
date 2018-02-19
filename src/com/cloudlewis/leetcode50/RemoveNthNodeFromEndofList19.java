package com.cloudlewis.leetcode50;

import com.cloudlewis.leetcode.common.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one pass.
 * 
 * 
 * @author xiao
 *
 */

// asking to remove the first one?
// to find the n's node from back in one pass, keep two pointers, with n steps
// apart

public class RemoveNthNodeFromEndofList19 {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;

		ListNode curr = head;
		ListNode parent = head;

		while (n > 0) {
			curr = curr.next;
			n--;
		}

		if (curr == null) // special case, remove first one
			return head.next;

		while (curr.next != null) {
			curr = curr.next;
			parent = parent.next;
		}

		ListNode child = parent.next.next;
		parent.next = child;

		return head;

	}

	public void test() {
		ListNode n5 = new ListNode(5);
		ListNode n4 = new ListNode(4, n5);
		ListNode n3 = new ListNode(3, n4);
		ListNode n2 = new ListNode(2, n3);
		ListNode n1 = new ListNode(1, n2);

		ListNode nh = removeNthFromEnd(n1, 5);

		while (nh != null) {
			System.out.print(nh.val + " ");
			nh = nh.next;
		}

	}

	public static void main(String[] args) {
		RemoveNthNodeFromEndofList19 t = new RemoveNthNodeFromEndofList19();
		t.test();
	}
}
