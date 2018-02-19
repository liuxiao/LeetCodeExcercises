package com.cloudlewis.leetcode50;

import com.cloudlewis.leetcode.common.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * @author xiao
 *
 */

// doing in pairs, so should be even number ideally
// can ask if it is the assumption
// can handle for every two steps, save the parent, i.e. prev of the pair
// special handling the first
// 1, 2, 3, 4

// !!!! IMPORTANT TO USE a dummay node to de-special the first node

public class SwapNodesinPairs24 {
	public ListNode swapPairs(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return head;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode curr = dummy, par = dummy, tmp;
		curr = curr.next;
		
		// next one is not null, if next.next is null, leave next as it is
		while(curr != null && curr.next != null) {  // 3, 4
			tmp = curr.next.next; // 4's next
			curr.next.next = curr; // point 4's next to 3
			par.next = curr.next;
			curr.next = tmp;
			par = curr;
			curr = curr.next; // point to 4's next
		}
		
		return dummy.next;
	}
	
	public void test() {
		ListNode n4 = new ListNode(4);
		ListNode n3 = new ListNode(3, n4);
		ListNode n2 = new ListNode(2, n3);
		ListNode n1 = new ListNode(1, n2);
		
		ListNode newhead = swapPairs(n1);
		
		while(newhead != null) {
			System.out.print(newhead.val + " ");
			System.out.println();
			newhead = newhead.next;
		}
	}
	
	public static void main(String[] args) {
		SwapNodesinPairs24 t = new SwapNodesinPairs24();
		t.test();
	}
}
