package com.cloudlewis.leetcode500;

/**
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Note: 0 ≤ x, y < 231.
 * 
 * Example:
 * 
 * Input: x = 1, y = 4
 * 
 * Output: 2
 * 
 * Explanation: 1 (0 0 0 1) 4 (0 1 0 0) ↑ ↑
 * 
 * The above arrows point to positions where the corresponding bits are
 * different.
 * 
 * @author xiao
 *
 */
public class HammingDistance461 {
	public int hammingDistance(int x, int y) {
		int dis = 0;
		while (x > 0 && y > 0) {
			dis += ((x & 0x1) ^ (y & 0x1));
			x >>= 1;
			y >>= 1;
		}
		while (x > 0) {
			dis += (x & 0x1);
			x >>= 1;
		}
		while (y > 0) {
			dis += (y & 0x1);
			y >>= 1;
		}
		return dis;
	}

	public static void main(String[] args) {
		HammingDistance461 t = new HammingDistance461();
		System.out.println(t.hammingDistance(1, 4));
	}
}
