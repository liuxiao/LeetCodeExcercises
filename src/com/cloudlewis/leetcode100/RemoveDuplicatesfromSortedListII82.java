package com.cloudlewis.leetcode100;

import com.cloudlewis.leetcode.common.ListNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, 
 * 
 * @formatter:off
 * Given 1->2->3->3->4->4->5, return 1->2->5. 
 * Given 1->1->1->2->3,return 2->3.
 * @formatter:on
 * 
 * @author xiao
 *
 */

// what if all duplicates --> should return null

public class RemoveDuplicatesfromSortedListII82 {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode curr = head, parent = dummy; // must always the unique
		while( curr != null){
			// if i should remove myself
			if( curr.next != null && curr.val == curr.next.val){
				ListNode tmp = curr;
				while( curr != null && curr.val == tmp.val)
					curr = curr.next;
				// stop when curr is a different one
				if (curr == null)  // !!!! TRICKY POINT
					parent.next = curr;
			}
			else{
				parent.next = curr;
				parent = curr;
				curr = curr.next;	
			}
		}
		return dummy.next;
	}
	
	public void test() {
		ListNode n5 = new ListNode(3);
		ListNode n4 = new ListNode(2, n5);
		ListNode n3 = new ListNode(1, n4);
		ListNode n2 = new ListNode(1, n3);
		ListNode n1 = new ListNode(1, n2);
		ListNode h = deleteDuplicates(n1);
		Util.printListNode(h);
	}
	
	public void test1() {
		ListNode n7 = new ListNode(5);
		ListNode n6 = new ListNode(4, n7);
		ListNode n5 = new ListNode(4, n6);
		ListNode n4 = new ListNode(3, n5);
		ListNode n3 = new ListNode(3, n4);
		ListNode n2 = new ListNode(2, n3);
		ListNode n1 = new ListNode(1, n2);
		ListNode h = deleteDuplicates(n1);
		Util.printListNode(h);
	}
	
	public void test3() {
		ListNode n7 = new ListNode(1);
		ListNode n1 = new ListNode(1, n7);
		ListNode h = deleteDuplicates(n1);
		Util.printListNode(h);
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedListII82 t= new RemoveDuplicatesfromSortedListII82();
		t.test1();
		t.test();
		t.test3();
	}
}
