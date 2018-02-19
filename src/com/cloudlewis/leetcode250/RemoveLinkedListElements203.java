package com.cloudlewis.leetcode250;

import com.cloudlewis.leetcode.common.ListNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * @formatter:off
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * 
 * @formatter:on
 * @author xiao
 *
 */
public class RemoveLinkedListElements203 {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode curr = dummy;
		while(curr != null) {
			if (curr.next != null && curr.next.val != val) {
				curr = curr.next;
				continue;
			}
			// curr.next is the one to be removed or is null
			ListNode prev = curr;
			while(curr.next != null && curr.next.val == val)
				curr = curr.next;
			// stop when curr.next = null or curr.next.val is not the val
			prev.next = curr.next;
			curr = curr.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		RemoveLinkedListElements203 t= new RemoveLinkedListElements203();
		ListNode n66 = new ListNode(6);
		ListNode n5 = new ListNode(5, n66);
		ListNode n4 = new ListNode(4, n5);
		ListNode n3 = new ListNode(3, n4);
		ListNode n6 = new ListNode(6, n3);
		ListNode n2 = new ListNode(2, n6);
		ListNode root = new ListNode(1, n2);
		ListNode head = t.removeElements(root, 6);
		Util.printListNode(head);
	}
}
