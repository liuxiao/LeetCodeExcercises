package com.cloudlewis.leetcode250;

import java.util.ArrayList;
import java.util.List;

import com.cloudlewis.leetcode.common.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Could you do it in O(n) time and O(1) space?
 * 
 * @author xiao
 *
 */

/*
 * easy to do it with O(n) space, traverse and save then into arraylist and two
 * pointer to compare
 * 
 * if we want it to be O(1) space, we cannot copy nor reverse the list, it cost
 * O(n) space, unless we could manipulate structure
 * 
 * without changing strucutre of ListNode to have a reverse pointer, it is
 * impossible to use O(1) space
 * 
 */
public class PalindromeLinkedList234 {
	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;
		List<ListNode> nodes = new ArrayList<>();
		while(head != null) {
			nodes.add(head);
			head = head.next;
		}
		int i = 0, j = nodes.size()- 1;
		while( i < j) {
			if (nodes.get(i).val != nodes.get(j).val)
				return false;
			i++;
			j--;
		}
		return true;
	}
}
