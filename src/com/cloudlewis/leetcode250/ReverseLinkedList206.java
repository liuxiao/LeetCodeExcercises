package com.cloudlewis.leetcode250;

import com.cloudlewis.leetcode.common.ListNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * Reverse a singly linked list.
 * 
 * click to show more hints.
 * 
 * Hint: A linked list can be reversed either iteratively or recursively. Could
 * you implement both?
 * 
 * #92
 * 
 * @author xiao
 *
 */
public class ReverseLinkedList206 {
	public ListNode reverseListRecursive(ListNode head) {
		if (head == null)
			return null;
		return reverse(head, null);
	}

	private ListNode reverse(ListNode node, ListNode prev) {
		ListNode next = node.next;
		if (next == null) {
			node.next = prev;
			return node; // the last
		}
		node.next = prev;
		return reverse(next, node);
	}

	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode curr = head, prev = null;
		while (curr != null) {
			ListNode tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
		}
		return prev;
	}

	public static void main(String[] args) {
		ReverseLinkedList206 t= new ReverseLinkedList206();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2, n1);
		ListNode n3 = new ListNode(3, n2);
		ListNode newnode = t.reverseListRecursive(n3);
		Util.printListNode(newnode);
		ListNode resnode = t.reverseList(newnode);
		Util.printListNode(resnode);
	}
}
