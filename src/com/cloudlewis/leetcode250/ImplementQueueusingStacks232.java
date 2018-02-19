package com.cloudlewis.leetcode250;

import java.util.Stack;

/**
 * @formatter:off
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue. 
 * pop() -- Removes the element from in front of queue. 
 * peek() -- Get the front element. 
 * empty() -- Return whether the queue is empty. 
 * 
 * Notes: 
 * You must use only standard operations of a stack -- which means 
 * only push to top, peek/pop from top, size, and is empty operations are valid. 
 * 
 * Depending on your language, stack may not be supported
 * natively. You may simulate a stack by using a list or deque (double-ended
 * queue), as long as you use only standard operations of a stack. 
 * 
 * You may assume that all operations are valid (for example, no pop or peek operations
 * will be called on an empty queue).
 * 
 * @formatter:on
 * @author xiao
 *
 */
public class ImplementQueueusingStacks232 {
	Stack<Integer> s1;
	Stack<Integer> s2;

	public ImplementQueueusingStacks232() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		s1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		peek();
		return s2.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty())
				s2.push(s1.pop());
		}
		return s2.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return s1.isEmpty() && s2.isEmpty();
	}
}
