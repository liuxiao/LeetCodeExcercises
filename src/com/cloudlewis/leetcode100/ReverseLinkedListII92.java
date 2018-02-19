package com.cloudlewis.leetcode100;

import com.cloudlewis.leetcode.common.ListNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * @formatter:off
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ? m ? n ? length of list.
 *
 * @formatter:on
 * @author xiao
 *
 */

// Looks like to be traditional two pointer problem
// assume n > m always

// !!!! VERT TRICKY BOUNDARY CONDITION
// REVISIT


public class ReverseLinkedListII92 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if ( m == n) // not change
			return head;
		ListNode dummy = new ListNode(0), curr = dummy, left = null;
		dummy.next = head;
		while(m > 0) {
			left = curr;
			curr = curr.next;
			m--;
			n--;
		}
		// we can start reverse now
		ListNode prev = curr;
		curr = curr.next;
		while(n > 0) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			n--;
		}
		
		left.next.next = curr; // link 2 to 5
		left.next = prev; // link 1 to 4
		return dummy.next;
		
	}
	
	public void test() {
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(4, l5);
		ListNode l3 = new ListNode(3, l4);
		ListNode l2 = new ListNode(2, l3);
		ListNode l1 = new ListNode(1, l2);
		Util.printListNode(reverseBetween(l1, 2, 4));
	}
	
	public void test1() {
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(4, l5);
		ListNode l3 = new ListNode(3, l4);
		ListNode l2 = new ListNode(2, l3);
		ListNode l1 = new ListNode(1, l2);
		Util.printListNode(reverseBetween(l1, 1, 3));
	}
	
	public void test2() {
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(4, l5);
		ListNode l3 = new ListNode(3, l4);
		ListNode l2 = new ListNode(2, l3);
		ListNode l1 = new ListNode(1, l2);
		Util.printListNode(reverseBetween(l1, 1, 5));
	}
	
	public void test3() {
		ListNode l2 = new ListNode(2);
		ListNode l1 = new ListNode(1, l2);
		Util.printListNode(reverseBetween(l1, 1, 2));
	}
	
	public static void main(String [] args) {
		ReverseLinkedListII92 t = new ReverseLinkedListII92();
		t.test();
		t.test1();
		t.test2();
		t.test3();
		
	}
}
