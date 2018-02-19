package com.cloudlewis.leetcode150;

import com.cloudlewis.leetcode.common.TreeLinkNode;

/**
 * 
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution
 * still work?
 * 
 * Note:
 * 
 * You may only use constant extra space. For example, Given the following
 * binary tree,
 * 
 * 
 * 
 * 
 * @author xiao
 *
 */

// !!! REVISIT

/*
 * @formatter:off
 * #116 is a generic solution, will apply too !! But if it is not a perfect
 * tree, we need to modify the algorithm
 * 
 * 3 cases: 
 * 1) if left is null, not need to connect
 * 2) if right is null, not need to connect
 * 3) if prev.next.left == null, try prev.next.right; if both null, prev = prev.next, and keep trying
 * 
 *  @formatter:on
 */

public class PopulatingNextRightPointersinEachNodeII117 {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode curr = root, prev = null, head = null;
		while (curr != null) { // big loop
			while (curr != null) { // loop each level
				if (curr.left != null) {
					if (prev == null)
						head = curr.left;
					else
						prev.next = curr.left;
					prev = curr.left;
				}
				if (curr.right != null) {
					if (prev == null)
						head = curr.right;
					else
						prev.next = curr.right;
					prev = curr.right;
				}

				curr = curr.next; // move to the next on same level
			}
			// should move to next level
			curr = head; // where we set it to either curr.left/right
			head = null;
			prev = null;
		}
	}

	// !!!! Good solution
	public void connectWithDummyHead(TreeLinkNode root) {
		TreeLinkNode dummyHead = new TreeLinkNode(0);
		TreeLinkNode pre = dummyHead;
		while (root != null) {
			if (root.left != null) {
				pre.next = root.left;
				pre = pre.next;
			}
			if (root.right != null) {
				pre.next = root.right;
				pre = pre.next;
			}
			root = root.next;
			if (root == null) {
				pre = dummyHead;
				root = dummyHead.next;
				dummyHead.next = null;
			}
		}
	}

	public static void main(String[] args) {
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n7 = new TreeLinkNode(7);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n7;

		PopulatingNextRightPointersinEachNodeII117 t = new PopulatingNextRightPointersinEachNodeII117();
		t.connect(n2);
		System.out.println(n2);
	}

}
