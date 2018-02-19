package com.cloudlewis.leetcode200;

import java.util.Stack;

/**
 * @formatter: off 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * @author xiao
 * @formatter:on
 */

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 * 
 * 
 */

// !!! GOOD Design!!!

// @formatter:off
// asking what is the runtime requirement; if trade off needed, better write or better pop
// asking is getMin pop the data out or no
//
// solution 1, can have two stacks, one pointer to keep minimum, and move data around, all might have O(n)
// solution 2, have a query structure, push with O(logN) runtime, remove and pop with O(1)
// solution 3, to store the diff in the stack instead of actual value
//             https://discuss.leetcode.com/topic/4953/share-my-java-solution-with-only-one-stack/2
// @formatter:on

public class MinStack155 {
	/** initialize your data structure here. */
	int min = Integer.MAX_VALUE;
	Stack<Integer> stack = new Stack<Integer>();

	public MinStack155() {

	}

	public void push(int x) {
		// only push the old minimum value when the current
		// minimum value changes after pushing the new value x
		if (x <= min) {
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}

	public void pop() {
		// if pop operation could result in the changing of the current minimum
		// value,
		// pop twice and change the current minimum value to the last minimum
		// value.
		if (stack.pop() == min)
			min = stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}
}
