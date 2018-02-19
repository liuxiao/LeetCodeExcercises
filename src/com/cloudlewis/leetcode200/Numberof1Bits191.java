package com.cloudlewis.leetcode200;

/**
 * 
 * Write a function that takes an unsigned integer and returns the number of ’1'
 * bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ’11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 * 
 * @author xialiliu
 *
 */

// max O(32) alg?
// !!!!!
// In Java we need to put attention on the fact that the maximum integer is
// 2147483647. Integer type in Java is signed and there is no unsigned int. So
// the input 2147483648 is represented in Java as -2147483648 (in java int type
// has a cyclic representation, that means
// Integer.MAX_VALUE+1==Integer.MIN_VALUE).
// This force us to use
//
// n!=0
// in the while condition and we cannot use
//
// n>0
public class Numberof1Bits191 {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int sum = 0;
		while (n != 0) {
			sum += n & 0x1;
			n >>>= 1;
		}
		return sum;
	}

	public static void main(String[] args) {
		Numberof1Bits191 t = new Numberof1Bits191();
		System.out.print(t.hammingWeight(11));
	}
}