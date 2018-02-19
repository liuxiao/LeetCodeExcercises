package com.cloudlewis.leetcode100;

/**
 * Validate if a given string is numeric.
 *
 * @formatter:off
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * 
 * @formatter:on
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 * @author xiao
 *
 */

// !! DID NOT PASS JUDGE

// space: space in front, middle and back ---- making assumption that space not
// in middle
// sign : +, -, only one time, what about space?
// dot : must have something after, what about .8?
// char : 2e10, pi? probably not, 0.00000000052 is 5.2E-10, allow only one?
// "/" : fractional number?
// num : 0000.000 ?

// MISSED:
// dot and e cannot show up same time
// + or - cannot be the last or random in middle element
// " -."

public class ValidNumber65 {
	public boolean isNumber(String s) {
		s = s.trim(); // we could write our own trim function
		int len = s.length();
		boolean dot = false;
		boolean e = false;
		if (len == 0)
			return false;
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9')
				continue;
			else if ((c == '+' || c == '-')
					&& (i == 0 || (i - 1 > 0 && s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E') && i < len - 1))
				continue;
			else if (c == '.' && len != 1 && !dot
					&& ((i - 1 >= 0 && s.charAt(i - 1) <= '9' && s.charAt(i - 1) >= '0')
							|| (i + 1 < len && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9'))) {
				dot = true;
				continue;
			} else if ((c == 'e' || c == 'E') && i > 0 && i < len - 1 && !e && (s.charAt(i - 1) >= '0'
					&& s.charAt(i - 1) <= '9' || (i > 1 && s.charAt(i - 2) >= '0'
					&& s.charAt(i - 2) <= '9'))) {
				e = true;
				continue;
			} else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		ValidNumber65 t = new ValidNumber65();
		System.out.println(t.isNumber(".e1"));
		System.out.println(t.isNumber("46.e3"));
		
		System.out.println(t.isNumber("+E3"));
		System.out.println(t.isNumber(" .-"));
		System.out.println(t.isNumber("4e+"));		
		System.out.println(t.isNumber(".")); // true
		System.out.println(t.isNumber("0")); // true
		System.out.println(t.isNumber(" 0.1 ")); // true
		System.out.println(t.isNumber(" 3. ")); // false ？ what judge said this
												// is ture?
		System.out.println(t.isNumber("abc")); // false
		System.out.println(t.isNumber("1 a")); // false
		System.out.println(t.isNumber("2e10")); // true
	}
}
