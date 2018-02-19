package com.cloudlewis.leetcode200;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 * 
 * Follow up: If this function is called many times, how would you optimize it?
 * 
 * Related problem: Reverse Integer
 * 
 * @author xiao
 *
 */
// idea can be simple, bit operation to check every bit and push into stack
// pop the stack to form a new number, this will cause O(32) space;
// or we could use another integer directly, but loop to the right bit every
// time

// can be optimized with divide and concur; log(n)

public class ReverseBits190 {
	public int reverseBits(int n) {
		int num = 0;
		for (int i = 0; i < 32; i++) {
			num |= n & 0x1; // mask it with last bit
			if (i < 31)
				num <<= 1;
			n >>>= 1;
		}
		return num;
	}

	public static void main(String[] args) {
		ReverseBits190 t = new ReverseBits190();
		System.out.println(t.reverseBits(43261596));
	}
}
