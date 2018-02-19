package com.cloudlewis.leetcode.facebook;

import com.cloudlewis.leetcode.common.ListNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * 
 * Consider a Singly Linked List, in addition to having a typical 'next'
 * pointer, it also has a 'jump' pointer. The 'jump' pointer points to some
 * random other Node on the linked list. The jump pointer can also be NULL
 * 
 * You are required to reverse the direction of all 'next' and 'jump' pointers.
 * Can you do this in O(1) space complexity?
 * 
 * @author xiao
 *
 */

/*
 * given jump pointer has no impact on tranvse the linked list, can we do it in
 * two pass? swap the jump pointer first, and then do a regular in place reverse
 * given O(1) space, will need to use iterative solution
 * 
 * issue might just be jump pointer has a loop
 * 
 * ASKING: what if multiple random pointer points to one node? one node cannot
 * point to multiple
 * 
 * two step:
 * 
 * 1) reverse linked list in place
 * 
 * 2) traverse linked list with new head(tail), if jump is not null, set a
 * marker node; check marker node before reverse to prevent loop
 * 
 */
public class ReversingLinkedListRandomPointer {
	public ListNode reverse(ListNode node) {
		ListNode tmp, curr = node, prev = null;
		while (curr != null) {
			tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
		}
		// here the prev is the new head
		curr = prev;
		node = prev;
		prev = null;
		ListNode icurr = curr;
		while (icurr != null) {
			curr = icurr;
			while (curr.jump != null
					&& (curr.next == null || (curr.next != null && curr.next.val != Integer.MIN_VALUE))) {
				// insert a dummy node after curr to prevent look again
				ListNode dummy = new ListNode(Integer.MIN_VALUE);
				dummy.next = curr.next;
				curr.next = dummy;
				// reverse jump
				tmp = curr.jump;
				curr.jump = prev;
				prev = curr;
				curr = tmp;
			}
			// complete the loop
			if (icurr == curr && prev != null) {
				curr.jump = prev;
				prev = null;
			}
			icurr = icurr.next;
		}
		curr = node;
		// remove all dummy nodes
		while (curr != null) {
			if (curr.next != null && curr.next.val == Integer.MIN_VALUE) {
				curr.next = curr.next.next;
			}
			curr = curr.next;
		}
		return node;
	}

	// one loop, with one alone node
	public void test1() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2, n1);
		ListNode n3 = new ListNode(3, n2);
		ListNode n4 = new ListNode(4, n3);
		ListNode n5 = new ListNode(5, n4);
		// jump
		n5.jump = n3;
		n3.jump = n1;
		n1.jump = n2;
		n2.jump = n5;

		Util.printListNode(n5);
		ListNode newhead = reverse(n5);
		Util.printListNode(newhead);
	}

	// two loops
	public void test2() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2, n1);
		ListNode n3 = new ListNode(3, n2);
		ListNode n4 = new ListNode(4, n3);
		ListNode n5 = new ListNode(5, n4);
		// jump
		n5.jump = n4;
		n4.jump = n3;
		n3.jump = n5;
		n1.jump = n2;
		n2.jump = n1;

		Util.printListNode(n5);
		ListNode newhead = reverse(n5);
		Util.printListNode(newhead);
	}

	public static void main(String[] args) {
		ReversingLinkedListRandomPointer t = new ReversingLinkedListRandomPointer();
		t.test1();
		System.out.println();
		t.test2();

	}
}
