package com.cloudlewis.leetcode100;

import com.cloudlewis.leetcode.common.ListNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * @author xiao
 *
 */

// multiple x exists? or single one?
// assume single one here, what if not exist?

// intuitive idea is to keep two points, so that scan list and assign them to two pointers
// need to take care of the re-link when hit the value node, or maybe not

public class PartitionList86 {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode left = new ListNode(0), lhead = left;
		ListNode right = new ListNode(0), rhead = right;
		ListNode curr = head;
			
		while(curr != null) {
			if (curr.val >= x) {
				right.next = curr;
				right = right.next;
			}
			else {
				left.next = curr;
				left = left.next;
			}
			curr = curr.next;
		}
		right.next = null;
		// concatenate three together
		left.next = rhead.next;
		return lhead.next;
	}
	
	public static void main(String[] args) {
		PartitionList86 t = new PartitionList86();
		//1->4->3->2->5->2
		ListNode n6 = new ListNode(2);
		ListNode n5 = new ListNode(5, n6);
		ListNode n4 = new ListNode(2, n5);
		ListNode n3 = new ListNode(3, n4);
		ListNode n2 = new ListNode(4, n3);
		ListNode n1 = new ListNode(1, n2);
		Util.printListNode(t.partition(n1, 3));
	}
}
