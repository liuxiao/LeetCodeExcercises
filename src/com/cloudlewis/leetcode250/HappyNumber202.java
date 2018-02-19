package com.cloudlewis.leetcode250;

import java.util.HashSet;
import java.util.Set;

/**
 * @formatter:off
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 
 * @formatter:on
 * @author xiao
 *
 */

// can keep calling this, but the problem is how to determine when it stops, or
// never stop, using hashset to track seen value

// another way to stop the loop is to have a faster node, and a slower node,
// like detection of loop in linked list
public class HappyNumber202 {
	public boolean isHappy(int n) {
		return isHappy(n, new HashSet<Integer>());
	}

	private boolean isHappy(int n, Set<Integer> prev) {
		int sum = 0;
		while (n > 0) {
			sum += Math.pow((n % 10), 2);
			n /= 10;
		}
		if (sum == 1)
			return true;
		if (prev.contains(sum))
			return false;
		prev.add(sum);
		return isHappy(sum, prev);
	}

	public static void main(String[] args) {
		HappyNumber202 t = new HappyNumber202();
		System.out.println(t.isHappy(19));
		System.out.println(t.isHappy(20));
	}
}
