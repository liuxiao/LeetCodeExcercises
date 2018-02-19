package com.cloudlewis.leetcode400;

import java.util.Random;

import com.cloudlewis.leetcode.common.ListNode;

/**
 * @formatter:off
 * Given a singly linked list, return a random node's value from the linked
 * list. Each node must have the same probability of being chosen.
 * 
 * Follow up: What if the linked list is extremely large and its length is
 * unknown to you? Could you solve this efficiently without using extra space?
 * 
 * Example:
 * 
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 * 
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should
 * have equal probability of returning. solution.getRandom();
 * 
 * 
 * @formatter:on
 * @author xiao
 *
 */


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */


// in general https://discuss.leetcode.com/topic/53753/brief-explanation-for-reservoir-sampling

public class LinkedListRandomNode382 {
	
	private ListNode head;
	private Random rand = new Random();
	
	/**
	 * @param head
	 *            The linked list's head. Note that the head is guaranteed to be
	 *            not null, so it contains at least one node.
	 */
	public LinkedListRandomNode382(ListNode head) {
		this.head = head;
	}

	/** Returns a random node's value. */
	public int getRandom() {
		ListNode curr = head;
		int rs = -1;
		int cnt = 0;
		while(curr != null) {
			cnt++;
			if( rand.nextInt(cnt) == 0)
				rs = curr.val;
			curr = curr.next;
		}
		return rs;
	}
	
	public static void main(String [] args) {
		ListNode n3 = new ListNode(3);
		ListNode n2 = new ListNode(2, n3);
		ListNode n1 = new ListNode(1, n2);
		LinkedListRandomNode382 t = new LinkedListRandomNode382(n1);
		System.out.println(t.getRandom());
	}
}
