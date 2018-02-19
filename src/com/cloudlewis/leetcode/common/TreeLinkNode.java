package com.cloudlewis.leetcode.common;

public class TreeLinkNode {
	public TreeLinkNode left;
	public TreeLinkNode right;
	public TreeLinkNode next;
	public int val;
	
	public TreeLinkNode(int val)
	{
		this.val = val;
	}

	@Override
	public String toString() {
		return "TreeLinkNode [left=" + left + ", right=" + right + ", next=" + next + ", val=" + val + "]";
	}

	
}
