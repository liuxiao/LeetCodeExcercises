package com.cloudlewis.leetcode100;

import com.cloudlewis.leetcode.common.ListNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, 
 * @formatter:off
 * Given 1->1->2, return 1->2. 
 * Given 1->1->2->3->3, return 1->2->3.
 * @formatter:on
 * 
 * @author xiao
 *
 */
public class RemoveDuplicatesfromSortedList83 {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode curr = head;
		while( curr != null && curr.next != null){
			if (curr.val == curr.next.val)
				curr.next= curr.next.next;
			else
				curr = curr.next;
				
		}
		return head;
	}
	
	public void test() {
		ListNode n3 = new ListNode(2);
		ListNode n2 = new ListNode(1, n3);
		ListNode n1 = new ListNode(1, n2);
		ListNode h = deleteDuplicates(n1);
		Util.printListNode(h);
	}
	
	public void test1() {
		ListNode n5 = new ListNode(3);
		ListNode n4 = new ListNode(3, n5);
		ListNode n3 = new ListNode(2, n4);
		ListNode n2 = new ListNode(1, n3);
		ListNode n1 = new ListNode(1, n2);
		ListNode h = deleteDuplicates(n1);
		Util.printListNode(h);
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedList83 t = new RemoveDuplicatesfromSortedList83();
		t.test();
		t.test1();
		
	}
}
