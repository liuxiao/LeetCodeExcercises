package com.cloudlewis.leetcode100;

import com.cloudlewis.leetcode.common.ListNode;
import com.cloudlewis.leetcode.common.Util;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 * @author xiao
 *
 */

// k might be bigger than the size of the list

public class RotateList61 {
	public ListNode rotateRight(ListNode head, int k) {
		if (k == 0 || head == null) // !!! MISSED  TRICKY!
			return head;
		ListNode cur = head;
		int sum = 0;
		while (cur != null) {
			cur = cur.next;
			sum++;
		}
		
		if (sum == 1) // !!! MISSED  TRICKY!
			return head;
		
		if ( sum <= k) // !!! MISSED EQUAL TRICKY!! if no equal, failed(NPE) on same length
			k = k % sum;
		
		if (k == 0) // no need
			return head;
		
		cur = head;
		ListNode fast = head;
		while (k > 0){
			fast = fast.next;
			k --;
		}
		
		while(fast !=null && fast.next != null) {
			cur = cur.next;
			fast = fast.next; // stop at the last element
		}
		
		ListNode newhead = cur.next;
		cur.next = null;
		fast.next = head;
		
		return newhead;
	}
	
	public void test() {
		ListNode l2 = new ListNode(2);
		ListNode l1 = new ListNode(1, l2);
		
		Util.printListNode(rotateRight(l1, 2));
	}
	
	public void test1() {
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(4, l5);
		ListNode l3 = new ListNode(3, l4);
		ListNode l2 = new ListNode(2, l3);
		ListNode l1 = new ListNode(1, l2);
		
		Util.printListNode(rotateRight(l1, 9));
	}
	
	public void test2() {
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(4, l5);
		ListNode l3 = new ListNode(3, l4);
		ListNode l2 = new ListNode(2, l3);
		ListNode l1 = new ListNode(1, l2);
		
		Util.printListNode(rotateRight(l1, 5));
	}
	
	public static void main(String[] args) {
		RotateList61 t = new RotateList61();
		t.test();
		t.test1();
	}
}
