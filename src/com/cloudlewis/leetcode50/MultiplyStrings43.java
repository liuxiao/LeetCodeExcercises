package com.cloudlewis.leetcode50;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2.
 * 
 * Note:
 * 
 * @formatter:off
 * 1. The length of both num1 and num2 is < 110. 
 * 2. Both num1 and num2 contains only digits 0-9. 
 * 3. Both num1 and num2 does not contain any leading zero. 
 * 4. You mustnot use any built-in BigInteger library or convert the inputs to integer
 * directly.
 * @formatter:on
 * @author xiao
 *
 */

// Solution 1
// use chengshi , store digits m + n
// num1[i] & num[j] will be stored in map[i+j]

// Solution 2. play with Karatsuba Multiply alg

public class MultiplyStrings43 {
	public String multiply(String num1, String num2) {
		if (num1.isEmpty() || num2.isEmpty())
			return "0";
		if (num1.charAt(0) == '0' || num2.charAt(0) == '0')
			return "0";
		int l1 = num1.length();
		int l2 = num2.length();
		int[] map = new int[l1 + l2];
		for (int i = l1 - 1; i >= 0; i--) {
			for (int j = l2 - 1; j >= 0; j--) {
				int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + map[i + j + 1];
				map[i + j + 1] = sum % 10;
				map[i + j ] += sum / 10;
			}
		}
		StringBuilder s = new StringBuilder();
		for (int i : map)
			s.append(i);
		return  (s.charAt(0) == '0') ? s.substring(1) : s.toString();
	}

	public static void main(String[] args) {
		MultiplyStrings43 t = new MultiplyStrings43();
		System.out.println(t.multiply("145", "213")); // 30,885
	}
}
