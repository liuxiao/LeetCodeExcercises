package com.cloudlewis.leetcode50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cloudlewis.leetcode.common.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * @author xiao
 *
 */

// solution 1 can call merge two sorted list, untill it merges into one;
// complexity O(log(n)*m)

public class MergekSortedLists32 {
	MergeTwoSortedLists21 sorter = new MergeTwoSortedLists21();

	public ListNode mergeKLists(ListNode[] lists) {
		List<ListNode> newlist = new ArrayList<>(Arrays.asList(lists));
		List<ListNode> tmp = new ArrayList<>();
		while (newlist.size() > 1) {
			for (int i = 0; i < newlist.size(); i += 2) {
				if (i + 1 < newlist.size())
					tmp.add(sorter.mergeTwoLists(newlist.get(i), newlist.get(i + 1)));
				else
					tmp.add(newlist.get(i));
			}
			newlist.clear();
			newlist.addAll(tmp);
			tmp.clear();
		}
		return newlist.get(0);
	}
	
	private void test() {
		ListNode n5 = new ListNode(5);
		ListNode n3 = new ListNode(3, n5);
		ListNode n1 = new ListNode(1, n3);
		
		ListNode n4 = new ListNode(4);
		ListNode n2 = new ListNode(2, n4);
		ListNode n11 = new ListNode(1, n2);
		
		ListNode n6 = new ListNode(6);
		ListNode n0 = new ListNode(0, n6);
		
		ListNode[] arr = new ListNode[] {n0, n11, n1};
		ListNode a = mergeKLists(arr);
		
		while(a != null) {
			System.out.print(a.val + " ");
			System.out.println();
			a= a.next;
		}
		
		
	}
	
	public static void main(String[] args) {
		MergekSortedLists32 t = new MergekSortedLists32();
		t.test();
	}
}
