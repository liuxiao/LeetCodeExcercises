package com.cloudlewis.leetcode150;

import java.util.Stack;

import com.cloudlewis.leetcode.common.ListNode;

/**
 * 
 * Given a singly linked list L: L0?L1?…?Ln-1?Ln, reorder it to:
 * L0?Ln?L1?Ln-1?L2?Ln-2?…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author xiao
 *
 */

// Solution 1. easy way is to have a stack and put everything even number into.
// then when reach end, start from beginning again, pop and relink
// a problem with odd vs even number; can we solve it with two stack? -YES

public class ReorderList143 {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		Stack<ListNode> s = new Stack<>();
		ListNode pt = head;
		while (pt != null) {
			s.push(pt);
			pt = pt.next;
		}

		pt = s.peek();
		while (head != pt) { // not collide yet
			ListNode tmp = head.next;
			ListNode nm1 = s.pop();
			if (tmp == nm1) {
				tmp.next = null;
				return; // !!!! MISSED, USED TO BE BREAK, which lead to head.next = null, break test2
			}
			head.next = nm1;
			nm1.next = tmp;
			head = tmp;
			pt = s.peek();
		}
		head.next = null; // !!! IMPORTANT, MISSED
	}

	public void test() {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		reorderList(n1);

		ListNode head = n1;
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();

	}

	public void test1() {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		reorderList(n1);

		ListNode head = n1;
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	public void test2() {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		reorderList(n1);

		ListNode head = n1;
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ReorderList143 t = new ReorderList143();
		t.test();
		t.test1();
		t.test2();
	}
}
