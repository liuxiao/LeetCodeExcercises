package com.cloudlewis.leetcode150;

import com.cloudlewis.leetcode.common.ListNode;

/**
 * 
 * Sort a linked list using insertion sort.
 * 
 * @author xiao
 *
 */

// listnode has no link to trace backward, which is problematic.
// ideally, could instaniate the class to have a backward pointer;

// without changing the class, we need to scan from head everytime
// because we might insert into the first node, so we create a dummy node;
public class InsertionSortList147 {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		while (head != null) {
			if (head.next != null && head.next.val < head.val)
				insert(dummy, head, head.next);
			else
				head = head.next;
		}
		return dummy.next;
	}

	private void insert(ListNode head, ListNode prev, ListNode node) {
		prev.next = node.next; // short cut the node
		ListNode curr = head;
		while (curr != null && curr.next != null) {
			if (curr.val <= node.val && curr.next.val >= node.val)
				break;
			curr = curr.next;
		}
		ListNode tmp = curr.next;// relink
		curr.next = node;
		node.next = tmp;
	}

	public void test() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n2.next = n1;
		n1.next = n4;
		n4.next = n3;

		ListNode h = insertionSortList(n2);
		while (h != null) {
			System.out.print(h.val + " ");
			h = h.next;
		}
		System.out.println();
	}

	public void test1() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n2.next = n1;

		ListNode h = insertionSortList(n2);
		while (h != null) {
			System.out.print(h.val + " ");
			h = h.next;
		}
		System.out.println();
	}

	public void test2() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n4.next = n3;
		n3.next = n2;
		n2.next = n1;

		ListNode h = insertionSortList(n4);
		while (h != null) {
			System.out.print(h.val + " ");
			h = h.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		InsertionSortList147 t = new InsertionSortList147();
		t.test();
		t.test1();
		t.test2();
	}
}
