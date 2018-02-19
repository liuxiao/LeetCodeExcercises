package com.cloudlewis.leetcode50;

import com.cloudlewis.leetcode.common.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * 
 * @author xiao
 *
 */
public class MergeTwoSortedLists21 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head, curr;
		if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		else {
			if (l1.val > l2.val) {
				head = l2;
				l2 = l2.next;
			}
			else {
				head = l1;
				l1 = l1.next;
			}
			curr = head;
			while ( l1 != null || l2 != null) { // start from new node
				if (l1 !=null && l2 != null) {
					if (l1.val > l2.val) {
						curr.next = l2;
						l2 = l2.next;
					}
					else {
						curr.next = l1;
						l1 = l1.next;
					}
					curr = curr.next;
				}
				else if (l1 != null) { // when l2 is null
					curr.next = l1;
					break;
				}
				else {
					curr.next = l2;
					break;
				}	
			}
		}
		return head;
	}
	
	public void test() {
		ListNode n5 = new ListNode(5);
		ListNode n3 = new ListNode(3, n5);
		ListNode n1 = new ListNode(1, n3);
		
		ListNode n6 = new ListNode(6);
		ListNode n4 = new ListNode(4, n6);
		ListNode n2 = new ListNode(2, n4);
		
		ListNode head = mergeTwoLists(n1, n2);
		while(head != null) {
			System.out.print(head.val + "" );
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MergeTwoSortedLists21 t = new MergeTwoSortedLists21();
		t.test();
	}
}
