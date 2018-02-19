package com.cloudlewis.leetcode200;

import java.util.HashMap;
import java.util.Map;

/**
 * @formatter:off
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * For example,
 * 
 * Given numerator = 1, denominator = 2, return "0.5". 
 * Given numerator = 2, denominator = 1, return "2". 
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * 
 * @formatter:on
 * @author xialiliu
 *
 */

// what is denominator is 0?
// problem is how to determine the repeating part
// theoretically, human won't even know unless they repeated many times? but how
// many times?

// submit problem is the long issue. we are using int, not enough precision
public class FractiontoRecurringDecimal166 {
	public String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0 || numerator == 0)
			return "0";
		StringBuilder s = new StringBuilder();
		s.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator); // this overflow one of the
													// test case!!
		s.append(num / den);
		num %= den;
		if (num == 0)
			return s.toString();
		s.append(".");
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		// map the number with size of the stringbuilder,i.e. location to insert
		// (
		map.put(num, s.length());
		while (num != 0) {
			num *= 10;
			s.append(num / den);
			num %= den;
			if (map.containsKey(num)) {
				int index = map.get(num);
				s.insert(index, "(");
				s.append(")");
				break;
			} else
				map.put(num, s.length());
		}
		return s.toString();
	}

	public static void main(String[] args) {
		FractiontoRecurringDecimal166 t = new FractiontoRecurringDecimal166();
		System.out.println(t.fractionToDecimal(3, 4));
		System.out.println(t.fractionToDecimal(4, 3));
		System.out.println(t.fractionToDecimal(-1, -2147483648));
	}
}
