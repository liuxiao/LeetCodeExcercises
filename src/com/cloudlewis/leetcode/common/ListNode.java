package com.cloudlewis.leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode jump;

    public ListNode(int x) {
        val = x;
    }
    
    public ListNode(int x, ListNode n) {
        val = x;
        next = n;
    }
    
    @Override
    public String toString() {
    	return "" + val;
    }
}
