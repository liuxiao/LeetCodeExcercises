package com.cloudlewis.leetcode50;

import com.cloudlewis.leetcode.common.ListNode;

/**
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes in
 * the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * @author xiao
 *
 */

public class ReverseNodesinkGroup25 {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head;
		int count = 0;
		while (curr != null && count != k) { // find next k+1 node
			curr = curr.next;
			count++;
		}
		if (count == k) { // if k+1 node is found, do reverse
			curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
			// head - head-pointer to direct part
			// curr - head-pointer to reversed part;
			// reverse current k-group, similar concept to reserve below
			while (count-- > 0) {
				// tmp - next head in direct part
				ListNode tmp = head.next;
				// preappending "direct" head to the reversed list
				head.next = curr;
				// move head of reversed part to a new node
				curr = head;
				// move "direct" head to the next node in direct part
				head = tmp;
			}
			head = curr;
		}
		return head;
	}

	public ListNode reverseInPlace(ListNode head) {
		return reverseInPlace(head, null);
	}

	public ListNode reverseInPlace(ListNode head, ListNode stop) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode prev = head, curr = head.next, tmp; // head is not null
		prev.next = null;
		while (curr != stop) {
			tmp = curr.next;
			curr.next = prev;
			prev = curr;
			if (tmp == stop)
				break;
			curr = tmp;
		}
		return curr;
	}

	public static void main(String[] args) {
		ReverseNodesinkGroup25 t = new ReverseNodesinkGroup25();

		ListNode n5 = new ListNode(5);
		ListNode n4 = new ListNode(4, n5);
		ListNode n3 = new ListNode(3, n4);
		ListNode n2 = new ListNode(2, n3);
		ListNode n1 = new ListNode(1, n2);

		// ListNode nh = t.reverseInPlace(n1);

		// while (nh != null) {
		// System.out.print(nh.val + " ");
		// nh = nh.next;
		// }

		ListNode nh = t.reverseKGroup(n1, 2);
		while (nh != null) {
			System.out.print(nh.val + " ");
			nh = nh.next;
		}
	}
}
