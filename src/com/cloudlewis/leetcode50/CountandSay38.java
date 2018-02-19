package com.cloudlewis.leetcode50;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * @formatter:off
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 *
 * @formatter:on
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 * Input: 1
 * Output: "1"
 *
 * Example 2:
 * Input: 4
 * Output: "1211"
 * @author xiao
 *
 */

// asking for 0 and negative value

public class CountandSay38 {
	public String countAndSay(int n) {
		if (n == 0)
			return "";
		StringBuilder str = new StringBuilder();
		StringBuilder tmp = new StringBuilder();
		str.append(1);
		while (n > 1) {
			int len = str.length();
			int i = 0;
			while (i < len)  {
				int count = 1;
				while(i + 1 < len && str.charAt(i) == str.charAt(i + 1)) {
					i++;
					count ++;
				}
				tmp.append(count).append(str.charAt(i));
				// stop when next number is different
				i++;
			}
			str.setLength(0);
			str.append(tmp.toString());
			tmp.setLength(0);
			n--;
		}
		return str.toString();
	}
	
	public static void main(String[] args) {
		CountandSay38 t = new CountandSay38();
		System.out.println(t.countAndSay(5)); //111221
		System.out.println(t.countAndSay(6)); //"312211"
	}
}
