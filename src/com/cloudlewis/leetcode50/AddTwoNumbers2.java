package com.cloudlewis.leetcode50;

import com.cloudlewis.leetcode.common.ListNode;

/**
 * 
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 *
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }
 */

// stored in the reverse order, use single bit for carry;
// scan both list at the same time, till exhaust both list and carry bit;
// O(n), and space is O(n) to store data

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return null;
        ListNode rs = null;
        ListNode root = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int value = carry;
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            carry = value / 10;
            if (root == null) {
                root = new ListNode(value % 10);
                rs = root;
            } else {
                rs.next = new ListNode(value % 10);
                rs = rs.next;
            }
        }
        return root;
    }
}
